<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<sj:head />
<sb:head />
<s:head/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Registration</title>

<script>
 function validator(){
	 var password = document.getElementById('password');
	    var confirmpassword = document.getElementById('confirmPassword');
	    if(password.value==confirmPassword.value){
	    	return true;
	    }else{
	    	alert("password and confirm password must match");
	    	return false;
	    }	
}
</script>

<br/><br/><br/><br/><br/><br/>
<div class="container" align="center" style=" border: 2px solid; border-radius: 25px;  box-shadow: 10px 10px 5px #888888; width:600px;">
	<s:form action="rest/OperatorAuthenticationService/registerOperator" label="Register Operator" theme="bootstrap" cssClass="form-horizontal" method="post" onsubmit="return validator()">
	     <h3>Master Login:</h3> </center>
	    <s:textfield label="Master Login Id" name="operatorEmaild" required="true"  />
	    <s:password label="Master Password" name="operatorPassword"  required="true"  /></br></br>
	    <h3>New Operator</h3> </center>
	    <s:textfield label="First Name" name="firstname" tooltip="Enter Login Id" required="true"  />
	    <s:textfield label="Last Name" name="lastname" tooltip="Enter Last Name" required="true"  />
		<s:textfield label="Login Id" name="emaild" tooltip="Enter Login Id" required="true"  />
		<s:password label="Password" name="password"  required="true" tooltip="" id="password"/>
	    <s:password label="Confirm Password" name="confirmPassword" tooltip="Should match with Password" required="true" id="confirmPassword"/>
		<s:submit cssClass="btn btn-success" onclick="validator()" return="true" />
	</s:form>
</div>

</html>
