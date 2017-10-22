$(document).ready(function() {
	var INTEREST_TO_YEAR = "http://localhost:8080/api/interestToYear/";
	var YEAR_TO_INTEREST = "http://localhost:8080/api/yearToInterest/";
	
	$("#inpInterest").change(function() {
		var interest = $("#inpInterest").val();
		fetch(INTEREST_TO_YEAR + interest)
			.then(function(response) {
				return response.text();
			})
			.then(function(result) {
				$("#inpYear").val(result);
			});
	});
	
	$("#inpYear").change(function() {
		var year = $("#inpYear").val();
		fetch(YEAR_TO_INTEREST + year)
			.then(function(response) {
				return response.text();
			})
			.then(function(result) {
				$("#inpInterest").val(result);
			});
	});
	
});