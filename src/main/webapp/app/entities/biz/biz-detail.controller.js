(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('BizDetailController', BizDetailController);

    BizDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Biz'];

    function BizDetailController($scope, $rootScope, $stateParams, previousState, entity, Biz) {
        var vm = this;

        vm.biz = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('tuxAdminApp:bizUpdate', function(event, result) {
            vm.biz = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
