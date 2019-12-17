<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/profile.css">
<script src="js/profile.js"></script>
</head>
<!-- <html> -->
<!-- <body> -->






<br/><br/>


<div class="container" align="center" style=" border: 2px solid; border-radius: 25px;  box-shadow: 10px 10px 5px #888888; width:800px">


	<div class="panel panel-info">
		<div class="panel-heading">

			<h3 class="panel-title">My Plan</h3>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-md-3 col-lg-3 " align="center">
					<img alt="User Pic"
						src="images/plan.png" alt="My Plan"
						class="img-circle">
				</div>


				<div class=" col-md-9 col-lg-9 ">
					<table class="table table-user-information">
						<tbody>
							<tr>
								<td><b><s:property value="%{getText('global.planName')}"/></b></td>
								<td><s:property value="%{#request.subscriptionPlan.subsName}"/></td>
							</tr>
							<tr>
								<td><b><s:property value="%{getText('global.timePeriod')}"/></b></td>
								<td><s:property value="%{#request.subscriptionPlan.timePeriod}" /></td>
							</tr>
							<tr>
								<td><b><s:property value="%{getText('global.maxBooks')}"/></b></td>
								<td><s:property value="%{#request.subscriptionPlan.maxBooks}" /></td>
							</tr>

							<tr>

								<td><b><s:property value="%{getText('global.price')}"/></b></td>
								<td><s:property value="%{#request.subscriptionPlan.amount}" /></td>
							</tr>


						</tbody>
					</table>


				</div>
			</div>
		</div>
		<div class="panel-footer"></div>

	</div>
</div>
</div>
</div>