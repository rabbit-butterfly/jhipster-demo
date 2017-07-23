(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('WelderSkillDetailController', WelderSkillDetailController);

    WelderSkillDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'WelderSkill'];

    function WelderSkillDetailController($scope, $rootScope, $stateParams, previousState, entity, WelderSkill) {
        var vm = this;

        vm.welderSkill = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('tuxAdminApp:welderSkillUpdate', function(event, result) {
            vm.welderSkill = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
