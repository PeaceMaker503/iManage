<%-- 
    Document   : Offers
    Created on : 29 déc. 2016, 11:51:21
    Author     : prmm95
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>iManage - Offers</title>
	    <meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
    </head>
	
    <body>
		
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        
		<!-- Header --> 
		<jsp:include page="./HeaderCompany.jsp"/>
		
		<!-- Body -->
		<h1>My Offers</h1>
		
		<a class="btn btn-primary" href="<%=request.getContextPath()+"/AddOffer?login=" + request.getParameter("login")%>" style="float:right">Add Offer</a>
		<br><br><br>
		
		<c:choose>
						
			<c:when test="${!internshipList.isEmpty()}">
				<table class="table table-bordered">
				  <thead>
					<tr>
					  <th>ID</th>
					  <th>Name</th>
					  <th>Date</th>
					  <th>Applications</th>
					  <th>Edit</th>
					  <th>Delete</th>
					</tr>
				  </thead>

				  <tbody>	
					  <c:forEach var="offer" items="${internshipList}">
						<tr>
						  <td><fmt:formatNumber type="number" pattern="0000" value="${offer.id}"/></td>
						  <td>${offer.name}</td>
						  <td><fmt:formatDate type="both" pattern="dd/MM/yyyy 'at' HH:mm" value="${candidature.createdAt}"/></td>	  
						  <td><a href="<%=request.getContextPath()+"/CandidaturesCompany?login=" + request.getParameter("login")%>&offer_id=${offer.id}">View Candidatures</a></td>
						  <td><a href="<%=request.getContextPath()+"/EditOffer?login=" + request.getParameter("login")%>&offer_id=${offer.id}">Edit Offer</a></td>
						  <td><a href="<%=request.getContextPath()+"/DeleteOffer?login=" + request.getParameter("login")%>&offer_id=${offer.id}" class="btn btn-danger">Delete Offer</a></td>
						 </tr>							
					  </c:forEach>	
				  </tbody>
				</table>
				
			</c:when>
			
			<c:when test="${internshipList.isEmpty()}">
			    <h3>You have no offers added on iManage.</h3>
			    <br>
			</c:when>
			
		</c:choose>
				
		<!-- Footer -->
		<jsp:include page="./Footer.jsp"/>
				
    </body>
</html>