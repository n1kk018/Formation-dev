import {Router, Request, Response} from 'express';
import {DaoPersonne} from '../dao/dao-personne';

export let router = Router();
let dao:DaoPersonne = new DaoPersonne();

router.get('/all',function(req:Request, res:Response) {
    dao.getAllPersonnes()
        .then(personnes => res.json(personnes))
        .catch(err => res.json(err));
});

router.post('/ajouter', function(req:Request, res:Response) {
    dao.addPersonne(req.body)
        .then(personne => res.json(personne))
        .catch(err => res.json(err));
});

