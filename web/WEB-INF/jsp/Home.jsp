<%-- 
    Document   : home
    Created on : 5 nov. 2016, 20:42:51
    Author     : jordycabannes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>iManage</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style>
			/* Set height of the grid so .sidenav can be 100% (adjust if needed) */
			

			/* Set gray background color and 100% height */
			.sidenav {
				background-color: #f1f1f1;
				height: 100%;
			}

			/* Set black background color, white text and some padding */
			footer {
			background-color: #555;
			color: white;
			padding: 15px;
			}

			/* On small screens, set height to 'auto' for sidenav and grid */
			@media screen and (max-width: 767px) {
			.sidenav {
				height: auto;
				padding: 15px;
			}
			.row.content {height: auto;}
			}
			
			footer {
				bottom:0;
			}
			
		</style>
		<script src="/iManage/Web-Content/StyleHome/js/pagination.js">	</script>
	</head>

	<body>
    
		<!-- Navigation Bar -->
		<nav class="navbar navbar-inverse">
		   <div class="container-fluid">
				<ul class="nav navbar-nav">
	                <li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span> Home</a></li>
		            <li><a href="<%=request.getContextPath()+"/Notifications?login=" + request.getParameter("login")%>"><span class="glyphicon glyphicon-user"></span>  Notifications</a></li>
			        <li><a href="<%=request.getContextPath()+"/Messages?login=" + request.getParameter("login")%>"><span class="glyphicon glyphicon-envelope"></span>  Messages</a></li> 
			        <li><a href="<%=request.getContextPath()+"/Candidatures?login=" + request.getParameter("login")%>"><span class="glyphicon glyphicon-paste"></span>  My Candidatures</a></li>
				</ul>
			   
				<ul class="nav navbar-nav navbar-right">
	               <li><a href="<%=request.getContextPath()+"/ViewUpdateUserProfile?login=" + request.getParameter("login")%>"><span class="glyphicon glyphicon-user"></span>  John Doe</a></li>
				   <li><a href="<%=request.getContextPath()+"/Candidatures?login=" + request.getParameter("login")%>"><span class="glyphicon glyphicon-paste"></span>  Logout</a></li>
		        </ul>
			</div>
		</nav>        
          
		<!-- Search Engine -->
		<div class="input-group" >
			<input type="text" class="form-control" placeholder="Search Internship by Tag..">
			<span class="input-group-btn">
				<button class="btn btn-default" type="button">
					<span class="glyphicon glyphicon-search"></span>
				</button>
			</span>
		</div>
		
		<!-- Sidebar -->
		<div class="container-fluid">
		  <div class="row content">
			<div class="col-sm-2 sidenav">
			  <h4>Internship Offers by Departement</h4>
			  <ul class="nav nav-pills nav-stacked">
				<li class="active"><a href="#section1">Computer and Networks Engineering</a></li>
				<li><a href="#section2">Civil Engineering</a></li>
				<li><a href="#section3">Chemical Engineering</a></li>
				<li><a href="#section3">Physics Engineering</a></li>
			  </ul><br>

			</div>

		<!-- Internship Offers --> 		
		<!-- Offer Template -->
		<div class="col-sm-10">
		  <h4><small>INTERNSHIP OFFERS OF COMPUTER AND NETWORKS ENGINEERING</small></h4>
		  <hr>
		  <h2>Python Full Stack Developer</h2>
		  <h5><span class="glyphicon glyphicon-time"></span> Sep 27th, 2016.</h5>
		  <h5><span class="label label-danger">Python</span> <span class="label label-primary">Django</span></h5><br>
		  <div class="col-sm-2 text-center">
			<img src="/iManage/Web-Content/StyleHome/img/air-france.jpg" class="img-circle" height="65" width="65" alt="Avatar">
		  </div>
		  <p>	Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
		  <br><br>
			  
		  <a href="#" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">View PDF</a>
		  <a href="#" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Send my Candidature</a>
		  
		</div>
		</div>
				
		</div>
		
		<br>
		<br>
		<br>
		
		<!-- Footer -->
		<footer class="container-fluid footer" >
		  <p style="text-align: center;	">2016 ® INSA Toulouse - iManage Development Team</p>
		</footer>
		
	</body>
</html>

