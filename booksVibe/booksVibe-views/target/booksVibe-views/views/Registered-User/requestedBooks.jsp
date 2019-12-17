<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
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

<center><h3>Requested Books</h3></center>


<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
</s:if>

<s:if test="hasActionMessages()">
	     <sj:dialog id="myDialog" href="%{remoteurl}" title="Message" modal="true" showEffect="slide" hideEffect="explode" > <s:actionmessage/></sj:dialog>
	</s:if>



<div align="center">	
	<display:table id="data" uid="row" name="${requestScope.requestedBooksList}" pagesize="5" requestURI="viewRequestedBooks">
         
		<display:column >
		<s:hidden name="bookId" value="bookId"></s:hidden>
		</display:column>
		<display:column titleKey="global.image"> 
			<img src='<s:property value="%{#attr.row.kimageFileName}"/>' width="100" height="100" /> 
 		</display:column> 
		<display:column property="bookTitle" titleKey="global.title" sortable="true" />
		<display:column property="author" titleKey="global.author" sortable="true" />
		<display:column property="category" titleKey="global.category" sortable="true" />
		<display:column property="language" titleKey="global.language" sortable="true" />
		<display:column property="publisher" titleKey="global.publisher" sortable="true" />
		<display:column >
			<a class="btn btn-info" href='cancelDeleiveryRequest?bookId=<s:property value="%{#attr.row.bookId}"/>'><s:property value="%{getText('global.cancel')}"/></a>
		</display:column>
		

	</display:table>
</div>


</body>
</html>