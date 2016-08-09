/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var clientUri = "ws://" + document.location.host + "/chapter02NewSpecifications/chatserver";
var wsocket;

window.addEventListener("load", connect, false);

function connect() {
    wsocket = new WebSocket(clientUri);
    wsocket.onmessage = onMessage;
    wsocket.onerror = onError;
}

function joinChatRoom() {
    wsocket.send("ID-" + txtMessage.value);
}

function sendMessage() {
    wsocket.send("M-" + txtMessage.value);
}

function onMessage(event) {
    var parsedJSON = eval('(' + event.data + ')');

    if (parsedJSON.wel != null) {
        userState.innerHTML = parsedJSON.wel;
    }

    if (parsedJSON.msg != null) {
        userMessage.innerHTML += "\n"+parsedJSON.msg;
    }

    if (parsedJSON.users.length > 0) {
        userId.innerHTML = "";

        for (i = 0; i < parsedJSON.users.length; i++) {
            userId.innerHTML += i + "-" + parsedJSON.users[i] + "\n";
        }
    }
}

function onError(event) {
    userState.innerHTML += '<h3 style="color: red;"> ERROR : ' + event.data + '</h3> ';
}
