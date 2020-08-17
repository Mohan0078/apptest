<html>
    <head>
        <title>Chat</title>
        <script type="text/javascript" src="js/script.js"></script>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
    
    <form action="messages">
    <input type="submit" value="messages">
    </form>

        <table>
            <tr>
                <td colspan="2">
                    <input type="text" id="username" placeholder="Username"/>
                    <button type="button" onclick="connect();" >Connect</button>
                </td>
            </tr>
            
            <tr>
            <td>
            <textarea readonly="readonly" rows="10" cols="80" id="usertextbox"></textarea>
                </td>
                </tr>
             
                <tr>
                <td>
                   <div id="error-message"></div>
                    <div id="log"></div>
               </td>
            </tr>
 

        <tr>
                <td>
                    <input type="text" size="15" id="to" placeholder="To"/>
                    <input type="text" size="51" id="msg" placeholder="Message"/>
                    <button type="button" onclick="send();" >Send</button>
                </td>
            </tr>
        </table>         
    </body>


</html>