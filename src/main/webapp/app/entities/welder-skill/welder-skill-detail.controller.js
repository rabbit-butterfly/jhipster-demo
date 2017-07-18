(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('WelderSkillDetailController', WelderSkillDetailController);

    WelderSkillDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'WelderSkill'];

    function WelderSkillDetailController($scope, $rootScope, $stateParams, previousState, entity, WelderSkill) {
        var vm = this;

        vm.welderSkill = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('pcmsApp:welderSkillUpdate', function(event, result) {
            vm.welderSkill = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
