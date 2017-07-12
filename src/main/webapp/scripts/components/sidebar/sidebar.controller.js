'use strict';

angular.module('tuxAdminApp')
    .controller('SidebarController', function ($scope, $location, $state, Account,Auth, Principal, ENV, User) {
    	$scope.isAuthenticated = Principal.isAuthenticated;
        //$scope.username = JSON.stringify(Principal);
    	
        $scope.username = Principal.getIdentity().login;
    	//$scope.userImage ="/dist/img/user2-160x160.jpg";
    	$scope.userImage ="/bower_components/admin-lte/dist/img/user2-160x160.jpg";
    	
    	
    	$scope.$state = $state;
        $scope.inProduction = ENV === 'prod';

        $scope.logout = function () {
            Auth.logout();
            $state.go('home');
        };
        
        $scope.setActive = function (id) {
        	if($("#"+id).attr('class') == "treeview active"){
        		$("#"+id).attr('class','treeview');
        	}else{
        		$('.treeview').attr('class','treeview');
        		$("#"+id).attr('class','treeview active');
        	} 
        };
        
        $scope.IsPC = function() {
            var userAgentInfo = navigator.userAgent;
            var Agents = ["Android", "iPhone",
                        "SymbianOS", "Windows Phone",
                        "iPad", "iPod"];
            var flag = true;
            for (var v = 0; v < Agents.length; v++) {
                if (userAgentInfo.indexOf(Agents[v]) > 0) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }
        
        $scope.setMenuToActive = function () {
        	if(!$scope.IsPC()){
        		if ($(window).width() > ($.AdminLTE.options.screenSizes.sm - 1)) {
                    if ($("body").hasClass('sidebar-collapse')) {
                      $("body").removeClass('sidebar-collapse').trigger('expanded.pushMenu');
                    } else {
                      $("body").addClass('sidebar-collapse').trigger('collapsed.pushMenu');
                    }
                  }
                  //Handle sidebar push menu for small screens
                  else {
                    if ($("body").hasClass('sidebar-open')) {
                      $("body").removeClass('sidebar-open').removeClass('sidebar-collapse').trigger('collapsed.pushMenu');
                    } else {
                      $("body").addClass('sidebar-open').trigger('expanded.pushMenu');
                    }
                  }
        	}else{
        		return;
        	}
        }; 
    });
