(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('PpLineWeldDialogController', PpLineWeldDialogController);

    PpLineWeldDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'PpLineWeld'];

    function PpLineWeldDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, PpLineWeld) {
        var vm = this;

        vm.ppLineWeld = entity;
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
            if (vm.ppLineWeld.id !== null) {
                PpLineWeld.update(vm.ppLineWeld, onSaveSuccess, onSaveError);
            } else {
                PpLineWeld.save(vm.ppLineWeld, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('tuxAdminApp:ppLineWeldUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.finishDate = false;
        vm.datePickerOpenStatus.createTime = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
