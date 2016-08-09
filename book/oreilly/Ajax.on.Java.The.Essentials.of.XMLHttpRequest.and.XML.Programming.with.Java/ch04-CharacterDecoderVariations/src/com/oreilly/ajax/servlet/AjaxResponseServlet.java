/*
 * Takes a character, converts it to hex, decimal, binary, octal and html. 
 * Then wraps each of the fields with XML and sends it back through the response.
 */
package com.oreilly.ajax.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;
import org.xml.sax.helpers.AttributesImpl;

public class AjaxResponseServlet extends HttpServlet
{

  private static final long serialVersionUID = 1L;

  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException
  {
    // key is the parameter passed in from the javascript
    // variable named url (see index.html)
    String key = req.getParameter("key");

    if (key != null)
    {

      // extract the first character from key
      // as an int, then convert that int to a String
      int keyInt = key.charAt(0);
      // setup the response
      res.setContentType("text/xml");
      res.setHeader("Cache-Control", "no-cache");
      // write out the xml string
      String outString = createSAXXML(keyInt);
      res.getWriter().write(outString);
    }
    else
    {
      // If key comes back as a null, return a question mark.
      res.setContentType("text/xml");
      res.setHeader("Cache-Control", "no-cache");
      res.getWriter().write("?");
    }
  }

  public String createStringBufferXML(int keyInt)
  {
    StringBuffer returnXML = null;
    returnXML = new StringBuffer("\r\n<converted-values>");
    returnXML.append("\r\n<decimal>" + Integer.toString(keyInt) + "</decimal>");
    returnXML.append("\r\n<hexadecimal>0x" + Integer.toString(keyInt, 16)
        + "</hexadecimal>");
    returnXML.append("\r\n<octal>0" + Integer.toString(keyInt, 8) + "</octal>");
    returnXML.append("\r\n<hyper>&amp;0x" + Integer.toString(keyInt, 16)
        + ";</hyper>");
    returnXML.append("\r\n<binary>" + Integer.toString(keyInt, 2)
        + "B</binary>");
    returnXML.append("\r\n</converted-values>");
    return returnXML.toString();
  }

  public String createJdomXML(int key) throws IOException
  {
    Document document = new Document();
    // create root node
    Element root = new org.jdom.Element("converted-values");
    document.setRootElement(root);

    // create your a node
    org.jdom.Element element = new org.jdom.Element("decimal");
    // add content to the node
    element.addContent(Integer.toString(key));
    // add your node to root
    root.addContent(element);

    element = new org.jdom.Element("hexadecimal");
    element.addContent("0x" + Integer.toString(key, 16));
    root.addContent(element);
    element = new org.jdom.Element("octal");
    element.addContent("0" + Integer.toString(key, 8));
    root.addContent(element);
    element = new org.jdom.Element("hyper");
    element.addContent("&0x" + Integer.toString(key, 16));
    root.addContent(element);
    element = new org.jdom.Element("binary");
    element.addContent(Integer.toString(key, 2) + "B");
    root.addContent(element);

    // output JDOM document as a String of bytes
    XMLOutputter outputter = new XMLOutputter();
    return outputter.outputString(document);
  }

  public String createECSXML(int key)
  {
    org.apache.ecs.xml.XMLDocument document = new org.apache.ecs.xml.XMLDocument()
        .addElement(new org.apache.ecs.xml.XML("converted-values"));

    String xml = document.toString();
    System.out.println(xml);

    return null;
  }

  public String createSAXXML(int key)
  {
    Writer writer = new StringWriter();
    // holder for the transformation result
    StreamResult streamResult = new StreamResult(writer);

    SAXTransformerFactory transformerFactory = (SAXTransformerFactory) SAXTransformerFactory
        .newInstance();
    try
    {
      String data = null;
      TransformerHandler transformerHandler = transformerFactory
          .newTransformerHandler();

//      Transformer serializer = transformerHandler.getTransformer();
//      // Document type declarations
//      serializer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "Public");
//      serializer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "System ");
      transformerHandler.setResult(streamResult);
      // Start the document
      transformerHandler.startDocument();
      // list all the attributes for element
      AttributesImpl attr = new AttributesImpl();
      // start writing elements, every start tag and end tag has to be defined
      // explicitly.
      transformerHandler.startElement(null,null, "converted-values",
          null);
      transformerHandler.startElement(null,null,"decimal",null);
      data = Integer.toString(key, 10);
      transformerHandler.characters(data.toCharArray(),0,data.length());
      
      transformerHandler.endElement(null,null,"decimal");
      
      transformerHandler.startElement(null,null,"hexadecimal",null);
      data = "0x" + Integer.toString(key, 16);
      transformerHandler.characters(data.toCharArray(),0,data.length());
      
      transformerHandler.endElement(null,null,"hexadecimal");
      transformerHandler.startElement(null,null,"octal",null);
      data = "0" + Integer.toString(key, 8);
      transformerHandler.characters(data.toCharArray(),0,data.length());
      
      transformerHandler.endElement(null,null,"octal");
      transformerHandler.startElement(null,null,"binary",null);
      data = Integer.toString(key, 2)+"B";
      transformerHandler.characters(data.toCharArray(),0,data.length());
      
      transformerHandler.endElement(null,null,"binary");
      transformerHandler.startElement(null,null,"hyper",null);
      data = "&0x" +Integer.toString(key, 16);
      transformerHandler.characters(data.toCharArray(),0,data.length());
      
      transformerHandler.endElement(null,null,"hyper");
      transformerHandler.endElement(null,null, "converted-values");
      transformerHandler.endDocument();

      transformerHandler.setResult(streamResult);


    } catch (Exception e)
    {
      return null;
    }
    return writer.toString();
  }

  public String createDom4jXML(int key) throws IOException
  {
    org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
    org.dom4j.Element root = document.addElement("converted-values");

    org.dom4j.Element element = root.addElement("decimal").addText(
        Integer.toString(key));
    element = root.addElement("hexadecimal").addText(
        "0x" + Integer.toString(key, 16));
    element = root.addElement("octal").addText("0" + Integer.toString(key, 8));
    element = root.addElement("hyper").addText(
        "&0x" + Integer.toString(key, 16));
    element = root.addElement("binary").addText(Integer.toString(key, 2) + "B");
    StringBuffer xmlDoc = null;

    StringWriter sw = new StringWriter();
    org.dom4j.io.XMLWriter writer = new org.dom4j.io.XMLWriter(sw);
    writer.write(document);
    writer.close();
    xmlDoc = sw.getBuffer();

    return xmlDoc.toString();
  }
}