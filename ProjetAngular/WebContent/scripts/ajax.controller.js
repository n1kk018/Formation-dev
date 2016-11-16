//angular.module('monApp')
//.controller('ajaxCtrl', 
module.exports = ['$scope', 'chienService', function($scope, chienService){
	$scope.title='Ajax view';
	$scope.listOfDogs = false;
	$scope.selected = '';
	$scope.form_visibility='none';
	$scope.breeds={};
	function loadList() {
		chienService.obtenirChiens().then(function(response) {
			$scope.listOfDogs = response;
			if($scope.listOfDogs.length<1) {
				$scope.listOfDogs = false;
			} else {
				$scope.listOfDogs.forEach(function(chien,index){
					if($scope.breeds.hasOwnProperty(chien.race)) {
						$scope.breeds[chien.race]++;
					} else {
						$scope.breeds[chien.race]=1;
					}
				});
			}
		});
	}
	loadList();
	$scope.add2Ul = function(chien) {
		$scope.selected = chien;
	};
	$scope.toggleForm = function() {
		if($scope.form_visibility=="none") {
			$scope.form_visibility="block";
		} else {
			$scope.form_visibility="none";
		}
	};
	$scope.addDog = function() {
		$scope.chien.id=null;
		chienService.ajouterChien($scope.chien)
			.then(function(response){
				if(response) {
					loadList();
					$scope.toggleForm();
					$scope.chien=null;
				}
			});
	};
	$scope.delDog = function(id) {
		chienService.supprimerChien(id)
			.then(function(response){
				if(response) {
					loadList();
				}
			});
	}
}];
//);