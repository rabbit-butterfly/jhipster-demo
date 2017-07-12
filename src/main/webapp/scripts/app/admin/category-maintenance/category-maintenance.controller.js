'use strict';

angular.module('tuxAdminApp')
    .controller('CategoryMaintenanceController', function ($scope, categorySearchService,categoryService, ParseLinks, Language) {
    	$scope.categories = [];
        Language.getAll().then(function (languages) {
            $scope.languages = languages;
        });

        $scope.page = 1;
        $scope.loadAll = function () {
        	categorySearchService.query({query: 0},{page: $scope.page - 1, size: 10}, function (result, headers) {
                //$scope.links = ParseLinks.parse(headers('link'));
                $scope.totalItems = headers('X-Total-Count');
                $scope.categories = result;
            });
        };

        $scope.loadPage = function (page) {
            $scope.page = page;
            $scope.loadAll();
        };
        $scope.loadAll();

        $scope.setRelease = function (category, status) {
        	category.status = status;
        	categoryService.update(category, function () {
                $scope.loadAll();
            });
        };
    });
