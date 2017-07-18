(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('WelderDetailController', WelderDetailController);

    WelderDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Welder'];

    function WelderDetailController($scope, $rootScope, $stateParams, previousState, entity, Welder) {
        var vm = this;

        vm.welder = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('pcmsApp:welderUpdate', function(event, result) {
            vm.welder = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
