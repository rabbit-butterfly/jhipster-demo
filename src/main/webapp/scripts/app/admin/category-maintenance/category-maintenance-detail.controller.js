'use strict';

angular.module('tuxAdminApp')
    .controller('CategoryMaintenanceDetailController', function ($scope, $stateParams,ParseLinks,categorySearchService,categoryService) {
        $scope.categories = [];
        $scope.page = 1;
        $scope.load = function (parentId) {
        	categorySearchService.query({query: parentId}, {page: $scope.page - 1, size: 10}, function(result,headers) {
        		//$scope.links = ParseLinks.parse(headers('link'));
                $scope.totalItems = headers('X-Total-Count');
        		$scope.categories = result;
            });
        };
        $scope.loadPage = function (page) {
            $scope.page = page;
            $scope.load();
        };
        $scope.load($stateParams.parentId);
        
        $scope.setRelease = function (category, status) {
        	category.status = status;
        	categoryService.update(category, function () {
                $scope.load();
            });
        };
    });
