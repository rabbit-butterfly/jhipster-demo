(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('PpLineWeldEntrustDialogController', PpLineWeldEntrustDialogController);

    PpLineWeldEntrustDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'PpLineWeldEntrust'];

    function PpLineWeldEntrustDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, PpLineWeldEntrust) {
        var vm = this;

        vm.ppLineWeldEntrust = entity;
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
            if (vm.ppLineWeldEntrust.id !== null) {
                PpLineWeldEntrust.update(vm.ppLineWeldEntrust, onSaveSuccess, onSaveError);
            } else {
                PpLineWeldEntrust.save(vm.ppLineWeldEntrust, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('pcmsApp:ppLineWeldEntrustUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.entrustDate = false;
        vm.datePickerOpenStatus.createTime = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
