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

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents an array of JSONValue objects.
 */
public class JSONArray extends JSONValue {
  private ArrayList values = new ArrayList();
  
  public JSONArray isArray() {
    return this;
  }
  
  /**
   * Add an item to the end of the list
   * 
   * @param value
   */
  public void add(JSONValue value) {
    values.add(value);
  }
  
  /**
   * Add an item at the specified position within the array.
   */
  public void add(int index, JSONValue element) {
    values.add(index, element);
  }
  
  /**
   * throws java array index out of bounds
   * @param index
   * @return
   */
  public JSONValue get(int index) {
    return (JSONValue) values.get(index);
  }

  /**
   * Replaces the JSONValue object at the specified instance
   *
   * @param index
   * @param value
   * @return returns the previous value at the specified index
   */
  public JSONValue set(int index, JSONValue element) {
    return (JSONValue) values.set(index, element);
  }
  
  /**
   * Returns the number of elements in this array.
   * 
   * @return size of this array
   */
  public int size() {
    return values.size();
  }

  /**
   * Create the JSON encoded string representation of this JSONArray instance.
   */
  public String toString() {
    StringBuffer sb = new StringBuffer();
    Iterator iter = values.iterator();
    
    sb.append("[");
    while (iter.hasNext()) {      
      JSONValue value = (JSONValue) iter.next();
      sb.append(value.toString());
      
      if (iter.hasNext()) {
        sb.append(",");
      }
    }
    sb.append("]");
    
    return sb.toString();
  }
}
