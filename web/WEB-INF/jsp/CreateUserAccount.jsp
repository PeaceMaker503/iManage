<%@page import="insa.db.UserProfile"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>iManage - Create Profile</title>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <link rel="stylesheet" media="screen" type="text/css" href="/iManage/Web-Content/index.css"> 
        <script async src="https://www.youtube.com/iframe_api"></script>
        <script type="text/javascript" src="/iManage/Web-Content/index.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/css/bootstrap-select.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/bootstrap-select.min.js"></script>
    </head>

    <body>
        
        <article id="main" class="col-xs-12">
            <!--div id="videoPlayer"></div-->
            <div id="homePage" class="container-fluid col-xs-12 col-sm-push-2 col-sm-8 col-md-push-2 col-md-8 col-lg-push-2 col-lg-8">
                <div id ="insideHomePage" class="row">
                    <div id="titleMain" class="col-lg-12">
                        <img id="logoCompany" src="http://ibewmain.atstestweb.com/wp-content/uploads/sites/8/2015/04/handshake.png"/><p id="titleApp" class="centrerVerticalement">iManage</p>
                    </div>
                    <div id="connexion" class="container-fluid col-xs-12">
                        <div class="row" id="insideConnexion"> 
                            <form id="formulaireCreationCompte" action="CreateUserAccount" class="col-xs-push-1 col-xs-10 col-sm-push-2 col-sm-8 col-md-push-3 col-md-6 col-lg-push-3 col-lg-6 centrerVerticalementForm" method="post">
                                <div class="labelForm form-group" style="margin-left:15px;margin-right:15px">
                                    <label for="motDePasse">Login</label>
                                    <input type="text" id="loginCr" name="loginCr" class="form-control">
                                </div>
                                <div class="labelForm form-group" style="margin-left:15px;margin-right:15px">
                                    <label class="labelForm" for="motDePasse">Password</label>
                                    <input type="password" id="motDeaPasseCr" name="motDePasseCr" class="form-control">
                                </div>
                                <div class="labelForm form-group" style="margin-left:15px;margin-right:15px">
                                    <label class="labelForm" for="emailAddressCr">E-mail address</label>
                                    <input type="email" id="emailAddressCr" name="emailAddressCr" class="form-control">
                                </div>
                                <div class="labelForm form-group">
                                    <label for="selectUserCategory">User category</label>
                                    <select class="selectpicker col-xs-12 " id="selectUserCategory" name="selectUserCategory" data-style="btn-default">
                                        <option>Student</option> 
                                        <option>Company</option>
										<option>Admin</option>
										<option>Security Organization</option>
										<option>INSA Staff</option>
                                    </select>
                                </div>
                                <div>
                                    <button type="submit" class="btn btn-primary col-xs-push-2 col-xs-8 col-sm-push-3 col-sm-6 col-md-push-3 col-md-6 col-lg-push-3 col-lg-6">Sign up</button>
                                </div>
                            </form>
                        </div>
                        <div id="liensCr" class="container-fluid col-xs-12" style="margin-top:40px">
                            <div class="row"> 
                                <form id="formulaireCreationCompte" action="Login" method="get">
                                    <button type="submit" class="col-xs-6 boutonsCompte">Back</button>
                                </form>
                            </div>
                        </div>           
                    </div>
                </div>
            </div>
        </article>
	
		
    </body>
    <script>
    </script>
</html>
