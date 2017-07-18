(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('welder-skill', {
            parent: 'entity',
            url: '/welder-skill?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'pcmsApp.welderSkill.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/welder-skill/welder-skills.html',
                    controller: 'WelderSkillController',
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
                    $translatePartialLoader.addPart('welderSkill');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('welder-skill-detail', {
            parent: 'welder-skill',
            url: '/welder-skill/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'pcmsApp.welderSkill.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/welder-skill/welder-skill-detail.html',
                    controller: 'WelderSkillDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('welderSkill');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'WelderSkill', function($stateParams, WelderSkill) {
                    return WelderSkill.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'welder-skill',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('welder-skill-detail.edit', {
            parent: 'welder-skill-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/welder-skill/welder-skill-dialog.html',
                    controller: 'WelderSkillDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['WelderSkill', function(WelderSkill) {
                            return WelderSkill.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('welder-skill.new', {
            parent: 'welder-skill',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/welder-skill/welder-skill-dialog.html',
                    controller: 'WelderSkillDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                welderId: null,
                                name: null,
                                assessmentDate: null,
                                effectiveDate: null,
                                createTime: null,
                                delFlag: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('welder-skill', null, { reload: 'welder-skill' });
                }, function() {
                    $state.go('welder-skill');
                });
            }]
        })
        .state('welder-skill.edit', {
            parent: 'welder-skill',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/welder-skill/welder-skill-dialog.html',
                    controller: 'WelderSkillDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['WelderSkill', function(WelderSkill) {
                            return WelderSkill.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('welder-skill', null, { reload: 'welder-skill' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('welder-skill.delete', {
            parent: 'welder-skill',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/welder-skill/welder-skill-delete-dialog.html',
                    controller: 'WelderSkillDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['WelderSkill', function(WelderSkill) {
                            return WelderSkill.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('welder-skill', null, { reload: 'welder-skill' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
