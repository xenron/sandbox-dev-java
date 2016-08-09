package com.oreilly.ajax;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

/**
 * @author steveo
 * 
 */
public final class ZipCodeRenderer extends Renderer
{
  public boolean getRendersChildren()
  {
    return true;
  }

  public void encodeBegin(FacesContext context, UIComponent component)
      throws IOException
  {
    ResponseWriter writer = context.getResponseWriter();
    Map attributeMap = component.getAttributes();
    Object o = attributeMap.get("zipcodeId");
    writer.startElement("script", component);
    writer.writeAttribute("type", "text/javascript", null);
    // this should be an attribute. Just like cityId is.
    String src = "scripts/ora-ajax.js";
    writer.writeAttribute("src", src, null);

    writer.endElement("script");

    writer.startElement("div", component);
    writer.writeAttribute("id", "ajaxDivId", null);
    writer.endElement("div");
    writer.write("\n");
    writer.startElement("table", component);
    writer.startElement("tr", component);
    writer.startElement("td", component);
    writer.write("Zip Code: ");
    writer.endElement("td");
    writer.startElement("td", component);
    writer.startElement("input", component);
    writer.writeAttribute("onblur", "retrieveCityState();", null);
    writer.writeAttribute("type", "text", null);
    writer.writeAttribute("id", "zipcodeId", null);
    writer.endElement("td");
    writer.endElement("tr");

    writer.startElement("tr", component);
    writer.startElement("td", component);
    writer.write("City: ");
    writer.endElement("td");
    writer.startElement("td", component);
    writer.startElement("input", component);
    writer.writeAttribute("type", "text", null);
    writer.writeAttribute("id", "cityId", null);
    writer.endElement("td");
    writer.endElement("tr");

    writer.startElement("tr", component);
    writer.startElement("td", component);
    writer.write("State: ");
    writer.endElement("td");
    writer.startElement("td", component);
    writer.startElement("input", component);
    writer.writeAttribute("type", "text", null);
    writer.writeAttribute("id", "stateId", null);
    writer.endElement("td");
    writer.endElement("tr");
    writer.endElement("table");

    writer.write("\n");
  }

  public void encodeEnd(FacesContext context, UIComponent component)
  {

  }

}
