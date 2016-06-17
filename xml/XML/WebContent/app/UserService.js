(function (angular) {
	angular.module('app')
	.factory('UserService', function($http,$rootScope){
		var factory={};
    
        factory.login= function(email, password, callback){
           return $http.post('/XML/rest/user/login', {
                'email': ''+email,
                'pass': ''+password
            });
        };
       
        factory.logout= function(onSuccess, onError){
        	$rootScope.currentUser = {};
            $state.go('login');
        };
        
        return factory;
   
});
})(angular);