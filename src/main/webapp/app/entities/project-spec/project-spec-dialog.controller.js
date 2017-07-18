(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('ProjectSpecDialogController', ProjectSpecDialogController);

    ProjectSpecDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'ProjectSpec'];

    function ProjectSpecDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, ProjectSpec) {
        var vm = this;

        vm.projectSpec = entity;
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
            if (vm.projectSpec.id !== null) {
                ProjectSpec.update(vm.projectSpec, onSaveSuccess, onSaveError);
            } else {
                ProjectSpec.save(vm.projectSpec, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('pcmsApp:projectSpecUpdate', result);
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
