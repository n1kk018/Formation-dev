"use strict";
var express = require('express');
var bodyParser = require('body-parser');
var personne_service_1 = require('./services/personne-service');
var app = express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.use('/rest', personne_service_1.router);
app.listen(1337, function () {
    console.log('Express listening on 1337');
});
//# sourceMappingURL=serveur-express.js.map