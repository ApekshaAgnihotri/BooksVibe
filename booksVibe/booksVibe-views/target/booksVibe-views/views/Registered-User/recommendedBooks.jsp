<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@page import="java.util.*"%>
<%@page import="com.booksVibe.models.BooksBean"%>
<html>
<head>
<sj:head/>
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
<center><h3>Recommended books</h3></center>
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
	<display:table id="data" uid="row" name="${requestScope.recommendedBooksList}" pagesize="5" requestURI="getRecommendedBooks">

		
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
		<display:column property="publisher" titleKey="global.publisher" sortable="true" />
		<display:column title="">
		<s:if test="%{#attr.row.isRequested=='false'}">
		  		<s:url id="confirmAddress" escapeAmp="false" action="confirmAddress" var="confirmAddress">
              		<s:param name="bookId" value="%{#attr.row.bookId}"/>
          		</s:url>
				<sj:a cssClass="btn btn-info" openDialog="confirmAddressDialog" href="%{confirmAddress}"><s:property value="%{getText('global.request')}"/></sj:a>
			</s:if>
			
			<s:if test="%{#attr.row.isRequested=='true'}">
		 		<sj:a disabled="true" cssClass="btn btn-info" openDialog="confirmAddressDialog" href="%{confirmAddress}"><s:property value="%{getText('global.request')}"/></sj:a>
			</s:if>
		</display:column>
		

	</display:table>
	 <sj:dialog id="confirmAddressDialog"  title="Confirm Your Address" modal="true" showEffect="slide" hideEffect="explode" height="300" width="400" autoOpen="false"/>

</div>

</body>
</html>