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
<script type="text/javascript">




</script>


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
 <sj:head jqueryui="true"/>
</head>
<body>
<br/><br/>
<div class="container-fluid" align="center">
	<s:form action="usersearchBooks?requestedBy=user" theme="bootstrap" cssClass="form-inline" label="BooksVibe Store" align="center">
		
			 <s:hidden name="requestId" value="2" />
		    <div class="row">
			    <div class="col-lg-2"></div>
		        <div class="col-lg-2"><s:textfield name="bookTitle" placeholder="%{getText('global.title')}" style="height:29px;" /></div>
				<div class="col-lg-2"><s:textfield name="author" placeholder="%{getText('global.author')}" style="height:29px;" /></div>
				<div class="col-lg-2"><s:textfield name="publisher" placeholder="%{getText('global.publisher')}" style="height:29px;" /></div>
				<div class="col-lg-2"><s:select name="category"  headerKey="all" headerValue="All"
												list="#{'Children & Teens':'Children & Teens',
														'Technical':'Technical', 
														'Fiction':'Fiction',
														'Entertainment':'Entertainment',
														'G.K & References':'G.K & References',
														'Health & Familiy':'Health & Familiy',
														'Sports':'Sports',
														'Non Fiction':'Non Fiction'}" />
				</div>
				<div class="col-lg-2"></div>
				
		    </div>
			
			<div class="row">
				<div class="col-xs-4"></div>
				<div class="col-xs-4" align="center"><s:submit effect="highlight" cssClass="btn btn-info" value="%{getText('global.search')}" /></div>
				<div class="col-xs-4"></div>
			</div>
           <br/>
          	<s:if test="hasActionErrors()">
		         <div class="errors">
			         <s:actionerror />
		         </div>
	        </s:if>
	</s:form>
</div>
    <br/><br/>
 


	<s:if test="hasActionMessages()">
	     <sj:dialog id="myDialog" href="%{remoteurl}" title="Message" modal="true" showEffect="slide" hideEffect="explode" onCloseTopics="onCloseTopic"> <s:actionmessage/></sj:dialog>
	</s:if>
	 
	 
 <div align="center">	
	<display:table id="data" uid="row" name="${sessionScope.ListCarrier}" pagesize="6" partialList="true" size="${sessionScope.Records}" requestURI="usersearchBooks">

		
		<display:column >
	    	<s:hidden name="bookId" value="%{#attr.row.bookId}"></s:hidden>
		</display:column>
		<display:column titleKey="global.image">
				<img src='<s:property value="%{#attr.row.kimageFileName}"/>' width="100" height="100" />
		</display:column>
		<display:column property="bookTitle" titleKey="global.title" sortable="true" />
		<display:column property="author" titleKey="global.author" sortable="true" />
		<display:column property="category" titleKey="global.category" sortable="true" />
		<display:column property="publisher" titleKey="global.publisher" sortable="true" />
		
		<display:column>
		
			 <s:if test="%{#attr.row.inShelf=='true'}">
		   			<sj:a disabled="true" cssClass="btn btn-info" href='addToShelf?bookId=<s:property value="%{#attr.row.bookId}"/>&requestType=addToShelf' ><s:property value="%{getText('global.addToShelf')}"/></sj:a>
		 	</s:if>
		 
			<s:if test="%{#attr.row.inShelf=='false'}">
		   			<a class="btn btn-info" href='addToShelf?bookId=<s:property value="%{#attr.row.bookId}"/>&requestType=addToShelf' ><s:property value="%{getText('global.addToShelf')}"/></a>
		 	</s:if>
		</display:column>
		
		<display:column>
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