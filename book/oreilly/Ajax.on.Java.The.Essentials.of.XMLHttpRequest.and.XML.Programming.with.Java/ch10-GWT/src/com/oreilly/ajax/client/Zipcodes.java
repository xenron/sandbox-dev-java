package com.oreilly.ajax.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.FocusListener;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Zipcodes implements EntryPoint
{
  private Label zipCodeLabel = new Label();
  private TextBox zipCodeBox = new TextBox();
  private Label stateLabel = new Label("State:");
  private TextBox stateTextBox = new TextBox();
  private Label cityLabel = new Label("City:");
  private TextBox cityTextBox = new TextBox();
  private Grid grid = new Grid(3, 2);

  /**
   * This is the entry point method.
   */
  public void onModuleLoad()
  {

    zipCodeLabel.setText("Zip Code:");
    zipCodeBox.setVisibleLength(5);
    zipCodeBox.setMaxLength(5);

    stateTextBox.setVisibleLength(2);
    stateTextBox.setMaxLength(2);
    cityTextBox.setMaxLength(40);
    cityTextBox.setVisibleLength(40);

    grid.setWidget(0, 0, zipCodeLabel);
    grid.setWidget(0, 1, zipCodeBox);
    grid.setWidget(1, 0, cityLabel);
    grid.setWidget(1, 1, cityTextBox);
    grid.setWidget(2, 0, stateLabel);
    grid.setWidget(2, 1, stateTextBox);

    zipCodeBox.addFocusListener(new FocusListener()
    {
      public void onFocus(Widget sender)
      {
      }

      public void onLostFocus(Widget sender)
      {
        ResponseServiceAsync respService = (ResponseServiceAsync) GWT
            .create(com.oreilly.ajax.client.ResponseService.class);
        ServiceDefTarget endpoint = (ServiceDefTarget) respService;

        endpoint.setServiceEntryPoint("/responseService");


        displayFormattedMessage("getting data...", "blue");
        AsyncCallback callback = new AsyncCallback()
        {
          public void onSuccess(Object result)
          {

            JSONObject jsonObject;
            try
            {
              displayFormattedMessage("Parsing JSON data...", "blue");
              jsonObject = JSONParser.parse((String) result);
              String[] keys = jsonObject.getKeys();
              if (keys.length >= 2)
              {
                String city = jsonObject.get("city").toString();
                String state = jsonObject.get("state").toString();
                cityTextBox.setText(city);
                stateTextBox.setText(state);
                displayFormattedMessage("", "blue");
              }
              else
              {
                cityTextBox.setText("");
                stateTextBox.setText("");
                displayFormattedMessage("This zip code was not found in the database.", "red");
              }

            } catch (JSONException e)
            {
              displayFormattedMessage("Error parsing JSON data \n"
                  + e.getMessage(), "red");
            }
          }

          public void onFailure(Throwable caught)
          {

            displayFormattedMessage(
                "Server request raised an error; Java exception : " + caught == null ? "An unknown exception"
                    : caught.getMessage(), "red");
          }
        };
        // Call the service method, validating the form
        // values first.
        try
        {
          displayFormattedMessage("getting request", "green");
          respService.displayResponse(zipCodeBox.getText(), callback);
        } catch (Exception e)
        {
          displayFormattedMessage("Server request raised an error: "
              + e.getMessage(), "red");
        } finally
        {
          displayFormattedMessage("", "green");
        }
      }
    });
    RootPanel.get("gridholder").add(grid);
  }

  private void displayFormattedMessage(String message, String color)
  {
    Element el = DOM.getElementById("status");
    if (el != null)
    {
      DOM.setStyleAttribute(el, "font-family", "ariel, san-serif");
      DOM.setStyleAttribute(el, "font-size", "1.2em");
      DOM.setStyleAttribute(el, "color", color);
      DOM.setInnerHTML(el, message);
    }
  }
}
