(function (angular) {
	angular.module('app')
	.factory('UserService', function($http,$rootScope){
		var factory={};
    
        factory.login= function(email, password, callback){		//salje na backend objekat koji ima polja email i pass, ocekuje objekat koji se koristi kao User
           return $http.post('/XML/rest/user/login', {			
                'email': ''+email,
                'pass': ''+password
            });
        };
       
        factory.logout= function(onSuccess, onError){			//ne koristi backend samo iz storage uklanja usera i preusmerava na login stranicu
        	$rootScope.currentUser = {};
            $state.go('login');
        };
        
        return factory;
   
});
})(angular);