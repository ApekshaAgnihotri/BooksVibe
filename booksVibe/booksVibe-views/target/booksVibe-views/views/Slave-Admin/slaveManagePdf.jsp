<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>

<html>
<head>

   <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
   <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
   <script src="http://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <style type="text/css">
      .errorMessage {
	     color: red;
	     list-style: none;
      }
   </style>
   <style type="text/css">
      .actionMessage {
	     color: blue;
	     list-style: none;
     }
   </style>
<s:head/>
<sj:head jqueryui="true"/>
</head>

<body>
	
 <br/><br/>
	
		<div class="container-fluid" align="center">
		<s:form action="getParameterMethod" label="PDF Generation" id="form2" theme="bootstrap"  cssClass="form-inline">
		
		    
		    <div class="row">
			    <div class="col-lg-2"></div>
		        <div class="col-lg-2"><s:select name="category" label="%{getText('global.category')}" headerKey="all"
												headerValue="All"
												list="#{'Novels':'Novels',
												'Children & Teens':'Children & Teens',
												'Technical':'Technical',
												'Fiction':'Fiction',
												'Entertainment':'Entertainment',
												'G.K & References':'G.K & References',
												'Health & Familiy':'Health & Familiy',
												'Sports':'Sports',
												'Non Fiction':'Non Fiction'}"
										labelposition="left"/>
				</div>
				<div class="col-lg-2"> <s:select list="%{#session.author}" name="author" headerKey="All" headerValue="All"
												label="%{getText('global.author')}" labelposition="left" />
				</div>
				<div class="col-xs-2"><sj:datepicker id="from" name="from" label="%{getText('global.fromDate')}" displayFormat="yy/mm/dd" changeMonth="true" changeYear="true" required="true" style="height:30px; width:160px;" inputAppendIcon="calendar"/></div>
				<div class="col-xs-2"><sj:datepicker id="to" name="to" label="%{getText('global.toDate')}" displayFormat="yy/mm/dd" changeMonth="true" changeYear="true" required="true" style="height:30px; width:160px;" inputAppendIcon="calendar"/></div>
				<div class="col-lg-2"></div>
				
		    </div>
			
			<div class="row">
				<div class="col-xs-4"></div>
				<div class="col-xs-4" align="center"><s:submit effect="highlight" cssClass="btn btn-info" value="%{getText('global.filterList')}" /></div>
				<div class="col-xs-4"></div>
			</div>
          
		</s:form>
	</div>
	
<div class="container" align="center">	
<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
	<s:if test="hasActionMessages()">
		<div class="message">
			<s:actionmessage />
		</div>
	</s:if>
	<br />
</div>	
<div class="container">
	<s:if test="%{#request.pdfList.size!= 0}"> 
		<s:url action="generatePdf" var="generatePdf" />
		<a  cssClass="btn btn-info btn-xs" align="center" href="<s:property value="#generatePdf"/>"><s:property value="%{getText('global.generatePdf')}"/></a>
		<br />
	
</div>
	<display:table id="data" uid="row" name="${requestScope.pdfList}"
		pagesize="5" requestURI="">

		<display:column property="title" titleKey="global.title" sortable="true" />

		<display:column property="author" titleKey="global.author" sortable="true" />

		<display:column property="category" titleKey="global.category" sortable="true" />

		<display:column property="delivered" titleKey="global.delivered"  />
		
		<display:column property="returned" titleKey="global.returned"  />
		
		<display:column property="cancelled" titleKey="global.cancelled"  />

	</display:table>
	</s:if>
</body>
</html>