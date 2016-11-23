<%-- 
    Document   : Header
    Created on : 21 nov. 2016, 15:23:21
    Author     : prmm95
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </head>
    <body>
        <!-- Navigation Bar -->
        <nav class="navbar navbar-inverse" style="margin-bottom: 0px;">
           <div class="container-fluid">
                        <ul class="nav navbar-nav">
                <li class="active"><a href="<%=request.getContextPath()+"/Home?login=" + request.getParameter("login")%>"><span class="glyphicon glyphicon-home"></span> Home</a></li>
                <li><a href="<%=request.getContextPath()+"/Search?login=" + request.getParameter("login")%>"><span class="glyphicon glyphicon-heart-empty"></span> Search</a></li>
                    <li><a href="<%=request.getContextPath()+"/Notifications?login=" + request.getParameter("login")%>"><span class="glyphicon glyphicon-user"></span>  Notifications</a></li>
                        <li><a href="<%=request.getContextPath()+"/Messages?login=" + request.getParameter("login")%>"><span class="glyphicon glyphicon-envelope"></span>  Messages</a></li> 
                        <li><a href="<%=request.getContextPath()+"/Candidatures?login=" + request.getParameter("login")%>"><span class="glyphicon glyphicon-paste"></span>  My Candidatures</a></li>
                        </ul>

                        <ul class="nav navbar-nav navbar-right">
               <li><a href="<%=request.getContextPath()+"/ViewUpdateUserProfile?login=" + request.getParameter("login")%>"><span class="glyphicon glyphicon-user"></span> <%=request.getParameter("login")%></a></li>
                           <li><a href="<%=request.getContextPath()+"/Login?login=" + request.getParameter("login")%>"><span class="glyphicon glyphicon-remove-circle"></span>  Logout</a></li>
                </ul>
                </div>
        </nav> 
    </body>
</html>
