var ws;
var timerID = 0;

function connect() {
    var username = document.getElementById("username").value;
    
  //   ws = new WebSocket("ws://"+document.location.host+":8080/chat" + username);

   // ws = new WebSocket("ws://" + document.location.host + "/ChatApp/chat/" + username);

      

//      var wsProtocol = window.location.protocol == "https:" ? "wss" : "ws";
//      var port = (wsProtocol=="wss") ? ":8443" : ":8000";
//      var wsurl = wsProtocol + "://" + loc.hostname + port + loc.pathname+ "/../chat";
    
    var wsurl = "ws://" + document.location.hostname + ":" + document.location.port + document.location.pathname + "chat/"+username;
//     if (window.location.protocol == 'http:') {
//     wsurl = 'ws://' + window.location.host + ':8080/jws-app/chat/'+username;
//   } else {
//     wsurl = 'wss://' + window.location.host + ':8443/jws-app/chat/'+username;
//   }

     var log_1 = document.getElementById("log");
    
    log_1.innerHTML = wsurl+" "+username;
    
    ws = new WebSocket(wsurl);
    
    
    ws.onopen = function(message){ 
        console.log("Opening connections..");
        keepAlive();
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
    cancelKeepAlive();
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

    ws.send(json);
    log.innerHTML += "<span style='font-size:25px;'>Me : " + content + "</span>";
}
 
function keepAlive() { 
    var timeout = 20000;  
    if (ws.readyState == ws.OPEN) {  
        ws.send('');  
    }  
    timerID = setTimeout(keepAlive, timeout);  
}  
function cancelKeepAlive() {  
    if (timerID) {  
        clearTimeout(timerID);  
    }  
}
