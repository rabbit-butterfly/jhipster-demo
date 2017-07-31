(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('BizAuthDeleteController',BizAuthDeleteController);

    BizAuthDeleteController.$inject = ['$uibModalInstance', 'entity', 'BizAuth'];

    function BizAuthDeleteController($uibModalInstance, entity, BizAuth) {
        var vm = this;

        vm.bizAuth = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            BizAuth.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
