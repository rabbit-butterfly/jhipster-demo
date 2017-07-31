(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('RoleDetailController', RoleDetailController);

    RoleDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Role', 'BizAuth'];

    function RoleDetailController($scope, $rootScope, $stateParams, previousState, entity, Role, BizAuth) {
        var vm = this;

        vm.role = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('tuxAdminApp:roleUpdate', function(event, result) {
            vm.role = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
