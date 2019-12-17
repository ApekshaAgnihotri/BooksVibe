<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@page import="java.util.*"%>
<%@page import="com.booksVibe.models.BooksBean"%>
<html>
<head>
<title>BooksVibe.com</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<center><h3>My History</h3></center>

	<br />
	<br />
	<br />
	<div align="center">
	<display:table id="data" uid="row" name="${requestScope.myHistory}" pagesize="5"  requestURI="viewMyHistory">
 
		<display:column property="bookTitle" titleKey="global.title" sortable="true" />
		
		<display:column property="author" titleKey="global.author" sortable="true" />
		 
		 <display:column property="requestStatus" titleKey="global.requestStatus" sortable="true"/>
		 
		 <display:column property="requestDate" titleKey="global.requestDate"/>
		 
		 <display:column property="returnDate" titleKey="global.returnDate"/>
		 
		 <display:column property="cancellationDate" titleKey="global.cancellationDate"/>
		
	

	</display:table>
</div>


</body>
</html>