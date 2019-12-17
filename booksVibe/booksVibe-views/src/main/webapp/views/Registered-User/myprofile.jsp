<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/profile.css">
<script src="js/profile.js"></script>
</head>
<!-- <html> -->
<!-- <body> -->









        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
   
   
          <div class="panel panel-info">
            <div class="panel-heading">
			<span class="pull-right">
                            <a href="editprofile" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
                        </span>
              <h3 class="panel-title">My Profile</h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=100" class="img-circle"> </div>
                
                
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td><s:property value="%{getText('global.firstname')}"/></td>
                        <td><s:property value="firstname"/></td>
                      </tr>
                      <tr>
                        <td><s:property value="%{getText('global.lastname')}"/></td>
                        <td><s:property value="lastname"/></td>
                      </tr>
                      <tr>
                        <td><s:property value="%{getText('global.address')}"/></td>
                        <td> <s:property value="address"/></td>
                      </tr>
                   
                         <tr>
                           
                        <td><s:property value="%{getText('global.contactno')}"/></td>
                        <td><s:property value="contactno"/></td>
                      </tr>
                        <tr>
                        <td><s:property value="%{getText('global.emailId')}"/></td>
                        <td><s:property value="emaild"/></td>
                      </tr>
                      <tr>
                        <td><s:property value="%{getText('global.language')}"/></td>
                        <td><s:property value="language"/></td>
                      </tr>
                      
                     
                    </tbody>
                  </table>
                  
                
                </div>
              </div>
            </div>
                 <div class="panel-footer">
                       
                        
                    </div>
            
          </div>
        </div>
      </div>
    </div>