
<%-- 
    Document   : profile
    Created on : 5 nov. 2016, 22:51:00
    Author     : jordycabannes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>iManage - My Profile</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
		
		<!-- Header --> 
		<jsp:include page="./Header.jsp"/>
		
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		
        <div class="container" style="padding-top: 0px; padding-bottom: 10px;">
			<h1 class="page-header">Edit Profile</h1>
			<div class="row">
				
			  <!-- left column -->
			  <div class="col-md-4 col-sm-6 col-xs-12">
				<div class="text-center">
				  <img src="/iManage/Web-Content/StyleViewUpdateUserProfile/img/User.png" class="avatar img-circle img-thumbnail" alt="avatar" style="height: 200px;">
				</div>
				<br>
				<div class="col-md-4 col-sm-6 col-xs-12">				
					<form method="post" action="<%="Upload?login=" + request.getParameter("login")%>" enctype="multipart/form-data" >
						<label class="col-lg-3 control-label" for="cv">CV</label>
						<input type="file" name="file" id="file" class="btn btn-default" />
						
						<c:if test="${userProfile.cvPath != null}">
							<a href="<%=request.getContextPath()+"/Pdf?path="%>${userProfile.cvPath}" target="_blank" class="btn btn-default" role="button" aria-pressed="true">View PDF</a>
						</c:if>					
						
						<input type="submit" class="btn btn-default" value="Upload CV" name="upload" id="upload" />
					</form>				
				</div>
			  </div>
			 
			  <!-- edit form column -->
			  <div class="col-md-8 col-sm-6 col-xs-12 personal-info">
				<h3>Personal Info</h3>
				<form class="form-horizontal" method="post">
				  <div class="form-group">
					<label class="col-lg-3 control-label" for="firstname">First name</label>
					<div class="col-lg-8">
					  <input class="form-control" id="firstname" name="firstname" value="<c:out value="${userProfile.firstName}"/>" type="text">
					</div>
				  </div>
				  <div class="form-group">
					<label class="col-lg-3 control-label" for="lastname" >Last name</label>
					<div class="col-lg-8">
					  <input class="form-control" id="lastname" name="lastname" value="<c:out value="${userProfile.lastName}"/>" type="text">
					</div>
				  </div>
				  <div class="form-group">
					<label class="col-lg-3 control-label" for="phone" >Phone</label>
					<div class="col-lg-8">
					  <input class="form-control" id="phone" name="phone" value="<c:out value="${userProfile.phone}"/>" type="text">
					</div>
				  </div>
                  <div class="form-group">
					<label class="col-lg-3 control-label" for="mail">Email address</label>
					<div class="col-lg-8">
                        <input type="email" id="mail" name="mail" class="form-control" value="<c:out value="${userProfile.mail}"/>">
					</div>
				  </div> 
				  <div class="form-group">
					<label class="col-md-3 control-label"></label>
					<div class="col-md-8">
					  <input class="btn btn-primary" value="Save Changes" type="submit" name="saveChanges">
					  <span></span>
					  <input class="btn btn-default" value="Cancel" type="reset">
					  <a class="btn btn-danger" href="<%=request.getContextPath()+"/DeleteAccount?login=" + request.getParameter("login")%>"/>Delete Account</a>
					</div>
				  </div>
				</form>
			  </div>
			</div>
		</div>
							
	<jsp:include page="./Footer.jsp"/>
		
    </body>
    
    <script>
    $('#profile').addClass('active');
    </script>

</html>