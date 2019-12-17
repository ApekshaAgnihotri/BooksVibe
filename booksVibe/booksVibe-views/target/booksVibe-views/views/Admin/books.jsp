<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sj:head/>
<s:head/>
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

	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
	<s:if test="hasActionMessage()">
		<div class="displayMessage">
			 <s:actionmessage/> 
		</div>
	</s:if>

<div class="container" align="center" style=" border: 2px solid; border-radius: 25px;  box-shadow: 10px 10px 5px #888888; width:500px">
<br/>
	<s:form action="addBooks" method="post" theme="bootstrap" label="Add New Book" cssClass="form-horizontal" enctype="multipart/form-data">

		<s:textfield name="bookTitle" label="%{getText('global.title')}" required="true" style="height:29px; width:214px;"/>
		
		<s:textfield name="author" label="%{getText('global.author')}" required="true" style="height:29px; width:214px;"/>

		<s:select name="category" label="%{getText('global.category')}" required="true"
		
			list="#{'Children & Teens':'Children & Teens', 'Technical':'Technical', 'Fiction':'Fiction', 'Entertainment':'Entertainment','G.K & References':'G.K & References','Health & Familiy':'Health & Familiy','Sports':'Sports','Non Fiction':'Non Fiction'}" />
        

		<s:textfield name="publisher" label="%{getText('global.publisher')}" required="true" style="height:29px; width:214px;"/>

        <s:textfield name="copies" label="%{getText('global.copies')}" required="true" style="height:29px; width:214px;"/>

		<s:select name="language" label="Language" required="true"
			headerValue="Select language"
			list="#{'English':'English', 'Hindi':'Hindi'}" />
        
        
        <s:file name="kimage" label="%{getText('global.bookCover')}" value="Choose File" required="true"></s:file>
		
		<s:submit cssClass="btn btn-info" value="%{getText('global.addBookSubmit')}"  align="center" />


	</s:form>

</div>

</body>
</html>