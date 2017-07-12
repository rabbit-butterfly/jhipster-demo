'use strict';

angular.module('tuxAdminApp')
    .controller('NewsManagementController', function ($scope, newsService, ParseLinks,Upload, Language) {
    	$scope.news = [];
        Language.getAll().then(function (languages) {
            $scope.languages = languages;
        });

        $scope.page = 1;
        $scope.loadAll = function () {
        	newsService.query({page: $scope.page - 1, size: 10}, function (result, headers) {
                $scope.links = ParseLinks.parse(headers('link'));
                $scope.totalItems = headers('X-Total-Count');
                $scope.news = result;
            });
        };

        $scope.loadPage = function (page) {
            $scope.page = page;
            $scope.loadAll();
        };
        $scope.loadAll();

        $scope.setRelease = function (news, status) {
        	news.status = status;
        	newsService.patch(news, function () {
                $scope.loadAll();
            });
        };

    });
