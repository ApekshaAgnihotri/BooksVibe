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
<center><h3>Subscription History</h3></center>
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
	<display:table id="data" uid="row" name="${requestScope.planList}" pagesize="5" requestURI="viewSubscriptionHistory">
	
		<display:column >
		<s:hidden name="subsId" value="%{#attr.row.subsId}"></s:hidden>
		</display:column>
		<display:column property="subsName" titleKey="global.planName" sortable="true" />
		<display:column property="maxBooks" titleKey="global.maxBooks" sortable="true" />
		<display:column property="timePeriod" titleKey="global.timePeriod" sortable="true" />
		<display:column property="amount" titleKey="global.price"  />
		<display:column property="subStart" titleKey="global.startDate"  />
		<display:column property="subEnd" titleKey="global.endDate" />
		
	</display:table>
</div>


</body>
</html>