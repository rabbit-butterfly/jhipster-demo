'use strict';

angular.module('tuxAdminApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('news-management', {
                parent: 'admin',
                url: '/news',
                reload: 'true',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'news-management.home.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/admin/news-management/news-management.html',
                        controller: 'NewsManagementController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('news');
                        return $translate.refresh();
                    }]
                }
            })
            .state('news-management.new', {
                parent: 'news-management',
                url: '/news/{id}/new',
                data: {
                    authorities: ['ROLE_USER'],
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/admin/news-management/news-management-dialog.html',
                        controller: 'NewsManagementDialogController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('news');
                        return $translate.refresh();
                    }]
                }
            })
            .state('news-management.edit', {
                parent: 'news-management',
                url: '/news/{id}/edit',
                data: {
                    authorities: ['ROLE_USER'],
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/admin/news-management/news-management-dialog.html',
                        controller: 'NewsManagementDialogController'
                    }
                },
                resolve: {
                	entity: function () {
                        return {
                            id: null, categoryId: null,  title: null, picPath: null,
                            summary: null, status: null,contentUrl:null,createdTime:null,modifyTime:null
                        };
                    },
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('news');
                        return $translate.refresh();
                    }]
                }
            })
    });
