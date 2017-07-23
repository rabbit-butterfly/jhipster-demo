(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('UserInfoDetailController', UserInfoDetailController);

    UserInfoDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'UserInfo'];

    function UserInfoDetailController($scope, $rootScope, $stateParams, previousState, entity, UserInfo) {
        var vm = this;

        vm.userInfo = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('tuxAdminApp:userInfoUpdate', function(event, result) {
            vm.userInfo = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
