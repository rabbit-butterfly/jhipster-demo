(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('PpThicknessDetailController', PpThicknessDetailController);

    PpThicknessDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'PpThickness'];

    function PpThicknessDetailController($scope, $rootScope, $stateParams, previousState, entity, PpThickness) {
        var vm = this;

        vm.ppThickness = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('tuxAdminApp:ppThicknessUpdate', function(event, result) {
            vm.ppThickness = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
