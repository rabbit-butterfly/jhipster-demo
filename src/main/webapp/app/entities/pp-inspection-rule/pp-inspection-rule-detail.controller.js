(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('PpInspectionRuleDetailController', PpInspectionRuleDetailController);

    PpInspectionRuleDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'PpInspectionRule'];

    function PpInspectionRuleDetailController($scope, $rootScope, $stateParams, previousState, entity, PpInspectionRule) {
        var vm = this;

        vm.ppInspectionRule = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('pcmsApp:ppInspectionRuleUpdate', function(event, result) {
            vm.ppInspectionRule = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
