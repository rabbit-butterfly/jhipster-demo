(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('ProjectWelderDeleteController',ProjectWelderDeleteController);

    ProjectWelderDeleteController.$inject = ['$uibModalInstance', 'entity', 'ProjectWelder'];

    function ProjectWelderDeleteController($uibModalInstance, entity, ProjectWelder) {
        var vm = this;

        vm.projectWelder = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            ProjectWelder.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
