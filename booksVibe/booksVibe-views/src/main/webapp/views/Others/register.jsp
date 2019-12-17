<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<script src="js/browseplan.js"></script>
<link rel="stylesheet" type="text/css" href="table.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<script src="js/browseplan.js"></script>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.btnSubscription').click(function() {
			var getId = $(this).attr('id');
			$('#subsid').val(getId);
		})
	});
</script>
<title>Register Page</title>

<sj:head jqueryui="true"/>
<s:head/>
<sb:head/>
<style type="text/css">
.errors {
	color: red;
}

.displayMessage {
	color: blue;
}


</style>
</head>

<body>
	
<br>
<br>
	<div class="container" align="center" style=" border: 2px solid; border-radius: 25px;  box-shadow: 10px 10px 5px #888888; width:600px;">
		<s:form action="register" theme="bootstrap"	cssClass="form-vertical" label="Register With Us">
		 
	    <s:if test="hasActionErrors()">
		    <div class="errors">
			   <s:actionerror/>
		    </div>
	    </s:if>
	
		<div class="row">
		
		  <div class="col-lg-6"><s:textfield label="%{getText('global.firstname')}" name="firstname" required="true" style="height:29px;" /></div>
		  <div class="col-lg-6"><s:textfield label="%{getText('global.lastname')}" name="lastname" required="true" style="height:29px;"/></div>
		 
		  
		</div>
		<br>
		<div class="row">
		
		  <div class="col-lg-6"> <s:textfield name="emaild"   label="%{getText('global.emailId')}" required="true" style="height:29px;"/></div>
		  <div class="col-lg-6"><s:textfield name="contactno" label="%{getText('global.contactno')}" size="10" required="true" style="height:29px;"/></div>
		  
		</div>
		<br>
		
		<div class="row">
		  
		  <div class="col-lg-6"><s:password name="password" tooltip="Must be of atleast 6 characters" label="%{getText('global.password')}" maxlength="15" required="true" style="height:29px;"/></div>
		   <div class="col-lg-6"><s:password name="confrimPassword" label="%{getText('global.confirmpassword')}" required="true" style="height:29px;"/></div>
		  
		</div>
		<br>	
		<div class="row">
		    
			<div class="form-group">
			    
				<div class="col-lg-6"><s:textfield name="subsid" label="%{getText('global.subscriptionId')}" id="subsid" value="1" required="true" style="height:29px;" readonly="true"/></div>
				<div class="col-lg-6"><s:select name="language" required="true" label="Select a Language"  headerValue="-Select Language-" headerKey="" style="width:210;" list="#{'English':'English', 'Hindi':'Hindi'}" /></div>
				
			</div>
		</div>
		<div class="row">
		  <div class="col-lg-12"><s:textarea label="%{getText('global.address')}" name="address" required="true" style="height:29px; width:512px;"/></div>
		</div>   
		<br>
		<div class="row">
		    
		    <div class="col-lg-6"><a data-toggle="modal" href="#myModal" class="btn btn-info btn-sm">Browse Plans</a></div>
			<div class="col-lg-6"><s:submit value="%{getText('global.registerSubmit')}" id="registerid" cssClass="btn btn-info" /></div>
			
		</div>
		</s:form>
	</div>


	

<div class="modal fade modal-dialog modal-content" id="myModal" style="height:380px;">
<!-- <div class="modal-dialog">
  <div class="modal-content"> -->
    <div class="modal-header">
      <button type="button" class="pick" data-dismiss="modal" aria-hidden="true">&times;</button>
      <h4 class="modal-title"><center>Subscription Plans</center></h4>
    </div>
    <div class="modal-body">
      <table>
          <thead>
      
                <th hidden=true> Plan Id </th>
				<th>Subscription Plan</th>

				<th>Time Period</th>

				<th>Max books</th>

				<th>Amount</th>

				<th>Subscribe</th>
          </thead>
          <tbody class="table">
             <s:iterator value="%{#session.subscriptionList}">
				<tr>
					<td hidden=true><s:hidden value="subsid" /></td>
					<td><s:property value="subsName" /></td>
					<td><s:property value="timePeriod" /></td>
					<td><s:property value="maxBooks" /></td>
					<td><s:property value="amount" /></td>
					<td><input type="button" data-dismiss="modal" value="Pick" class="btnSubscription btn btn-info" name="<s:property value="subsid" />"	id="<s:property value="subsid" />" /></td>

				</tr>
			</s:iterator>
          </tbody>
      </table>
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
   <!--  </div>
 </div> /.modal-content -->
</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
	
</body>

</html>