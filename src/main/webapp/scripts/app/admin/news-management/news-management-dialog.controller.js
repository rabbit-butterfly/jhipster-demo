'use strict';

angular.module('tuxAdminApp').controller('NewsManagementDialogController',
    ['$scope', '$stateParams','newsService', 'categorySearchService','Upload','Language',
        function($scope, $stateParams,  newsService, categorySearchService,Upload, Language) {
    	$scope.parentCategories = [];
    	$scope.categories = [];
    	
        Language.getAll().then(function (languages) {
            $scope.languages = languages;
        });

        $scope.page = 1;
        $scope.loadAll = function () {
        	categorySearchService.query({query : 0},{page: $scope.page - 1, size: 10}, function (result, headers) {
                $scope.parentCategories = result;
            });
        };

        $scope.loadAll();
        
        $scope.searchCategory = function (self) {
        	categorySearchService.query({query : self.parentId},{page: $scope.page - 1, size: 10}, function (result, headers) {
                $scope.categories = result;
            });
        };

        
        $scope.news = {};
    	
    	$scope.init = function(){
    		if($stateParams.id !=null && $stateParams.id != ""){
    			newsService.get({id:$stateParams.id},function (result, headers) {
   				 	$scope.news = result;
   			 	});
   		 	}
    	};
    	
    	$scope.init();

        $scope.upload = function (file) {
        	var data = {title:$scope.news.title,categoryId:$scope.news.categoryId,summary:$scope.news.summary,contentUrl:$scope.news.contentUrl}
        	var reqMetod ='POST';
        	if ($scope.news.id != null) {
        		reqMetod ='PUT';
        		data.id = $scope.news.id;
            }else{
            	if(file == undefined){
            		alert("请添加一张配图!");
            		return;
            	}
            }
        	$scope.fileInfo = file;
        	
            Upload.upload({
                //服务端接收
                url: 'api/news',
                method: reqMetod,
                //上传的文件
                file: file,	
                data: data
            }).progress(function (evt) {
                //进度条
                var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
//               
            }).success(function (data, status, headers, config) {
            	window.location = "/#/news";
                window.location.reload();
            	
            }).error(function (data, status, headers, config) {
                //上传失败
                console.log('error status: ' + status);
                 if (status == 500 && data.exception == "org.springframework.web.multipart.MultipartException"){
                	 alert("图片大小超出限制,请上传528K以内的图片");
                 }
            });
        };

        $scope.save = function () {	
    		var contentUrl = $scope.news.contentUrl;
    		var urlStart = contentUrl.indexOf("http");
    		if(urlStart == -1){
         	   alert("请输入正确的正文链接!");
         	   return false;
         	}
            $scope.upload($scope.file);
            
        };
}]);
