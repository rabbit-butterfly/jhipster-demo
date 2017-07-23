(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('PpLineWeldCheckDetailController', PpLineWeldCheckDetailController);

    PpLineWeldCheckDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'PpLineWeldCheck'];

    function PpLineWeldCheckDetailController($scope, $rootScope, $stateParams, previousState, entity, PpLineWeldCheck) {
        var vm = this;

        vm.ppLineWeldCheck = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('tuxAdminApp:ppLineWeldCheckUpdate', function(event, result) {
            vm.ppLineWeldCheck = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
