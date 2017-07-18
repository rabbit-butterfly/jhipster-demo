(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('ProjectMaterialDeleteController',ProjectMaterialDeleteController);

    ProjectMaterialDeleteController.$inject = ['$uibModalInstance', 'entity', 'ProjectMaterial'];

    function ProjectMaterialDeleteController($uibModalInstance, entity, ProjectMaterial) {
        var vm = this;

        vm.projectMaterial = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            ProjectMaterial.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
