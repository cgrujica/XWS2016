(function(angular) {
	angular.module('app').controller(
			'poslanikCtrl',
			function($scope, $state, $log, $rootScope, UserService, $window,
					$timeout, ResourceService) {

				init = function() {
					$scope.user = getUser();
					
					$scope.predlog ={};
					$timeout(function() {
						if (!$scope.user.hasOwnProperty('ime')) {
							$state.go('login');
						} else {
							$scope.message = 'Uspesno ste se ulogovali';
						}
					}, 1000);
					getRes();
					Xonomy.render(xml, editor, null);
				};

				init();

				function getUser() {
					return JSON.parse($window.localStorage['currentUser']);
				}
				;

				function getRes() {
					ResourceService.getRes().success(function(data) {
						$scope.res = data;
					});
				}
				;

				$scope.logout = function() {
					$window.localStorage.setItem('currentUser', JSON
							.stringify({}));
					$state.go('gradjani');
				};

				var xml = '<zakon naziv="naziv1" ID="ID1sa"><deo><glava><title></title><odeljak><clan><naslov></naslov><sadrzaj></sadrzaj></clan></odeljak></glava></deo></zakon>';
				var editor=document.getElementById("editor");
				

			});
})(angular);