(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('UserAreaDeleteController',UserAreaDeleteController);

    UserAreaDeleteController.$inject = ['$uibModalInstance', 'entity', 'UserArea'];

    function UserAreaDeleteController($uibModalInstance, entity, UserArea) {
        var vm = this;

        vm.userArea = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            UserArea.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
