<%-- 
    Document   : Candidatures
    Created on : 19 nov. 2016, 15:57:17
    Author     : prmm95
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>iManage - My Candidatures</title>
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
  
  <body>
	  
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	  
    <!-- Header --> 
	<jsp:include page="./Header.jsp"/>
	
	<!-- Body -->
	<div class="container">					
	  <h2>My Candidatures</h2>
	  <table class="table table-bordered">
		  
	    <thead>
	      <tr>
		    <th>Company</th>
			<th>Offer</th>
			<th>Date</th>
			<th>Status</th>
		  </tr>
		</thead>
			  
		<tbody>				
		  <c:forEach var="candidature" items="${candidatureList}">
		    <tr>
			  <td>name</td>
			  <td><a href="#">${candidature.title}</a></td>
			  <td>${candidature.createdAt}</td>
			  <td>${candidature.status}</td>
			</tr>							
		  </c:forEach>				  
		</tbody>
			  
	  </table>
	</div>
		
    <!-- Footer --> 
	<jsp:include page="./Footer.jsp"/>
  </body>
    
  <script>
    $('#candidatures').addClass('active');
  </script>

</html>











