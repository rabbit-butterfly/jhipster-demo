(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('PpIinspectionTatioDetailController', PpIinspectionTatioDetailController);

    PpIinspectionTatioDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'PpIinspectionTatio'];

    function PpIinspectionTatioDetailController($scope, $rootScope, $stateParams, previousState, entity, PpIinspectionTatio) {
        var vm = this;

        vm.ppIinspectionTatio = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('tuxAdminApp:ppIinspectionTatioUpdate', function(event, result) {
            vm.ppIinspectionTatio = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
