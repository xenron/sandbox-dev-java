<%-- 
    Document   : websocketChatClient
    Created on : Jun 23, 2013, 7:26:55 PM
    Author     : Ndjobo Armel Fabrice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <script language="javascript" type="text/javascript" src="websocketchat.js"></script>
        <title>Student chat room</title>
    </head>
    <body>
        <h3 id="userState"></h3>
        <form action="">
            <table cellspacing="10">
                <thead>
                    <tr>
                        <th>Connected users</th>
                        <th>Messages</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><textarea id="userId" rows="10" cols="12" readonly="readonly">
                            </textarea></td>
                            <td><textarea id="userMessage" rows="10" cols="60" readonly="readonly">
                                </textarea></td>
                    </tr>
                    <tr>
                        <td> </td>
                        <td>                                                 
                            <input type="text" id="txtMessage" value="write your message" size="40" />
                            <input type="button" value="Join the room"  onclick="joinChatRoom();">
                            <input type="button" value="Send message" onclick="sendMessage();"/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>        
    </body>
</html>
