'use strict';

angular.module('tuxAdminApp')
    .controller('EventReportCountDetailController', function ($scope, $stateParams, eventService,reportCountService) {
        $scope.event = {};
        $scope.reportCount=[];
        $scope.page = 1;
        $scope.load = function (id) {
        	eventService.get({id: id}, function(result) {
                $scope.event = result;
            });
//        	$scope.eventId= $scope.event.id+'';
        	reportCountService.query({query: id},{page: $scope.page - 1, size: 20},function(result){
        		$scope.reportCount=result;
        		
        	})
        	
        };
        $scope.load($stateParams.id);
    });
