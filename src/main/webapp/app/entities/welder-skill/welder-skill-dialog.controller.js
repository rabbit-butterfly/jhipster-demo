(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('WelderSkillDialogController', WelderSkillDialogController);

    WelderSkillDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'WelderSkill'];

    function WelderSkillDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, WelderSkill) {
        var vm = this;

        vm.welderSkill = entity;
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
            if (vm.welderSkill.id !== null) {
                WelderSkill.update(vm.welderSkill, onSaveSuccess, onSaveError);
            } else {
                WelderSkill.save(vm.welderSkill, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('pcmsApp:welderSkillUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.assessmentDate = false;
        vm.datePickerOpenStatus.effectiveDate = false;
        vm.datePickerOpenStatus.createTime = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
