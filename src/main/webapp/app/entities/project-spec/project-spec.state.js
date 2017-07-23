(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('project-spec', {
            parent: 'entity',
            url: '/project-spec?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'tuxAdminApp.projectSpec.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/project-spec/project-specs.html',
                    controller: 'ProjectSpecController',
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
                    $translatePartialLoader.addPart('projectSpec');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('project-spec-detail', {
            parent: 'project-spec',
            url: '/project-spec/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'tuxAdminApp.projectSpec.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/project-spec/project-spec-detail.html',
                    controller: 'ProjectSpecDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('projectSpec');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'ProjectSpec', function($stateParams, ProjectSpec) {
                    return ProjectSpec.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'project-spec',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('project-spec-detail.edit', {
            parent: 'project-spec-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/project-spec/project-spec-dialog.html',
                    controller: 'ProjectSpecDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['ProjectSpec', function(ProjectSpec) {
                            return ProjectSpec.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('project-spec.new', {
            parent: 'project-spec',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/project-spec/project-spec-dialog.html',
                    controller: 'ProjectSpecDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                projId: null,
                                name: null,
                                size: null,
                                unit: null,
                                remark: null,
                                createTime: null,
                                delFlag: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('project-spec', null, { reload: 'project-spec' });
                }, function() {
                    $state.go('project-spec');
                });
            }]
        })
        .state('project-spec.edit', {
            parent: 'project-spec',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/project-spec/project-spec-dialog.html',
                    controller: 'ProjectSpecDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['ProjectSpec', function(ProjectSpec) {
                            return ProjectSpec.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('project-spec', null, { reload: 'project-spec' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('project-spec.delete', {
            parent: 'project-spec',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/project-spec/project-spec-delete-dialog.html',
                    controller: 'ProjectSpecDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['ProjectSpec', function(ProjectSpec) {
                            return ProjectSpec.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('project-spec', null, { reload: 'project-spec' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
