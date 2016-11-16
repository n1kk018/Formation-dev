module.exports = ['$http', function($http){
	var urlService = 'http://localhost:8180/ProjetRIARest/rest/chien/';
	
	function obtenirChien(id) {
		return $http.get(urlService+'id/'+id)
					.then(function(response) {
			if(!response.data) {
				throw new Error('Chien Inexistant');
			}
			var chien = response.data;
			convertDate(chien);
			return chiens;
		});
	}
	
	function obtenirChiens() {
		return $http.get(urlService+'all')
					.then(function(response) {
			var chiens = response.data;
			chiens.forEach(function(chien,index) {
				convertDate(chien);
			});
			return chiens;
		});
	}
	
	function ajouterChien(chien) {
		convertDate(chien);
		return $http.post(urlService+'add', chien)
			.then(function(response) {
				if(response.data!="true") {
					throw new Error('Le chien n\'a pas été ajouté');
				}
				return true;
			});
	}
	
	function supprimerChien(id) {
		return $http.delete(urlService+'del/'+id)
					.then(function(response) {
			if(response.data!="true") {
				throw new Error('Chien Inexistant');
			}
			return true;
		});
	}
	
	function convertDate(chien) {
		if(chien.date_naissance instanceof Date) {
			chien.date_naissance = chien.date_naissance.getTime();
		} else if(typeof(chien.date_naissance)==='number' || 
				typeof(chien.date_naissance)==='string') {
			chien.date_naissance=new Date(chien.date_naissance);
		} else {
			chien.date_naissance=new Date();
		}
	}
	
	return {
		obtenirChien: obtenirChien,
		obtenirChiens: obtenirChiens,
		ajouterChien: ajouterChien,
		supprimerChien: supprimerChien
	};
}];