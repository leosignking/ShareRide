function profileValidation(emailId){
	//$("#profile-details").show();
	
	//loadProfileDetails();
	var str = emailId;
	$.ajax({
		type:"GET",
		url:"profile",
		data: str,
		cache: false,
		success: function(response){
			alert("Success");
		},
		error: function(e){
			alert("Error Occured "+e);
		}
		
	});
	
}

