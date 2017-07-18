(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('PpIinspectionTatioDeleteController',PpIinspectionTatioDeleteController);

    PpIinspectionTatioDeleteController.$inject = ['$uibModalInstance', 'entity', 'PpIinspectionTatio'];

    function PpIinspectionTatioDeleteController($uibModalInstance, entity, PpIinspectionTatio) {
        var vm = this;

        vm.ppIinspectionTatio = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            PpIinspectionTatio.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
