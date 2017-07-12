'use strict';

angular.module('tuxAdminApp')
    .controller('EventRegistDetailController', function ($scope, $stateParams, eventService,registService) {
        $scope.event = {};
        $scope.regist=[];
        $scope.page = 1;
        $scope.load = function (id) {
        	eventService.get({id: id}, function(result) {
                $scope.event = result;
            });
//        	$scope.eventId= $scope.event.id+'';
        	registService.query({query: id},{page: $scope.page - 1, size: 20},function(result){
        		$scope.regist=result;
        		
        	})
        	
        };
        $scope.load($stateParams.id);
    });
