'use strict';

angular.module('tuxAdminApp').controller('CategoryMaintenanceDialogController',
    ['$scope', '$stateParams', 'categoryService', 'Language',
        function($scope, $stateParams, categoryService, Language) {
        $scope.category = {};
        
        $scope.init = function(){
    		if($stateParams.id !=null && $stateParams.id != ""){
    			categoryService.get({id:$stateParams.id},function (result, headers) {
   				 	$scope.category = result;
   			 	});
   		 	}
    	};
    	
    	$scope.init();
    	
        var onSaveSuccess = function (result) {
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if($scope.category.status == null){
            	alert("请选择类目的状态!");
            	return false;
            }
            if ($scope.category.id != null) {
            	categoryService.update($scope.category, onSaveSuccess, onSaveError);
            } else {
            	categoryService.save($scope.category, onSaveSuccess, onSaveError);
            }
            window.location = "/#/category-maintenance";
            window.location.reload();
        };

}]);
