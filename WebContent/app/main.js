(function (angular) {
	angular.module('app')
	.controller('mainCtrl', function($scope, $log, UserService){
		$scope.message = 'Uspesno ste se ulogovali';
	});
})(angular);