"use strict";
var mongoose = require('mongoose');
var DaoPersonne = (function () {
    function DaoPersonne() {
        mongoose.connect('mongodb://localhost:27017/test');
        this.personneSchema = new mongoose.Schema({
            id: Number,
            nom: String,
            prenom: String
        });
        this.Personne = mongoose.model('Personne', this.personneSchema);
    }
    ;
    DaoPersonne.prototype.connect = function () {
        this.db = mongoose.connection;
        this.db.on('error', console.error.bind(console, 'connection error'));
    };
    DaoPersonne.prototype.addPersonne = function (personne) {
        this.connect();
        var db = this.db;
        var p = new this.Personne(personne);
        return new Promise(function (resolve, reject) {
            db.once('open', function () {
                p.save(function (err, pers) {
                    if (err) {
                        reject(err);
                    }
                    else {
                        resolve(pers);
                    }
                });
            });
        });
    };
    return DaoPersonne;
}());
exports.DaoPersonne = DaoPersonne;
//# sourceMappingURL=dao-personne.js.map