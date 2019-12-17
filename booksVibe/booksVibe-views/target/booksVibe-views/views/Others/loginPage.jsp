<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<sj:head jqueryui="true"/>
<s:head/>
<sb:head />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>BooksVibe</title>
<style type="text/css">

.radio{
top: -6px;
}



.radio input[type="radio"] {
margin-left: 6px;
}

</style>

</head>
<body>

	

</br>
</br>
<div class="container" align="center" style=" border: 2px solid; border-radius: 25px;  box-shadow: 10px 10px 5px #888888; width:500px">

	<s:form action="login" theme="bootstrap" label="Login Here" cssClass="form-horizontal" >
	
	  <s:if test="hasActionErrors()">
		<div class="errors">
			 <s:actionerror/>
		</div>
	</s:if>
	
	<s:actionmessage />
	    <s:textfield label="%{getText('global.loginId')}" autocomplete="off" name="emaild" tooltip="Enter your Login Id" required="true" style="height:29px;"/><br>
		<s:password label="%{getText('global.password')}" name="password" tooltip="Enter your BooksVibe password" required="true" style="height:29px;"/><br>
		<s:radio theme="bootstrap" labelposition="inline" label="Login as:" name="role" list="#{'admin':'Admin','master':'Master Admin','user':'User'}" value="%{'user'}" />
		<s:submit cssClass="btn btn-info" value="%{getText('global.loginSubmit')}"/>
	</s:form>
</div>
</body>
</html>
