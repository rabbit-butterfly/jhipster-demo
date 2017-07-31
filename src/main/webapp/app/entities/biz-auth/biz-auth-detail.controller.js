(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('BizAuthDetailController', BizAuthDetailController);

    BizAuthDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'BizAuth', 'Biz', 'Role'];

    function BizAuthDetailController($scope, $rootScope, $stateParams, previousState, entity, BizAuth, Biz, Role) {
        var vm = this;

        vm.bizAuth = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('tuxAdminApp:bizAuthUpdate', function(event, result) {
            vm.bizAuth = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
