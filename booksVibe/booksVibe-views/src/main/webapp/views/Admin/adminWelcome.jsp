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
<link href="css/sb-admin.css" rel="stylesheet">
<link rel="stylesheet" href="css/MasterHomeStyle.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/MasterHomeTemplate.css"/>
 <link href="font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

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
    <center><h3>Welcome Master Admin</h3></center>
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
	
	
	
	
				<section class="vt_wrapper_showcase vt_section">
<div class=" vt_group">
  <div class="vt_showcase row-fluid clearfix" id="vt_showcase">
	<div class="col-md-3      vt_block">
		<div class="wapper_box">
			<div class="vt_moduletable clearfix moduletable">
				<div class="vt_moduletable_content">
					<div class="custom">
						<p><i class="fa fa-books"><%= request.getAttribute("totalBooks")%></i></p>
						<h3>Total Books</h3>
						<p>
							These are the total books available in the BooksVibe library.
						</p>
						<p>
							<a href='operatorSearchBooks?requestedBy=masterAdmin&requestId=1'>View Details <i class="fa fa-angle-right">&nbsp;</i></a>	
						</p>
					</div>
				</div>   
			</div>
		</div>
	</div>
	<div class="col-md-3     separator_showcase vt_block">
		<div class="wapper_box">
			<div class="vt_moduletable clearfix moduletable">
				<div class="vt_moduletable_content">
					<div class="custom">
						<p>	
						<i class="fa fa-request"><%= request.getAttribute("totalRequests")%></i>
						</p>
						<h3>New Requests</h3>
						<p>These are the user's books requests assigned to the admin.</p>
						<p><a href="#">View Details <i class="fa fa-angle-right">&nbsp;</i></a></p>
					</div>
				</div>   
			</div>
		</div>
	</div>


	<div class="col-md-3     separator_showcase vt_block">
		<div class="wapper_box">
			<div class="vt_moduletable clearfix moduletable">
				<div class="vt_moduletable_content">
					<div class="custom">
						<p>
							<i class="fa fa-plan"><%= request.getAttribute("activePlans")%></i>
						</p>
						<h3>Active Subscription Plans</h3>
						<p>These are the active subscription plans a user can subscribe to.</p>

						<p><a href="operatorViewSubscriptionPlans">View Details <i class="fa fa-angle-right">&nbsp;</i></a></p>
					</div>
				</div>   
			</div>
		</div>
	</div>


	<div class="col-md-3     separator_showcase vt_block">
		<div class="wapper_box">
			<div class="vt_moduletable clearfix moduletable">
				<div class="vt_moduletable_content">
					<div class="custom">
						<p><i class="fa fa-activeuser"><%= request.getAttribute("activeUsers")%></i></p>
						<h3>Active Users</h3>
						<p>These are the users whose subscription plan is not Expired.</p>
						<p><a href="viewUsers">View Details <i class="fa fa-angle-right">&nbsp;</i></a></p>
					</div>
				</div>   
			</div>
		</div>
	</div>
  </div>
</div>

</section>


		
 
</body>
</html>
