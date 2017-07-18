(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('UserAreaDetailController', UserAreaDetailController);

    UserAreaDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'UserArea'];

    function UserAreaDetailController($scope, $rootScope, $stateParams, previousState, entity, UserArea) {
        var vm = this;

        vm.userArea = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('pcmsApp:userAreaUpdate', function(event, result) {
            vm.userArea = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
