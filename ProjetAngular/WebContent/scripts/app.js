angular.module('monApp', ['ngRoute'])
	.config(['$routeProvider', function($routeProvider) {
		$routeProvider.when('/premier', {
			controller: "premierCtrl",
			templateUrl: "templates/premier-ctrl.template.html"
		}).when('/ajax', {
			controller: "ajaxCtrl",
			templateUrl: "templates/ajax.template.html"
		}).when('/404', {
			templateUrl: "templates/404.template.html"
		}).otherwise({
			redirectTo: '/404'
		});
	}])
	.controller('premierCtrl', require('./premier-ctrl.controller.js'))
	.controller('ajaxCtrl', require('./ajax.controller'))
	.factory('chienService', require('./chien.service'))
	.directive('afcPremiere', require('./premiere.directive'));
