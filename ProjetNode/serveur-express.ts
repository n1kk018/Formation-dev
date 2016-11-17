import * as express from 'express';
import {Application} from 'express';
import * as bodyParser from 'body-parser';
import {router} from './services/premier-service';
import * as dao from './dao/dao-personne';


let app:Application = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:true}));

let daoP:dao.DaoPersonne = new dao.DaoPersonne();
daoP.addPersonne({id:2,nom:'Bo',prenom:'Dum'})
        .then(function(retour) {
            console.log(retour);
        }).catch(function(error) {
            console.log(error);
        });
app.use('/rest', router);

app.listen(1337, function() {
    console.log('Express listening on 1337');
});