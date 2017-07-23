(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('ProjectWelderDetailController', ProjectWelderDetailController);

    ProjectWelderDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'ProjectWelder'];

    function ProjectWelderDetailController($scope, $rootScope, $stateParams, previousState, entity, ProjectWelder) {
        var vm = this;

        vm.projectWelder = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('tuxAdminApp:projectWelderUpdate', function(event, result) {
            vm.projectWelder = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
