(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('PpLineWeldEntrustDetailController', PpLineWeldEntrustDetailController);

    PpLineWeldEntrustDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'PpLineWeldEntrust'];

    function PpLineWeldEntrustDetailController($scope, $rootScope, $stateParams, previousState, entity, PpLineWeldEntrust) {
        var vm = this;

        vm.ppLineWeldEntrust = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('tuxAdminApp:ppLineWeldEntrustUpdate', function(event, result) {
            vm.ppLineWeldEntrust = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
