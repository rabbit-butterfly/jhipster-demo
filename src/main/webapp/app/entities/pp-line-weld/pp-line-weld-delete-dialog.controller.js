(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('PpLineWeldDeleteController',PpLineWeldDeleteController);

    PpLineWeldDeleteController.$inject = ['$uibModalInstance', 'entity', 'PpLineWeld'];

    function PpLineWeldDeleteController($uibModalInstance, entity, PpLineWeld) {
        var vm = this;

        vm.ppLineWeld = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            PpLineWeld.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
