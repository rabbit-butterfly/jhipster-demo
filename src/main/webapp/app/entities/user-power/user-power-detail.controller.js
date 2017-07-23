(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('UserPowerDetailController', UserPowerDetailController);

    UserPowerDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'UserPower'];

    function UserPowerDetailController($scope, $rootScope, $stateParams, previousState, entity, UserPower) {
        var vm = this;

        vm.userPower = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('tuxAdminApp:userPowerUpdate', function(event, result) {
            vm.userPower = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
