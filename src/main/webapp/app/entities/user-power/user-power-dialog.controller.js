(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('UserPowerDialogController', UserPowerDialogController);

    UserPowerDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'UserPower'];

    function UserPowerDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, UserPower) {
        var vm = this;

        vm.userPower = entity;
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
            if (vm.userPower.id !== null) {
                UserPower.update(vm.userPower, onSaveSuccess, onSaveError);
            } else {
                UserPower.save(vm.userPower, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('tuxAdminApp:userPowerUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
