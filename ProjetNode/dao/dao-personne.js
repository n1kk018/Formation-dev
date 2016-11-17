"use strict";
var mongoose = require('mongoose');
var es6_promise_1 = require('es6-promise');
var DaoPersonne = (function () {
    function DaoPersonne() {
        mongoose.Promise = es6_promise_1.Promise;
        this.personneSchema = new mongoose.Schema({
            id: {
                type: Number,
                required: true
            },
            nom: String,
            prenom: String
        });
        this.Personne =
            mongoose.model('Personne', this.personneSchema);
    }
    ;
    DaoPersonne.prototype.connect = function () {
        mongoose.connect('mongodb://localhost:27017/test');
        this.db = mongoose.connection;
        this.db.on('error', console.error.bind(console, 'connection error'));
    };
    DaoPersonne.prototype.addPersonne = function (personne) {
        this.connect();
        var db = this.db;
        var p = new this.Personne(personne);
        return new es6_promise_1.Promise(function (resolve, reject) {
            db.once('open', function () {
                p.save(function (err, pers) {
                    if (err) {
                        reject(err);
                    }
                    else {
                        resolve(pers);
                    }
                    db.close();
                });
            });
        });
    };
    DaoPersonne.prototype.getAllPersonnes = function () {
        this.connect();
        var db = this.db;
        var model = this.Personne;
        return new es6_promise_1.Promise(function (resolve, reject) {
            model.find().exec(function (err, res) {
                if (err) {
                    reject(err);
                }
                else {
                    resolve(res);
                }
                db.close();
            });
        });
    };
    return DaoPersonne;
}());
exports.DaoPersonne = DaoPersonne;
//# sourceMappingURL=dao-personne.js.map