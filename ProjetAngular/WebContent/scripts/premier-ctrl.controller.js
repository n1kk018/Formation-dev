//angular.module('monApp')
//.controller('premierCtrl', 
module.exports = ['$scope', function($scope) {
	$scope.machin = 'bloup';
	$scope.second = '';
	$scope.liste = ['str1','str2','str3','str4'];
	$scope.methodeCtrl = function() {
		alert($scope.machin);
	};
	$scope.addList = function() {
		$scope.liste.push($scope.second);
	};
	$scope.deleteItem = function(clef) {
		$scope.liste.splice(clef,1);
	}
}];
//);