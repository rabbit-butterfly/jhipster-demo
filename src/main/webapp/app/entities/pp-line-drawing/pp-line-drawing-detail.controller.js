(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('PpLineDrawingDetailController', PpLineDrawingDetailController);

    PpLineDrawingDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'PpLineDrawing'];

    function PpLineDrawingDetailController($scope, $rootScope, $stateParams, previousState, entity, PpLineDrawing) {
        var vm = this;

        vm.ppLineDrawing = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('pcmsApp:ppLineDrawingUpdate', function(event, result) {
            vm.ppLineDrawing = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
