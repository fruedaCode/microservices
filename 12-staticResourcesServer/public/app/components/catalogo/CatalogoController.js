angular.module('tiendaAngular.components.catalogo.controllers', ['tiendaAngular.components.catalogo.services'])
	.controller('CatalogoController', function ($scope, CatalogoService){
		
		$scope.productos = [];
		
		CatalogoService.getProductos()
		.then(function(response){
			$scope.productos = response.data;
		}, function(response){
			console.error('Error recuperando productos');
			console.error(response);
		});
		
	});