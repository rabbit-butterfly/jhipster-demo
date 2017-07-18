(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('pp-line', {
            parent: 'entity',
            url: '/pp-line?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'pcmsApp.ppLine.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/pp-line/pp-lines.html',
                    controller: 'PpLineController',
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
                    $translatePartialLoader.addPart('ppLine');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('pp-line-detail', {
            parent: 'pp-line',
            url: '/pp-line/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'pcmsApp.ppLine.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/pp-line/pp-line-detail.html',
                    controller: 'PpLineDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('ppLine');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'PpLine', function($stateParams, PpLine) {
                    return PpLine.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'pp-line',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('pp-line-detail.edit', {
            parent: 'pp-line-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-line/pp-line-dialog.html',
                    controller: 'PpLineDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['PpLine', function(PpLine) {
                            return PpLine.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('pp-line.new', {
            parent: 'pp-line',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-line/pp-line-dialog.html',
                    controller: 'PpLineDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                compId: null,
                                projId: null,
                                areaId: null,
                                lineNum: null,
                                lineVersion: null,
                                size: null,
                                serv: null,
                                classSpec: null,
                                lineFrom: null,
                                lineTo: null,
                                operatePressure: null,
                                operateTemperature: null,
                                lineLevel: null,
                                lineCode: null,
                                designPressure: null,
                                designTemperature: null,
                                kindLevel: null,
                                inspectionCode: null,
                                insulationCode: null,
                                insulationHigh: null,
                                paintCode: null,
                                pIDiagram: null,
                                testPressure: null,
                                testMaterial: null,
                                jacketedPipe: null,
                                remark: null,
                                createTime: null,
                                delFlag: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('pp-line', null, { reload: 'pp-line' });
                }, function() {
                    $state.go('pp-line');
                });
            }]
        })
        .state('pp-line.edit', {
            parent: 'pp-line',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-line/pp-line-dialog.html',
                    controller: 'PpLineDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['PpLine', function(PpLine) {
                            return PpLine.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('pp-line', null, { reload: 'pp-line' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('pp-line.delete', {
            parent: 'pp-line',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-line/pp-line-delete-dialog.html',
                    controller: 'PpLineDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['PpLine', function(PpLine) {
                            return PpLine.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('pp-line', null, { reload: 'pp-line' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
