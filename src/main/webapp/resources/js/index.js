function popup_getFacebookConnection(){
	var winParams ="status=yes, resizable=yes, height=400, width=750, left=200, top=200";
	var newwinow = window.open('https://www.facebook.com/', '_blank', winParams);
		newwinow.focus();
}

function popup_get_Google_Plus_Connection(){
	var winParams ="status=yes, resizable=yes, height=400, width=750, left=200, top=200";
	var newwinow = window.open('https://www.gmail.com/', '_blank', winParams);
		newwinow.focus();
}

function validateEmail(){
	document.getElementById("email").style.borderColor = "";
	$('#errorval').html('');
	if($("#email").val()== null || $.trim($("#email").val()) == '' ){
		/*setTimeout(function(){
			$("#email").focus();
	    },3000);*/
		$("#email").focus();
		document.getElementById("email").style.borderColor = "red";
		$('#errorval').html('UserName/Email is required');
		return;
	}
};
function passwordValidation(){
	document.getElementById("password").style.borderColor = "";
	$('#errorvalPswd').html('');
	if($("#password").val()== null || $.trim($("#password").val()) == '' ){
		$("#password").focus();
		document.getElementById("password").style.borderColor = "red";
		$('#errorvalpaswd').html('Password is required');
		return false;
	}
}
function validateEmails(){
	document.getElementById("email").style.borderColor = "";
	$('#errorvals').html('');
	if($("#emailReg").val()== null || $.trim($("#emailReg").val()) == '' ){
		$("#emailReg").focus();
		document.getElementById("emailReg").style.borderColor = "red";
		$('#errorvals').html('UserName/Email is required');
		return;
	}
};
function passwordValidations(){
	document.getElementById("password").style.borderColor = "";
	$('#errorvalPswds').html('');
	if($("#passwordReg").val()== null || $.trim($("#passwordReg").val()) == '' ){
		$("#passwordReg").focus();
		document.getElementById("passwordReg").style.borderColor = "red";
		$('#errorvalpaswds').html('Password is required');
		return false;
	}
}

function firstNameValidation(){
	document.getElementById("firstName").style.borderColor = "";
	$('#errorvalfstName').html('');
	if($("#firstName").val()== null || $.trim($("#firstName").val()) == '' ){
		$("#firstName").focus();
		document.getElementById("email").style.borderColor = "red";
		$('#errorvalfstName').html('First Name is required');
		return;
	}
};
function lastNameValidation(){
	document.getElementById("lastName").style.borderColor = "";
	$('#errorvallstName').html('');
	if($("#lastName").val()== null || $.trim($("#lastName").val()) == '' ){
		$("#lastName").focus();
		document.getElementById("lastName").style.borderColor = "red";
		$('#errorvallstName').html('last Name is required');
		return false;
	}
}
function phoneNoValidation(){
	document.getElementById("password").style.borderColor = "";
	$('#errorvalPhoneNo').html('');
	if($("#mobileNo").val()== null || $.trim($("#mobileNo").val()) == '' ){
		$("#mobileNo").focus();
		document.getElementById("mobileNo").style.borderColor = "red";
		$('#errorvalPhoneNo').html('Phone Number is required');
		return false;
	}
}
function saveLogin(){
	
	$('#errorval').html('');
	if($("#email").val()== null || $.trim($("#email").val()) == '' ){
		$("#email").focus();
		document.getElementById("email").style.borderColor = "red";
		$('#errorval').html('UserName/Email is required');
		return;
	}
	if($("#password").val()== null || $.trim($("#password").val()) == '' ){
		document.getElementById("password").style.borderColor = "red";
		$('#errorvalpaswd').html('Password is required');
		return false;
	}
	
	
	var str = $("#login-form").serialize();
	alert("values are 2nd "+str);
	
	document.getElementById("login-form").submit();
}


