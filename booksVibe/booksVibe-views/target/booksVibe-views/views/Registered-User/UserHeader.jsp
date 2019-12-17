<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<head>
<sj:head />
<sb:head />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<style>
.slightlytranslucent {
	opacity: 0.8;
}

.slightlytranslucent:hover {
	opacity: 1;
}

.btn {
	margin-left: 10px;
}
</style>



<!-- </head> -->
<!-- <body> -->

<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
<a class="navbar-brand" href="#" style="color:white;">BooksVibe</a>
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="width:1100px;">
			<ul class="nav navbar-nav">


				<div class="btn-group">
					<button type="button" class="btn btn-default dropdown-toggle btn-lg" data-toggle="dropdown">Hello ${sessionScope.userBean.firstname}<span class="caret"></span></button>
					
					<ul class="dropdown-menu" role="menu">
					    <li><a href="userHomePage">Home</a></li>
						<li><a href="profile">View Profile</a></li>
						
					</ul>
					
				</div><div class="btn-group">
					<button type="button" class="btn btn-default dropdown-toggle btn-lg" data-toggle="dropdown">Browse Books<span class="caret"></span></button>
					
					<ul class="dropdown-menu" role="menu">
						<li><a href="usersearchBooks?requestId=1&requestedBy=user">Browse Books</a></li>
						
					</ul>
					
				</div>

						

				<div class="btn-group">
					<button type="button" class="btn btn-default dropdown-toggle btn-lg" data-toggle="dropdown">Manage Books <span class="caret"></span></button>
					<ul class="dropdown-menu" role="menu">
						<li><a href="viewRequestedBooks">Requested</a></li>
						<li><a href="viewIssuedBooks">Issued</a></li>
						<li><a href="viewToBeReturnedBooks">Return</a></li>
						<li><a href="viewMyHistory">Books History</a></li>
					</ul>
				</div>


				<div class="btn-group">
					<button type="button" class="btn btn-default dropdown-toggle btn-lg" data-toggle="dropdown">Mine<span class="caret"></span></button>
					<ul class="dropdown-menu" role="menu">
					        <li><a href="getRecommendedBooks">Recommendations</a></li>
					        <li><a href="viewMyShelf">My Shelf</a></li>
					</ul>
				</div>
				

				<div class="btn-group">
					<button type="button" class="btn btn-default dropdown-toggle btn-lg" data-toggle="dropdown">Subscription Plans<span class="caret"></span></button>
					<ul class="dropdown-menu" role="menu">
					
					        <li><a href="viewMyPlan">My Plan</a></li>
					        <li><a href="viewSubscriptionPlans">BooksVibe Plans</a></li>
					        <li><a href="viewSubscriptionHistory">Subscription Plan history</a></li>
					        
					</ul>
				</div>

				 <div class="btn-group">
					   <button type="button" class="btn btn-default dropdown-toggle btn-lg" data-toggle="dropdown">Account<span class="caret"></span></button>
					        <ul class="dropdown-menu" role="menu">
						         <li><a href="logout">Logout</a></li>
						                      
					        </ul>
	           </div>
	           
			</ul>
			
			<div style="margin-top:6px;">
				        <s:form action="usersearchBooks?requestId=1&requestedBy=user" theme="simple" class="form-inline" align="right" >
		
		    				<s:hidden name="requestId" value="2" />
		    				
							    <s:hidden name="author" value="" />
								<s:hidden name="publisher" value="" />
								<s:hidden name="category" value="all"/>
								
								  <s:textfield name="bookTitle" placeholder="%{getText('global.title')}" style="height:31px;"/>
								 
								<s:submit style="margin-top:-9px;" effect="highlight" cssClass="btn btn-info" value="%{getText('global.search')}" />
								
							
						</s:form>
            </div>
			
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>
<!--  </body> -->