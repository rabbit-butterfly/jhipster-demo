(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('project-area', {
            parent: 'entity',
            url: '/project-area?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'pcmsApp.projectArea.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/project-area/project-areas.html',
                    controller: 'ProjectAreaController',
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
                    $translatePartialLoader.addPart('projectArea');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('project-area-detail', {
            parent: 'project-area',
            url: '/project-area/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'pcmsApp.projectArea.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/project-area/project-area-detail.html',
                    controller: 'ProjectAreaDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('projectArea');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'ProjectArea', function($stateParams, ProjectArea) {
                    return ProjectArea.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'project-area',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('project-area-detail.edit', {
            parent: 'project-area-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/project-area/project-area-dialog.html',
                    controller: 'ProjectAreaDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['ProjectArea', function(ProjectArea) {
                            return ProjectArea.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('project-area.new', {
            parent: 'project-area',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/project-area/project-area-dialog.html',
                    controller: 'ProjectAreaDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                compId: null,
                                projId: null,
                                name: null,
                                enName: null,
                                unitCode: null,
                                subConstractor: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('project-area', null, { reload: 'project-area' });
                }, function() {
                    $state.go('project-area');
                });
            }]
        })
        .state('project-area.edit', {
            parent: 'project-area',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/project-area/project-area-dialog.html',
                    controller: 'ProjectAreaDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['ProjectArea', function(ProjectArea) {
                            return ProjectArea.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('project-area', null, { reload: 'project-area' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('project-area.delete', {
            parent: 'project-area',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/project-area/project-area-delete-dialog.html',
                    controller: 'ProjectAreaDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['ProjectArea', function(ProjectArea) {
                            return ProjectArea.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('project-area', null, { reload: 'project-area' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
