(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('biz', {
            parent: 'entity',
            url: '/biz?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'tuxAdminApp.biz.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/biz/bizs.html',
                    controller: 'BizController',
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
                    $translatePartialLoader.addPart('biz');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('biz-detail', {
            parent: 'biz',
            url: '/biz/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'tuxAdminApp.biz.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/biz/biz-detail.html',
                    controller: 'BizDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('biz');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'Biz', function($stateParams, Biz) {
                    return Biz.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'biz',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('biz-detail.edit', {
            parent: 'biz-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/biz/biz-dialog.html',
                    controller: 'BizDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Biz', function(Biz) {
                            return Biz.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('biz.new', {
            parent: 'biz',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/biz/biz-dialog.html',
                    controller: 'BizDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                bizName: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('biz', null, { reload: 'biz' });
                }, function() {
                    $state.go('biz');
                });
            }]
        })
        .state('biz.edit', {
            parent: 'biz',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/biz/biz-dialog.html',
                    controller: 'BizDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Biz', function(Biz) {
                            return Biz.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('biz', null, { reload: 'biz' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('biz.delete', {
            parent: 'biz',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/biz/biz-delete-dialog.html',
                    controller: 'BizDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['Biz', function(Biz) {
                            return Biz.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('biz', null, { reload: 'biz' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
