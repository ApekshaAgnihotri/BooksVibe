<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
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
<center><h3>Subscription Plans</h3></center>
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
	<display:table id="data" uid="row" name="${sessionScope.subscriptionList}" pagesize="5" requestURI="viewSubscriptionPlans">

		
		<display:column >
		<s:hidden name="subsid" value="%{#attr.row.subsid}"></s:hidden>
		</display:column>
		<display:column property="subsName" titleKey="global.planName" sortable="true" />
		<display:column property="maxBooks" titleKey="global.maxBooks" sortable="true" />
		<display:column property="timePeriod" titleKey="global.timePeriod" sortable="true" />
		<display:column property="amount" titleKey="global.price" sortable="true" />
		<display:column>
		    <s:if test="%{#request.userStatus=='inactive'}">
			   <a class="btn btn-success" href='upgradePlan?subsid=<s:property value="%{#attr.row.subsid}"/>'><s:property value="%{getText('global.pick')}"/></a>
		    </s:if>
		</display:column>
	</display:table>

</div>

</body>
</html>