(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('BizDeleteController',BizDeleteController);

    BizDeleteController.$inject = ['$uibModalInstance', 'entity', 'Biz'];

    function BizDeleteController($uibModalInstance, entity, Biz) {
        var vm = this;

        vm.biz = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            Biz.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
