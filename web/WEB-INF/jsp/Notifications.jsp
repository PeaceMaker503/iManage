<%-- 
    Document   : Notifications
    Created on : 21 nov. 2016, 14:21:14
    Author     : prmm95
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>iManage - Notifications</title>
    </head>
    <body>
		
		<!-- Header --> 
		<jsp:include page="./Header.jsp"/>
		
        <div class="container">
						
			<h2>Notifications</h2>
			<table class="table table-bordered">
			  <thead>
				<tr>
				  <th>Company</th>
				  <th>Offer</th>
				  <th>Message</th>
				  <th>Date</th>
				</tr>
			  </thead>
			  <tbody>
				<tr>
				  <td>Air France</td>
				  <td><a href="#">Python Full Stack Developper</a></td>
				  <td>Your candidature has been received.</td>
				  <td>25th September, 13:40</td>
				</tr>
				<tr>
				  <td>Capgemini</td>
				  <td><a href="#">Java Developer</a></td>
				  <td>You candidature has been rejected.</td>
				  <td>10th October, 16:50</td>
				</tr>
			  </tbody>
			</table>
		</div>
		
		<!-- Footer --> 
		<jsp:include page="./Footer.jsp"/>
		
    </body>
</html>
