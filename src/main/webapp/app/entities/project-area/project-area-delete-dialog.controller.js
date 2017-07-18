(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('ProjectAreaDeleteController',ProjectAreaDeleteController);

    ProjectAreaDeleteController.$inject = ['$uibModalInstance', 'entity', 'ProjectArea'];

    function ProjectAreaDeleteController($uibModalInstance, entity, ProjectArea) {
        var vm = this;

        vm.projectArea = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            ProjectArea.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
