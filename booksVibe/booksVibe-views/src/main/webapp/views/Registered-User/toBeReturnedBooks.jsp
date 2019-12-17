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
<sj:head jqueryui="true"/>
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
<center><h3>To Be Returned Books</h3></center>
   <s:if test="hasActionErrors()">
	     <sj:dialog id="myDialog" href="%{remoteurl}" title="Message" modal="true" showEffect="slide" hideEffect="explode" > <s:actionerror/></sj:dialog>
	</s:if>
	
	
	<s:if test="hasActionMessages()">
	     <sj:dialog id="myDialog" href="%{remoteurl}" title="Message" modal="true" showEffect="slide" hideEffect="explode" > <s:actionmessage/></sj:dialog>
	</s:if>
	<br />
	<br />
	<br />
 <div align="center">
	<display:table id="data" uid="row" name="${requestScope.requestedBooksList}" pagesize="5" requestURI="viewToBeReturnedBooks">

		
		<display:column >
		<s:hidden name="bookId" value="bookId"></s:hidden>
		</display:column>
		<display:column titleKey="global.image"> 
			<img src='<s:property value="%{#attr.row.kimageFileName}"/>' width="100" height="100" /> 
 		</display:column> 
		<display:column property="bookTitle" titleKey="global.title" sortable="true" />
		<display:column property="author" titleKey="global.author" sortable="true" />
		<display:column property="category" titleKey="global.category" sortable="true" />
		<display:column property="publisher" titleKey="global.publisher" sortable="true" />
		<display:column title="">
		    <a class="btn btn-info" href='cancelReturnRequest?bookId=<s:property value="%{#attr.row.bookId}"/>'><s:property value="%{getText('global.cancel')}"/></a>
		</display:column>
		

	    </display:table>


</div>
</body>
</html>