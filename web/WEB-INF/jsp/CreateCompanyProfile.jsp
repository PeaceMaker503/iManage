<%-- 
    Document   : createProfile
    Created on : 6 nov. 2016, 15:04:58
    Author     : jordycabannes
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>iManage - Create Company Profile</title>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <link rel="stylesheet" media="screen" type="text/css" href="/iManage/Web-Content/createProfile.css"> 
        <script async src="https://www.youtube.com/iframe_api"></script>
        <!--script type="text/javascript" src="/iManage/Web-Content/index.js"></script-->
    </head>
    <body>
        <article id="main" class="col-xs-12">
            <nav class="navbar navbar-inverse">
		   <div class="container-fluid">
				
			   
				 <ul class="nav navbar-nav navbar-right">
                        <li id="profile"><span class="glyphicon glyphicon-user"></span> <%=request.getParameter("login")%></a></li>
                        <li><a href="<%=request.getContextPath()+"/Login?login=" + request.getParameter("login")%>" style="font-weight: bold;"><span class="glyphicon glyphicon-off"></span>  Logout</a></li>
                </ul>
			</div>
		</nav> 
            
            <div class="container" style="padding-top: 0px; padding-bottom: 10px;">
                <h1 class="page-header">Create Company Profile</h1>
                    <div class="row">
			  <!-- left column -->
			  <div class="col-md-4 col-sm-6 col-xs-12">
				<div class="text-center">
				  <img src="/iManage/Web-Content/StyleViewUpdateCompanyProfile/img/Company.png" class="avatar img-circle img-thumbnail" alt="avatar", style="height: 200px;">
				</div>
			  </div>
                          <!-- edit form column -->
			  <div class="col-md-8 col-sm-6 col-xs-12 personal-info">
				<h3>Conpany Info</h3>
                <form class="form-horizontal" method="post" action="<%=request.getContextPath()+"/CreateCompanyProfile?login=" + request.getParameter("login")%>">
				  <div class="form-group">
                    <label class="col-lg-3 control-label" for="name">Name</label>
                    <div class="col-lg-8">
                      <input class="form-control" id="lastname" name="name" type="text" required>
                    </div>
		</div>
                     <div class="form-group">
					<label class="col-lg-3 control-label" for="address">Address</label>
					<div class="col-lg-8">
                                            <input type="text" id="address" name="address" class="form-control" required>
					</div>
				  </div>
				<div class="form-group">
                                      <label class="col-lg-3 control-label" for="phone">Phone</label>
                                       <div class="col-lg-8">
                                            <input class="form-control" id="phone" name="phone" type="text" required>
                                       </div>
				  </div>
				  <div class="form-group">
					<label class="col-lg-3 control-label" for="mail">Email address</label>
					<div class="col-lg-8">
                                            <input type="email" id="mail" name="mail" class="form-control" required>
					</div>
				  </div>
				  <div class="form-group">
					<label class="col-md-3 control-label"></label>
					<div class="col-md-8">
					  <input class="btn btn-primary" value="Create" type="submit">
					</div>
				  </div>
				</form>
			  </div>
			</div>
		</div>
            <!--div id="videoPlayer"></div-->
            <!--div id="creationProfilePage" class="container-fluid col-xs-12 col-sm-push-2 col-sm-8 col-md-push-2 col-md-8 col-lg-push-2 col-lg-8">
                <div id ="insideCreationProfilePage" class="row">
                    <div id="titleMain" class="col-lg-12">
                        <img id="logoCompany" src="http://ibewmain.atstestweb.com/wp-content/uploads/sites/8/2015/04/handshake.png"/><p id="titleApp" class="centrerVerticalement">iManage</p>
                    </div>
                    <div id="create" class="container-fluid col-xs-12">
                        <div class="row" id="insideCreate"> 
                            <form id="formulaireCreationProfile"  action="equest.getParameter("login")%>" class="col-xs-push-1 col-xs-10 col-sm-push-2 col-sm-8 col-md-push-3 col-md-6 col-lg-push-3 col-lg-6 centrerVerticalementForm" method="post">
                                
                                <div class="labelForm form-group">
                                    <label for="lasname">Lastname</label>
                                    <input type="text" id="lastname" name="lastname" class="form-control">
                                </div>
                                <div class="labelForm form-group">
                                    <label class="labelForm" for="firstname">Firstname</label>
                                    <input type="text" id="firstname" name="firstname" class="form-control">
                                </div>
                                <div>
                                    <div class="labelForm form-group">
                                    <label for="phone">Phone</label>
                                    <input type="text" id="phone" name="phone" class="form-control">
                                </div>
                                <div class="labelForm  form-group">
                                    <label class="labelForm" for="mail">Email address</label>
                                    <input type="email" id="mail" name="mail" class="form-control">
                                </div>
                                <div class="labelForm form-group">
                                    <label class="labelForm" for="cvPath">CV</label>
                                    <input type="file" class="text-center center-block well well-sm">
                                </div>
                                <div>
                                    <button type="submit" class="btn btn-primary col-xs-push-2 col-xs-8 col-sm-push-3 col-sm-6 col-md-push-3 col-md-6 col-lg-push-3 col-lg-6">Create</button>
                                </div>
                            </form>
                        </div>
                    </div>
                    
                </div>
            </div-->
        </article>
	<!-- Footer --> 
								
		<!-- Footer --> 
		<!--jsp:include page="./Footer.jsp"/-->
											
    </body>
	
    <script>
    </script>
</html>
