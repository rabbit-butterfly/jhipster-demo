'use strict';

angular.module('tuxAdminApp')
    .controller('EventController', function ($scope,$filter, eventService, Upload,ParseLinks) {
    	$scope.events =[];
    	$scope.event ={};
    	
    	 $scope.page = 1;
         $scope.loadAll = function () {
         	var data = {};
         	data.page=$scope.page - 1;
         	data.size= 10;
         	data.title="";
         	data.startDate="";
         	data.endDate="";
         	data.status="";
         	eventService.query(data, function (result, headers) {
                 $scope.links = ParseLinks.parse(headers('link'));
                 $scope.totalItems = headers('X-Total-Count');
                 $scope.events = result;
             });
         };

         $scope.loadPage = function (page) {
             $scope.page = page;
             $scope.loadAll();
         };
         $scope.loadAll();
         console.log($scope.event);
         
         
        $scope.pass = function (param) {
        	eventService.patch(param, function () {
                $scope.loadAll();
//                $scope.clear();
            });
        };
        
        
        $scope.error = null;
        $scope.success =null;
        $scope.save = function () {
        	$scope.isSaving = true;
        	if($scope.event.id !=null){
        		eventService.update($scope.event);
        	} else{
        		eventService.save($scope.event);
        	}
        	$scope.btnSave="quiet";
        	$scope.initStatus=true;
        };
        
        $scope.activeSave = function(){
        	$scope.btnSave="active";
        	$scope.initStatus=false;
        	
        };
        
       
        //提交
        $scope.submit = function () {
            $scope.upload($scope.file);
        };
        $scope.upload = function (file) {
            $scope.fileInfo = file;
            
            Upload.upload({
                //服务端接收
                url: 'api/import',
                method: 'POST',
                //上传的文件
                file: file
            }).progress(function (evt) {
                //进度条
                var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
//                console.log('progess:' + progressPercentage + '%' + evt.config.file.name);
            }).success(function (data, status, headers, config) {
                //上传成功
//            	debugger
//            	alert('file ' + config.file.name + 'uploaded. Response: ' + headers);
            	
//                console.log('file ' + config.file.name + 'uploaded. Response: ' + data);
//                $scope.uploadImg = data;
//            	 $scope.loadData();
            	 $scope.loadAll();
            }).error(function (data, status, headers, config) {
                //上传失败
                console.log('error status: ' + status);
            });
        };
        
        
        
        $scope.formatDate =  function (dateToFormat) {
            if (dateToFormat !== undefined && !angular.isString(dateToFormat)) {
                return dateToFormat.dateToFormat.getYear() + '-' + dateToFormat.getMonth() + '-' + dateToFormat.getDay();
            }
            return dateToFormat;
        };
        
    });
