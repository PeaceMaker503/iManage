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
        
        var wrongLog=false;
        
        function wrongLogin(){
            if(document.URL==="http://localhost:8080/iManage/connectionServlet" && wrongLog===false){
                $("#formulaireConnexion").append("<div class='container-fluid col-xs-12'><div class='row'><div class='col-xs-push-1 col-xs-10' style='text-align: center; color: red; font-family: Helvetica'>Wrong login or password</div></div></div>");
                wrongLog=true;
            }
        }

        jQuery(document).ready(function(){
            setInterval(sizeTitleApp, 1);
        });
        
        jQuery(document).ready(function(){
            setInterval(wrongLogin, 1);
        });
