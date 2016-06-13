(function (angular) {
	angular.module('login',['UserService'])
	.controller('loginCtrl', function($scope, $log, UserService){
		$scope.user={};
		$scope.login=function () {
			UserService.login($scope.user.name,$scope.user.password,success,error);
		};
		function success(success) {
			if (success) {
				$log.info('success!');
			}
			else{
				$log.info('failure!');
			}
		}
	});
}(angular));