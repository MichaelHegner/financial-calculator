$(document).ready(function() {
	var deprecationId = getDeprecationId();
	
	if(undefined !== deprecationId) {
		var DEPRECATION_API = "http://localhost:8080/api/" + getDeprecationId();
		fetch(DEPRECATION_API)
			.then(function(response) {
				return response.json();
			})
			.then(function(deprecations) {
				var years = deprecations.map(function(deprecation) {
					return deprecation.date;
				});
				
				var values =  deprecations.map(function(deprecation) {
					return deprecation.value;
				});
				
				var data = {
					labels: years,
					series: [ values ]
				};
				
				new Chartist.Line('.ct-chart', data, {
			    });
			});
	}
	
	function getDeprecationId() {
		return $("#deprecationId").val();
	}
});