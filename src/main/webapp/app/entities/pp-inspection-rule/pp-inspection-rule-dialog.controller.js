(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('PpInspectionRuleDialogController', PpInspectionRuleDialogController);

    PpInspectionRuleDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'PpInspectionRule'];

    function PpInspectionRuleDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, PpInspectionRule) {
        var vm = this;

        vm.ppInspectionRule = entity;
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
            if (vm.ppInspectionRule.id !== null) {
                PpInspectionRule.update(vm.ppInspectionRule, onSaveSuccess, onSaveError);
            } else {
                PpInspectionRule.save(vm.ppInspectionRule, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('pcmsApp:ppInspectionRuleUpdate', result);
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
