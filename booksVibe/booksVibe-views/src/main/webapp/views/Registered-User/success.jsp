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


</head>
<body>
	
	
	<center><h2>Welcome to BooksVibe</h2></center>
	<br/>
	<!-- Call to Action Well -->
			<div class="row">
				<div class="col-lg-12">
					<div class="text-center"><h3>New Arrivals</h3></div>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->

			<!-- Content Row -->
			 <div class="">
                   
                     
                <div class="row">
                    <s:iterator value="%{#session.newArrivalsList}">
				        <div class="col-md-4" style="width:247px height:325px;">
				
					        <div class="thumbnail" style="height:400px;">
					
						        <img alt="Image Not Found" src='<s:property value="kimageFileName"/>' style="width:150px; height:180px;"/>
									 
						        <div class="caption">
							      <center><h5><b><s:property value="bookTitle" /></b></h5></center>
							 						
								    <div class="panel-group" id='panel-277316<s:property value="bookId"/>'>
				
				                        <div class="panel panel-default">
					                       <div class="panel-heading">
						                       <a class="panel-title collapsed" data-toggle="collapse" data-parent='#panel-277316<s:property value="bookId"/>' href='#panel-element-954643<s:property value="bookId"/>'>Details</a>
					                        </div>
					                        <div id='panel-element-954643<s:property value="bookId"/>' class="panel-collapse collapse">
									   
												<div class="panel-body">
													<b><i>Name:</i></b>  <s:property value="bookTitle" /><br/>
													<b><i>Category:</i></b>  <s:property value="category" /><br/>
													<b><i>Author:</i></b>  <s:property value="author" /><br/>
													<b><i>Publisher:</i></b>  <s:property value="publisher" /><br/>
												</div>
											</div>
				                       </div>
									</div>
									
								</div>
							</div>
						</div>
				
					</s:iterator>
				</div>
                   
            </div>     
			
			<!-- /.row -->
	
	
	
	<br />
	<br />
	<br />
</body>
</html>
