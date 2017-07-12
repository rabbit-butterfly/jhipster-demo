'use strict';

angular.module('tuxAdminApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('feedback-record', {
                parent: 'admin',
                url: '/feedback-record',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'user-management.home.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/admin/feedback-record/feedback-record.html',
                        controller: 'FeedbackController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('feedback.record');
                        return $translate.refresh();
                    }]
                }
            });
    });
