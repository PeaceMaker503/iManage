<%-- 
    Document   : home
    Created on : 5 nov. 2016, 20:42:51
    Author     : jordycabannes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>iManage - Home</title>
		<style>
			/* Set height of the grid so .sidenav can be 100% (adjust if needed) */
			

			/* Set gray background color and 100% height */
			.sidenav {
				background-color: #f1f1f1;
				height: 100%;
			}

			/* On small screens, set height to 'auto' for sidenav and grid */
			@media screen and (max-width: 767px) {
			.sidenav {
				height: auto;
				padding: 15px;
			}
			.row.content {height: auto;}
			}
						
		</style>
		<script src="/iManage/Web-Content/StyleHome/js/pagination.js">	</script>

       <link href="/iManage/Web-Content/StyleHome/css/landing-page.css" rel="stylesheet">
        
        <!-- Custom Fonts -->
        <link href="/iManage/Web-Content/StyleHome/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
    </head>
    

        <body>
        <jsp:include page="./Header.jsp"/>
             
        <div class="intro-header">
        <div class="container">
            
	<!-- Footer --> 
	<jsp:include page="./Footer.jsp"/>
		
	</body>
</html>

