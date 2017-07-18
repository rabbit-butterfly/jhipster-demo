(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('PpGradeMaterailDetailController', PpGradeMaterailDetailController);

    PpGradeMaterailDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'PpGradeMaterail'];

    function PpGradeMaterailDetailController($scope, $rootScope, $stateParams, previousState, entity, PpGradeMaterail) {
        var vm = this;

        vm.ppGradeMaterail = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('pcmsApp:ppGradeMaterailUpdate', function(event, result) {
            vm.ppGradeMaterail = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
