(function() {
    'use strict';

    angular
        .module('pcmsApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('pp-iinspection-tatio', {
            parent: 'entity',
            url: '/pp-iinspection-tatio?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'pcmsApp.ppIinspectionTatio.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/pp-iinspection-tatio/pp-iinspection-tatios.html',
                    controller: 'PpIinspectionTatioController',
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
                    $translatePartialLoader.addPart('ppIinspectionTatio');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('pp-iinspection-tatio-detail', {
            parent: 'pp-iinspection-tatio',
            url: '/pp-iinspection-tatio/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'pcmsApp.ppIinspectionTatio.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/pp-iinspection-tatio/pp-iinspection-tatio-detail.html',
                    controller: 'PpIinspectionTatioDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('ppIinspectionTatio');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'PpIinspectionTatio', function($stateParams, PpIinspectionTatio) {
                    return PpIinspectionTatio.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'pp-iinspection-tatio',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('pp-iinspection-tatio-detail.edit', {
            parent: 'pp-iinspection-tatio-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-iinspection-tatio/pp-iinspection-tatio-dialog.html',
                    controller: 'PpIinspectionTatioDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['PpIinspectionTatio', function(PpIinspectionTatio) {
                            return PpIinspectionTatio.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('pp-iinspection-tatio.new', {
            parent: 'pp-iinspection-tatio',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-iinspection-tatio/pp-iinspection-tatio-dialog.html',
                    controller: 'PpIinspectionTatioDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                compId: null,
                                projId: null,
                                inspectionCode: null,
                                rtRate: null,
                                rtRateGd: null,
                                rtStandard: null,
                                rtGrade: null,
                                ptRate: null,
                                ptStandard: null,
                                ptGrade: null,
                                utRate: null,
                                utStandard: null,
                                utGrade: null,
                                mtRate: null,
                                mtStandard: null,
                                mtGrade: null,
                                createTime: null,
                                delFlag: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('pp-iinspection-tatio', null, { reload: 'pp-iinspection-tatio' });
                }, function() {
                    $state.go('pp-iinspection-tatio');
                });
            }]
        })
        .state('pp-iinspection-tatio.edit', {
            parent: 'pp-iinspection-tatio',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-iinspection-tatio/pp-iinspection-tatio-dialog.html',
                    controller: 'PpIinspectionTatioDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['PpIinspectionTatio', function(PpIinspectionTatio) {
                            return PpIinspectionTatio.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('pp-iinspection-tatio', null, { reload: 'pp-iinspection-tatio' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('pp-iinspection-tatio.delete', {
            parent: 'pp-iinspection-tatio',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/pp-iinspection-tatio/pp-iinspection-tatio-delete-dialog.html',
                    controller: 'PpIinspectionTatioDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['PpIinspectionTatio', function(PpIinspectionTatio) {
                            return PpIinspectionTatio.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('pp-iinspection-tatio', null, { reload: 'pp-iinspection-tatio' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
