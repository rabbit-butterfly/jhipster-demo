(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('PpLineDrawingDialogController', PpLineDrawingDialogController);

    PpLineDrawingDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'PpLineDrawing'];

    function PpLineDrawingDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, PpLineDrawing) {
        var vm = this;

        vm.ppLineDrawing = entity;
        vm.clear = clear;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        vm.save = save;

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.ppLineDrawing.id !== null) {
                PpLineDrawing.update(vm.ppLineDrawing, onSaveSuccess, onSaveError);
            } else {
                PpLineDrawing.save(vm.ppLineDrawing, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('tuxAdminApp:ppLineDrawingUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.createTime = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
