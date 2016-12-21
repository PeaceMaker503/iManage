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
        <link rel="shortcut icon" href="http://ibewmain.atstestweb.com/wp-content/uploads/sites/8/2015/04/handshake.png">

    </head>
    <body>
        <!-- Navigation Bar -->
        <nav class="navbar navbar-inverse" style="margin-bottom: 0px;">
           <div class="container-fluid">
                        <ul class="nav navbar-nav">
                <li id="home"><a href="<%=request.getContextPath()+"/HomeCompany?login=" + request.getParameter("login")%>" style="font-weight: bold;"><span class="glyphicon glyphicon-home"></span> Home</a></li>
                <li id="search"><a href="<%=request.getContextPath()+"/Search?login=" + request.getParameter("login")%>" style="font-weight:bold;"><span class="glyphicon glyphicon-search"></span> Search</a></li>
                        <li id="messages"><a href="<%=request.getContextPath()+"/Messages?login=" + request.getParameter("login")%>" style="font-weight: bold;"><span class="glyphicon glyphicon-envelope"></span>  Messages</a></li> 
                        <li id="candidatures"><a href="<%=request.getContextPath()+"/Candidatures?login=" + request.getParameter("login")%>" style="font-weight: bold;"><span class="glyphicon glyphicon-paste"></span> Candidatures</a></li>
                        </ul>

                        <ul class="nav navbar-nav navbar-right">
                        <li id="profile"><a href="<%=request.getContextPath()+"/ViewUpdateCompanyProfile?login=" + request.getParameter("login")%>" style="font-weight: bold;"><span class="glyphicon glyphicon-user"></span> <%=request.getParameter("login")%></a></li>
                        <li><a href="<%=request.getContextPath()+"/Login?login=" + request.getParameter("login")%>" style="font-weight: bold;"><span class="glyphicon glyphicon-off"></span>  Logout</a></li>
                </ul>
                </div>
        </nav> 
    </body>
</html>
