(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('PpLineWeldEntrustDeleteController',PpLineWeldEntrustDeleteController);

    PpLineWeldEntrustDeleteController.$inject = ['$uibModalInstance', 'entity', 'PpLineWeldEntrust'];

    function PpLineWeldEntrustDeleteController($uibModalInstance, entity, PpLineWeldEntrust) {
        var vm = this;

        vm.ppLineWeldEntrust = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            PpLineWeldEntrust.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
