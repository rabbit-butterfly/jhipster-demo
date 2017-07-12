'use strict';

angular.module('tuxAdminApp').controller('CategoryMaintenanceDialogTwoController',
    ['$scope', '$stateParams', 'categorySearchService','categoryService', 'Language',
        function($scope, $stateParams, categorySearchService,categoryService, Language) {
    	$scope.categories = [];
        Language.getAll().then(function (languages) {
            $scope.languages = languages;
        });

        $scope.page = 1;
        $scope.loadAll = function () {
        	categorySearchService.query({query : 0},{page: $scope.page - 1, size: 10}, function (result, headers) {
                $scope.categories = result;
            });
        };

        $scope.loadPage = function (page) {
            $scope.page = page;
            $scope.loadAll();
        };
        $scope.loadAll();

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
            window.location = "/#/category/"+$scope.category.parentId;
            window.location.reload();
        };
}]);
