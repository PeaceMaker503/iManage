<%@page import="insa.client.Controller"%>
<%@page import="insa.db.UserProfile"%>
<%@page import="insa.ws.ManageWS"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <p>Hello! This is the default welcome page for a Spring Web MVC project.</p>
        <p><i>To display a different welcome page for this project, modify</i>
            <tt>index.jsp</tt> <i>, or create your own welcome page then change
                the redirection in</i> <tt>redirect.jsp</tt> <i>to point to the new
                welcome page and also update the welcome-file setting in</i>
            <tt>web.xml</tt>.</p>
        
            <button type="submit" onclick="callSOAPWS()" class="btn btn-primary">bouton</button>

            <script>
                
                function callSOAPWS()
                {
                  var soapMessage =
                      `<?xml version="1.0" encoding="UTF-8"?><S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/" xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
                        <SOAP-ENV:Header/>
                        <S:Body>
                            <ns2:addUserProfile xmlns:ns2="http://ws.insa/">
                                <firstName>a</firstName>
                                <lastName>a</lastName>
                                <mail>a@a.fr</mail>
                                <phone>0645259233</phone>
                                <cvPath>C:/p.pdf</cvPath>
                            </ns2:addUserProfile>
                        </S:Body>
                    </S:Envelope>`;

                  alert("Check SOAP: [" + soapMessage + "]");

                  $.ajax({
                          url: "http://localhost:8080/iManage/ManageWS",
                          type: "POST",
                          dataType: "xml",
                          data: soapMessage,
                          contentType: "text/xml; charset=\"utf-8\"",

                          //processData: false,   // what is it for? may be should be true when using 'complete:' ?
                          //timeout: 5000,

                          // below I first try to have only 'complete:' then I tried to have 'success:' + 'error:', then the 3. Nothing seems to be ok. I do not find which one i should use.
                          complete: function( response ){
                              alert(response.responseText);
                          },

                          success: function( response ){
                              alert(response.responseText);
                          },

                          error: function(XMLHttpRequest,textStatus, errorThrown){
                              alert("error:");
                          }

                  });
                }
            </script>
    </body>
</html>
