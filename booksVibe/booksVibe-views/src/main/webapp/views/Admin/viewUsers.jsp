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
<center><h3>Active Users</h3></center>
<div align="center">
	<display:table id="data" uid="row" name="${requestScope.usersList}" pagesize="5" requestURI="viewUsers">

		<display:column property="emaild" title="User Id" sortable="true"/>
		<display:column property="subsName" title="Plan Name"  />
		<display:column property="subStart" title="Plan Start Date"  />
		<display:column property="subEnd" title="Plan End Date" />
	
	</display:table>
</div>
</body>
</html>