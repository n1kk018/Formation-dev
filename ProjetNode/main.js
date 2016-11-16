var http = require('http');

var serveur = http.createServer(function(req, res) {
	  res.writeHead(200);
	  res.end('Salut tout le monde !');
	});
serveur.listen(1337, function() {
	console.log('serveur htp dispo sur le port 1337')
})