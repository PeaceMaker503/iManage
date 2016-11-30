<%-- 
    Document   : Search
    Created on : 19 nov. 2016, 15:19:01
    Author     : paul & pablo
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
        
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
       
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

        <!-- Custom CSS -->
        <link href="/iManage/Web-Content/StyleHome/css/landing-page.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="/iManage/Web-Content/search-page.css">
        
        <!-- Custom Fonts -->
        <link href="/iManage/Web-Content/StyleHome/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
    
 
    </head>
    
    <body>
              
        <jsp:include page="./Header.jsp"/>
        
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
        <form action="Search" method="post">
		<!-- Sidebar -->
		<div class="container-fluid">
		  <div class="row content">
			<div class="col-sm-2 sidenav">
			  <h4>Internship Offers by Departement</h4>
			  <ul name="category" class="nav nav-pills nav-stacked" id="category">
                              <li class="active"><a>All</a></li>
                                <c:forEach var="element" items="${categoryList}">
                                <li><a>${element.name}</a></li> 
                                </c:forEach>
			  </ul><br>

			</div>

		<!-- Internship Offers --> 		
		<!-- Offer Template -->
		<div class="col-sm-10">
         
                    Company : 
                    <select name="selectCompany">
                        <option>All</option> 
                        <c:forEach var="element" items="${companyList}">
                            <option>${element.name}</option> 
                        </c:forEach>
                    </select>
                    Category : 
                    <select name="selectCategory">
                        <option>All</option> 
                        <c:forEach var="element" items="${categoryList}">
                            <option>${element.name}</option> 
                        </c:forEach>
                    </select>
                    <!-- Search Engine -->
                    <div class="input-group" >
                        <input type="text" name="keywords" class="form-control" placeholder="Search Internship by Tag..">
                        <span class="input-group-btn">
                        </span>
                    </div>
                    <br /><br />
                    <input id="paramButton" type="submit" value="Rechercher" style="margin-left: 9%;"/>
                    <a><% if(request.getAttribute("test") != null) {
                         out.print(request.getAttribute("test"));
                    }
                    %></a>
                    <br /><br />
        
        
		  <h4><small>INTERNSHIP OFFERS OF COMPUTER AND NETWORKS ENGINEERING</small></h4>
		  <hr>
                  <div class="flex-list">
                      <ul>
                  <c:forEach var="internship" items="${internshipList}">
                      <li style="width:100%">
                    <h2>${internship.name}</h2>
                    <h5><span class="glyphicon glyphicon-time"></span> Sep 27th, 2016.</h5>
                    <h5><span class="label label-danger">LABEL</span> <span class="label label-primary">Label</span></h5><br>
                    <div class="col-sm-2 text-center">
                          <img src="/iManage/Web-Content/StyleHome/img/air-france.jpg" class="img-circle" height="65" width="65" alt="Avatar">
                    </div>
                    <p>Company : ${internship.id_company.name}</p>
                    <p>Category : ${internship.id_category.name}</p>
                    <p>${internship.description}</p>
                    <br><br>

                    <a href="#" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">View PDF</a>
                    <a href="#" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Send my Candidature</a>
                      </li><br/>
                  </c:forEach>
                    </ul>
                  </div>
		</div>
		</div>
            </div>
        </form>
        <jsp:include page="./Footer.jsp"/>
        
    </body>
    
    <script type="text/javascript">
    
        
        
        $("#category li").on("click", function() {
            $("#category").find("li").removeClass("active");
            $(this).addClass("active");
            $("#sidebarValue").val($(this).text());
        });

        $('#search').addClass('active');
  
    </script>
        
</html>


