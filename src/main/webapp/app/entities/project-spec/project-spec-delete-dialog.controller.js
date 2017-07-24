(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('ProjectSpecDeleteController',ProjectSpecDeleteController);

    ProjectSpecDeleteController.$inject = ['$uibModalInstance', 'entity', 'ProjectSpec'];

    function ProjectSpecDeleteController($uibModalInstance, entity, ProjectSpec) {
        var vm = this;

        vm.projectSpec = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            ProjectSpec.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
