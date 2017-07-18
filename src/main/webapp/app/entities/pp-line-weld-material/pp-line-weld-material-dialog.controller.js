(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('PpLineWeldMaterialDialogController', PpLineWeldMaterialDialogController);

    PpLineWeldMaterialDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'PpLineWeldMaterial'];

    function PpLineWeldMaterialDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, PpLineWeldMaterial) {
        var vm = this;

        vm.ppLineWeldMaterial = entity;
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
            if (vm.ppLineWeldMaterial.id !== null) {
                PpLineWeldMaterial.update(vm.ppLineWeldMaterial, onSaveSuccess, onSaveError);
            } else {
                PpLineWeldMaterial.save(vm.ppLineWeldMaterial, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('pcmsApp:ppLineWeldMaterialUpdate', result);
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
