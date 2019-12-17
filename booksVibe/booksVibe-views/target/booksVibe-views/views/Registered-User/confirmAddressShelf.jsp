<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<sj:head jqueryui="true" />
</head>
<body>
        	<s:form action="requestBook">
				<s:hidden name="bookId" value="%{#request.bookId}"></s:hidden>
				<s:textarea label="%{getText('global.address')}" name="address" rows="4" cols="10" value="%{#session.loggedUser.address}"></s:textarea>
				<s:hidden name="requestedFrom" value="userShelf"></s:hidden>
				<s:submit cssClass="btn btn-info" value="%{getText('global.request')}"></s:submit>
		  	</s:form>
</body>
</html>