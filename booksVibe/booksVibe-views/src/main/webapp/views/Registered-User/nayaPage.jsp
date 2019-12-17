<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@page import="java.util.*"%>
<%@page import="com.booksVibe.models.BooksBean"%>
<html>
<head>
<sj:head jqueryui="true"/>
<title>BooksVibe.com</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.errors {
	color: red;
}
</style>
<style type="text/css">
.message {
	color: green;
}
</style>
</head>
<body>
	
	<s:if test="hasActionErrors()">
		<sj:dialog id="myDialog" href="%{remoteurl}" title="Message" modal="true" showEffect="slide" hideEffect="explode" > <s:actionerror/></sj:dialog>
	</s:if>
	<s:if test="hasActionMessages()">
		<sj:dialog id="myDialog" href="%{remoteurl}" title="Message" modal="true" showEffect="slide" hideEffect="explode" > <s:actionmessage/></sj:dialog>
	</s:if>
	<br />
	<br />
	<br />
</body>
</html>
