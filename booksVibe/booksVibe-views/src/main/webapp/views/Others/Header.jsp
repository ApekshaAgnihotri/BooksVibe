<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<style>

.slightlytranslucent{ 
 		opacity:0.8; 
 	} 
 .slightlytranslucent:hover{ 
		opacity:1; 
 	} 
	
	
</style>
	


<!-- </head> -->
<!-- <body> -->
	
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation" >
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
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="width:1100px;">
                <ul class="nav navbar-nav">
                <li>
                        <a href="homePage.jsp" style="color:white;">Home</a>
                    </li>
                                       
                  
                    <li>
                        <a href="searchBooks?requestId=1&requestedBy=annonymousUser" style="color:white;">Browse Our Store</a>
                    </li>
                    <li>
                        <a href="registrationPage" style="color:white;">Register</a>
                    </li>
                    <li>
                        <a href="loginPage" style="color:white;">Login</a>
                    </li>
                    
                 
                </ul>
				<div style="margin-top:6px;">
				        <s:form action="searchBooks?requestedBy=annonymousUser" theme="simple" class="form-inline" align="right" >
		
		    				<s:hidden name="requestId" value="2" />
		    				
							    <s:hidden name="author" value="" />
								<s:hidden name="publisher" value="" />
								<s:hidden name="category" value="all"/>
								
								  <s:textfield name="bookTitle" placeholder="%{getText('global.title')}" style="height:31px;"/>
								 
								<s:submit style="margin-top:-9px;" effect="highlight" cssClass="btn btn-info" value="%{getText('global.search')}" />
								
							
						</s:form>
            </div>
			
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
<!--  </body> -->