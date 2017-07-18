(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('pp-line-drawing', {
            parent: 'entity',
            url: '/pp-line-drawing?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'pcmsApp.ppLineDrawing.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/pp-line-drawing/pp-line-drawings.html',
                    controller: 'PpLineDrawingController',
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
                    $translatePartialLoader.addPart('ppLineDrawing');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('pp-line-drawing-detail', {
            parent: 'pp-line-drawing',
            url: '/pp-line-drawing/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'pcmsApp.ppLineDrawing.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/pp-line-drawing/pp-line-drawing-detail.html',
                    controller: 'PpLineDrawingDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('ppLineDrawing');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'PpLineDrawing', function($stateParams, PpLineDrawing) {
                    return PpLineDrawing.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'pp-line-drawing',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('pp-line-drawing-detail.edit', {
            parent: 'pp-line-drawing-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-line-drawing/pp-line-drawing-dialog.html',
                    controller: 'PpLineDrawingDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['PpLineDrawing', function(PpLineDrawing) {
                            return PpLineDrawing.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('pp-line-drawing.new', {
            parent: 'pp-line-drawing',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-line-drawing/pp-line-drawing-dialog.html',
                    controller: 'PpLineDrawingDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                pipeId: null,
                                pageCode: null,
                                versionCode: null,
                                alterationCode: null,
                                name: null,
                                filePath: null,
                                remark: null,
                                createTime: null,
                                delFlag: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('pp-line-drawing', null, { reload: 'pp-line-drawing' });
                }, function() {
                    $state.go('pp-line-drawing');
                });
            }]
        })
        .state('pp-line-drawing.edit', {
            parent: 'pp-line-drawing',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-line-drawing/pp-line-drawing-dialog.html',
                    controller: 'PpLineDrawingDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['PpLineDrawing', function(PpLineDrawing) {
                            return PpLineDrawing.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('pp-line-drawing', null, { reload: 'pp-line-drawing' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('pp-line-drawing.delete', {
            parent: 'pp-line-drawing',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-line-drawing/pp-line-drawing-delete-dialog.html',
                    controller: 'PpLineDrawingDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['PpLineDrawing', function(PpLineDrawing) {
                            return PpLineDrawing.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('pp-line-drawing', null, { reload: 'pp-line-drawing' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
