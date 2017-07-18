(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('PpLineWeldCheckDetailController', PpLineWeldCheckDetailController);

    PpLineWeldCheckDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'PpLineWeldCheck'];

    function PpLineWeldCheckDetailController($scope, $rootScope, $stateParams, previousState, entity, PpLineWeldCheck) {
        var vm = this;

        vm.ppLineWeldCheck = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('pcmsApp:ppLineWeldCheckUpdate', function(event, result) {
            vm.ppLineWeldCheck = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
