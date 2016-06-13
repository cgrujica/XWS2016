app.factory('productsFactory', function($http) {
	
	var factory = {};
	factory.getProducts = function() {
		return $http.get('/Web/rest/proizvodi/getJustProducts');
	};

	factory.addToCart = function(product) {
		return $http.post('/Web/rest/proizvodi/add', {"id":''+product.id, "count":parseInt(product.count)});
	};
	
	return factory;
	
});

app.factory('shoppingCartFactory', function($http) {

	var factory = {};
	factory.getSC = function() {
		return $http.get('/Web/rest/proizvodi/getJustSc');
	};
	
	factory.getTotal = function() {
		return $http.get('/Web/rest/proizvodi/getTotal');
	};
	
	factory.clearSc = function() {
		return $http.post('/Web/rest/proizvodi/clearSc');
	};
	return factory;
	
});
