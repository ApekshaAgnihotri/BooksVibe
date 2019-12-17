<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<head>
<sj:head />
<sb:head />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<style>

.slightlytranslucent{ 
 		opacity:0.8; 
 	} 
 .slightlytranslucent:hover{ 
		opacity:1; 
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
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
              
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                  
		                   <div class="btn-group">
					                  <button type="button" class="btn btn-default dropdown-toggle btn-lg" data-toggle="dropdown">Hello ${sessionScope.userBean.firstname}<span class="caret"></span></button>
					                       <ul class="dropdown-menu" role="menu">
						                       <li><a href="userHomePage">Home</a></li>
						                   </ul>
				             </div>
		                   
		                   	                  
		                   <div class="btn-group">
					              <button type="button" class="btn btn-default dropdown-toggle btn-lg" data-toggle="dropdown">Manage Books Requests<span class="caret"></span></button>
				                     	<ul class="dropdown-menu" role="menu">
						                      <li><a href="requestedBooks">Delivery Requests</a></li>
						                      <li><a href="toBeReturnedBooks">Return Requests</a></li>
					
					                    </ul>
				            </div>
				            
				           
				             
				            <div class="btn-group">
					                  <button type="button" class="btn btn-default dropdown-toggle btn-lg" data-toggle="dropdown">Generate PDF<span class="caret"></span></button>
					                       <ul class="dropdown-menu" role="menu">
						                       <li><a href="managePDF">Generate PDF</a></li>
						                                   
					                       </ul>
				             </div>
		                  
		                    <div class="btn-group">
					                  <button type="button" class="btn btn-default dropdown-toggle btn-lg" data-toggle="dropdown">Account<span class="caret"></span></button>
					                       <ul class="dropdown-menu" role="menu">
						                       <li><a href="logout">Logout</a></li>
						                       
					                       </ul>
				             </div>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
