(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('RegistDetailController', RegistDetailController);

    RegistDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Regist'];

    function RegistDetailController($scope, $rootScope, $stateParams, previousState, entity, Regist) {
        var vm = this;

        vm.regist = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('tuxAdminApp:registUpdate', function(event, result) {
            vm.regist = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
