import * as mongoose from 'mongoose';
import {Promise} from 'es6-promise';
import {Personne} from '../entities/personne';
type PersonneModel = Personne & mongoose.Document;


export class DaoPersonne {
    private personneSchema: mongoose.Schema;
    private Personne: mongoose.Model<PersonneModel>;
    private db:mongoose.Connection;
    

    constructor() {
        (<any>mongoose).Promise = Promise;
        this.personneSchema = new mongoose.Schema({
            id: {
                type: Number,
                required: true
            },
            nom:String,
            prenom: String
        });
        this.Personne =
            mongoose.model<PersonneModel>('Personne',this.personneSchema);
    };

    private connect() {
        mongoose.connect('mongodb://localhost:27017/test');
        this.db = mongoose.connection;
        this.db.on('error', console.error.bind(console, 'connection error'));
    }

    public addPersonne(personne:Personne):Promise<Personne> {
        this.connect();
        let db = this.db;
        let p = new this.Personne(personne);
        return new Promise<Personne>(function(resolve:Function, reject:Function) {
            db.once('open',function() {
                p.save(function(err,pers) {
                    if(err) {
                        reject(err);
                    } else {
                        resolve(pers);
                    }
                    db.close();
                });
            });
        });
    }

    public getAllPersonnes():Promise<Personne[]> {
        this.connect();
        let db = this.db;
        let model = this.Personne;
        return new Promise<Personne[]>(function(resolve, reject) {
                model.find().exec(function(err,res) {
                    if(err) {
                        reject(err);
                    } else {
                        resolve(res);
                    }
                    db.close();
            });
        });
    }
}