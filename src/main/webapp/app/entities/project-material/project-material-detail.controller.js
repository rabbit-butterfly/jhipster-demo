(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .controller('ProjectMaterialDetailController', ProjectMaterialDetailController);

    ProjectMaterialDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'ProjectMaterial'];

    function ProjectMaterialDetailController($scope, $rootScope, $stateParams, previousState, entity, ProjectMaterial) {
        var vm = this;

        vm.projectMaterial = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('pcmsApp:projectMaterialUpdate', function(event, result) {
            vm.projectMaterial = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
