(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('WelderDeleteController',WelderDeleteController);

    WelderDeleteController.$inject = ['$uibModalInstance', 'entity', 'Welder'];

    function WelderDeleteController($uibModalInstance, entity, Welder) {
        var vm = this;

        vm.welder = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            Welder.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
