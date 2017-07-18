(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('PpThicknessDetailController', PpThicknessDetailController);

    PpThicknessDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'PpThickness'];

    function PpThicknessDetailController($scope, $rootScope, $stateParams, previousState, entity, PpThickness) {
        var vm = this;

        vm.ppThickness = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('pcmsApp:ppThicknessUpdate', function(event, result) {
            vm.ppThickness = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
