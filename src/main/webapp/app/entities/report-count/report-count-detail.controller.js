(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .controller('ReportCountDetailController', ReportCountDetailController);

    ReportCountDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'ReportCount'];

    function ReportCountDetailController($scope, $rootScope, $stateParams, previousState, entity, ReportCount) {
        var vm = this;

        vm.reportCount = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('tuxAdminApp:reportCountUpdate', function(event, result) {
            vm.reportCount = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
