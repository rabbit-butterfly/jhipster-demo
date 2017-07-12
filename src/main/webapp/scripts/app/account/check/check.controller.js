'use strict';

angular.module('tuxAdminApp')
    .controller('CheckController', function ($scope,checkConfigService) {
    	
    	/*angular.module('tuxAdminApp').controller('UserManagementDialogController',
    		    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'User', 'Language',
    		        function($scope, $stateParams, $uibModalInstance, entity, User, Language) {
*/
    	
    	$scope.checkConfig = {};
    	
        $scope.init = function () {
        	$scope.btnSave="quiet";
        	$scope.initStatus=true;
        	checkConfigService.query(function (result, headers) {
                $scope.checkConfig = result;
            });
        };
        $scope.error = null;
        $scope.success =null;
        $scope.save = function () {
        	$scope.isSaving = true;
        	if($scope.checkConfig.userId !=null){
        		checkConfigService.update($scope.checkConfig);
        	} else{
        		checkConfigService.save($scope.checkConfig);
        	}
        	$scope.btnSave="quiet";
        	$scope.initStatus=true;
        };
        
        $scope.activeSave = function(){
        	$scope.btnSave="active";
        	$scope.initStatus=false;
        	
        };
        
        $scope.init();
        
    });
