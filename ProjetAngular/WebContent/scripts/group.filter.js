module.exports = [function() {
	return function (input, field) {
		var response = {};
		if(Array.isArray(input)) {
			input.forEach(function(value, key) {
				if(value.hasOwnProperty(field)) {
					if(response.hasOwnProperty(value[field])) {
						response[value[field]]++;
					} else {
						response[value[field]] = 1;
					}
				}
			});
		}
		return response;
	};
}];