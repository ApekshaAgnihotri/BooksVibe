<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<sj:head/>
<s:head/>
<body>

<body>
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
	<br/><br/>
<div class="container" align="center"  style=" border: 2px solid; border-radius: 25px;  box-shadow: 10px 10px 5px #888888; width:600px"><br/>
	<s:form action="updateprofile"  label="Update Your Profile" theme="bootstrap" cssClass="form-vertical">
      
		<div class="row">
		   <div class="col-lg-4"></div>
		   <div class="col-lg-4 col-lg-3 " align="right"> <img alt="User Pic" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=100" class="img-circle"> </div>
		   <div class="col-lg-4"></div>
		</div> 
		
        <div class="row">
		
		  <div class="col-lg-6"><s:textfield name="firstname" label="%{getText('global.firstname')}" style="height:29px; width:220px;" required="true" /><br/></div>
		  <div class="col-lg-6"><s:textfield name="lastname" label="%{getText('global.lastname')}" style="height:29px; width:220px;" required="true"/><br/></div>
			  
		</div>		
		
	    <div class="row">
		
		  <div class="col-lg-6"><s:textfield name="contactno" label="%{getText('global.contactno')}" size="10" style="height:29px; width:220px;" required="true"/><br/></div>
		  <div class="col-lg-6"><s:textfield name="emaild" label="%{getText('global.emailId')}" readonly="true" style="height:29px;" required="true"/><br/></div>
		 
		</div>	
		
		 <div class="row">
		    <div class="col-lg-12"><s:textarea name="address" label="%{getText('global.address')}" style="height:29px; width:512px;" required="true" /><br/></div>
		    </div>   
	
		<br/>
		
		<div class="row">
		
		  <div class="col-lg-12"><s:select name="language" label="%{getText('global.language')}" headerKey="-1"
			headerValue="Select language" 
			list="#{'English':'English', 'Hindi':'Hindi'}" style="height:29px; width:512px;"/> <br/></div>
		  	 
		</div>	
	
	   
			
  	    <s:submit cssClass="btn btn-info" value="%{getText('global.update')}"  align="center" /><br/><br/> 
		

	</s:form>  
</div>
</body>
</html>

