(function (angular) {
	angular.module('app')
	.factory('ResourceService', function($http,$rootScope){
		var factory={};
    
		factory.getAll= function(callback){		//poziva get funkciju sa resurs patha ocekuje kolekcije
	           return $http.get('/XML/rest/resurs/zakonij');
	        };
	        
		
        factory.getResComp= function(callback){		//poziva get funkciju sa resurs patha ocekuje kolekcije
           return $http.get('/XML/rest/resurs/zakonicompletedx');
        };
        
       //treba posebna funkcija koja vraca izglasane zakone
        

        factory.getResPen= function(callback){   //poziva get funkciju sa resurs patha ocekuje kolekcije
           return $http.get('/XML/rest/resurs/zakonipendingx');
        };
       //treba posebna funkcija koja vraca ne izglasane zakone
        
       //treba nam funkcija za nove predloge kako zakona tako i amandmana
        return factory;
   
});
})(angular);