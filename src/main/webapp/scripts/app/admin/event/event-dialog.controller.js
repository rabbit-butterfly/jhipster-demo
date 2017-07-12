'use strict';

angular.module('tuxAdminApp').controller('EventDialogController',
    ['$scope','$state','$stateParams', 'eventService' ,
        function($scope,$state,$stateParams, eventService) {
    	 $scope.event ={};
    	 $scope.init = function () {
    		 if($stateParams.id !=null && $stateParams.id != ""){
    			 eventService.get({id:$stateParams.id},function (result, headers) {
    				 $scope.event = result;
    				 CKEDITOR.replace('content');
    				 CKEDITOR.instances.content.setData($scope.event.content);
    			 });
    		 }else{
    			 CKEDITOR.replace('content');
    		 }
         };
         var onSaveSuccess = function (result) {
             $scope.isSaving = false;
             $state.go('event');
         };

         var onSaveError = function (result) {
             $scope.isSaving = false;
         };
         
        $scope.save = function () {
        	var content = CKEDITOR.instances.content.getData();
        	var contentText = CKEDITOR.instances.content.document.getBody().getText(); //取得纯文本  
        	if(contentText == null || contentText==""){
        		alert("请输入正文介绍！");
        		return;
        	}else if(contentText.length >10000){
        		alert("正文介绍不能多于10000个汉字！");
        		return;
        	}
        	
        	if($scope.event.status == null || $scope.event.content == ""){
        		alert("请选择活动状态！");
        		return;
        	}
        	$scope.event.content=contentText;
        	$scope.event.startDate=$("#begin_time").val();
        	$scope.event.endDate=$("#end_time").val();
        	$scope.isSaving = true;
        	if($scope.event.id !=null){
        		eventService.update($scope.event, onSaveSuccess, onSaveError);
        	} else{
        		eventService.save($scope.event ,onSaveSuccess, onSaveError);
        	}
        };
        $scope.init();
}]);
