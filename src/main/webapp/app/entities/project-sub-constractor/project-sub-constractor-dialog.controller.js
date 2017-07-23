(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('ProjectSubConstractorDialogController', ProjectSubConstractorDialogController);

    ProjectSubConstractorDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'ProjectSubConstractor'];

    function ProjectSubConstractorDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, ProjectSubConstractor) {
        var vm = this;

        vm.projectSubConstractor = entity;
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
            if (vm.projectSubConstractor.id !== null) {
                ProjectSubConstractor.update(vm.projectSubConstractor, onSaveSuccess, onSaveError);
            } else {
                ProjectSubConstractor.save(vm.projectSubConstractor, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('tuxAdminApp:projectSubConstractorUpdate', result);
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
