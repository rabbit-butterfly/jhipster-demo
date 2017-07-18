(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('PpLineWeldDetailController', PpLineWeldDetailController);

    PpLineWeldDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'PpLineWeld'];

    function PpLineWeldDetailController($scope, $rootScope, $stateParams, previousState, entity, PpLineWeld) {
        var vm = this;

        vm.ppLineWeld = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('pcmsApp:ppLineWeldUpdate', function(event, result) {
            vm.ppLineWeld = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
