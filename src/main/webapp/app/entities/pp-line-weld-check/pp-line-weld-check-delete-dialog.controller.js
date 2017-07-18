(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('PpLineWeldCheckDeleteController',PpLineWeldCheckDeleteController);

    PpLineWeldCheckDeleteController.$inject = ['$uibModalInstance', 'entity', 'PpLineWeldCheck'];

    function PpLineWeldCheckDeleteController($uibModalInstance, entity, PpLineWeldCheck) {
        var vm = this;

        vm.ppLineWeldCheck = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            PpLineWeldCheck.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
