/*
 * Copyright 2006 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.oreilly.ajax.client;

import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This class converts a JSON object encoded as a string into the 
 * corresponding set of JSONValue derived objects.  Internally,
 * this class uses JSNI to interact with JavaScript directly.
 */
public class JSONParser {
  
  /*
   * This method converts the json string into a JavaScriptObject inside of 
   * JSNI method by simply evaluating the string in JavaScript.
   */
  private static native JavaScriptObject evaluate(String jsonString) /*-{
    return eval('(' + jsonString + ')');
  }-*/;
 
  /**
   * Given a jsonString return the JSONObject representation.  This method
   * will throw a JSONException if the string is invalid.
   *  
   * @param jsonString
   * @return a JSONObject that has been built by parsing the JSON string.
   */
  public static JSONObject parse(String jsonString) throws JSONException {
    // Create a JavaScriptObject from the JSON string
    //
    try {
      JavaScriptObject jsonObject = evaluate(jsonString);
    
      return buildObject(jsonObject);
      
    } catch (JavaScriptException ex) { 
      throw new JSONException(ex);
      
    }
  }
  
  /*
   * Given a JavaScript object that could be an Object or a primitive JavaScript
   * type, create the correct subtype of JSONValue and return it.
   */
  private static native JSONValue buildValue(JavaScriptObject jsValue) /*-{
    if (jsValue instanceof Array) {
      // This is a JSONArray
      //
      var jsonArray = @com.oreilly.ajax.client.JSONParser::buildArray()();
      for (var index in jsValue) {
        var newJSONValue = @com.oreilly.ajax.client.JSONParser::buildValue(Lcom/google/gwt/core/client/JavaScriptObject;)(Object(jsValue[index]));
        jsonArray.@com.oreilly.ajax.client.JSONArray::add(ILcom/oreilly/ajax/client/JSONValue;)(index, newJSONValue);
      }
      return jsonArray;
      
    } else if (jsValue instanceof Boolean) {
      // This is a JSONBoolean
      //
      return @com.oreilly.ajax.client.JSONParser::buildBoolean(Z)(jsValue.valueOf());
      
    } else if (jsValue instanceof String) {
      // This is a JSONString
      //
      return @com.oreilly.ajax.client.JSONParser::buildString(Ljava/lang/String;)(jsValue.toString());
      
    } else if (jsValue instanceof Number) {
      // This is a JSONNumber
      //
      return @com.oreilly.ajax.client.JSONParser::buildNumber(Ljava/lang/String;)(jsValue.toString());
      
    } else  if (jsValue instanceof Object) {
      // This is a JSONObject
      return @com.oreilly.ajax.client.JSONParser::buildObject(Lcom/google/gwt/core/client/JavaScriptObject;)(jsValue);
      
    } else {
      // We do not know what this is so throw an exception
      //
      @com.oreilly.ajax.client.JSONParser::raiseJSONException()();
    }
  }-*/;
  
  /*
   * Given a JavaScriptObject build the corresponding JSONObject representation.  
   * Note it is assumed that the JavaScriptObject is a proper JSON object.   
   */
  private static native JSONObject buildObject(JavaScriptObject jsObject) /*-{
    
    // Create the JSONObject 
    //
    var object = @com.oreilly.ajax.client.JSONParser::createJSONObject()();
    
    // Enumerate all of the key,value pairs in the object and build the 
    // corresponding JSONValue
    // 
    for (var key in jsObject) {
    
      var jsValue = jsObject[key];
      
      // Create the JSONValue associated with the name
      // 
      var javaValue = @com.oreilly.ajax.client.JSONParser::buildValue(Lcom/google/gwt/core/client/JavaScriptObject;)(Object(jsValue));
      
      // Add the name of the value and JSONValue representation to the current JSONObject
      object.@com.oreilly.ajax.client.JSONObject::put(Ljava/lang/String;Lcom/oreilly/ajax/client/JSONValue;)(key, javaValue);
    }
    
    return object;
  }-*/;

  private static JSONArray buildArray() {
    JSONArray array = new JSONArray();
    return array;
  }
  
  private static JSONBoolean buildBoolean(boolean value) {
    return new JSONBoolean(value);
  }
  
  private static JSONNumber buildNumber(String value) {
    return new JSONNumber(value);
  }
  
  private static JSONString buildString(String value) {
    return new JSONString(value);
  }
  
  private static JSONObject createJSONObject() {
    return new JSONObject();
  }
  
  private static void raiseJSONException() throws JSONException {
    throw new JSONException();
  }
  
  public static String toString(JSONValue value) {
    return value.toString();
  }  
}