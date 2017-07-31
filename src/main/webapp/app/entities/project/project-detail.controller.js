(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('ProjectDetailController', ProjectDetailController);

    ProjectDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Project', 'Company'];

    function ProjectDetailController($scope, $rootScope, $stateParams, previousState, entity, Project, Company) {
        var vm = this;

        vm.project = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('tuxAdminApp:projectUpdate', function(event, result) {
            vm.project = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
