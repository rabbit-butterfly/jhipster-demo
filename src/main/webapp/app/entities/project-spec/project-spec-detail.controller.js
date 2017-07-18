(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('ProjectSpecDetailController', ProjectSpecDetailController);

    ProjectSpecDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'ProjectSpec'];

    function ProjectSpecDetailController($scope, $rootScope, $stateParams, previousState, entity, ProjectSpec) {
        var vm = this;

        vm.projectSpec = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('pcmsApp:projectSpecUpdate', function(event, result) {
            vm.projectSpec = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
