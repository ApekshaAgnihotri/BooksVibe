<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

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
			<s:actionmessage />
		</div>
	</s:if>
<div class="container" align="center" style=" border: 2px solid; border-radius: 25px;  box-shadow: 10px 10px 5px #888888; width:500px">
<br/>
	<s:form action="updateBook" theme="bootstrap" label="Update Book" cssClass="form-horizontal" enctype="multipart/form-data">
	
		<s:hidden name="bookId" label="Book Id" readonly="true" />
		
		<s:textfield name="bookTitle" label="%{getText('global.title')}" style="height:29px; width:214px;" required="true"/>
		
		<s:textfield name="author" label="%{getText('global.author')}" style="height:29px; width:214px;" required="true" />

		<s:select name="category" label="%{getText('global.category')}"	list="#{'Children & Teens':'Children & Teens', 'Technical':'Technical', 'Fiction':'Fiction', 'Entertainment':'Entertainment','G.K & References':'G.K & References','Health & Familiy':'Health & Familiy','Sports':'Sports','Non Fiction':'Non Fiction'}" />


		<s:textfield name="publisher" label="%{getText('global.publisher')}" style="height:29px; width:214px;" required="true" />
		
        <s:textfield name="copies" label="%{getText('global.currentCopies')}" readonly="true" style="height:29px; width:214px;" />
        
		<s:textfield name="newcopies" label="%{getText('global.newCopies')}" style="height:29px; width:214px;"/>


		<s:select name="language" label="%{getText('global.language')}"
			headerValue="Select language"
			list="#{'English':'English', 'Hindi':'Hindi', 'French':'French', 'Spanish':'Spanish'}" />


		<s:file name="kimage" value="%{getText('global.bookCover')}" ></s:file>

		<s:submit cssClass="btn btn-info" value="%{getText('global.update')}" align="center" />


	</s:form>
</div>
</body>
</html>