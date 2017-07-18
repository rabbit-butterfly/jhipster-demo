(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('ProjectSubConstractorDetailController', ProjectSubConstractorDetailController);

    ProjectSubConstractorDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'ProjectSubConstractor'];

    function ProjectSubConstractorDetailController($scope, $rootScope, $stateParams, previousState, entity, ProjectSubConstractor) {
        var vm = this;

        vm.projectSubConstractor = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('pcmsApp:projectSubConstractorUpdate', function(event, result) {
            vm.projectSubConstractor = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
