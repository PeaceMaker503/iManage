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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/bootstrap-select.min.js"></script>
       
        <!-- Custom CSS -->
        <link href="/iManage/Web-Content/StyleHome/css/landing-page.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="/iManage/Web-Content/search-page.css">         
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/css/bootstrap-select.min.css">

        
        <!-- Custom Fonts -->
        <link href="/iManage/Web-Content/StyleHome/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
    
 
    </head>
    
    <body>
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
        
        <form action="<%="Search?login=" + request.getParameter("login")%>" method="post">
		<!-- Sidebar -->
		<div class="container-fluid">
                    <div class="row content">
                        <div class="col-sm-2 sidenav">
                            <div class="title-criteria">
                                   Company
                            </div>
                 
                            <select class="selectpicker col-xs-12" name="selectCompany" data-style="btn-primary" >
                                <option>All</option> 
                                <c:forEach var="element" items="${companyList}">
                                    <option>${element.name}</option> 
                                </c:forEach>
                            </select>
                            <div class="title-criteria">
                                   Category
                            </div> 
                            <select name="selectCategory" class="selectpicker col-xs-12" data-style="btn-info">
                                <option>All</option> 
                                <c:forEach var="element" items="${categoryList}">
                                    <option>${element.name}</option> 
                                </c:forEach>
                            </select>
                            <!-- Search Engine -->
                            <div class="form-group col-xs-12">
                                <div class="title-criteria">
                                   Keywords
                                </div>
                                <input type="text" name="keywords" class="form-control" placeholder="Search Internship by Tag..">
                                <span class="input-group-btn">
                                </span>
                            </div>
                            <div class="col-xs-12">
                                <input id="paramButton"  class="btn btn-secondary col-xs-12" type="submit" value="Rechercher" style="margin-top:20px"/>
                            </div>
                            
                        </div>

                      
		<!-- Internship Offers --> 		
		<!-- Offer Template -->
		<div class="col-sm-10">
                    <br />  
                    <h4><small><% if (request.getAttribute("company") != null) {
                        out.print("INTERNSHIP OFFERS OF <b>" + request.getAttribute("company") + "</b> IN <b>" + request.getAttribute("category") + "</b> WITH TAGS : <b>" + request.getAttribute("keywords") + "</b>");
                    } else {
                        out.print("ALL INTERNSHIP");
                    }
                    %></small></h4>
		  <hr>
                  <div class="flex-list">
                      <ul>
                  <c:forEach var="internship" items="${internshipList}">
                      <li style="width:100%">
                    <h2>${internship.name}</h2>
                    <h5><span class="label label-primary">${internship.id_category.name}</span></h5><br>
                    <p>Company : ${internship.id_company.name}</p>
                    <p>Description: ${internship.description}</p>
                    <br><br>
                    <a href="<%=request.getContextPath()+"/Pdf?path="%>${internship.pdfPath}" target="_blank" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">View PDF</a>
                    <% if(request.getAttribute("student") != null) {
                                        if((request.getAttribute("student")).equals("true")){
                                 %>
                        <a href="<%=request.getContextPath()+"/SendCandidature?login=" + request.getParameter("login")%>&company_name=${internship.id_company.name}&offer_name=${internship.name}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Send my Candidature</a>
                    <%}
                                }%>
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

    </script>
        
</html>


