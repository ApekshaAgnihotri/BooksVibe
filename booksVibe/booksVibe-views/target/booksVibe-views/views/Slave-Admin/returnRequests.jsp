<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@page import="java.util.*"%>
<%@page import="com.booksVibe.models.BooksBean"%>
<html>
<head>
<title>BooksVibe.com</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.errors {
	color: red;
}
</style>
<style type="text/css">
.message{
color:green;
}
</style>
</head>
<body>
<center><h3>Return Requests</h3></center>
<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
	<s:if test="hasActionMessages()">
	  <div class="message">
	   <s:actionmessage/>
	  </div>
	 </s:if>
	<br />
	<br />
	<br />
<div align="center">	
<display:table id="data" uid="row" name="${requestScope.requestedBooksList}" pagesize="5" requestURI="toBeReturnedBooks">
		<display:column >
		<s:hidden name="requestId" value="%{#attr.row.requestId}"></s:hidden>
		</display:column>
		<display:column >
		<s:hidden name="bookId" value="%{#attr.row.bookId}"></s:hidden>
		</display:column>
		<display:column property="bookTitle" titleKey="global.title" sortable="true" />
		<display:column property="requestDate" titleKey="global.requestDate" sortable="true" />
		<display:column property="requestStatus" titleKey="global.requestStatus" sortable="true" />
		<display:column property="emaild" titleKey="global.emailId"> </display:column>
		<display:column property="address" titleKey="global.address" sortable="true" />
		
		<display:column>
			<a class="btn btn-info" href='closeReturnRequest?requestId=<s:property value="%{#attr.row.requestId}"/>'><s:property value="%{getText('global.close')}"/></a>
		</display:column>
		

	</display:table>
</div>


</body>
</html>