(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('biz-auth', {
            parent: 'entity',
            url: '/biz-auth?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'tuxAdminApp.bizAuth.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/biz-auth/biz-auths.html',
                    controller: 'BizAuthController',
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
                    $translatePartialLoader.addPart('bizAuth');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('biz-auth-detail', {
            parent: 'biz-auth',
            url: '/biz-auth/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'tuxAdminApp.bizAuth.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/biz-auth/biz-auth-detail.html',
                    controller: 'BizAuthDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('bizAuth');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'BizAuth', function($stateParams, BizAuth) {
                    return BizAuth.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'biz-auth',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('biz-auth-detail.edit', {
            parent: 'biz-auth-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/biz-auth/biz-auth-dialog.html',
                    controller: 'BizAuthDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['BizAuth', function(BizAuth) {
                            return BizAuth.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('biz-auth.new', {
            parent: 'biz-auth',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/biz-auth/biz-auth-dialog.html',
                    controller: 'BizAuthDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                bizName: null,
                                roleCode: null,
                                minAuthCode: null,
                                maxAuthCode: null,
                                authCode: null,
                                authCategory: null,
                                createdBy: null,
                                createdDate: null,
                                lastModifiedBy: null,
                                lastModifiedDate: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('biz-auth', null, { reload: 'biz-auth' });
                }, function() {
                    $state.go('biz-auth');
                });
            }]
        })
        .state('biz-auth.edit', {
            parent: 'biz-auth',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/biz-auth/biz-auth-dialog.html',
                    controller: 'BizAuthDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['BizAuth', function(BizAuth) {
                            return BizAuth.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('biz-auth', null, { reload: 'biz-auth' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('biz-auth.delete', {
            parent: 'biz-auth',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/biz-auth/biz-auth-delete-dialog.html',
                    controller: 'BizAuthDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['BizAuth', function(BizAuth) {
                            return BizAuth.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('biz-auth', null, { reload: 'biz-auth' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
