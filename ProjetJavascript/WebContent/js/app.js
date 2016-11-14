var service = require('./service-chien');
//var chien = {"id":"","nom":"toto","race":"doberman","date_naissance":1479122759000};
//service.ajouterChien(chien);
//service.obtenirChien(6);
var chiens = service.obtenirChiens();

chiens.then(function(reponse) {
	reponse.forEach(function(chien,index) {
		var tr = document.createElement('tr');
		tr.insertCell(0).innerHTML = chien.id;
		tr.insertCell(1).innerHTML = chien.nom;
		tr.insertCell(2).innerHTML = chien.race;
		tr.insertCell(3).innerHTML = chien.date_naissance;
		document.getElementById("tbody").appendChild(tr);
	});
});