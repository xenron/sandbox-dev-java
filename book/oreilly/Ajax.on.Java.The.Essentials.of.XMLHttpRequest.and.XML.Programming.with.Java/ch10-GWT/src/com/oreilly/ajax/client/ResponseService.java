package com.oreilly.ajax.client;


import com.google.gwt.user.client.rpc.RemoteService;

public interface ResponseService extends RemoteService{
    String displayResponse(String req);
}

