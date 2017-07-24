(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('pp-inspection-rule', {
            parent: 'entity',
            url: '/pp-inspection-rule?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'tuxAdminApp.ppInspectionRule.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/pp-inspection-rule/pp-inspection-rules.html',
                    controller: 'PpInspectionRuleController',
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
                    $translatePartialLoader.addPart('ppInspectionRule');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('pp-inspection-rule-detail', {
            parent: 'pp-inspection-rule',
            url: '/pp-inspection-rule/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'tuxAdminApp.ppInspectionRule.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/pp-inspection-rule/pp-inspection-rule-detail.html',
                    controller: 'PpInspectionRuleDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('ppInspectionRule');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'PpInspectionRule', function($stateParams, PpInspectionRule) {
                    return PpInspectionRule.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'pp-inspection-rule',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('pp-inspection-rule-detail.edit', {
            parent: 'pp-inspection-rule-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-inspection-rule/pp-inspection-rule-dialog.html',
                    controller: 'PpInspectionRuleDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['PpInspectionRule', function(PpInspectionRule) {
                            return PpInspectionRule.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('pp-inspection-rule.new', {
            parent: 'pp-inspection-rule',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-inspection-rule/pp-inspection-rule-dialog.html',
                    controller: 'PpInspectionRuleDialogController',
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
                                jacketedPipe: null,
                                inspectionCode: null,
                                createTime: null,
                                delFlag: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('pp-inspection-rule', null, { reload: 'pp-inspection-rule' });
                }, function() {
                    $state.go('pp-inspection-rule');
                });
            }]
        })
        .state('pp-inspection-rule.edit', {
            parent: 'pp-inspection-rule',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-inspection-rule/pp-inspection-rule-dialog.html',
                    controller: 'PpInspectionRuleDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['PpInspectionRule', function(PpInspectionRule) {
                            return PpInspectionRule.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('pp-inspection-rule', null, { reload: 'pp-inspection-rule' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('pp-inspection-rule.delete', {
            parent: 'pp-inspection-rule',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-inspection-rule/pp-inspection-rule-delete-dialog.html',
                    controller: 'PpInspectionRuleDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['PpInspectionRule', function(PpInspectionRule) {
                            return PpInspectionRule.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('pp-inspection-rule', null, { reload: 'pp-inspection-rule' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
