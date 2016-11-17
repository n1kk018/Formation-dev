import {Router, Request, Response} from 'express';

export let router = Router();

router.get('/test',function(req:Request, res:Response) {
    res.json({message: 'coucou'});
});

router.post('/testpost', function(req:Request, res:Response) {
    console.log(req.body);
    res.end();
});