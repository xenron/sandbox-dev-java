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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

/**
 * Class that models a JSON object.
 */
public class JSONObject extends JSONValue {
  /*
   * Name/Value pairs are stored in this member.
   */
  private HashMap valueMap = new HashMap();

  public JSONObject() {
  }


  public JSONObject isObject() {
    return this;
  }

  /**
   * Returns true if this JSONObject contains the requested named key.
   * 
   * @param key - named value to look for
   * @return true if the JSONObject contains the key
   */
  public boolean containsKey(String key) {
    return valueMap.containsKey(key);
  }

  /**
   * Return null if not found.
   * 
   * @param key
   * @return
   */
  public JSONValue get(String key) {
    return (JSONValue) valueMap.get(key);
  }

  /**
   * Adds the named key and value pair to this JSONObject. If there was already
   * a value associated with that key, then the previous value is returned.
   * 
   * @param key
   * @return the previous value associated with the key
   */
  public JSONValue put(String key, JSONValue jsonValue) {
    return (JSONValue) valueMap.put(key, jsonValue);
  }

  /**
   * Returns keys for which this JSONObject has associations.
   * 
   * @return array of keys for which there is a value
   */
  public String[] getKeys() {
    Set keySet = valueMap.keySet();
    String[] keys = new String[keySet.size()];
    Iterator iter = keySet.iterator();
    int i = 0;
    while (iter.hasNext()) {
      keys[i++] = (String) iter.next();
    }

    return keys;
  }

  /**
   * Converts a JSONObject into a JSON representation that can be used to
   * communicate with a JSON service.
   * 
   * @return a JSON string representation of this JSONObject instance
   */
  public String toString() {
    Set entrySet = valueMap.entrySet();
    Iterator iter = entrySet.iterator();

    StringBuffer sb = new StringBuffer();
    sb.append("{");
    while (iter.hasNext()) {
      Entry entry = (Entry) iter.next();
      sb.append("\"");
      sb.append(entry.getKey().toString());
      sb.append("\":");
      sb.append(entry.getValue().toString());

      if (iter.hasNext()) {
        sb.append(",");
      }
    }
    sb.append("}");
    return sb.toString();
  }
}
