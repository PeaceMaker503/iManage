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
        <div>
        <nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
        <div class="container topnav">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand topnav">iManage</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="<%=request.getContextPath()+"/Search?login=" + request.getParameter("login")%>">Search</a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()+"/ViewUpdateUserProfile?login=" + request.getParameter("login")%>">Profile</a>
                    </li>
                    <!--li>
                        request.getContextPath()+"/homeServlet"%>
                    </li-->
                    <li>
                        <a>Login</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        </nav>
        </div>        
        <br/><br/>
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


