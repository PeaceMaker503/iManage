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
        
		<!-- Header --> 
		<jsp:include page="./HeaderCompany.jsp"/>
		
		<!-- Body -->
		<h1>My Offers</h1>
		
		<a class="btn btn-primary" href="#" style="float:right">Add Offer</a>
		<br><br><br>
		
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
				  <c:forEach var="candidature" items="${candidatureList}">
					<tr>
					  <td><fmt:formatNumber type="number" pattern="0000" value="${candidature.id}"/></td>			  
					  <td><a href="${candidature.id_internship.pdfPath}">${candidature.id_internship.name}</a></td>
					  <td><fmt:formatDate type="both" pattern="dd/MM/yyyy 'at' HH:mm" value="${candidature.createdAt}"/></td>	  
					  <td><a href="<%=request.getContextPath()+"/DeleteCandidature?login=" + request.getParameter("login")%>&cand_id=${candidature.id}">View Candidatures</a></td>
					  <td><a href="<%=request.getContextPath()+"/DeleteCandidature?login=" + request.getParameter("login")%>&cand_id=${candidature.id}">Edit Offer</a></td>
					  <td><a href="<%=request.getContextPath()+"/DeleteCandidature?login=" + request.getParameter("login")%>&cand_id=${candidature.id}" class="btn btn-danger">Delete Offer</a></td>
					 </tr>							
				  </c:forEach>	
			  </tbody>
			</table>
		
		<!-- Footer -->
		<jsp:include page="./Footer.jsp"/>
				
    </body>
</html>