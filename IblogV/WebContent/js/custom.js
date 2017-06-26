$(document).ready(function(){
    $("#btnLogin").click(function(){
        $("#myModal").modal();
        return false 
    });
    $("#btnSignUp").click(function(){
        $("#myModal").modal();
        return false 
    });
});

function goBack() {
    window.history.back();
    return false;
}

w3.includeHTML();

function toggle() {
	
	var asignIn = document.getElementById('aSignIn');
	var asignUp = document.getElementById('aSignUp');
	var aForgotPassword = document.getElementById('aForgotPassword');
	
	var divSignIn = document.getElementById('divSignIn');
	var divSignUp = document.getElementById('divSignUp');
	var divForgotPassword = document.getElementById('divForgotPassword');
	
	if (divSignIn.style.display === 'none') {
		divSignIn.style.display = 'block';
		divSignUp.style.display = 'none';
		divForgotPassword.style.display = 'none';
	} else {
		divSignIn.style.display = 'none';
		divSignUp.style.display = 'block';
		divForgotPassword.style.display = 'none';
	}
	return false;
}

function forgotPassword(){
	
	var divSignIn = document.getElementById('divSignIn');
	var divSignUp = document.getElementById('divSignUp');
	var divForgotPassword = document.getElementById('divForgotPassword');
	

		divSignIn.style.display = 'none';
		divSignUp.style.display = 'none';
		divForgotPassword.style.display = 'block';
	
	return false;
}