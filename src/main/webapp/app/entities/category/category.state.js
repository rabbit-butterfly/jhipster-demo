(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('category', {
            parent: 'entity',
            url: '/category?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'tuxAdminApp.category.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/category/categories.html',
                    controller: 'CategoryController',
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
                    $translatePartialLoader.addPart('category');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('category-detail', {
            parent: 'entity',
            url: '/category/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'tuxAdminApp.category.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/category/category-detail.html',
                    controller: 'CategoryDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('category');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'Category', function($stateParams, Category) {
                    return Category.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'category',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('category-detail.edit', {
            parent: 'category-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/category/category-dialog.html',
                    controller: 'CategoryDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Category', function(Category) {
                            return Category.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('category.new', {
            parent: 'category',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/category/category-dialog.html',
                    controller: 'CategoryDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                parentId: null,
                                name: null,
                                remark: null,
                                status: null,
                                crateTime: null,
                                modifyTime: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('category', null, { reload: 'category' });
                }, function() {
                    $state.go('category');
                });
            }]
        })
        .state('category.edit', {
            parent: 'category',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/category/category-dialog.html',
                    controller: 'CategoryDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Category', function(Category) {
                            return Category.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('category', null, { reload: 'category' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('category.delete', {
            parent: 'category',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/category/category-delete-dialog.html',
                    controller: 'CategoryDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['Category', function(Category) {
                            return Category.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('category', null, { reload: 'category' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
