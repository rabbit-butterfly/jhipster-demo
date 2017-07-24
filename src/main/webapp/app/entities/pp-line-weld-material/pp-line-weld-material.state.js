(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('pp-line-weld-material', {
            parent: 'entity',
            url: '/pp-line-weld-material?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'tuxAdminApp.ppLineWeldMaterial.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/pp-line-weld-material/pp-line-weld-materials.html',
                    controller: 'PpLineWeldMaterialController',
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
                    $translatePartialLoader.addPart('ppLineWeldMaterial');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('pp-line-weld-material-detail', {
            parent: 'pp-line-weld-material',
            url: '/pp-line-weld-material/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'tuxAdminApp.ppLineWeldMaterial.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/pp-line-weld-material/pp-line-weld-material-detail.html',
                    controller: 'PpLineWeldMaterialDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('ppLineWeldMaterial');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'PpLineWeldMaterial', function($stateParams, PpLineWeldMaterial) {
                    return PpLineWeldMaterial.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'pp-line-weld-material',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('pp-line-weld-material-detail.edit', {
            parent: 'pp-line-weld-material-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-line-weld-material/pp-line-weld-material-dialog.html',
                    controller: 'PpLineWeldMaterialDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['PpLineWeldMaterial', function(PpLineWeldMaterial) {
                            return PpLineWeldMaterial.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('pp-line-weld-material.new', {
            parent: 'pp-line-weld-material',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-line-weld-material/pp-line-weld-material-dialog.html',
                    controller: 'PpLineWeldMaterialDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                pipelineId: null,
                                pageCode: null,
                                sequenceNumber: null,
                                materialCode: null,
                                name: null,
                                materialDesc: null,
                                spec: null,
                                unit: null,
                                material: null,
                                designQty: null,
                                remark: null,
                                createTime: null,
                                delFlag: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('pp-line-weld-material', null, { reload: 'pp-line-weld-material' });
                }, function() {
                    $state.go('pp-line-weld-material');
                });
            }]
        })
        .state('pp-line-weld-material.edit', {
            parent: 'pp-line-weld-material',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-line-weld-material/pp-line-weld-material-dialog.html',
                    controller: 'PpLineWeldMaterialDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['PpLineWeldMaterial', function(PpLineWeldMaterial) {
                            return PpLineWeldMaterial.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('pp-line-weld-material', null, { reload: 'pp-line-weld-material' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('pp-line-weld-material.delete', {
            parent: 'pp-line-weld-material',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-line-weld-material/pp-line-weld-material-delete-dialog.html',
                    controller: 'PpLineWeldMaterialDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['PpLineWeldMaterial', function(PpLineWeldMaterial) {
                            return PpLineWeldMaterial.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('pp-line-weld-material', null, { reload: 'pp-line-weld-material' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
