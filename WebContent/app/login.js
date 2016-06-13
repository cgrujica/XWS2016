(function (angular) {
	angular.module('app')
	.controller('loginCtrl', function($scope, $state,$rootScope, $log, UserService,shoppingCartFactory){
		$scope.user={};
		$scope.login=function () {
			UserService.login($scope.user.name,$scope.user.password).success(function(data){
				$rootScope.currentUser = data;
				 $state.transitionTo('main');
			});
		};
		
		  function init() {
		    	console.log('ShoppingCartController.Init');
		        shoppingCartFactory.getSC().success(function (data) {
		        	$scope.sc = data;
				});

		        shoppingCartFactory.getTotal().success(function(data) {
		        	$scope.total = data;
		        });
		    }

			init();
		
	});
})(angular);