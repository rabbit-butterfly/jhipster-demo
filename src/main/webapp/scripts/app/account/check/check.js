'use strict';

angular.module('tuxAdminApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('checkIndex', {
                parent: 'account',
                url: '/check',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'global.menu.account.password'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/account/check/checkIndex.html',
                        controller: 'CheckController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('password');
                        return $translate.refresh();
                    }]
                }
            });
    });
