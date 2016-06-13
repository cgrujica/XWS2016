(function (angular) {
	var app = angular.module('app',['ui.select','chart.js','task','comment','login', 'register','ui.router', 'authentication','project','user','reports']);
	app
    .config(config)
    .run(run);
    function config($stateProvider, $urlRouterProvider) {
     $urlRouterProvider.otherwise('/login');
        $stateProvider
       .state('main', {
          url: '/main',
          templateUrl: 'main.html',
          controller: 'mainCtrl'
      })
       .state('login', {
        url: '/login',
        templateUrl: 'users/login.html',
        controller: 'loginCtrl'
    });
   }
   function run($rootScope, $window, $http, $location, $localStorage, $state) {

        $rootScope.logout = function () {
            UserService.logout();
        }
        
        $rootScope.getCurrentState = function () {
          return $state.current.name;
        }
    }

}(angular));