var ws;

function connect() {
    var username = document.getElementById("username").value;
    ws = new WebSocket("ws://" + document.location.host + "/ChatApp/chat/" + username);


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