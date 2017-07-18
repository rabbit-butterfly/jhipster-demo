(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('ProjectAreaDialogController', ProjectAreaDialogController);

    ProjectAreaDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'ProjectArea'];

    function ProjectAreaDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, ProjectArea) {
        var vm = this;

        vm.projectArea = entity;
        vm.clear = clear;
        vm.save = save;

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.projectArea.id !== null) {
                ProjectArea.update(vm.projectArea, onSaveSuccess, onSaveError);
            } else {
                ProjectArea.save(vm.projectArea, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('pcmsApp:projectAreaUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
