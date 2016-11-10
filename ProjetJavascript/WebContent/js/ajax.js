function doAjax(args) {
	var ajax = new XMLHttpRequest();
	var options = {
		methode: 'GET',
		url: '',
		args: '',
		async: true,
		callback: function(){}
	};
	assignerArguments(args,options);
	ajax.open(options.methode, options.url, options.async);
	ajax.onreadystatechange=function(){
		if(ajax.readyState===4) {
			if(ajax.status===200 || ajax.status===304) {
				options.callback(ajax.responseText);
			}
		}
	};
	ajax.send(options.args);
}

function assignerArguments(source,destination) {
	for(var clef in source) {
		if(destination.hasOwnProperty(clef)) {
			destination[clef] = source[clef];
		}
	}
}