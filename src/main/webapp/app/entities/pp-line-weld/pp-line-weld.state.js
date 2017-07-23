(function() {
    'use strict';

    angular
        .module('tuxAdminApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('pp-line-weld', {
            parent: 'entity',
            url: '/pp-line-weld?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'tuxAdminApp.ppLineWeld.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/pp-line-weld/pp-line-welds.html',
                    controller: 'PpLineWeldController',
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
                    $translatePartialLoader.addPart('ppLineWeld');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('pp-line-weld-detail', {
            parent: 'pp-line-weld',
            url: '/pp-line-weld/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'tuxAdminApp.ppLineWeld.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/pp-line-weld/pp-line-weld-detail.html',
                    controller: 'PpLineWeldDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('ppLineWeld');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'PpLineWeld', function($stateParams, PpLineWeld) {
                    return PpLineWeld.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'pp-line-weld',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('pp-line-weld-detail.edit', {
            parent: 'pp-line-weld-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-line-weld/pp-line-weld-dialog.html',
                    controller: 'PpLineWeldDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['PpLineWeld', function(PpLineWeld) {
                            return PpLineWeld.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('pp-line-weld.new', {
            parent: 'pp-line-weld',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-line-weld/pp-line-weld-dialog.html',
                    controller: 'PpLineWeldDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                pipeId: null,
                                pageCode: null,
                                jiont: null,
                                wpsno: null,
                                jlocation: null,
                                jclass: null,
                                finishDate: null,
                                jsize: null,
                                thickness: null,
                                jtype: null,
                                weldingProcess: null,
                                fixedRotat: null,
                                rootWelder: null,
                                examitem: null,
                                coverWelder: null,
                                visual: null,
                                pieceNo1: null,
                                weldingMatial: null,
                                pieceNo2: null,
                                heatNo1: null,
                                heatNo2: null,
                                alterCode: null,
                                alterType: null,
                                dailyNo: null,
                                hardessRec: null,
                                heatRec: null,
                                rtLot: null,
                                rtSample: null,
                                remark: null,
                                createTime: null,
                                delFlag: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('pp-line-weld', null, { reload: 'pp-line-weld' });
                }, function() {
                    $state.go('pp-line-weld');
                });
            }]
        })
        .state('pp-line-weld.edit', {
            parent: 'pp-line-weld',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-line-weld/pp-line-weld-dialog.html',
                    controller: 'PpLineWeldDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['PpLineWeld', function(PpLineWeld) {
                            return PpLineWeld.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('pp-line-weld', null, { reload: 'pp-line-weld' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('pp-line-weld.delete', {
            parent: 'pp-line-weld',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-line-weld/pp-line-weld-delete-dialog.html',
                    controller: 'PpLineWeldDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['PpLineWeld', function(PpLineWeld) {
                            return PpLineWeld.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('pp-line-weld', null, { reload: 'pp-line-weld' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
