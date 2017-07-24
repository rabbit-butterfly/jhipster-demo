(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('ProjectUserDetailController', ProjectUserDetailController);

    ProjectUserDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'ProjectUser'];

    function ProjectUserDetailController($scope, $rootScope, $stateParams, previousState, entity, ProjectUser) {
        var vm = this;

        vm.projectUser = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('tuxAdminApp:projectUserUpdate', function(event, result) {
            vm.projectUser = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
