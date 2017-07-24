(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('PpLineDeleteController',PpLineDeleteController);

    PpLineDeleteController.$inject = ['$uibModalInstance', 'entity', 'PpLine'];

    function PpLineDeleteController($uibModalInstance, entity, PpLine) {
        var vm = this;

        vm.ppLine = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            PpLine.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
