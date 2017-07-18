(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('pp-grade-materail', {
            parent: 'entity',
            url: '/pp-grade-materail?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'pcmsApp.ppGradeMaterail.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/pp-grade-materail/pp-grade-materails.html',
                    controller: 'PpGradeMaterailController',
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
                    $translatePartialLoader.addPart('ppGradeMaterail');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('pp-grade-materail-detail', {
            parent: 'pp-grade-materail',
            url: '/pp-grade-materail/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'pcmsApp.ppGradeMaterail.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/pp-grade-materail/pp-grade-materail-detail.html',
                    controller: 'PpGradeMaterailDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('ppGradeMaterail');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'PpGradeMaterail', function($stateParams, PpGradeMaterail) {
                    return PpGradeMaterail.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'pp-grade-materail',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('pp-grade-materail-detail.edit', {
            parent: 'pp-grade-materail-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-grade-materail/pp-grade-materail-dialog.html',
                    controller: 'PpGradeMaterailDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['PpGradeMaterail', function(PpGradeMaterail) {
                            return PpGradeMaterail.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('pp-grade-materail.new', {
            parent: 'pp-grade-materail',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-grade-materail/pp-grade-materail-dialog.html',
                    controller: 'PpGradeMaterailDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                compId: null,
                                projId: null,
                                material: null,
                                ppClass: null,
                                jsizeMin: null,
                                jsizeMax: null,
                                wallThickCode: null,
                                materialType: null,
                                materialCategory: null,
                                createTime: null,
                                delFlag: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('pp-grade-materail', null, { reload: 'pp-grade-materail' });
                }, function() {
                    $state.go('pp-grade-materail');
                });
            }]
        })
        .state('pp-grade-materail.edit', {
            parent: 'pp-grade-materail',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-grade-materail/pp-grade-materail-dialog.html',
                    controller: 'PpGradeMaterailDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['PpGradeMaterail', function(PpGradeMaterail) {
                            return PpGradeMaterail.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('pp-grade-materail', null, { reload: 'pp-grade-materail' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('pp-grade-materail.delete', {
            parent: 'pp-grade-materail',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-grade-materail/pp-grade-materail-delete-dialog.html',
                    controller: 'PpGradeMaterailDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['PpGradeMaterail', function(PpGradeMaterail) {
                            return PpGradeMaterail.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('pp-grade-materail', null, { reload: 'pp-grade-materail' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
