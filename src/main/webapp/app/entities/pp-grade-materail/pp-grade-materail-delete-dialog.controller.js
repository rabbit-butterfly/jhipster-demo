(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('PpGradeMaterailDeleteController',PpGradeMaterailDeleteController);

    PpGradeMaterailDeleteController.$inject = ['$uibModalInstance', 'entity', 'PpGradeMaterail'];

    function PpGradeMaterailDeleteController($uibModalInstance, entity, PpGradeMaterail) {
        var vm = this;

        vm.ppGradeMaterail = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            PpGradeMaterail.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
