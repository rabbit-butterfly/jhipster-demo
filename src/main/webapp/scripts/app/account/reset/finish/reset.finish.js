'use strict';

angular.module('tuxAdminApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('finishReset', {
                parent: 'account',
                url: '/reset/finish?key',
                data: {
                    authorities: []
                },
                views: {
                    'wrapper@': {
                        templateUrl: 'scripts/app/account/reset/finish/reset.finish.html',
                        controller: 'ResetFinishController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('reset');
                        return $translate.refresh();
                    }]
                }
            });
    });
