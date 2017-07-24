(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('pp-line-weld-check', {
            parent: 'entity',
            url: '/pp-line-weld-check?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'tuxAdminApp.ppLineWeldCheck.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/pp-line-weld-check/pp-line-weld-checks.html',
                    controller: 'PpLineWeldCheckController',
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
                    $translatePartialLoader.addPart('ppLineWeldCheck');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('pp-line-weld-check-detail', {
            parent: 'pp-line-weld-check',
            url: '/pp-line-weld-check/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'tuxAdminApp.ppLineWeldCheck.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/pp-line-weld-check/pp-line-weld-check-detail.html',
                    controller: 'PpLineWeldCheckDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('ppLineWeldCheck');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'PpLineWeldCheck', function($stateParams, PpLineWeldCheck) {
                    return PpLineWeldCheck.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'pp-line-weld-check',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('pp-line-weld-check-detail.edit', {
            parent: 'pp-line-weld-check-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-line-weld-check/pp-line-weld-check-dialog.html',
                    controller: 'PpLineWeldCheckDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['PpLineWeldCheck', function(PpLineWeldCheck) {
                            return PpLineWeldCheck.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('pp-line-weld-check.new', {
            parent: 'pp-line-weld-check',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-line-weld-check/pp-line-weld-check-dialog.html',
                    controller: 'PpLineWeldCheckDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                projId: null,
                                pipeId: null,
                                jointId: null,
                                rtfilmTotal: null,
                                rtfilmPassTotal: null,
                                reportCode: null,
                                checkDate: null,
                                checkResult: null,
                                reworkCode: null,
                                reworkWelder: null,
                                reworkDate: null,
                                reworkResult: null,
                                repairReport: null,
                                remark: null,
                                createTime: null,
                                delFlag: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('pp-line-weld-check', null, { reload: 'pp-line-weld-check' });
                }, function() {
                    $state.go('pp-line-weld-check');
                });
            }]
        })
        .state('pp-line-weld-check.edit', {
            parent: 'pp-line-weld-check',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-line-weld-check/pp-line-weld-check-dialog.html',
                    controller: 'PpLineWeldCheckDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['PpLineWeldCheck', function(PpLineWeldCheck) {
                            return PpLineWeldCheck.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('pp-line-weld-check', null, { reload: 'pp-line-weld-check' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('pp-line-weld-check.delete', {
            parent: 'pp-line-weld-check',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-line-weld-check/pp-line-weld-check-delete-dialog.html',
                    controller: 'PpLineWeldCheckDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['PpLineWeldCheck', function(PpLineWeldCheck) {
                            return PpLineWeldCheck.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('pp-line-weld-check', null, { reload: 'pp-line-weld-check' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
