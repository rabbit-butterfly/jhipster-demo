'use strict';

describe('Controller Tests', function() {

    describe('BizAuth Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockBizAuth, MockBiz, MockRole;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockBizAuth = jasmine.createSpy('MockBizAuth');
            MockBiz = jasmine.createSpy('MockBiz');
            MockRole = jasmine.createSpy('MockRole');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'BizAuth': MockBizAuth,
                'Biz': MockBiz,
                'Role': MockRole
            };
            createController = function() {
                $injector.get('$controller')("BizAuthDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'tuxAdminApp:bizAuthUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
