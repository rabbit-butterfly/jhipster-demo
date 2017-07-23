(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('PpLineDrawingDeleteController',PpLineDrawingDeleteController);

    PpLineDrawingDeleteController.$inject = ['$uibModalInstance', 'entity', 'PpLineDrawing'];

    function PpLineDrawingDeleteController($uibModalInstance, entity, PpLineDrawing) {
        var vm = this;

        vm.ppLineDrawing = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            PpLineDrawing.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
