(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('PpIinspectionTatioDialogController', PpIinspectionTatioDialogController);

    PpIinspectionTatioDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'PpIinspectionTatio'];

    function PpIinspectionTatioDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, PpIinspectionTatio) {
        var vm = this;

        vm.ppIinspectionTatio = entity;
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
            if (vm.ppIinspectionTatio.id !== null) {
                PpIinspectionTatio.update(vm.ppIinspectionTatio, onSaveSuccess, onSaveError);
            } else {
                PpIinspectionTatio.save(vm.ppIinspectionTatio, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('tuxAdminApp:ppIinspectionTatioUpdate', result);
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
