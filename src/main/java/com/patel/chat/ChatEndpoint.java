package com.patel.chat;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(
        value="/chat/{username}",
        decoders = MessageDecoder.class,
        encoders = MessageEncoder.class
)
public class ChatEndpoint {
    private final Logger log = Logger.getLogger(getClass().getName());

    private Session session;
    private String  username;
    private String  user_Id;
    private String  friend_Id;
    private String  message_Content;
    
    private static final Set<ChatEndpoint> chatEndpoints = new CopyOnWriteArraySet<>();
    private static HashMap<String,String> users = new HashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) throws IOException, EncodeException {
        log.info(session.getId() + " connected!");
            
        
        this.session = session;
        session.setMaxIdleTimeout(300000);
        this.username = username;
        chatEndpoints.add(this);
        users.put(session.getId(), username);

        Message message = new Message();
        message.setFrom(username);
        message.setContent("connected!");
        message.setUsername(username);// setting the username who connected to the chat room
        broadcast(message);
    }

    @OnMessage
    public void onMessage(Session session, Message message) throws IOException, EncodeException {
        log.info(message.toString());
       session.setMaxIdleTimeout(300000);
        message.setFrom(users.get(session.getId()));
        user_Id = message.getFrom();
        friend_Id = message.getTo();
        message_Content = message.getContent();
        System.out.println(user_Id);
        System.out.println(friend_Id);
        System.out.println(message_Content);
     //  int flag = DataBase_Operations.storeMessage(user_Id, friend_Id, message_Content);
        
       sendMessageToOneUser(message);
        
        
    }

    @OnClose
    public void onClose(Session session) throws IOException, EncodeException {
        log.info(session.getId() + " disconnected!");
        session.setMaxIdleTimeout(0);
        chatEndpoints.remove(this);
        Message message = new Message();
        message.setFrom(users.get(session.getId()));
        message.setContent("disconnected!");
        broadcast(message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        log.warning(throwable.toString());
    }

    private static void broadcast(Message message) throws IOException, EncodeException {
        for (ChatEndpoint endpoint : chatEndpoints) {
            synchronized(endpoint) {
                endpoint.session.getBasicRemote().sendObject(message);
            }
        }
    }

    private static void sendMessageToOneUser(Message message) throws IOException, EncodeException {
        for (ChatEndpoint endpoint : chatEndpoints) {
            synchronized(endpoint) {
                if (endpoint.session.getId().equals(getSessionId(message.getTo()))) {
                    endpoint.session.getBasicRemote().sendObject(message);
                }
            }
        }
    }

    private static String getSessionId(String to) {
        if (users.containsValue(to)) {
            for (String sessionId: users.keySet()) {
                if (users.get(sessionId).equals(to)) {
                    return sessionId;
                }
            }
        }
        return null;
    }
}
