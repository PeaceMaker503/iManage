<%@page import="insa.db.UserProfile"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>iManage - Login</title>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <link rel="stylesheet" media="screen" type="text/css" href="/iManage/Web-Content/index.css"> 
        <script async src="https://www.youtube.com/iframe_api"></script>
        <script type="text/javascript" src="/iManage/Web-Content/index.js"></script>
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
                            <form id="formulaireConnexion"  action="Login" class="col-xs-push-1 col-xs-10 col-sm-push-2 col-sm-8 col-md-push-3 col-md-6 col-lg-push-3 col-lg-6 centrerVerticalementForm" method="post">
                                <div class="labelForm form-group">
                                    <label for="login">Login</label>
                                    <input type="text" id="login" name="login" class="form-control">
                                </div>
                                <div class="labelForm form-group">
                                    <label class="labelForm" for="motDePasse">Password</label>
                                    <input type="password" id="motDeaPasse" name="motDePasse" class="form-control">
                                </div>
                                 <% if(request.getAttribute("exists") != null) {
                                        if((request.getAttribute("exists")).equals("false")){
                                 %>
                                            <div class='container-fluid col-xs-12'><div class='row'><div class='col-xs-push-1 col-xs-10' style='text-align: center; color: red; font-family: Helvetica'>Wrong login or password</div></div></div>
                                    <%}
                                }%>
                                <div>
                                    <button id="Submit" type="submit" class="btn btn-primary col-xs-push-2 col-xs-8 col-sm-push-3 col-sm-6 col-md-push-3 col-md-6 col-lg-push-3 col-lg-6" >Sign in</button>
                                </div>
                            </form>
                            <div id="liens" class="container-fluid col-xs-12">
                                <div id="insideLiens" class="row"> 
                                    <form id="formulaireConnexion" action="CreateUserAccount" method="get">
                                        <button id="creationCompte" class="col-xs-6 boutonsCompte">Create an account</button>
                                    </form>
                                    <form id="formulaireConnexion" action="RecoverPassword" method="get">
                                        <button id="motDePasseOublie" class="col-xs-6 boutonsCompte">Forgot your password?</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </article>
			
    </body>
    <script>
        var wrongLog=true;
        
        function onclickwrongLogin(exists){
            if(document.URL==="http://localhost:8080/iManage/Login" && wrongLog===false){
                $("#formulaireConnexion").append("<div class='container-fluid col-xs-12'><div class='row'><div class='col-xs-push-1 col-xs-10' style='text-align: center; color: red; font-family: Helvetica'>Wrong login or password</div></div></div>");
                wrongLog=true;
            }
        }
        
        jQuery(document).ready(function(){
            setInterval(onclickwrongLogin, 1);
        });
    </script>
</html>
