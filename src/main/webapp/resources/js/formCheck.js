function formCheck() {
	var id = document.forms[0].loginId;
	var pass = document.forms[0].pass;

	if (id.value == null || id.value == "") {
		alert('Please enter a username');
		document.forms[0].loginId.focus();
		return false;
	}

	if (pass.value == null || pass.value == "") {
		alert('Please enter a password');
		document.forms[0].pass.focus();
		return false;
	}

}
function logCheck(check) {
	if (check == 1) {
		alert('The username does not exist.');
		return false;
	}
	if (check == 2) {
		alert('Password is incorrect.');
		return false;
	}
}
function logout() {
	alert("Thank you for visiting.");
}
function contentDelete() {
	alert("This content has been deleted.");
}