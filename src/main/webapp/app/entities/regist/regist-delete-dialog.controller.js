(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('RegistDeleteController',RegistDeleteController);

    RegistDeleteController.$inject = ['$uibModalInstance', 'entity', 'Regist'];

    function RegistDeleteController($uibModalInstance, entity, Regist) {
        var vm = this;

        vm.regist = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            Regist.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
