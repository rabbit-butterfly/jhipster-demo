(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('ProjectMaterialDialogController', ProjectMaterialDialogController);

    ProjectMaterialDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'ProjectMaterial'];

    function ProjectMaterialDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, ProjectMaterial) {
        var vm = this;

        vm.projectMaterial = entity;
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
            if (vm.projectMaterial.id !== null) {
                ProjectMaterial.update(vm.projectMaterial, onSaveSuccess, onSaveError);
            } else {
                ProjectMaterial.save(vm.projectMaterial, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('tuxAdminApp:projectMaterialUpdate', result);
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
