var ws;
var timerID = 1000*60*5;
var username = "";
function connect() {
     username = document.getElementById("username").value;
    
  //   ws = new WebSocket("ws://"+document.location.host+":8080/chat" + username);

//      var wsProtocol = window.location.protocol == "https:" ? "wss" : "ws";
    
    var wsurl = "";
    if (window.location.protocol == 'http:') {
     wsurl = "ws://" + document.location.hostname + ":" + document.location.port + document.location.pathname + "chat/"+username;
   } else {
     wsurl = "wss://" + document.location.hostname + ":" + document.location.port + document.location.pathname + "chat/"+username;
   }

     var log_1 = document.getElementById("log");
    
    log_1.innerHTML = wsurl+" "+username;
    
    ws = new WebSocket(wsurl);
    
    
    ws.onopen = function(event){ 
        console.log("Opening connections..");
                 };


    ws.onmessage = function(event) {
        
    var log = document.getElementById("log");
    var usersTextBox = document.getElementById("usertextbox");

        console.log(event.data);
        var message = JSON.parse(event.data);
        /*log.innerHTML += message.from + " : " + message.content + "\n";*/
        log.innerHTML += "<span class='error'>"+message.from+" : "+message.content+"</span><br>";    
        usersTextBox.innerHTML += message.username + "\n"; // putting all conneted users to a particulartext area
        document.getElementById('error-message').innerHTML = "<span class='error'>"+message.from+" : "+message.content+"</span><br>";    
};
    

    
    ws.onclose = function(event){
    console.log("Closing the connections..");
    };
    
    ws.onerror = function(event){ 
    console.log("Error occured ..");    
    };
    
}

function send() {
    var content = document.getElementById("msg").value;
    var to = document.getElementById("to").value;
    var json = JSON.stringify({
        "to":to,
        "content":content
    });

    if(isOpen(ws))
    {ws.send(json);
    log.innerHTML += "<span style='font-size:25px;'>Me : " + content + "</span>";
    }
    else
    {
     if (window.location.protocol == 'http:') {
     wsurl = "ws://" + document.location.hostname + ":" + document.location.port + document.location.pathname + "chat/"+username;
   } else {
     wsurl = "wss://" + document.location.hostname + ":" + document.location.port + document.location.pathname + "chat/"+username;
   }
        ws = "";
     ws = new WebSocket(wsurl);
     ws.send(json);
    log.innerHTML += "<span style='font-size:25px;'>Me : " + content + "</span>";
    }
}

function isOpen(ws) { return ws.readyState === ws.OPEN }

