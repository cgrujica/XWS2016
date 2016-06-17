(function (angular) {
	angular.module('app')
	.factory('ResourceService', function($http,$rootScope){
		var factory={};
    
        factory.getRes= function(callback){
           return $http.get('/XML/rest/resurs');
        };
        
        factory.store= function(callback){};
       
        return factory;
   
});
})(angular);