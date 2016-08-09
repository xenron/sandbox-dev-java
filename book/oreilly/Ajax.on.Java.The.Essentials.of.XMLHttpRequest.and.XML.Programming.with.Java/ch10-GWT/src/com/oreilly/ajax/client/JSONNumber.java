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
 * Represents a JSON number as read from a JSON encoded string.  This class
 * models a number as a string and only converts to an actual representation
 * when asked.  
 */
public class JSONNumber extends JSONValue {
  private String value;
  
  public JSONNumber(String value) {
    this.value = value;
  }

  public JSONNumber isNumber() {
    return this;
  }
  
  public byte byteValue() {
    return Byte.parseByte(value);
  }
  
  public double doubleValue() {
    return Double.parseDouble(value);
  }
  public float floatValue() {
    return Float.parseFloat(value);
  }
  
  public int intValue() {
    return Integer.parseInt(value);
  }
  
  public long longValue() {
    return Long.parseLong(value);
  }
  
  public short shortValue() {
    return Short.parseShort(value);
  }

  public String toString() {
    return value;
  }
}
