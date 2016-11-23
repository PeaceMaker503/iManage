<%-- 
    Document   : Search
    Created on : 19 nov. 2016, 15:19:01
    Author     : paul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>iManage Search</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

        <!-- Custom CSS -->
        <link href="/iManage/Web-Content/StyleHome/css/landing-page.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="/iManage/Web-Content/search-page.css">
        
        <!-- Custom Fonts -->
        <link href="/iManage/Web-Content/StyleHome/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
    
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
        
    </head>
    <body>
              
        <jsp:include page="./Header.jsp"/>
        <div class="mainPage" style="color:black;margin-left:10%;">
        <h1>Search internship</h1>
        
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
        Company : 
        <select name="select">
            <option>All</option> 
            <c:forEach var="element" items="${companyList}">
                <option>${element.name}</option> 
            </c:forEach>
        </select>
        Category :
        <select name="select">
            <option>All</option> 
            <c:forEach var="element" items="${categoryList}">
                <option>${element.name}</option> 
            </c:forEach>
        </select>
        <br /><br />
        <input id="paramButton" type="button" value="Rechercher" onclick="Search()" style="margin-left: 9%;"/>
        <br /><br />

        
        <table ID="table1">
            <tr><td>Title</td><td>Company</td><td>Category</td></tr>
            <c:forEach var="element" items="${internshipList}">
                <tr>
                    <td>${element.name}</td> 
                    <td>${element.id_company.name}</td> 
                    <td>${element.id_category.name}</td> 
                </tr> 
            </c:forEach>
        </table>
        
        </div>
        
        
        
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
        <jsp:include page="./Footer.jsp"/>
        
    </body>
    
    <script type="text/javascript">
    
        function Search() {
            
        }
        
        $('#table1').find('tr:gt(0)').mouseover(function () {
            $(this).css('cursor', 'pointer');
            $(this).toggleClass('bg');
        });
        
        $('#table1').find('tr:gt(0)').mouseleave(function () {
            $(this).css('cursor', 'default');
            $(this).toggleClass('bg');
        });
    
    </script>
        
</html>


