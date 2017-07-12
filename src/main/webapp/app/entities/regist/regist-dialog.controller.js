(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('RegistDialogController', RegistDialogController);

    RegistDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Regist'];

    function RegistDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Regist) {
        var vm = this;

        vm.regist = entity;
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
            if (vm.regist.id !== null) {
                Regist.update(vm.regist, onSaveSuccess, onSaveError);
            } else {
                Regist.save(vm.regist, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('tuxAdminApp:registUpdate', result);
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
