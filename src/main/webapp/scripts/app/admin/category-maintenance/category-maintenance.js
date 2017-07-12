'use strict';

angular.module('tuxAdminApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('category-maintenance', {
                parent: 'admin',
                url: '/category-maintenance',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'category-maintenance.home.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/admin/category-maintenance/category-maintenance.html',
                        controller: 'CategoryMaintenanceController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('category');
                        return $translate.refresh();
                    }]
                }
            })
            .state('category-maintenance.detail', {
                parent: 'admin',
                url: '/category/:parentId',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'category-maintenance.detail.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/admin/category-maintenance/category-maintenance-detail.html',
                        controller: 'CategoryMaintenanceDetailController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('category');
                        return $translate.refresh();
                    }]
                }
            })
            .state('category-maintenance.new', {
                parent: 'category-maintenance',
                url: '/new',
                data: {
                    authorities: ['ROLE_USER'],
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/admin/category-maintenance/category-maintenance-dialog.html',
                        controller: 'CategoryMaintenanceDialogController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('category');
                        return $translate.refresh();
                    }]
                }
            })
            .state('category-maintenance.edit', {
                parent: 'category-maintenance',
                url: '/{id}/edit',
                data: {
                    authorities: ['ROLE_USER'],
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/admin/category-maintenance/category-maintenance-dialog.html',
                        controller: 'CategoryMaintenanceDialogController'
                    }
                },
                resolve: {
                	entity: function () {
                        return {
                        	id: null, parentId: null, name: null, remark: null, status: null,
                            createdTime: null, modifyTime: null
                        };
                    },
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('category');
                        return $translate.refresh();
                    }]
                }
            })
            .state('category-maintenance.new-two', {
                parent: 'category-maintenance',
                //url: '/new',
                data: {
                    authorities: ['ROLE_USER'],
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/admin/category-maintenance/category-maintenance-dialog-two.html',
                        controller: 'CategoryMaintenanceDialogTwoController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('category');
                        return $translate.refresh();
                    }]
                }
            })
            .state('category-maintenance.editTwo', {
                parent: 'category-maintenance',
                url: '/{id}',
                data: {
                    authorities: ['ROLE_USER'],
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/admin/category-maintenance/category-maintenance-dialog-two.html',
                        controller: 'CategoryMaintenanceDialogTwoController'
                    }
                },
                resolve: {
                	entity: function () {
                        return {
                        	id: null, parentId: null, name: null, remark: null, status: null,
                            createdTime: null, modifyTime: null
                        };
                    },
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('category');
                        return $translate.refresh();
                    }]
                }
            });               
    });
