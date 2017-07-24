(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('PpThicknessDeleteController',PpThicknessDeleteController);

    PpThicknessDeleteController.$inject = ['$uibModalInstance', 'entity', 'PpThickness'];

    function PpThicknessDeleteController($uibModalInstance, entity, PpThickness) {
        var vm = this;

        vm.ppThickness = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            PpThickness.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
