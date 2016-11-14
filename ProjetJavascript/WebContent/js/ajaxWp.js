module.exports = doAjax;

function doAjax(args) {
	return new Promise(function(resolve, reject) {
		var ajax = new XMLHttpRequest();
		var options = {
			methode: 'GET',
			url: '',
			args: '',
			async: true,
			datatype: 'text/plain',
			callback: function(){}
		};
		assignerArguments(args,options);
		ajax.open(options.methode, options.url, options.async);
		ajax.onreadystatechange=function(){
			if(ajax.readyState===4) {
				if(ajax.status===200 || ajax.status===304) {
					resolve(ajax.responseText);
				} else {
					reject("HTTP " + ajax.status+" msg : "+ajax.statusText);
				}
			}
		};
		ajax.setRequestHeader('Content-Type', options.datatype)
		ajax.send(options.args);
	});
}

function assignerArguments(source,destination) {
	for(var clef in source) {
		if(destination.hasOwnProperty(clef)) {
			destination[clef] = source[clef];
		}
	}
}