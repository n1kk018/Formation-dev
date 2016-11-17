import * as mongoose from 'mongoose';

export class DaoPersonne {
    private personneSchema: mongoose.Schema;
    private Personne: mongoose.Model<mongoose.Document>;
    private db:mongoose.Connection;

    constructor() {
        mongoose.connect('mongodb://localhost:27017/test');
        this.personneSchema = new mongoose.Schema({
            id: Number,
            nom:String,
            prenom: String
        });
        this.Personne = mongoose.model('Personne',this.personneSchema);
    };

    private connect() {
        this.db = mongoose.connection;
        this.db.on('error', console.error.bind(console, 'connection error'));
    }

    public addPersonne(personne:any) {
        this.connect();
        let db = this.db;
        let p = new this.Personne(personne);
        return new Promise(function(resolve:Function, reject:Function) {
            db.once('open',function() {
                p.save(function(err,pers) {
                    if(err) {
                        reject(err);
                    } else {
                        resolve(pers);
                    }
                });
            });
        });
    }
}