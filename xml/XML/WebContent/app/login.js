(function (angular) {
	angular.module('app')
	.controller('loginCtrl', function($scope, $state,$rootScope, $log, UserService,$window){
		$scope.user={};
		$scope.login=function () {
			UserService.login($scope.user.name,$scope.user.password).success(function(data){
				 $window.localStorage.setItem('currentUser', JSON.stringify(data));
				 $state.transitionTo('main');
			});
		};
		
		  
		  $scope.nazad=function () {
				
					 $state.transitionTo('gradjani');
	
			};

			init();
		
	});
})(angular);