<%-- 
    Document   : Messages
    Created on : 21 nov. 2016, 14:19:19
    Author     : prmm95
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>iManage Messages</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
       
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/bootstrap-select.min.js"></script>
       
        <!-- Custom CSS -->
        <link href="/iManage/Web-Content/StyleHome/css/landing-page.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="/iManage/Web-Content/search-page.css">         
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/css/bootstrap-select.min.css">

        
        <!-- Custom Fonts -->
        <link href="/iManage/Web-Content/StyleHome/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        
        <style>
            #adviceAddress{
                font-style: italic;
                font-size: 8pt;
                color : grey;
            }
            
        </style>
    </head>
    <body>
        <!-- Header --> 
       	<%  if(request.getAttribute("student") != null) {
                if((request.getAttribute("student")).equals("true")){
                                 %>
                <jsp:include page="./Header.jsp"/>
         <%}
            else if((request.getAttribute("student")).equals("false")){
                                 %>
                <jsp:include page="./HeaderCompany.jsp"/>       
         <%}                       
        }%>
        
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <div class="container">
            <div class="row">
                <h1>New Message</h1>
                <form class="form-horizontal" method="post"> 
                    <div class="form-group">
                        <label class="col-lg-3 control-label" for="recipients">Recipients</label>
			<div class="col-lg-8">
                            <input class="form-control" id="recipients" name="recipients" type="text" required>
                            <p id="adviceAddress">If you want to add several recipients, please use this pattern: recipient1,recipient2</p>
                            <% if(request.getAttribute("error") != null) {
                                        if((request.getAttribute("error")).equals("true")){
                                            String wrongLogin=request.getAttribute("wrongLogin").toString();
                                        %>
                                 <p style='color: red; font-family: Helvetica'><%=wrongLogin%> is not a user</p>
                                    <%}
                                }%>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-3 control-label" for="object">Object</label>
			<div class="col-lg-8">
                            <input class="form-control" id="object" name="object" type="text" required>
                        </div>
                    </div>
                    <div class="form-group">
			<label class="col-lg-3 control-label" for="message">Message</label>
                        <div class="col-lg-8">
                            <textarea rows="4" cols="50" class="form-control" id="message" name="message" required></textarea>
                        </div>
                    </div> 
                    <!--div class="form-group">
                        <label class="col-lg-3 control-label" for="cv">Cover Letter</label>
                        <div class="col-lg-8">
                            <input style="display:inline;" type="file" accept="application/pdf" name="file" id="file" class="btn btn-default" />
                        </div>	
                    </div-->
                    <div class="form-group">
                        <label class="col-md-3 control-label"></label>
                        <div class="col-md-8">
                            <input class="btn btn-primary" value="Send" type="submit" name="send">
                        </div>
                    </div>
		</form>
            </div>
        </div>
        <!-- Footer --> 
        <jsp:include page="./Footer.jsp"/>
    </body>
</html>
