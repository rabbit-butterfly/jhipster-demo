(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('ProjectSubConstractorDeleteController',ProjectSubConstractorDeleteController);

    ProjectSubConstractorDeleteController.$inject = ['$uibModalInstance', 'entity', 'ProjectSubConstractor'];

    function ProjectSubConstractorDeleteController($uibModalInstance, entity, ProjectSubConstractor) {
        var vm = this;

        vm.projectSubConstractor = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            ProjectSubConstractor.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
