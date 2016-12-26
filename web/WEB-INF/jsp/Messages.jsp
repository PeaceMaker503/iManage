<%-- 
    Document   : Messages
    Created on : 21 nov. 2016, 14:19:19
    Author     : prmm95
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>iManage Messages</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
       	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/bootstrap-select.min.js"></script>
       
        <!-- Custom CSS -->
        <link href="/iManage/Web-Content/message.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/css/bootstrap-select.min.css">

        
        <!-- Custom Fonts -->
        <link href="/iManage/Web-Content/StyleHome/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
    
        <link href="/iManage/Web-Content/jquery-ui-1.10.4/css/ui-lightness/jquery-ui-1.10.4.css" rel="stylesheet">
        <script src="/iManage/Web-Content/jquery-ui-1.10.4/js/jquery-1.10.2.js"></script>
        <script src="/iManage/Web-Content/jquery-ui-1.10.4/js/jquery-ui-1.10.4.js"></script>
        
        <style>
           

            p { padding: 10px;} 

            /* modifie le titre de l'onglet */
            li.ui-state-default { font-size : 18px;} 

            /* modifie le contenu des onglets */
            div.ui-tabs-panel { font-size: 12px;} 
        </style>
    </head>
    <body>
		
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
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <div class="container">
			<div class="row">

				<section class="content">
					<h1>Messaging Service</h1>
                                        <a class="col-xs-2 btn btn-default" style="display:inline;" href="<%=request.getContextPath()+"/WriteMessage?login="+request.getParameter("login")%>" role="button" aria-pressed="true">New Message</a>
					<div class="col-xs-10">
						<div class="panel panel-default">
							<div class="panel-body">
								<!--div class="pull-right">
									<div class="btn-group">
										<button type="button" class="btn btn-success btn-filter" data-target="pagado">Pagado</button>
										<button type="button" class="btn btn-warning btn-filter" data-target="pendiente">Pendiente</button>
										<button type="button" class="btn btn-danger btn-filter" data-target="cancelado">Cancelado</button>
										<button type="button" class="btn btn-default btn-filter" data-target="all">Todos</button>
									</div>
								</div-->
                                                            <div id="onglets" class="col-xs-12 ongletsStyle"> 
                                                                <ul> 
                                                                        <li><a href="#onglet-1">Received messages</a></li> 
                                                                        <li><a href="#onglet-2">Sent messages</a></li> 
                                                                </ul> 
                                                                <div id="onglet-1" style="height:200px">
                                                                    <div class="container col-xs-12" style="height:30px">
                                                                        <div class="row">
                                                                            <ul class="listHead col-xs-12">
                                                                                <li class="headList col-xs-1"><b>Select</b></li>
                                                                                <li class="headList col-xs-3"><b>From</b></li>
                                                                                <li class="headList col-xs-6"><b>Object</b></li>
                                                                                <li class="headList col-xs-2"><b>Date</b></li>
                                                                            </ul>
                                                                        </div></div> 
                                                                    <div id="divReceived1" class="container scroll col-xs-12" style="height:150px">
                                                                        <div id="divReceived2" class="row">
                                                                            <script>var contentMsgR = new Array();
                                                                                    var i=0;</script>
                                                                                <c:forEach var="message" items="${messagesList}">
                                                                                    <script>
                                                                                        contentMsgR.push("<c:out value='${message.content}'/>");
                                                                                        var j =i;
                                                                                        i++;
                                                                                        var read = "<c:out value='${message.read}'/>";
                                                                                    </script>
                                                                                    <ul id='prov' class="uMsgR col-xs-12" style="height:20px">
                                                                                        <script> 
                                                                                        if(read==="false"){document.getElementById("prov").style.fontWeight="bold";}    
                                                                                        document.getElementById("prov").id=j;</script>
                                                                                                <li class="listMsg col-xs-1"></li>
                                                                                                <li class="listMsg col-xs-3">${message.sender.login}</li>
                                                                                                <li class="listMsg col-xs-6">${message.object}</li>
                                                                                                <li class="listMsg col-xs-2">${message.date}</li>
                                                                                                <li style="visibility: hidden" class="listMsg col-xs-0">${message.id}</li>
                                                                                                <li style="visibility: hidden" class="listMsg col-xs-0">${message.read}</li>
                                                                                             </ul> 
                                                                                </c:forEach>
                                                                        </div>
                                                                        </div>
                                                                                            <!--tr data-status="pagado">
                                                                                                    <td>
                                                                                                            <div class="ckbox">
                                                                                                                    <input type="checkbox" id="checkbox1">
                                                                                                                    <label for="checkbox1"></label>
                                                                                                            </div>
                                                                                                    </td>
                                                                                                    <td>
                                                                                                            <a href="javascript:;" class="star">
                                                                                                                    <i class="glyphicon glyphicon-star"></i>
                                                                                                            </a>
                                                                                                    </td>
                                                                                                    <td>
                                                                                                            <div class="media">
                                                                                                                    <a href="#" class="pull-left">
                                                                                                                            <img src="https://s3.amazonaws.com/uifaces/faces/twitter/fffabs/128.jpg" class="media-photo">
                                                                                                                    </a>
                                                                                                                    <div class="media-body">
                                                                                                                            <span class="media-meta pull-right">Febrero 13, 2016</span>
                                                                                                                            <h4 class="title">
                                                                                                                                    Lorem Impsum
                                                                                                                                    <span class="pull-right pagado">(Pagado)</span>
                                                                                                                            </h4>
                                                                                                                            <p class="summary">Ut enim ad minim veniam, quis nostrud exercitation...</p>
                                                                                                                    </div>
                                                                                                            </div>
                                                                                                    </td>
                                                                                            </tr>
                                                                                            <tr data-status="pendiente">
                                                                                                    <td>
                                                                                                            <div class="ckbox">
                                                                                                                    <input type="checkbox" id="checkbox3">
                                                                                                                    <label for="checkbox3"></label>
                                                                                                            </div>
                                                                                                    </td>
                                                                                                    <td>
                                                                                                            <a href="javascript:;" class="star">
                                                                                                                    <i class="glyphicon glyphicon-star"></i>
                                                                                                            </a>
                                                                                                    </td>
                                                                                                    <td>
                                                                                                            <div class="media">
                                                                                                                    <a href="#" class="pull-left">
                                                                                                                            <img src="https://s3.amazonaws.com/uifaces/faces/twitter/fffabs/128.jpg" class="media-photo">
                                                                                                                    </a>
                                                                                                                    <div class="media-body">
                                                                                                                            <span class="media-meta pull-right">Febrero 13, 2016</span>
                                                                                                                            <h4 class="title">
                                                                                                                                    Lorem Impsum
                                                                                                                                    <span class="pull-right pendiente">(Pendiente)</span>
                                                                                                                            </h4>
                                                                                                                            <p class="summary">Ut enim ad minim veniam, quis nostrud exercitation...</p>
                                                                                                                    </div>
                                                                                                            </div>
                                                                                                    </td>
                                                                                            </tr>
                                                                                            <tr data-status="cancelado">
                                                                                                    <td>
                                                                                                            <div class="ckbox">
                                                                                                                    <input type="checkbox" id="checkbox2">
                                                                                                                    <label for="checkbox2"></label>
                                                                                                            </div>
                                                                                                    </td>
                                                                                                    <td>
                                                                                                            <a href="javascript:;" class="star">
                                                                                                                    <i class="glyphicon glyphicon-star"></i>
                                                                                                            </a>
                                                                                                    </td>
                                                                                                    <td>
                                                                                                            <div class="media">
                                                                                                                    <a href="#" class="pull-left">
                                                                                                                            <img src="https://s3.amazonaws.com/uifaces/faces/twitter/fffabs/128.jpg" class="media-photo">
                                                                                                                    </a>
                                                                                                                    <div class="media-body">
                                                                                                                            <span class="media-meta pull-right">Febrero 13, 2016</span>
                                                                                                                            <h4 class="title">
                                                                                                                                    Lorem Impsum
                                                                                                                                    <span class="pull-right cancelado">(Cancelado)</span>
                                                                                                                            </h4>
                                                                                                                            <p class="summary">Ut enim ad minim veniam, quis nostrud exercitation...</p>
                                                                                                                    </div>
                                                                                                            </div>
                                                                                                    </td>
                                                                                            </tr>
                                                                                            <tr data-status="pagado" class="selected">
                                                                                                    <td>
                                                                                                            <div class="ckbox">
                                                                                                                    <input type="checkbox" id="checkbox4" checked>
                                                                                                                    <label for="checkbox4"></label>
                                                                                                            </div>
                                                                                                    </td>
                                                                                                    <td>
                                                                                                            <a href="javascript:;" class="star star-checked">
                                                                                                                    <i class="glyphicon glyphicon-star"></i>
                                                                                                            </a>
                                                                                                    </td>
                                                                                                    <td>
                                                                                                            <div class="media">
                                                                                                                    <a href="#" class="pull-left">
                                                                                                                            <img src="https://s3.amazonaws.com/uifaces/faces/twitter/fffabs/128.jpg" class="media-photo">
                                                                                                                    </a>
                                                                                                                    <div class="media-body">
                                                                                                                            <span class="media-meta pull-right">Febrero 13, 2016</span>
                                                                                                                            <h4 class="title">
                                                                                                                                    Lorem Impsum
                                                                                                                                    <span class="pull-right pagado">(Pagado)</span>
                                                                                                                            </h4>
                                                                                                                            <p class="summary">Ut enim ad minim veniam, quis nostrud exercitation...</p>
                                                                                                                    </div>
                                                                                                            </div>
                                                                                                    </td>
                                                                                            </tr>
                                                                                            <tr data-status="pendiente">
                                                                                                    <td>
                                                                                                            <div class="ckbox">
                                                                                                                    <input type="checkbox" id="checkbox5">
                                                                                                                    <label for="checkbox5"></label>
                                                                                                            </div>
                                                                                                    </td>
                                                                                                    <td>
                                                                                                            <a href="javascript:;" class="star">
                                                                                                                    <i class="glyphicon glyphicon-star"></i>
                                                                                                            </a>
                                                                                                    </td>
                                                                                                    <td>
                                                                                                            <div class="media">
                                                                                                                    <a href="#" class="pull-left">
                                                                                                                            <img src="https://s3.amazonaws.com/uifaces/faces/twitter/fffabs/128.jpg" class="media-photo">
                                                                                                                    </a>
                                                                                                                    <div class="media-body">
                                                                                                                            <span class="media-meta pull-right">Febrero 13, 2016</span>
                                                                                                                            <h4 class="title">
                                                                                                                                    Lorem Impsum
                                                                                                                                    <span class="pull-right pendiente">(Pendiente)</span>
                                                                                                                            </h4>
                                                                                                                            <p class="summary">Ut enim ad minim veniam, quis nostrud exercitation...</p>
                                                                                                                    </div>
                                                                                                            </div>
                                                                                                    </td>
                                                                                            </tr-->
                                                                                   
                                                                    </div>
                                                                
                                                                
                                                                    <div id="onglet-2" style="height:200px">
                                                                        <div class="container col-xs-12" style="height:30px">
                                                                        <div class="row">
                                                                            <ul class="listHead col-xs-12">
                                                                                <li class="headList col-xs-1"><b>Select</b></li>
                                                                                <li class="headList col-xs-3"><b>To</b></li>
                                                                                <li class="headList col-xs-6"><b>Object</b></li>
                                                                                <li class="headList col-xs-2"><b>Date</b></li>
                                                                            </ul>
                                                                        </div></div>   
                                                                        <div id ="divSent1" class="container scroll col-xs-12" style="height:150px">
                                                                        <div id ="divSent2" class="row">
                                                                            <script>var contentMsgS = new Array();
                                                                                    var i=0;
                                                                                    
                                                                                    var tabAllReceiver = new Array();</script>
                                                                              <c:forEach var="receivers" items="${receiverList}">
                                                                                  <script>var tabReceiver= new Array();</script>  
                                                                                  <c:forEach var="receiver" items="${receivers}">
                                                                                    <script>tabReceiver.push("<c:out value='${receiver.login}'/>");</script>
                                                                                  </c:forEach>
                                                                                  <script>tabAllReceiver.push(tabReceiver);</script>

                                                                              </c:forEach>
                                                                              <c:forEach var="sentMessage" items="${SentMessagesList}">
                                                                                  <script>
                                                                                         contentMsgS.push("<c:out value='${sentMessage.content}'/>");
                                                                                            var j=i;
                                                                                            i++;
                                                                                            var read = "<c:out value='${sentMessage.read}'/>";

                                                                                </script>
                                                                                   
                                                                                  <ul id='prov' class="uMsgS col-xs-12" style="height:20px"><script> 
                                                                                      if(read==="false"){document.getElementById("prov").style.fontWeight="bold";}
                                                                                                    document.getElementById("prov").id=j;
                                                                                      </script>   
                                                                                       <li class="listMsg col-xs-1"></li>                                                                                               
                                                                                                <li id="prov2" class="listMsg col-xs-3 listDesReceivers">
                                                                                                    <script>
                                                                                                        document.getElementById("prov2").id="listDesReceivers"+j;
                                                                                                        var elt=document.getElementById("listDesReceivers"+j);
                                                                                                        var indice;
                                                                                                        for(indice=0; indice<tabAllReceiver[j].length; indice++){
                                                                                                            elt.append(tabAllReceiver[j][indice]+", ");
                                                                                                        }
                                                                                                    </script>  
                                                                                                </li>  
                                                                                                <li class="listMsg col-xs-6">${sentMessage.object}</li>
                                                                                                <li class="listMsg col-xs-2">${sentMessage.date}</li>
                                                                                                <li style="visibility: hidden" class="listMsg col-xs-0">${sentMessage.id}</li>
                                                                                                <li style="visibility: hidden" class="listMsg col-xs-0">${sentMessage.read}</li>

                                                                                             </ul> 
                                                                                </c:forEach>        
                                                                        </div></div>
                                                                        
                                                                </div>
                                                                <div id="displayContent">
                                                                    
                                                                </div>
						</div>
                                                        </div></div></div>
				</section>

			</div>
		</div>
		
		<!-- Footer --> 
		<jsp:include page="./Footer.jsp"/>
				
    </body>
    
     <script>
    $('#messages').addClass('active');
    
    $(function()
{ 
	$("#onglets").tabs(); 
});

    $('.uMsgR').click(function(){
        var id = this.id;
        var readm = this.children[6].innerHTML;
        var idMsg = this.children[5].innerHTML;
        document.getElementById("displayContent").innerHTML=contentMsgR[id];
        if(readm==="false"){
            $.ajax({
            url:'Messages',
            data:{idm:idMsg},
            type:'post',
            cache:false
         });
     }
        $(this).css("font-weight","normal");
    });
    
    $('.uMsgS').click(function(){
        var id = this.id;
        var readm = this.children[6].innerHTML;
        var idMsg = this.children[5].innerHTML;
        document.getElementById("displayContent").innerHTML=contentMsgS[id];
        if(readm==="false"){
            $.ajax({
                url:'Messages',
                data:{idm:idMsg},
                type:'post',
                cache:false
             });
         }
        $(this).css("font-weight","normal");

    });
    
    var jObjSelect1 = $( "#divSent2" );
    var jObjSelect2 = $( "#divReceived2" );
    
    jObjSelect2.find( "ul" ).each( function( i, item ){ 
        $( item ).prependTo( jObjSelect2 );
    });
    
    jObjSelect1.find( "ul" ).each( function( i, item ){ 
        $( item ).prependTo( jObjSelect1 );
    });
    
    
   </script>

</html>