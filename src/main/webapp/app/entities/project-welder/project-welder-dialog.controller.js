(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('ProjectWelderDialogController', ProjectWelderDialogController);

    ProjectWelderDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'ProjectWelder'];

    function ProjectWelderDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, ProjectWelder) {
        var vm = this;

        vm.projectWelder = entity;
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
            if (vm.projectWelder.id !== null) {
                ProjectWelder.update(vm.projectWelder, onSaveSuccess, onSaveError);
            } else {
                ProjectWelder.save(vm.projectWelder, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('tuxAdminApp:projectWelderUpdate', result);
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
