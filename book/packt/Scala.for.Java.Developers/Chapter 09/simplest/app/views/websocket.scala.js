@(id: String)(implicit r: RequestHeader)

$(function() {

  var WS = window['MozWebSocket'] ? MozWebSocket : WebSocket;
  var wsSocket = new WS("@routes.Application.websocket(id).webSocketURL()");

  var sendMessage = function() {
    wsSocket.send(JSON.stringify(
       {
    	   "booking":$("#booking").val(),
    	   "numberOfPersons":$("#numberOfPersons").val()
       }
    ))
    $("#numberOfPersons").val('');
  }

  var receiveEvent = function(event) {
    console.log(event);
    var data = JSON.parse(event.data);
    // Handle errors
    if(data.error) {
      console.log("WS Error ", data.error);
      wsSocket.close();
      // TODO manage error
      return;
    } else {
      console.log("WS received ", data);
      // TODO manage display
      $("#placesLeft").val(data.placesLeft);
    }

  }

  var handleReturnKey = function(e) {
    if(e.charCode == 13 || e.keyCode == 13) {
      e.preventDefault();
      sendMessage();
    }
  }

  $("#numberOfPersons").keypress(handleReturnKey);

  wsSocket.onmessage = receiveEvent;

})