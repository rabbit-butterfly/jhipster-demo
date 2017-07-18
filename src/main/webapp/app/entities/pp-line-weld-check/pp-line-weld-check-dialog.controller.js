(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('PpLineWeldCheckDialogController', PpLineWeldCheckDialogController);

    PpLineWeldCheckDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'PpLineWeldCheck'];

    function PpLineWeldCheckDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, PpLineWeldCheck) {
        var vm = this;

        vm.ppLineWeldCheck = entity;
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
            if (vm.ppLineWeldCheck.id !== null) {
                PpLineWeldCheck.update(vm.ppLineWeldCheck, onSaveSuccess, onSaveError);
            } else {
                PpLineWeldCheck.save(vm.ppLineWeldCheck, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('pcmsApp:ppLineWeldCheckUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.reworkDate = false;
        vm.datePickerOpenStatus.createTime = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
