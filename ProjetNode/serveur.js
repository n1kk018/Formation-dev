var express = require('express');

var app = express();

var router = express.Router();

router.get('/test/:argument',function(req,res) {
	console.log(req.params.argument);
	res.json({message:'coucou'});
});

app.use('/rest', router);

app.listen(1337);
