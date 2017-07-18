(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('project-welder', {
            parent: 'entity',
            url: '/project-welder?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'pcmsApp.projectWelder.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/project-welder/project-welders.html',
                    controller: 'ProjectWelderController',
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
                    $translatePartialLoader.addPart('projectWelder');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('project-welder-detail', {
            parent: 'project-welder',
            url: '/project-welder/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'pcmsApp.projectWelder.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/project-welder/project-welder-detail.html',
                    controller: 'ProjectWelderDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('projectWelder');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'ProjectWelder', function($stateParams, ProjectWelder) {
                    return ProjectWelder.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'project-welder',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('project-welder-detail.edit', {
            parent: 'project-welder-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/project-welder/project-welder-dialog.html',
                    controller: 'ProjectWelderDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['ProjectWelder', function(ProjectWelder) {
                            return ProjectWelder.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('project-welder.new', {
            parent: 'project-welder',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/project-welder/project-welder-dialog.html',
                    controller: 'ProjectWelderDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                compId: null,
                                code: null,
                                name: null,
                                mobille: null,
                                identityCard: null,
                                workTerm: null,
                                unitName: null,
                                createTime: null,
                                delFlag: null,
                                remark: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('project-welder', null, { reload: 'project-welder' });
                }, function() {
                    $state.go('project-welder');
                });
            }]
        })
        .state('project-welder.edit', {
            parent: 'project-welder',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/project-welder/project-welder-dialog.html',
                    controller: 'ProjectWelderDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['ProjectWelder', function(ProjectWelder) {
                            return ProjectWelder.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('project-welder', null, { reload: 'project-welder' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('project-welder.delete', {
            parent: 'project-welder',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/project-welder/project-welder-delete-dialog.html',
                    controller: 'ProjectWelderDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['ProjectWelder', function(ProjectWelder) {
                            return ProjectWelder.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('project-welder', null, { reload: 'project-welder' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
