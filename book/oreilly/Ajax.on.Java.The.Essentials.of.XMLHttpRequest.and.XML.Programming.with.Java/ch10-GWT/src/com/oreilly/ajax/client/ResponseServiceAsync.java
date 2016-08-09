package com.oreilly.ajax.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ResponseServiceAsync {
  public void displayResponse(String s,
                              AsyncCallback callback);
}
