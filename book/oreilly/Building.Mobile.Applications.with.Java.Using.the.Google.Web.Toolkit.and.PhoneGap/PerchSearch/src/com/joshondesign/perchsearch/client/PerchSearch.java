package com.joshondesign.perchsearch.client;

import com.joshondesign.perchsearch.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.*;

import com.google.gwt.jsonp.client.JsonpRequestBuilder;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.*;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.dom.client.Style.Unit;

public class PerchSearch implements EntryPoint {
    final TextBox queryField = new TextBox();
    final VerticalPanel resultsPanel = new VerticalPanel();

    /**
    * This is the entry point method.
    */
    public void onModuleLoad() {
        Label header = new Label("Perch Search");
        header.addStyleName("header");
        
        FlowPanel nav = new FlowPanel();
        nav.add(new Button("All"));
        nav.add(new Button("Puppies"));
        nav.add(new Button("Lol Cats"));
        nav.add(new Button("Clear"));
        nav.addStyleName("nav");
        
        VerticalPanel panel = new VerticalPanel();
        panel.addStyleName("content");
        queryField.setText("puppy");
        panel.add(queryField);
        
        final Button searchButton = new Button("Search Twitter");
        panel.add(searchButton);
        
        final Label errorLabel = new Label();
        panel.add(errorLabel);
        panel.add(resultsPanel);
        
        RootPanel.get("header_container").add(header);
        RootPanel.get("nav_container").add(nav);
        RootPanel.get("content_container").add(panel);
        
        searchButton.addClickHandler(new TwitterHandler());
    }
  
    class TwitterHandler implements ClickHandler {
        public void onClick(ClickEvent event) {
            String url = "http://search.twitter.com/search.json?q="+queryField.getText();
            JsonpRequestBuilder jsonp = new JsonpRequestBuilder();
            jsonp.requestObject(url, new AsyncCallback<JavaScriptObject>() {
                    public void onFailure(Throwable throwable) {
                        System.out.println("Error: " + throwable);
                    }
                    public void onSuccess(JavaScriptObject o) {
                        JSONObject js = new JSONObject(o);
                        JSONArray results = js.get("results").isArray();
                        resultsPanel.clear();
                        for(int i=0; i<results.size(); i++) {
                            String text = (results.get(i).isObject()).get("text").toString();
                            Label label = new Label(text);
                            label.addStyleName("tweet");
                            resultsPanel.add(label);
                        }
                    }
            });
        }
    };
  
    public static void p(String s) {
        System.out.println(s);
    }
}
