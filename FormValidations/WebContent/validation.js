

function validate(frm){
	
	frm.vflag.value="yes";
	document.getElementById("nameErr").innerHTML="";
	document.getElementById("ageErr").innerHTML="";
	document.getElementById("nameErr").style="color:red";
	document.getElementById("ageErr").style="color:red";
	
	
	// read from data
	 var name=frm.name.value;
	 var age=frm.age.value;
	 
	 // perform client side form validations
	 
	 if(name=="")//required rule
		 {
		 document.getElementById("nameErr").innerHTML="Name is mandatory";
		 frm.name.focus();
		 return false;
		 
		 
		 }
	if(age==""){
		document.getElementById("ageErr").innerHTML="age is mandatory";
		frm.age.focus();
		return false;
	}
	
	else{
		if(isNaN(age)){
			document.getElementById("ageErr").innerHTML="age must be numeric value";
			frm.age.focus();
			frm.age.value="";
			return false;
		}
	}
	return true;
}