(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('project-sub-constractor', {
            parent: 'entity',
            url: '/project-sub-constractor?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'pcmsApp.projectSubConstractor.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/project-sub-constractor/project-sub-constractors.html',
                    controller: 'ProjectSubConstractorController',
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
                    $translatePartialLoader.addPart('projectSubConstractor');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('project-sub-constractor-detail', {
            parent: 'project-sub-constractor',
            url: '/project-sub-constractor/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'pcmsApp.projectSubConstractor.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/project-sub-constractor/project-sub-constractor-detail.html',
                    controller: 'ProjectSubConstractorDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('projectSubConstractor');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'ProjectSubConstractor', function($stateParams, ProjectSubConstractor) {
                    return ProjectSubConstractor.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'project-sub-constractor',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('project-sub-constractor-detail.edit', {
            parent: 'project-sub-constractor-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/project-sub-constractor/project-sub-constractor-dialog.html',
                    controller: 'ProjectSubConstractorDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['ProjectSubConstractor', function(ProjectSubConstractor) {
                            return ProjectSubConstractor.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('project-sub-constractor.new', {
            parent: 'project-sub-constractor',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/project-sub-constractor/project-sub-constractor-dialog.html',
                    controller: 'ProjectSubConstractorDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                projId: null,
                                name: null,
                                remark: null,
                                createTime: null,
                                delFlag: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('project-sub-constractor', null, { reload: 'project-sub-constractor' });
                }, function() {
                    $state.go('project-sub-constractor');
                });
            }]
        })
        .state('project-sub-constractor.edit', {
            parent: 'project-sub-constractor',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/project-sub-constractor/project-sub-constractor-dialog.html',
                    controller: 'ProjectSubConstractorDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['ProjectSubConstractor', function(ProjectSubConstractor) {
                            return ProjectSubConstractor.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('project-sub-constractor', null, { reload: 'project-sub-constractor' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('project-sub-constractor.delete', {
            parent: 'project-sub-constractor',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/project-sub-constractor/project-sub-constractor-delete-dialog.html',
                    controller: 'ProjectSubConstractorDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['ProjectSubConstractor', function(ProjectSubConstractor) {
                            return ProjectSubConstractor.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('project-sub-constractor', null, { reload: 'project-sub-constractor' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
