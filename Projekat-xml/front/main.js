(function (angular) {
	angular.module('main',[])
	.controller('mainCtrl', function($scope, $log, UserService){
		$scope.message = 'Uspesno ste se ulogovali'
}(angular));