<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@page import="java.util.*"%>
<%@page import="com.booksVibe.models.BooksBean"%>
<html>
<head>
<sj:head jqueryui="true" />
<title>BooksVibe</title>
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
<center><h3>Issued Books</h3></center>
	<s:if test="hasActionErrors()">
	     <sj:dialog id="myDialog" href="%{remoteurl}" title="Message" modal="true" showEffect="slide" hideEffect="explode" > <s:actionerror/></sj:dialog>
	</s:if>
	<s:if test="hasActionMessages()">
	     <sj:dialog id="myDialog" href="%{remoteurl}" title="Message" modal="true" showEffect="slide" hideEffect="explode" > <s:actionmessage/></sj:dialog>
	</s:if>
	<br />
	<br />
	<br />
	<display:table id="data" uid="row" name="${requestScope.requestedBooksList}" pagesize="5" requestURI="viewIssuedBooks">

		
		<display:column >
		<s:hidden name="bookId" value="%{#attr.row.bookId}"></s:hidden>
		</display:column>
		<display:column titleKey="global.image"> 
			<img src='<s:property value="%{#attr.row.kimageFileName}"/>' width="100" height="100" /> 
 			</display:column> 
		<display:column property="bookTitle" titleKey="global.title" sortable="true" />
		<display:column property="author" titleKey="global.author" sortable="true" />
		<display:column property="category" titleKey="global.category" sortable="true" />
		<display:column property="language" titleKey="global.language" sortable="true" />
		 
		<display:column title="">
			<a class="btn btn-info" href='bookReturnRequest?bookId=<s:property value="%{#attr.row.bookId}"/>'><s:property value="%{getText('global.return')}"/></a>
		</display:column>
		

	</display:table>



</body>
</html>