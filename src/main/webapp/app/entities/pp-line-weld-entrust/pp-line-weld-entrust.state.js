(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('pp-line-weld-entrust', {
            parent: 'entity',
            url: '/pp-line-weld-entrust?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'tuxAdminApp.ppLineWeldEntrust.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/pp-line-weld-entrust/pp-line-weld-entrusts.html',
                    controller: 'PpLineWeldEntrustController',
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
                    $translatePartialLoader.addPart('ppLineWeldEntrust');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('pp-line-weld-entrust-detail', {
            parent: 'pp-line-weld-entrust',
            url: '/pp-line-weld-entrust/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'tuxAdminApp.ppLineWeldEntrust.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/pp-line-weld-entrust/pp-line-weld-entrust-detail.html',
                    controller: 'PpLineWeldEntrustDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('ppLineWeldEntrust');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'PpLineWeldEntrust', function($stateParams, PpLineWeldEntrust) {
                    return PpLineWeldEntrust.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'pp-line-weld-entrust',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('pp-line-weld-entrust-detail.edit', {
            parent: 'pp-line-weld-entrust-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-line-weld-entrust/pp-line-weld-entrust-dialog.html',
                    controller: 'PpLineWeldEntrustDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['PpLineWeldEntrust', function(PpLineWeldEntrust) {
                            return PpLineWeldEntrust.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('pp-line-weld-entrust.new', {
            parent: 'pp-line-weld-entrust',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-line-weld-entrust/pp-line-weld-entrust-dialog.html',
                    controller: 'PpLineWeldEntrustDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                projId: null,
                                pipelineId: null,
                                weldId: null,
                                flowNum: null,
                                code: null,
                                expandCount: null,
                                repareCount: null,
                                entrustType: null,
                                entrustDate: null,
                                remark: null,
                                createTime: null,
                                delFlag: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('pp-line-weld-entrust', null, { reload: 'pp-line-weld-entrust' });
                }, function() {
                    $state.go('pp-line-weld-entrust');
                });
            }]
        })
        .state('pp-line-weld-entrust.edit', {
            parent: 'pp-line-weld-entrust',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-line-weld-entrust/pp-line-weld-entrust-dialog.html',
                    controller: 'PpLineWeldEntrustDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['PpLineWeldEntrust', function(PpLineWeldEntrust) {
                            return PpLineWeldEntrust.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('pp-line-weld-entrust', null, { reload: 'pp-line-weld-entrust' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('pp-line-weld-entrust.delete', {
            parent: 'pp-line-weld-entrust',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-line-weld-entrust/pp-line-weld-entrust-delete-dialog.html',
                    controller: 'PpLineWeldEntrustDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['PpLineWeldEntrust', function(PpLineWeldEntrust) {
                            return PpLineWeldEntrust.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('pp-line-weld-entrust', null, { reload: 'pp-line-weld-entrust' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
