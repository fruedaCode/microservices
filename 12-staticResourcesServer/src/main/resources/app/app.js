angular.module('tiendaAngular', ['ngRoute', 'ngMaterial','tiendaAngular.components']);
angular.module('tiendaAngular.components', ['tiendaAngular.components.catalogo', 'tiendaAngular.components.directivas']);
angular.module('tiendaAngular.components.catalogo', 
		['tiendaAngular.components.catalogo.controllers', 
		 'tiendaAngular.components.catalogo.services']);


angular.module('tiendaAngular').config(function($routeProvider){
	$routeProvider
		.when('/getCatalogo',{
			templateUrl: '/app/components/catalogo/catalogo.html',
			controller: 'CatalogoController'
		})
		.otherwise({
			redirectTo: '/getCatalogo'
		});
});