import * as express from 'express';
import {Application} from 'express';
import * as bodyParser from 'body-parser';
import {router} from './services/personne-service';


let app:Application = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:true}));

app.use('/rest', router);

app.listen(1337, function() {
    console.log('Express listening on 1337');
});