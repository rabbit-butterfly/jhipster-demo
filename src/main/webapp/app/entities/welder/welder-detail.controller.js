(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('WelderDetailController', WelderDetailController);

    WelderDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Welder'];

    function WelderDetailController($scope, $rootScope, $stateParams, previousState, entity, Welder) {
        var vm = this;

        vm.welder = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('tuxAdminApp:welderUpdate', function(event, result) {
            vm.welder = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
