(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('ProjectAreaDetailController', ProjectAreaDetailController);

    ProjectAreaDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'ProjectArea'];

    function ProjectAreaDetailController($scope, $rootScope, $stateParams, previousState, entity, ProjectArea) {
        var vm = this;

        vm.projectArea = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('tuxAdminApp:projectAreaUpdate', function(event, result) {
            vm.projectArea = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
