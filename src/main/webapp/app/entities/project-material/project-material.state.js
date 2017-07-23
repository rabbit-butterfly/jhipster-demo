(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('project-material', {
            parent: 'entity',
            url: '/project-material?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'tuxAdminApp.projectMaterial.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/project-material/project-materials.html',
                    controller: 'ProjectMaterialController',
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
                    $translatePartialLoader.addPart('projectMaterial');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('project-material-detail', {
            parent: 'project-material',
            url: '/project-material/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'tuxAdminApp.projectMaterial.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/project-material/project-material-detail.html',
                    controller: 'ProjectMaterialDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('projectMaterial');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'ProjectMaterial', function($stateParams, ProjectMaterial) {
                    return ProjectMaterial.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'project-material',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('project-material-detail.edit', {
            parent: 'project-material-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/project-material/project-material-dialog.html',
                    controller: 'ProjectMaterialDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['ProjectMaterial', function(ProjectMaterial) {
                            return ProjectMaterial.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('project-material.new', {
            parent: 'project-material',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/project-material/project-material-dialog.html',
                    controller: 'ProjectMaterialDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                projId: null,
                                name: null,
                                parentId: null,
                                remark: null,
                                createTime: null,
                                delFlag: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('project-material', null, { reload: 'project-material' });
                }, function() {
                    $state.go('project-material');
                });
            }]
        })
        .state('project-material.edit', {
            parent: 'project-material',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/project-material/project-material-dialog.html',
                    controller: 'ProjectMaterialDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['ProjectMaterial', function(ProjectMaterial) {
                            return ProjectMaterial.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('project-material', null, { reload: 'project-material' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('project-material.delete', {
            parent: 'project-material',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/project-material/project-material-delete-dialog.html',
                    controller: 'ProjectMaterialDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['ProjectMaterial', function(ProjectMaterial) {
                            return ProjectMaterial.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('project-material', null, { reload: 'project-material' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
