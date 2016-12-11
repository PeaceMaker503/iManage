<%-- 
    Document   : SendCandidature
    Created on : 7 déc. 2016, 10:36:39
    Author     : prmm95
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>iManage - Send Candidature</title>
		<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
       
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

        <!-- Custom CSS -->
        <link href="/iManage/Web-Content/StyleHome/css/landing-page.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="/iManage/Web-Content/search-page.css">
        
        <!-- Custom Fonts -->
        <link href="/iManage/Web-Content/StyleHome/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
    </head>
    <body>
        <jsp:include page="./Header.jsp"/>
		
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		
        <div class="container" style="padding-top: 0px; padding-bottom: 10px;">
			<h1 class="page-header">Send a candidature</h1>
			<div class="row">
							 
			  <!-- edit form column -->
			  <div class="col-md-8 col-sm-6 col-xs-12 personal-info">
				<h3>Offer: (Name of the offer) - # XXXX</h3>
				<br>				
				<form class="form-horizontal" method="post">
				  <div class="form-group">
					<label class="col-lg-3 control-label" for="Me">Title</label>
					<div class="col-lg-8">
					  <input class="form-control" id="firstname" name="firstname" value="<c:out value="${userProfile.firstName}"/>" type="text">
					</div>
				  </div>
				  <div class="form-group">
					<label class="col-lg-3 control-label" for="mail">Message</label>
					<div class="col-lg-8">
                        <textarea rows="4" cols="50" class="form-control" name="comment" form="usrform"></textarea>
					</div>
				  </div> 
				  <div class="form-group">
					<label class="col-lg-3 control-label" for="cv">Cover Letter</label>
					<div class="col-lg-8">
						<input style="display:inline;" type="file" accept="application/pdf" name="file" id="file" class="btn btn-default" />
					</div>	
				  </div>
				  <div class="form-group">
					<label class="col-md-3 control-label"></label>
					<div class="col-md-8">
					  <input class="btn btn-primary" value="Send candidature" type="submit" name="saveChanges">
					</div>
				  </div>
				</form>
			  </div>
			</div>
		</div>		
		
		<jsp:include page="./Footer.jsp"/>
    </body>
	
	    <script>
    $('#profile').addClass('active');
    </script>
		
	<script>
		function buttonSubmitClicked(event) {

			if (!document.getElementById("file").value) {
				event.preventDefault();
				alert("Please choose a file!");
			}
		}
	</script>
	
</html>
