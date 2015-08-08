angular.module('tiendaAngular.components.catalogo.services', [])
	.service('CatalogoService', function($http){
		var baseUrl = "http://localhost:8000/productosservice/productos";
		this.getProductos = function(){
			return  $http.get(baseUrl);
		};
	});