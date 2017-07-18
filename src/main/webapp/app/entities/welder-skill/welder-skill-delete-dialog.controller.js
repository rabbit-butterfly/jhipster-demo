(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('WelderSkillDeleteController',WelderSkillDeleteController);

    WelderSkillDeleteController.$inject = ['$uibModalInstance', 'entity', 'WelderSkill'];

    function WelderSkillDeleteController($uibModalInstance, entity, WelderSkill) {
        var vm = this;

        vm.welderSkill = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            WelderSkill.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
