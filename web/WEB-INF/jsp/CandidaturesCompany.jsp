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
		<h2>Candidatures of the offer: <%= request.getAttribute("offer_name") %></h2>
		<br>
				  
				  <c:choose>
								  
					  <c:when test="${!candidatesList.isEmpty()}"> 
						  
						  <table class="table table-bordered">
						  <thead>
						    <tr>
						  	  <th>Candidate Name</th>
							  <th>Message</th>
							  <th>CV</th>
							  <th>Cover Letter</th>
							  <th>Date</th>
							  <th>Status</th>
							  <th>Save</th>
						    </tr>
						  </thead>

						  <tbody>
					  
						  <c:forEach var="candidate" items="${candidatesList}">
							<tr>
							  <form method="post">
								<td>${candidate.id_userAccount.id_profile.firstName}  ${candidate.id_userAccount.id_profile.lastName} </td>			  
								<td><a href=""%>${candidate.title}</td>
								<td><a href="<%=request.getContextPath()+"/Pdf?path="%>${candidate.id_userAccount.id_profile.cvPath}">CV</a></td>
								<td><a href="<%=request.getContextPath()+"/Pdf?path="%>${candidate.coverLetterPath}>">Cover Letter</a></td>
								<td><fmt:formatDate type="both" pattern="dd/MM/yyyy 'at' HH:mm" value="${candidate.createdAt}"/></td>
								<td>		
								  <div class="labelForm form-group">
									<select class="selectpicker col-xs-12 " id="selectStatus" name="selectStatus" data-style="btn-default">
									  <option>Current: ${candidate.status} </option>
									  <option>-------------</option>
									  <option>Not yet studied</option> 
									  <option>In study</option>
									  <option>Rejected</option>
									  <option>Accepted</option>
									</select>
								  </div>
								</td>
								<td><input class="btn btn-primary" value="Save" type="submit" name="saveChanges"/></td>
								<input type="hidden" id="candId" name="candId" value="${candidate.id}"/>
							  </form>	
							 </tr>							
						  </c:forEach>	
						  
					  </c:when>
					  
					  <c:when test="${candidatesList.isEmpty()}">
						  <h3>You have not received candidatures on this offer.</h3>
						  <br>
					  </c:when>
					  
				  </c:choose>
				  
				  
				  
				  
				  
			  </tbody>
		</table>
		

		
		
		<!-- Footer -->
		<jsp:include page="./Footer.jsp"/>
		
    </body>
</html>
