(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('PpLineDialogController', PpLineDialogController);

    PpLineDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'PpLine'];

    function PpLineDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, PpLine) {
        var vm = this;

        vm.ppLine = entity;
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
            if (vm.ppLine.id !== null) {
                PpLine.update(vm.ppLine, onSaveSuccess, onSaveError);
            } else {
                PpLine.save(vm.ppLine, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('pcmsApp:ppLineUpdate', result);
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
