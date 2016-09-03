(function(angular) {
	angular.module('app').controller(
			'mainCtrl',
			function($scope, $state, $log, $rootScope, UserService, $window,
					$timeout, ResourceService) {

				init = function() {
					$scope.user = getUser();
					$scope.search = "";
					$scope.sednica = false;
					$scope.faza = "  ";
					$scope.sledecaFaza = "Zapocni Sednicu";
					$timeout(function() {
						if (!$scope.user.hasOwnProperty('ime')) {
							$state.go('login');
						} else {
							$scope.message = 'Uspesno ste se ulogovali';
						}
					}, 1000);
					getRes();
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

				$scope.setFaza = function() {		//faze sednice, menjaju se pritiskom na dugme i popunjavanjem rezultata glasanja
					if (!$scope.faza || $scope.faza.trim()=="") {
						$scope.faza = "Informisanje";
						$scope.sledecaFaza = "Predlozi";
						$scope.sednica = true;
						getRes();
						return;
					} else {
						if ($scope.faza == "Informisanje") {
							$scope.sledecaFaza = "Glasanje u nacelu";
							$scope.faza = "Predlozi";
							return;
						}
						if ($scope.faza == "Predlozi") {
							$scope.sledecaFaza = "Glasanje";
							$scope.faza = "Glasanje u nacelu";
							return;
						}
						if ($scope.faza == "Glasanje u nacelu") {
							$scope.sledecaFaza = "Rezultati";
							$scope.faza = "Glasanje";
							return;
						}
						if ($scope.faza == "Glasanje") {
							$scope.sledecaFaza = "Zavrsi Sednicu";
							$scope.faza = "Rezultati";
							return;
						}
						if ($scope.faza == "Rezultati") {
							$scope.faza = "";
							$scope.sledecaFaza = "Zapocni Sednicu";
							$scope.sednica = false;
							return;
						}

					}

				};

				$scope.isPrecednik = function() {		//provera da li je korisnik ulogovan i ako jeste da li je precednik
					if (!!$scope.user) {
						return $scope.user.uloga == "precednik";
					}
					return false;
				};

				$scope.gotoviRez = function() {		//sluzi za slanje rezultata svakog pojedinackog glasanja na backend, predvidjeno da se salju 3 vrednosti "za","protiv" i "uzdrzano"
					//	ResourceService.store().success(function(data) {
					$scope.res.splice(0,1);

					//	});

				};

				$scope.gotovo = function() {		//provera da li su svi rezultati uneseni
					if($scope.res){
						return ($scope.res.length > 0 && $scope.faza=="Rezultati");
					}
					return true;
				};

			});
})(angular);