/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

        /*function onYouTubeIframeAPIReady() {
                     var player;
                     player = new YT.Player('videoPlayer', {
                       videoId: 'M5hnrks2zow', // YouTube Video ID
                       height: $(window).height()+'px',
                       width: $(window).width()+'px',// Player height (in px)
                       playerVars: {
                         autoplay: 1,        // Auto-play the video on load
                         controls: 0,        // Show pause/play buttons in player
                         showinfo: 0,        // Hide the video title
                         modestbranding: 0,  // Hide the Youtube Logo
                         loop: 1,            // Run the video in a loop
                         fs: 0,              // Hide the full screen button
                         cc_load_policy: 0, // Hide closed captions
                         iv_load_policy: 3,  // Hide the Video Annotations
                         autohide: 1        // Hide video controls when playing
                       },
                       events: {
                         onReady: function(e) {
                           e.target.mute();
                         }
                       }
                     });
                     document.getElementById('main').style.height=$(window).height()+'px';
                     //document.getElementById('videoPlayer').style.marginTop=-(($('#videoPlayer').height()-$(window).height())/2)+'px';
                     //document.getElementById('videoPlayer').style.marginRight=-(($('#videoPlayer').width()-$(window).width())/2)+'px';
                        
                }*/
   
        
        function sizeTitleApp(){
            var largeurFenetre= $(window).width();
            document.getElementById("titleApp").style.fontSize="60pt";
            if(largeurFenetre<500){
                document.getElementById("titleApp").style.fontSize="40pt";
            }
        }
        
        function clicCreationCompte(){
            var formConnPere = document.getElementById("insideConnexion");
            var formConn=document.getElementById("formulaireConnexion");

            formConnPere.removeChild(formConn);

            formConnPere.innerHTML = '<form id="formulaireCreationCompte" class="col-xs-push-1 col-xs-10 col-sm-push-2 col-sm-8 col-md-push-3 col-md-6 col-lg-push-3 col-lg-6 centrerVerticalementForm" method="post">'
            +   '<div class="labelForm form-group">'
            +       '<label for="motDePasse">Login</label>'
            +       '<input type="text" id="loginCr" name="loginCr" class="form-control">'
            +   '</div>'
            +   '<div class="labelForm form-group">'
            +       '<label class="labelForm" for="motDePasse">Password</label>'
            +       '<input type="password" id="motDeaPasseCr" name="motDePasseCr" class="form-control">'
            +   '</div>'
            +   '<div class="labelForm form-group">'
            +       '<label class="labelForm" for="emailAddressCr">E-mail address</label>'
            +       '<input type="email" id="emailAddressCr" name="emailAddressCr" class="form-control">'
            +   '</div>'               
            +   '<div>'
            +       '<button type="submit" class="btn btn-primary col-xs-push-2 col-xs-8 col-sm-push-3 col-sm-6 col-md-push-3 col-md-6 col-lg-push-3 col-lg-6">Sign up</button>'
            +   '</div>'
            +'</form>'
            +'<div id="liensCr" class="container-fluid col-xs-12">'
            +   '<div class="row">' 
            +      '<div class="form-group">'
            +         '<button id="back" class="col-xs-6 boutonsCompte" onclick="clickBack()">Back</button>'
            +      '</div>'
            +   '</div>'
            +'</div>';            
        }
        
        function clickBack(){
            var formConnPere = document.getElementById("insideConnexion");
            var formConn=document.getElementById("formulaireCreationCompte");

            formConnPere.removeChild(formConn);
            
            formConnPere.innerHTML ='<form id="formulaireConnexion" class="col-xs-push-1 col-xs-10 col-sm-push-2 col-sm-8 col-md-push-3 col-md-6 col-lg-push-3 col-lg-6 centrerVerticalementForm" method="post">'
                                +       '<div class="labelForm form-group">'
                                +            '<label for="motDePasse">Login</label>'
                                +            '<input type="text" id="login" name="login" class="form-control">'
                                +       '</div>'
                                +   '<div class="labelForm form-group">'
                                +       '<label class="labelForm" for="motDePasse">Password</label>'
                                +       '<input type="password" id="motDeaPasse" name="motDePasse" class="form-control">'
                                +   '</div>'
                                +   '<div>'
                                +        '<button type="submit" class="btn btn-primary col-xs-push-2 col-xs-8 col-sm-push-3 col-sm-6 col-md-push-3 col-md-6 col-lg-push-3 col-lg-6">Sign in</button>'
                                +   '</div>'
                                +   '</form>'
                                +   '<div id="liens" class="container-fluid col-xs-12">'
                                +       '<div id="insideLiens" class="row">' 
                                +           '<button id="creationCompte" class="col-xs-6 boutonsCompte" onclick="clicCreationCompte()">Create an account</button>'
                                +           '<a id="motDePasseOublie" class="col-xs-6 boutonsCompte">Forgot your password?</a>'
                                +       '</div>'
                                +   '</div>';
        }
        
        jQuery(document).ready(function(){
            setInterval(sizeTitleApp, 1);
        });
