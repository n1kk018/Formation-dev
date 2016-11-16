module.exports = [function(){
	return {
		restrict: 'A', //AEC
		template: '<p>ma première directive {{varDirective}}</p>',
		replace:true,
		scope: {
			varDirective: '=afcPremiere'
		},
		link: function(scope,element,attributes) {
			scope.varDirective += 'jamon';
		}
	};
}];