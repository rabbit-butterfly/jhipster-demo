(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('PpLineWeldMaterialDeleteController',PpLineWeldMaterialDeleteController);

    PpLineWeldMaterialDeleteController.$inject = ['$uibModalInstance', 'entity', 'PpLineWeldMaterial'];

    function PpLineWeldMaterialDeleteController($uibModalInstance, entity, PpLineWeldMaterial) {
        var vm = this;

        vm.ppLineWeldMaterial = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            PpLineWeldMaterial.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
