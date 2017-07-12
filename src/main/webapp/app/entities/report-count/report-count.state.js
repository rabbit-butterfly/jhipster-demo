(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('report-count', {
            parent: 'entity',
            url: '/report-count?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'tuxAdminApp.reportCount.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/report-count/report-counts.html',
                    controller: 'ReportCountController',
                    controllerAs: 'vm'
                }
            },
            params: {
                page: {
                    value: '1',
                    squash: true
                },
                sort: {
                    value: 'id,asc',
                    squash: true
                },
                search: null
            },
            resolve: {
                pagingParams: ['$stateParams', 'PaginationUtil', function ($stateParams, PaginationUtil) {
                    return {
                        page: PaginationUtil.parsePage($stateParams.page),
                        sort: $stateParams.sort,
                        predicate: PaginationUtil.parsePredicate($stateParams.sort),
                        ascending: PaginationUtil.parseAscending($stateParams.sort),
                        search: $stateParams.search
                    };
                }],
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('reportCount');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('report-count-detail', {
            parent: 'entity',
            url: '/report-count/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'tuxAdminApp.reportCount.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/report-count/report-count-detail.html',
                    controller: 'ReportCountDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('reportCount');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'ReportCount', function($stateParams, ReportCount) {
                    return ReportCount.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'report-count',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('report-count-detail.edit', {
            parent: 'report-count-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/report-count/report-count-dialog.html',
                    controller: 'ReportCountDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['ReportCount', function(ReportCount) {
                            return ReportCount.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('report-count.new', {
            parent: 'report-count',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/report-count/report-count-dialog.html',
                    controller: 'ReportCountDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                userId: null,
                                personName: null,
                                personMobile: null,
                                eventId: null,
                                completeNum: null,
                                remark: null,
                                createTime: null,
                                modifyTime: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('report-count', null, { reload: 'report-count' });
                }, function() {
                    $state.go('report-count');
                });
            }]
        })
        .state('report-count.edit', {
            parent: 'report-count',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/report-count/report-count-dialog.html',
                    controller: 'ReportCountDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['ReportCount', function(ReportCount) {
                            return ReportCount.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('report-count', null, { reload: 'report-count' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('report-count.delete', {
            parent: 'report-count',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/report-count/report-count-delete-dialog.html',
                    controller: 'ReportCountDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['ReportCount', function(ReportCount) {
                            return ReportCount.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('report-count', null, { reload: 'report-count' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
