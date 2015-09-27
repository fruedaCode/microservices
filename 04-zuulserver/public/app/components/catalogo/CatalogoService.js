angular.module('tiendaAngular.components.catalogo.services', [])
	.service('CatalogoService', function($http){
		var baseUrl = "http://localhost:8000/productosinterno/productosInterno";
		this.getProductos = function(){
			return  $http.get(baseUrl);
		};
	});