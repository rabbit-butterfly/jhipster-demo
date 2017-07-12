(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('ReportCountDialogController', ReportCountDialogController);

    ReportCountDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'ReportCount'];

    function ReportCountDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, ReportCount) {
        var vm = this;

        vm.reportCount = entity;
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
            if (vm.reportCount.id !== null) {
                ReportCount.update(vm.reportCount, onSaveSuccess, onSaveError);
            } else {
                ReportCount.save(vm.reportCount, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('tuxAdminApp:reportCountUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.createTime = false;
        vm.datePickerOpenStatus.modifyTime = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
