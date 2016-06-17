(function(angular) {
	angular.module('app').controller(
			'gradjaniCtrl',
			function($scope, $state, $log, $rootScope, UserService, $window,
					$timeout, ResourceService) {

				init = function() {
					$scope.user = getUser();
					$scope.search = "";
					$timeout(function() {
						if (!$scope.user) {
							getRes();
							$window.localStorage.setItem('currentUser', JSON
									.stringify({}));
						} else {
							if ($scope.user.hasOwnProperty('ime')) {
								$state.go('main');
							} else {
								getRes();
							}
						}
					}, 1000);
				};

				init();

				function getUser() {
					if ($window.localStorage['currentUser']==undefined ) {
						$window.localStorage.setItem('currentUser', JSON
								.stringify({}));
						return{};
					}
					return JSON.parse($window.localStorage['currentUser']);
				}
				;

				function getRes() {
					ResourceService.getRes().success(function(data) {
						$scope.res = data;
					});
				}
				;

				$scope.login = function() {
					$state.go('login');
				};
			});
})(angular);