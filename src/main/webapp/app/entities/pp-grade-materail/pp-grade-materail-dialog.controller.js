(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('PpGradeMaterailDialogController', PpGradeMaterailDialogController);

    PpGradeMaterailDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'PpGradeMaterail'];

    function PpGradeMaterailDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, PpGradeMaterail) {
        var vm = this;

        vm.ppGradeMaterail = entity;
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
            if (vm.ppGradeMaterail.id !== null) {
                PpGradeMaterail.update(vm.ppGradeMaterail, onSaveSuccess, onSaveError);
            } else {
                PpGradeMaterail.save(vm.ppGradeMaterail, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('pcmsApp:ppGradeMaterailUpdate', result);
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
