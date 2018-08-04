 function  validate(frm){
	   //chnage vflag 'yes' indicating that client side form validations are done
	   frm.vflag.value="yes";

      document.getElementById("nameErr").style.color="red";
	  document.getElementById("ageErr").style.color="red";


       document.getElementById("nameErr").innerHTML="";	
        document.getElementById("ageErr").innerHTML="";	

	   //read form data
	   var name=frm.pname.value;
	   var age=frm.page.value;
	   //write client side form validations (Java Script)
		   if(name==""){
	        document.getElementById("nameErr").innerHTML="Person name is mandatory";	
		   frm.pname.focus();
		   return false;
	   }
	   if(age==""){
	       document.getElementById("ageErr").innerHTML="Person age is mandatory";	
		   frm.page.focus();
		   return false;
	   }
	   else if(isNaN(age)){
	        document.getElementById("ageErr").innerHTML="Person age must be numeric value";	
        	  frm.page.value="";
			  frm.page.focus();
			  return false;
     	   }
	   return true;
	   }//validate(frm)