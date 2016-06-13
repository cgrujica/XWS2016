var app = angular.module('app', [ 'ui.router' ]);

app.config(function($stateProvider, $urlRouterProvider,$httpProvider) {
	$urlRouterProvider.otherwise('/login');
	$stateProvider.state('main', {
		url : '/main',
		templateUrl : 'html/main.html',
		controller : 'mainCtrl'
	}).state('login', {
		url : '/login',
		templateUrl : 'html/login.html',
		controller : 'loginCtrl'
	});
});

app.config(function($logProvider) {
	$logProvider.debugEnabled(true);
});