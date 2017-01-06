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
        <title>iManage - Company Candidature</title>
    </head>
    <body>
		
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
		
		<!-- Header --> 
		<jsp:include page="./HeaderCompany.jsp"/>
		
		<!-- Body -->
		<br>
		<h2>Candidatures of the offer: ${internshipOffer.name}</h2>
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
					  <td>${candidate.id_userAccount.id_profile.firstName}  ${candidate.id_userAccount.id_profile.lastName} </td>			  
					  <td><a href="${candidate.id_userAccount.id_profile.cvPath}">CV</a></td>
					  <td><a href="${candidate.coverLetterPath}>">Cover Letter</a></td>
					  <td><fmt:formatDate type="both" pattern="dd/MM/yyyy 'at' HH:mm" value="${candidate.createdAt}"/></td>
					  <td>		
						<div class="labelForm form-group">
							<select class="selectpicker col-xs-12 " id="selectUserCategory" name="selectUserCategory" data-style="btn-default">
								<option>Current: ${candidate.status} </option>
								<option>-------------</option>
								<option>Not yet studied</option> 
								<option>In study</option>
								<option>Rejected</option>
								<option>Accepted</option>
							</select>
						</div>
					  <td>
					 </tr>							
				  </c:forEach>	
			  </tbody>
		</table>
		

		
		
		<!-- Footer -->
		<jsp:include page="./Footer.jsp"/>
		
    </body>
</html>
