(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('PpThicknessDialogController', PpThicknessDialogController);

    PpThicknessDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'PpThickness'];

    function PpThicknessDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, PpThickness) {
        var vm = this;

        vm.ppThickness = entity;
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
            if (vm.ppThickness.id !== null) {
                PpThickness.update(vm.ppThickness, onSaveSuccess, onSaveError);
            } else {
                PpThickness.save(vm.ppThickness, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('tuxAdminApp:ppThicknessUpdate', result);
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
