(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('PpInspectionRuleDeleteController',PpInspectionRuleDeleteController);

    PpInspectionRuleDeleteController.$inject = ['$uibModalInstance', 'entity', 'PpInspectionRule'];

    function PpInspectionRuleDeleteController($uibModalInstance, entity, PpInspectionRule) {
        var vm = this;

        vm.ppInspectionRule = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            PpInspectionRule.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
