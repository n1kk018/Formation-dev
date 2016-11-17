"use strict";
var express_1 = require('express');
exports.router = express_1.Router();
exports.router.get('/test', function (req, res) {
    res.json({ message: 'coucou' });
});
exports.router.post('/testpost', function (req, res) {
    console.log(req.body);
    res.end();
});
//# sourceMappingURL=premier-service.js.map