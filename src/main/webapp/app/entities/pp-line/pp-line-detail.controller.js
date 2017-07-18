(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('PpLineDetailController', PpLineDetailController);

    PpLineDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'PpLine'];

    function PpLineDetailController($scope, $rootScope, $stateParams, previousState, entity, PpLine) {
        var vm = this;

        vm.ppLine = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('pcmsApp:ppLineUpdate', function(event, result) {
            vm.ppLine = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
