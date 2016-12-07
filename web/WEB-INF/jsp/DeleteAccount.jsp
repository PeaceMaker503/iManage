<%-- 
    Document   : DeleteAccount
    Created on : 7 déc. 2016, 12:58:33
    Author     : prmm95
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>iManage - Delete Account</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <!-- Header --> 
		<jsp:include page="./Header.jsp"/>
		
		<!-- Body -->
		<div class="container" style="padding-top: 0px; padding-bottom: 10px;">
			<h1 class="page-header">Delete Profile</h1>
			<div class="row">
			  <!-- left column -->
			  <div class="col-md-4 col-sm-6 col-xs-12">
			  </div>
			  <!-- edit form column -->
			  <div class="col-md-8 col-sm-6 col-xs-12 personal-info">
				<h3>Are you sure that you want to delete your account?</h3>
				<br>
				<form class="form-horizontal" method="post">				  
				  <div class="form-group">
					<label class="col-md-3 control-label"></label>
					<div class="col-md-8">
					  <input class="btn btn-danger" value="Delete Account" type="submit">
					  <span></span>
					  <a class="btn btn-primary" href="<%=request.getContextPath()+"/Home?login=" + request.getParameter("login")%>"/>Cancel</a>
					</div>
				  </div>
				</form>
			  </div>
			</div>
		</div>
				
		<!-- Footer --> 
		<jsp:include page="./Footer.jsp"/>
    </body>
</html>
