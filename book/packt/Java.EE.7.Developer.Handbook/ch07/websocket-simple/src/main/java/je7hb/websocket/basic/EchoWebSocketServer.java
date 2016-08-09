/*******************************************************************************
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013,2014 by Peter Pilgrim, Addiscombe, Surrey, XeNoNiQUe UK
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU GPL v3.0
 * which accompanies this distribution, and is available at:
 * http://www.gnu.org/licenses/gpl-3.0.txt
 *
 * Developers:
 * Peter Pilgrim -- design, development and implementation
 *               -- Blog: http://www.xenonique.co.uk/blog/
 *               -- Twitter: @peter_pilgrim
 *
 * Contributors:
 *
 *******************************************************************************/

package je7hb.websocket.basic;


import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

/**
 * The type EchoWebSocketServer
 *                                                                                                                ≤§
 * @author Peter Pilgrim
 */
@ServerEndpoint("/echo")
public class EchoWebSocketServer {

    @OnMessage
    public String doListen(String message) {
        return "Echo: Got your message (" + message + "). Thanks";
    }
}

