'use strict';

angular.module('tuxAdminApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('event', {
            	parent: 'admin',
                url: '/event',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'event.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/admin/event/event.html',
                        controller: 'EventController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('event');
                        return $translate.refresh();
                    }]
                }
            })
            .state('eventRegist-detail', {
            	parent: 'admin',
                url: '/event/:id',
	            data: {
	                authorities: ['ROLE_USER'],
	                pageTitle: 'eventRegist-detail.title'
	            },
	            views: {
	                'content@': {
	                    templateUrl: 'scripts/app/admin/event/eventRegist-detail.html',
	                    controller: 'EventRegistDetailController'
	                }
	            },
	            resolve: {
	                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
	                    $translatePartialLoader.addPart('event');
	                    return $translate.refresh();
	                }]
	            }
	        })
	        .state('eventReportCount-detail', {
            	parent: 'admin',
                url: '/eventReportCount/:id',
	            data: {
	                authorities: ['ROLE_USER'],
	                pageTitle: 'eventReportCount-detail.title'
	            },
	            views: {
	                'content@': {
	                    templateUrl: 'scripts/app/admin/event/eventReportCount-detail.html',
	                    controller: 'EventReportCountDetailController'
	                }
	            },
	            resolve: {
	                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
	                    $translatePartialLoader.addPart('event');
	                    return $translate.refresh();
	                }]
	            }
	        })
           .state('event-new', {
                parent: 'admin',
                url: '/event/{id}/new',
                data: {
                    authorities: ['ROLE_USER'],
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/admin/event/event-dialog.html',
                        controller: 'EventDialogController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('event');
                        return $translate.refresh();
                    }]
                }
            })
        .state('event-edit', {
            parent: 'admin',
            url: '/event/{id}/edit',
            data: {
                authorities: ['ROLE_USER'],
            },
            views: {
                'content@': {
                    templateUrl: 'scripts/app/admin/event/event-dialog.html',
                    controller: 'EventDialogController'
                }
            },
            resolve: {
            	entity: function () {
                    return {
                        id: null, title: null,  startDate: null, endDate: null,
                        status: null,picPath:null,summary:null,content:null, createTime: null
                    };
                },
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('event');
                    return $translate.refresh();
                }]
            }
        })
    });
