//angular.module('monApp')
//.controller('ajaxCtrl', 
module.exports = ['$scope', '$http', function($scope, $http){
	$scope.title='Ajax view';
	$scope.listOfDogs = false;
	$scope.selected = '';
	$scope.form_visibility='none';
	function loadList() {
		$http.get('http://localhost:8180/ProjetRIARest/rest/chien/all')
		.then(function(response) {
			$scope.listOfDogs = response.data;
			if($scope.listOfDogs.length>0) {
			$scope.listOfDogs.forEach(function(chien,index) {
				chien.date_naissance=new Date(chien.date_naissance);
			}) } else {
				$scope.listOfDogs = false;
			}
		});
	}
	loadList();
	$scope.add2Ul = function(chien) {
		$scope.selected = chien;
	};
	$scope.toggleForm = function(formId) {
		if($scope.form_visibility=="none") {
			$scope.form_visibility="block";
		} else {
			$scope.form_visibility="none";
		}
	};
	$scope.addDog = function() {
		console.log($scope.chien);
		$scope.chien.id=null;
		console.log($scope.chien.date_naissance);
		$http.post('http://localhost:8180/ProjetRIARest/rest/chien/add', JSON.stringify($scope.chien))
		.then(function(response){
			if(response.data=="true") {
				loadList();
			}
		});
		$scope.toggleForm('formChien');
	};
}];
//);