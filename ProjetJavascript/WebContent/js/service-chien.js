var doAjax = require('./ajaxWp');
module.exports = {
		obtenirChiens: obtenirChiens,
		obtenirChien:obtenirChien,
		ajouterChien:ajouterChien};
var urlWs = 'http://localhost:8180/ProjetRIARest/rest/chien/';
function obtenirChiens() {
	return doAjax({
		url: urlWs+"all",
	}).then(function(reponse) {
		var chiens = JSON.parse(reponse);
		chiens.forEach(function(chien,index) {
			chien.date_naissance = new Date(chien.date_naissance);
		});
		return chiens;
	});
}

function obtenirChien(id) {
	return doAjax({
		url: urlWs+'id/'+id,
	}).then(function(reponse) {
		var chien = JSON.parse(reponse);
		return chien;
	});
}

function ajouterChien(chien) {
	return doAjax({
		url: urlWs+'add',
		methode: 'POST',
		args: JSON.stringify(chien),
		datatype:"application/json"
	});
}