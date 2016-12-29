<%-- 
    Document   : CandidaturesCompany
    Created on : 29 déc. 2016, 11:51:11
    Author     : prmm95
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
		
		<!-- Header --> 
		<jsp:include page="./HeaderCompany.jsp"/>
		
		<!-- Body -->
		<h1>Candidatures of the offer: (offer_name)</h1>
		<br>
		<table class="table table-bordered">
			  <thead>
				<tr>
				  <th>Candidate Name</th>
				  <th>CV</th>
				  <th>Cover Letter</th>
				  <th>Date</th>
				  <th>Status</th>
				</tr>
			  </thead>

			  <tbody>	
				  <c:forEach var="candidate" items="${candidatesList}">
					<tr>
					  <td>Name student</td>			  
					  <td><a href="#">lien_cv</a></td>
					  <td><a href="#">lien_cl</a></td>
					  <td><fmt:formatDate type="both" pattern="dd/MM/yyyy 'at' HH:mm" value="${candidature.createdAt}"/> dd/mm/yyyy at hh:mm</td>
					  <td>Not yet studied (dropdown to modify)</td>
					 </tr>							
				  </c:forEach>	
			  </tbody>
		</table>
		
		<!-- Footer -->
		<jsp:include page="./Footer.jsp"/>
		
    </body>
</html>
