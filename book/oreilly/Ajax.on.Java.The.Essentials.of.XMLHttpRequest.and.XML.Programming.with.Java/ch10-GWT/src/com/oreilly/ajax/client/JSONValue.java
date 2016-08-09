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


/**
 * The superclass for all JSON value types. 
 */
public abstract class JSONValue {
  /**
   * Returns non-null if this JSONValue is really a JSONObject.
   * 
   * @return a reference to a JSONObject if this JSONValue is a JSONObject or
   * null otherwise. 
   */
  public JSONObject isObject() {
    return null;
  }
  
  /**
   * Returns a non-null reference of this JSONValue is really a JSONArray.
   * 
   * @return a reference to a JSONArray if this JSONValue is a JSONArray or
   * null otherwise. 
   */
  public JSONArray isArray() {
    return null;
  }
  
  /**
   * Returns a non-null reference of this JSONValue is really a JSONString.
   * 
   * @return a reference to a JSONString if this JSONValue is a JSONString or
   * null otherwise. 
   */
  public JSONString isString() {
    return null;
  }
  
  /**
   * Returns a non-null reference of this JSONValue is really a JSONNumber.
   *  
   * @return a reference to a JSONNumber if this JSONValue is a JSONNumber or
   * null otherwise. 
   */
  public JSONNumber isNumber() {
    return null;
  }
  
  /**
   * Returns a non-null reference of this JSONValue is really a JSONBoolean.
   * 
   * @return a reference to a JSONBoolean if this JSONValue is a JSONBoolean or
   * null otherwise. 
   */
  public JSONBoolean isBoolean() {
    return null;
  }
  
  /**
   * This method returns a JSON encoded string for this entity.  Use this
   * method to create JSON strings that can be sent from the client to a server.
   */
  public abstract String toString();
}
