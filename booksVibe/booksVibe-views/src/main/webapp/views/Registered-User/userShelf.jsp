<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@page import="java.util.*"%>
<%@page import="com.booksVibe.models.BooksBean"%>
<html>
<head>
<sj:head />

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
<center><h3>My Shelf</h3></center>
<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
	<s:if test="hasActionMessages()">
	    <sj:dialog id="myCartDialog" href="%{remoteurl}" title="My Shelf" modal="true" showEffect="slide" hideEffect="explode"> <s:actionmessage/></sj:dialog>
	  
	 </s:if>
	 
<div align="center"	>
	 	<display:table class="table table-striped table-condensed" id="data" uid="row" name="${requestScope.booksInCartList}" pagesize="5" requestURI="viewMyCart">

		<display:column>
		<s:hidden name="bookId" value="%{#attr.row.bookId}"></s:hidden>
		</display:column>
		
		<display:column title="Image"> 
		<img src='<s:property value="%{#attr.row.kimageFileName}"/>' width="100" height="100" /> 
 		</display:column>
 		 
		<display:column property="bookTitle" titleKey="global.title" sortable="true"/>
		<display:column property="author" titleKey="global.author" sortable="true"/>
		<display:column property="category" titleKey="global.category" sortable="true"/>
		<display:column property="publisher" titleKey="global.publisher" sortable="true"/>
		
		<display:column>
		<a class="btn btn-info" href='deleteFromShelf?bookId=<s:property value="%{#attr.row.bookId}"/>&requestType="deleteFromCart"'><s:property value="%{getText('global.delete')}"/></a>
		</display:column>
		
        <display:column>
                  <s:if test="%{#attr.row.isRequested=='false'}">
		  		      <s:url id="shelfConfirmAddress" escapeAmp="false" action="shelfConfirmAddress" var="shelfConfirmAddress">
              		     <s:param name="bookId" value="%{#attr.row.bookId}"/>
          		       </s:url>
				      <sj:a cssClass="btn btn-info" openDialog="shelfConfirmAddressDialog" href="%{shelfConfirmAddress}"><s:property value="%{getText('global.request')}"/></sj:a>
			      </s:if>
			
			    <s:if test="%{#attr.row.isRequested=='true'}">
		 		     <sj:a disabled="true" cssClass="btn btn-info" openDialog="shelfConfirmAddressDialog" href="%{shelfConfirmAddress}"><s:property value="%{getText('global.request')}"/></sj:a>
			   </s:if>
		</display:column>
	     
	</display:table>
 </div>
<sj:dialog id="shelfConfirmAddressDialog"  title="Confirm Your Address" modal="true" showEffect="slide" hideEffect="explode" height="300" width="400" autoOpen="false"/>

</body>
</html>