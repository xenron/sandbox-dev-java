/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch09.chapter9.sam;

import java.io.IOException;
import java.util.Map;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.message.AuthException;
import javax.security.auth.message.AuthStatus;
import javax.security.auth.message.MessageInfo;
import javax.security.auth.message.MessagePolicy;
import javax.security.auth.message.callback.CallerPrincipalCallback;
import javax.security.auth.message.callback.GroupPrincipalCallback;
import javax.security.auth.message.callback.PasswordValidationCallback;
import javax.security.auth.message.module.ServerAuthModule;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.util.Base64;

/**
 *
 * @author Administrator
 */
public class ServerAuthModuleImpl implements ServerAuthModule {

    private MessagePolicy requestPolicy;
    private CallbackHandler handler;

    public void initialize(MessagePolicy requestPolicy, MessagePolicy responsePolicy, CallbackHandler handler, Map options) throws AuthException {
        this.requestPolicy = requestPolicy;
        this.handler = handler;
    }

    public Class[] getSupportedMessageTypes() {
        return new Class[]{HttpServletRequest.class, HttpServletResponse.class};
    }

    public AuthStatus validateRequest(MessageInfo messageInfo, Subject clientSubject, Subject serviceSubject) throws AuthException {
        try {

            String username = validation(messageInfo, clientSubject);
            if (username == null && requestPolicy.isMandatory()) {

                HttpServletRequest request = (HttpServletRequest) messageInfo.getRequestMessage();
               
                HttpServletResponse response = (HttpServletResponse) messageInfo.getResponseMessage();

                String header = "Basic" + " realm=\"" + request.getServerName() + "\"";
                response.setHeader("WWW-Authenticate", header);

                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return AuthStatus.SEND_CONTINUE;
            }

            handler.handle(new Callback[]{
                new CallerPrincipalCallback(clientSubject, username)});
            if (username != null) {
                messageInfo.getMap().put("javax.servlet.http.authType", "ServerAuthModuleImpl");
            }

            return AuthStatus.SUCCESS;

        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthException(e.getMessage());
        }
    }

    public String validation(MessageInfo mInfo, Subject cSubject) throws Exception {
        HttpServletRequest request = (HttpServletRequest) mInfo.getRequestMessage();

        String headerAutho = request.getHeader("authorization");

        if (headerAutho != null && headerAutho.startsWith("Basic")) {

            headerAutho = headerAutho.substring(6).trim();

            String decodedAutho = new String(Base64.decode(headerAutho.getBytes()));

            int colon = decodedAutho.indexOf(':');
            if (colon <= 0 || colon == decodedAutho.length() - 1) {
                return null;
            }

            String username = decodedAutho.substring(0, colon);
            String password = decodedAutho.substring(colon + 1);

            //Container password validation, you can put your
            //own validation process instead of delegating it to the container
            PasswordValidationCallback pwdValidCallback =
                    new PasswordValidationCallback(cSubject, username, password.toCharArray());

            handler.handle(new Callback[]{pwdValidCallback});
            //Removes the stored password
            pwdValidCallback.clearPassword();            

            if (pwdValidCallback.getResult()) {//if the user is authenticated                
                return username;
            }
        }
        return null;
    }

    public AuthStatus secureResponse(MessageInfo messageInfo, Subject serviceSubject) throws AuthException {
        return AuthStatus.SEND_SUCCESS;
    }

    public void cleanSubject(MessageInfo messageInfo, Subject subject) throws AuthException {
    }
}