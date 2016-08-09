package net.ensode.glassfishbook.customtags;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class LabeledTextField extends SimpleTagSupport
{
  private String label;
  private String value = "";
  private String name;

  @Override
  public void doTag() throws JspException, IOException
  {
    JspContext jspContext = getJspContext();
    JspWriter jspWriter = jspContext.getOut();

    jspWriter.print("<tr>");
    jspWriter.print("<td>");
    jspWriter.print("<b>");
    jspWriter.print(label);
    jspWriter.print("</b>");
    jspWriter.print("</td>");
    jspWriter.print("<td>");
    jspWriter.print("<input type=\"text\" name=\"");
    jspWriter.print(name);
    jspWriter.print("\" ");
    jspWriter.print("value=\"");
    jspWriter.print(value);
    jspWriter.print("\"");
    jspWriter.print("/>");
    jspWriter.print("</td>");
    jspWriter.println("</tr>");
  }

  public String getLabel()
  {
    return label;
  }

  public void setLabel(String label)
  {
    this.label = label;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getValue()
  {
    return value;
  }

  public void setValue(String value)
  {
    this.value = value;
  }
}
