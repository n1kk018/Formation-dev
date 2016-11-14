/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};

/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {

/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId])
/******/ 			return installedModules[moduleId].exports;

/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			exports: {},
/******/ 			id: moduleId,
/******/ 			loaded: false
/******/ 		};

/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);

/******/ 		// Flag the module as loaded
/******/ 		module.loaded = true;

/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}


/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;

/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;

/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";

/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ function(module, exports, __webpack_require__) {

	var service = __webpack_require__(1);
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

/***/ },
/* 1 */
/***/ function(module, exports, __webpack_require__) {

	var doAjax = __webpack_require__(2);
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

/***/ },
/* 2 */
/***/ function(module, exports) {

	module.exports = doAjax;

	function doAjax(args) {
		return new Promise(function(resolve, reject) {
			var ajax = new XMLHttpRequest();
			var options = {
				methode: 'GET',
				url: '',
				args: '',
				async: true,
				datatype: 'text/plain',
				callback: function(){}
			};
			assignerArguments(args,options);
			ajax.open(options.methode, options.url, options.async);
			ajax.onreadystatechange=function(){
				if(ajax.readyState===4) {
					if(ajax.status===200 || ajax.status===304) {
						resolve(ajax.responseText);
					} else {
						reject("HTTP " + ajax.status+" msg : "+ajax.statusText);
					}
				}
			};
			ajax.setRequestHeader('Content-Type', options.datatype)
			ajax.send(options.args);
		});
	}

	function assignerArguments(source,destination) {
		for(var clef in source) {
			if(destination.hasOwnProperty(clef)) {
				destination[clef] = source[clef];
			}
		}
	}

/***/ }
/******/ ]);