var ws;

function connect() {
    var username = document.getElementById("username").value;
    
   // ws = new WebSocket("ws://" + document.location.host + "/ChatApp/chat/" + username);

     var loc = window.location
    var port = loc.port;
    // Openshift WS port is 8000
    if (loc.hostname.indexOf('rhcloud.com', 0) > 0) {
        port = 8000;
    }
    var wsProtocol = window.location.protocol == "https:" ? "wss" : "ws";
    var wsurl = wsProtocol + "://" + loc.hostname + ':' + port + loc.pathname
            + "/../chat";
    ws = new WebSocket(wsurl+username);
    
    

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
