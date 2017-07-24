(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('pp-thickness', {
            parent: 'entity',
            url: '/pp-thickness?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'tuxAdminApp.ppThickness.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/pp-thickness/pp-thicknesses.html',
                    controller: 'PpThicknessController',
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
                    $translatePartialLoader.addPart('ppThickness');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('pp-thickness-detail', {
            parent: 'pp-thickness',
            url: '/pp-thickness/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'tuxAdminApp.ppThickness.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/pp-thickness/pp-thickness-detail.html',
                    controller: 'PpThicknessDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('ppThickness');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'PpThickness', function($stateParams, PpThickness) {
                    return PpThickness.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'pp-thickness',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('pp-thickness-detail.edit', {
            parent: 'pp-thickness-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-thickness/pp-thickness-dialog.html',
                    controller: 'PpThicknessDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['PpThickness', function(PpThickness) {
                            return PpThickness.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('pp-thickness.new', {
            parent: 'pp-thickness',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-thickness/pp-thickness-dialog.html',
                    controller: 'PpThicknessDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                compId: null,
                                projId: null,
                                jsize: null,
                                wallThickCode: null,
                                externalDiameter: null,
                                thickness: null,
                                createTime: null,
                                delFlag: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('pp-thickness', null, { reload: 'pp-thickness' });
                }, function() {
                    $state.go('pp-thickness');
                });
            }]
        })
        .state('pp-thickness.edit', {
            parent: 'pp-thickness',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-thickness/pp-thickness-dialog.html',
                    controller: 'PpThicknessDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['PpThickness', function(PpThickness) {
                            return PpThickness.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('pp-thickness', null, { reload: 'pp-thickness' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('pp-thickness.delete', {
            parent: 'pp-thickness',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-thickness/pp-thickness-delete-dialog.html',
                    controller: 'PpThicknessDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['PpThickness', function(PpThickness) {
                            return PpThickness.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('pp-thickness', null, { reload: 'pp-thickness' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
