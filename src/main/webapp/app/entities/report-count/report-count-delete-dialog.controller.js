(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('ReportCountDeleteController',ReportCountDeleteController);

    ReportCountDeleteController.$inject = ['$uibModalInstance', 'entity', 'ReportCount'];

    function ReportCountDeleteController($uibModalInstance, entity, ReportCount) {
        var vm = this;

        vm.reportCount = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            ReportCount.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
