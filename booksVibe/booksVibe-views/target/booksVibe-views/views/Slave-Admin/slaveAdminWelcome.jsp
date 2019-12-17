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
    <center><h3>Welcome Admin</h3></center>
	<s:if test="hasActionErrors()">
		<sj:dialog id="myDialog" href="%{remoteurl}" title="Message" modal="true" showEffect="slide" hideEffect="explode" > <s:actionerror/> </sj:dialog>
	</s:if>
	
	<s:if test="hasActionMessages()">
		<sj:dialog id="myDialog" href="%{remoteurl}" title="Message" modal="true" showEffect="slide" hideEffect="explode" > <s:actionmessage/></sj:dialog>
	</s:if>
	
	
	<html>
  <head>
   <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
	
	  valReturn = <%= request.getAttribute("returnRequests")%>; 
      valDelivery = <%= request.getAttribute("deliveryRequests")%>; 
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
	  

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Total Requests', 'Requests per Day'],
          ['Delivery Requests',valDelivery],
          ['Return Requests',valReturn]
          
        ]);

        var options = {
          title: 'New Books Requests',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
    </script>
    
    <script type="text/javascript">
	val1 = <%= request.getAttribute("todaysReturnRequests")%>; 
    val2 = <%= request.getAttribute("todaysDeliveryRequests")%>;
	val3 = <%= request.getAttribute("approvedRequests")%>; 
    val4 = <%= request.getAttribute("closedRequests")%>;
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Request Statuses', '',{role:'style'}],
          ['Pending',val2,'red'],
          ['Approved',val3,'sky blue'],
          ['Return',val1,'gold'],
          ['closed',val4,'green']
        ]);

        var options = {
          title: 'Todays Requests',
          vAxis: {title: 'Request Status',  titleTextStyle: {color: 'black'}}
        };

        var chart = new google.visualization.BarChart(document.getElementById('chart_div'));

        chart.draw(data, options);
      }
    </script>
    
  </head>
  <body>
   <br/><br/>
    <br/>
    <div class="row">
    	 <div class="col-lg-6" align="center">
			<div id="piechart_3d" style=" border: 2px solid; width:500px; height:300px;"></div>
		</div>
		 <div class="col-lg-6" align="center">
			<div id="chart_div" style=" border: 2px solid; width:500px; height:300px;"></div>
		</div>
	</div>
	<br/>
  </body>
</html>

