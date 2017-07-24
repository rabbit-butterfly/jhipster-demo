(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('ProjectSubConstractorDetailController', ProjectSubConstractorDetailController);

    ProjectSubConstractorDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'ProjectSubConstractor'];

    function ProjectSubConstractorDetailController($scope, $rootScope, $stateParams, previousState, entity, ProjectSubConstractor) {
        var vm = this;

        vm.projectSubConstractor = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('tuxAdminApp:projectSubConstractorUpdate', function(event, result) {
            vm.projectSubConstractor = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
