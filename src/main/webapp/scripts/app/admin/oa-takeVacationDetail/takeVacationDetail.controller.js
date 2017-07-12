'use strict';

angular.module('tuxAdminApp')
    .controller('takeVacationDetailController', function ($scope, takeVacationDetailService,takeVacationService, ParseLinks,$uibModal) {
    	
    	$scope.takeVacationDetails = [];
    	$scope.takeVacation = {};
        $scope.authorities = ["ROLE_USER", "ROLE_USER"];

        $scope.page = 1;
        $scope.loadAll = function () {
        	var data = {};
        	data.page=$scope.page - 1;
        	data.size= 10;
        	data.createdBy="";
        	data.startDate="";
        	data.endDate="";
        	data.status="";
        	takeVacationDetailService.query(data, function (result, headers) {
                $scope.links = ParseLinks.parse(headers('link'));
                $scope.totalItems = headers('X-Total-Count');
                $scope.takeVacationDetails = result;
            });
        	takeVacationService.query(function (result, headers) {
                $scope.takeVacation = result;
            });
        };

        $scope.loadPage = function (page) {
            $scope.page = page;
            $scope.loadAll();
        }
        $scope.loadAll();
        console.log($scope.takeVacationDetail);

        $scope.pass = function (param) {
        	takeVacationDetailService.patch(param, function () {
                $scope.loadAll();
                $scope.clear();
            });
        };
       

        $scope.clear = function () { 
            $scope.takeVacationDetail = {
            		id: null, createdBy: null, createdDate: null, startDate: null, endDate: null,
                    timeLength: null, status: null, remark: null
            };
     //       $scope.editForm.$setPristine();
      //      $scope.editForm.$setUntouched();
        };
        
        $scope.formatDate =  function (dateToFormat) {
            if (dateToFormat !== undefined && !angular.isString(dateToFormat)) {
                return dateToFormat.dateToFormat.getYear() + '-' + dateToFormat.getMonth() + '-' + dateToFormat.getDay();
            }
            return dateToFormat;
        };
        
        $scope.search = function(){
        	var data = {};
        	data.page=$scope.page - 1;
        	data.size= 10;
        	data.createdBy=$scope.formData.createdBy;
        	data.startDate=$scope.formatDate($scope.formData.startDate);
        	data.endDate=$scope.formatDate($scope.formData.endDate);
        	data.status=$scope.formData.status;

        	takeVacationDetailService.query(data, function (result, headers) {
                $scope.links = ParseLinks.parse(headers('link'));
                $scope.totalItems = headers('X-Total-Count');
                $scope.takeVacationDetails = result;
            });
        };
    });
