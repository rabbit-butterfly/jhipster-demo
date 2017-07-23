(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('UserPowerDeleteController',UserPowerDeleteController);

    UserPowerDeleteController.$inject = ['$uibModalInstance', 'entity', 'UserPower'];

    function UserPowerDeleteController($uibModalInstance, entity, UserPower) {
        var vm = this;

        vm.userPower = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            UserPower.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
