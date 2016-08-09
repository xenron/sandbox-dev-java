/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch02.websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Ndjobo Armel Fabrice
 */
@ServerEndpoint("/chatserver")
public class ChatServerEndPoint {

    static Set<Session> users = Collections.synchronizedSet(new HashSet());
    static Set<String> usersId = Collections.synchronizedSet(new HashSet());

    @OnOpen
    public void openConnection(Session session) throws Exception {
        users.add(session);
        Object[] obj = new Object[]{"users",usersId};
        String jsonString = getJsonObject(obj);
        session.getBasicRemote().sendObject(jsonString);
    }

    @OnMessage
    public void onMessage(Session session, String msg) throws Exception {
        if (msg.startsWith("ID")) {//if it is a connection message
            String id = msg.split("-")[1];
            session.getUserProperties().put("id", id);//save the ID of the user
            usersId.add(id);//add the id in the liste of connected users
            Object[] obj1 = new Object[]{"wel","Welcome to the chat room " + id +" !"};
            String jsonString = getJsonObject(obj1);//json message transformation            
            session.getBasicRemote().sendText(jsonString);//send a welcome message to the new user
            //send the list of connected users to all users
            Object[] obj2 = new Object[]{"users",usersId};
            jsonString = getJsonObject(obj2);
            for (Session s : users) {
                s.getBasicRemote().sendText(jsonString);
            }
        } else {//if it is a message to the chat room
            String id = (String) session.getUserProperties().get("id");//get id of the user who sends message
            Object[] obj = new Object[]{"msg",id + ">>" + msg.split("-")[1]};
            String jsonString = getJsonObject(obj);//json transformation
            //sends the message to all connected user
            for (Session s : users) {
                s.getBasicRemote().sendText(jsonString);
            }
        }
    }

    @OnClose
    public void closeConnection(Session session) throws Exception {
        usersId.remove(session.getUserProperties().get("id"));
        users.remove(session);
        for (Session s : users) {
            s.getBasicRemote().sendObject(usersId);
        }
    }

    public  String getJsonObject(Object[]... objs) {
        String result = "{\"empty\":\"\"}";       
        
        JsonObjectBuilder objBuilder = Json.createObjectBuilder();
        for (Object[] obj : objs) {    
            String name = (String) obj[0];
            Object value = obj[1];
            if (value instanceof String) {
                objBuilder.add(name, (String) value);
            } else if (value instanceof Set) {
                Set<String> set = (Set<String>) value;
                JsonArrayBuilder arraBuilder = Json.createArrayBuilder();
                for (String str : set) {
                    arraBuilder.add(str);
                }
                objBuilder.add(name, arraBuilder);
            }
        }
        result = objBuilder.build().toString();
        return result;
    }
}
