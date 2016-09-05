var app = angular.module('app', [ 'ui.router' ]);

app.config(function($stateProvider, $urlRouterProvider,$httpProvider) {
	$urlRouterProvider.otherwise('/gradjani');
	$stateProvider.state('main', {
		url : '/main',
		templateUrl : 'html/main.html',
		controller : 'mainCtrl'
	}).state('login', {
		url : '/login',
		templateUrl : 'html/login.html',
		controller : 'loginCtrl'
	}).state('gradjani', {
		url : '/gradjani',
		templateUrl : 'html/gradjani.html',
		controller : 'gradjaniCtrl'
	}).state('poslanik', {
		url : '/poslanik',
		templateUrl : 'html/poslanik.html',
		controller : 'poslanikCtrl'
	});
});

app.config(function($logProvider) {
	$logProvider.debugEnabled(true);
});