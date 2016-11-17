"use strict";
var express = require('express');
var bodyParser = require('body-parser');
var premier_service_1 = require('./services/premier-service');
var dao = require('./dao/dao-personne');
var app = express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
var daoP = new dao.DaoPersonne();
daoP.addPersonne({ id: 2, nom: 'Bo', prenom: 'Dum' })
    .then(function (retour) {
    console.log(retour);
}).catch(function (error) {
    console.log(error);
});
app.use('/rest', premier_service_1.router);
app.listen(1337, function () {
    console.log('Express listening on 1337');
});
//# sourceMappingURL=serveur-express.js.map