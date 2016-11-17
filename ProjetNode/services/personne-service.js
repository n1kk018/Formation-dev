"use strict";
var express_1 = require('express');
var dao_personne_1 = require('../dao/dao-personne');
exports.router = express_1.Router();
var dao = new dao_personne_1.DaoPersonne();
exports.router.get('/all', function (req, res) {
    dao.getAllPersonnes()
        .then(function (personnes) { return res.json(personnes); })
        .catch(function (err) { return res.json(err); });
});
exports.router.post('/ajouter', function (req, res) {
    dao.addPersonne(req.body)
        .then(function (personne) { return res.json(personne); })
        .catch(function (err) { return res.json(err); });
});
//# sourceMappingURL=personne-service.js.map