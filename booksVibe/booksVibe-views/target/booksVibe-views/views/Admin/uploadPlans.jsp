<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<html>
<head>
</head>
<body>
<h3><center>Subscription Plans</center></h3>
<br/><br/><br/><br/>
<div class="row">
  <div class="col-lg-6">
	<div class="container" style=" border: 2px solid; border-radius: 25px;  box-shadow: 10px 10px 5px #888888; width:500px">
		<br/>
		<s:form action="subsUpload" label="Add/Update Plan" align="center" method="POST" enctype="multipart/form-data" theme="bootstrap">
			<div class="row">
			   <div class="col-lg-6"><s:file name="xmlfile"  />	</div>
			   <div class="col-lg-6"><s:submit cssClass="btn btn-info" value="%{getText('global.modify')}" name="submit" /></div>
		</s:form> 
	</div>
  </div>

  <div class="col-lg-6">
    <div class="container" style=" border: 2px solid; border-radius: 25px;  box-shadow: 10px 10px 5px #888888;  width:500px">
		</br>
		<s:form action="subsDelete" label="Delete Plan" align="center" method="POST" enctype="multipart/form-data" theme="bootstrap">	
		    <div class="col-lg-6"><s:file name="xmlfile" /></div>
			<div class="col-lg-6"><s:submit cssClass="btn btn-info" value="%{getText('global.delete')}" name="submit" /></div>
		</s:form>
   </div>
  </div>
</div>
</body>
</html>