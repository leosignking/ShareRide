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

$(document).ready(function(){
		
	$("#email").blur(function(){
		checkEmail();
	});
	
	$("#password").blur(function(){
		checkPassword();
	});
	
	$("#emailSignup").blur(function(){
		checkEmailsignUp();
	});
	
	$("#passwordSignup").blur(function(){
		checkPasswordsignUp();
	});
	
	$("#firstName").blur(function(){
		checkFirstName();
	});
	
	$("#lastName").blur(function(){
		checkLastName();
	});
	
	$("#mobileNo").blur(function(){
		checkMobileNumber();
	});
	
	
	$("#login-submit").click(function(){
		if(!checkEmail()){
			return;
		}
		if(!checkPassword()){
			return;
		}
		document.getElementById("login-form").submit();
	});
	
	$("#register-submit").click(function(){
		
		if(!checkEmailsignUp()){
			return false;
		}
		if(!checkPasswordsignUp()){
			return false;
		}
		if(!checkFirstName()){
			return false;
		}
		if(!checkLastName()){
			return false;
		}
		if(!checkMobileNumber()){
			return false;
		}
		
		document.getElementById("register-submit").submit();
	});
	
	
});

function checkEmail( ) {
	
	$("#email").css('border-color','');
	$('#erroremail').html('');
	if($("#email").val()== null || $.trim($("#email").val()) == '' ){
		$("#email").css('border-color','red');
		$('#erroremail').html('UserName/Email is required');
		return false;
	}
	return true;
}

function checkPassword(){
	$("#password").css('border-color','');
	$('#errorpaswd').html('');
	if($("#password").val()== null || $.trim($("#password").val()) == '' ){
		$("#password").css('border-color','red');
		$('#errorpaswd').html('Password is required');
		return false;
	}
	return true;
	
}
function checkEmailsignUp(){
	$("#emailSignup").css('border-color','');
	$('#errorEmails').html('');
	if($("#emailSignup").val()== null || $.trim($("#emailSignup").val()) == '' ){
		$("#emailSignup").css('border-color','red');
		$('#errorEmails').html('UserName/Email is required');
		return false;
	}
	return true;
}
function checkPasswordsignUp(){
	$("#passwordSignup").css('border-color','');
	$('#errorPaswds').html('');
	if($("#passwordSignup").val()== null || $.trim($("#passwordSignup").val()) == '' ){
		$("#passwordSignup").css('border-color','red');
		$('#errorPaswds').html('Password is required');
		return false;
	}
	return true;
}
function checkFirstName(){
	$("#firstName").css('border-color','');
	$('#errorFirstName').html('');
	if($("#firstName").val()== null || $.trim($("#firstName").val()) == '' ){
		$("#firstName").css('border-color','red');
		$('#errorFirstName').html('First Name is required');
		return false;
	}
	return true;
}
function checkLastName(){
	$("#lastName").css('border-color','');
	$('#errorLastName').html('');
	if($("#lastName").val()== null || $.trim($("#lastName").val()) == '' ){
		$("#lastName").css('border-color','red');
		$('#errorLastName').html('Last Name is required');
		return false;
	}
	return true;
}
function checkMobileNumber(){
	$("#mobileNo").css('border-color','');
	$('#errorMobileNo').html('');
	if($("#mobileNo").val()== null || $.trim($("#mobileNo").val()) == '' ){
		$("#mobileNo").css('border-color','red');
		$('#errorMobileNo').html('Phone Number is required');
		return false;
	}
	return true;
}