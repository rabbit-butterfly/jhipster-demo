(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('PpLineWeldMaterialDetailController', PpLineWeldMaterialDetailController);

    PpLineWeldMaterialDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'PpLineWeldMaterial'];

    function PpLineWeldMaterialDetailController($scope, $rootScope, $stateParams, previousState, entity, PpLineWeldMaterial) {
        var vm = this;

        vm.ppLineWeldMaterial = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('tuxAdminApp:ppLineWeldMaterialUpdate', function(event, result) {
            vm.ppLineWeldMaterial = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
