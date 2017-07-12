'use strict';

angular.module('tuxAdminApp')
    .controller('FeedbackController', function ($scope, feedbackService, ParseLinks, Language) {
    	$scope.feedbacks = [];
        Language.getAll().then(function (languages) {
            $scope.languages = languages;
        });

        $scope.page = 1;
        $scope.loadAll = function () {
        	feedbackService.query({page: $scope.page - 1, size: 10}, function (result, headers) {
                $scope.links = ParseLinks.parse(headers('link'));
                $scope.totalItems = headers('X-Total-Count');
                $scope.feedbacks = result;
            });
        };

        $scope.loadPage = function (page) {
            $scope.page = page;
            $scope.loadAll();
        };
        $scope.loadAll();
    });
