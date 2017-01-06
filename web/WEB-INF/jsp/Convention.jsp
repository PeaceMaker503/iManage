<%-- 
    Document   : Convention
    Created on : 6 janv. 2017, 15:52:34
    Author     : prmm95
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	  
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
	
	<!-- Body -->
	<form method ="post">
		
		
		<!-- Take in account but is not necessary to choose from
			 Stage type --> 
		<h4>Year</h4>
		
		<h4>Student</h4>
		
		Lastname: <br>
		<input type="text" name="test"><br>

		Firstname: <br>
		<input type="text" name="test"><br>
		
		Email address: <br>
		<input type="text" name="test"><br>
		
		Personal email address: <br>
		<input type="text" name="test"><br>
		
		Social security number: <br>
		<input type="text" name="test"><br>
		
		Address: <br>
		<input type="text" name="test"><br>
		
		Zip code: <br>
		<input type="text" name="test"><br>
		
		City: <br>
		<input type="text" name="test"><br>
		
		Country: <br>
		<input type="text" name="test"><br>
		
		Phone: <br>
		<input type="text" name="test"><br>
		
		<h4>Company</h4>
		
		Name: <br>
		<input type="text" name="test"><br>

		SIRET Number: <br>
		<input type="text" name="test"><br>
		
		Address: <br>
		<input type="text" name="test"><br>
		
		Zip Code: <br>
		<input type="text" name="test"><br>
		
		City: <br>
		<input type="text" name="test"><br>
		
		Phone: <br>
		<input type="text" name="test"><br>
		
		Website: <br>
		<input type="text" name="test"><br>
		
		<h4>Company's representative</h4>
		
		Lastname: <br>
		<input type="text" name="test"><br>
		
		Name: <br>
		<input type="text" name="test"><br>
		
		Email address: <br>
		<input type="text" name="test"><br>
		
		Phone: <br>
		<input type="text" name="test"><br>
			
		<h4>Internship address</h4>
		
		Address: <br>
		<input type="text" name="test"><br>
		
		Zipcode: <br>
		<input type="text" name="test"><br>
		
		City: <br>
		<input type="text" name="test"><br>
		
		Phone: <br>
		<input type="text" name="test"><br>
				
		<h4>Company Tutor</h4>
		
		Lastname: <br>
		<input type="text" name="test"><br>
		
		Name: <br>
		<input type="text" name="test"><br>
		
		Email: <br>
		<input type="text" name="test"><br>
		
		Phone: <br>
		<input type="text" name="test"><br>
		
		<h4>Internship subject</h4>
		
		Internship subject: <br>
		<input type="text" name="test"><br>
		
		Activities subject: <br>
		<input type="text" name="test"><br>
		
		<br>
		<input class="btn btn-primary" value="Send Candidature" type="submit" name="saveChanges">
		<br>
		<input class="btn btn-primary" value="Save Changes" type="submit" name="saveChanges">
		
	</form>
		
    <!-- Footer --> 
	<jsp:include page="./Footer.jsp"/>
  </body>
    
  <script>
    $('#candidatures').addClass('active');
  </script>
  
</html>
