%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<html>
<head>
<title>BooksVibe.com</title>
</head>
<body>

	<h1>.....Welcome to BooksVibe....</h1>
	<s:form action="registrationPage">
		<s:submit value="Register" />
	</s:form>
	<s:form action="indexPage">
		<s:submit value="Login" />
	</s:form>

   <s:url action="searchBooks" var="searchBook">
   <s:param name="requestId" value="1"/>
   </s:url>
	<a href="<s:property value="#searchBook"/>">Browse Books </a>
	<br />
 
</body>
</html>