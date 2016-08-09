package com.oreilly.ajax;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ZipCodePhaseListener implements PhaseListener
{
  public void afterPhase(PhaseEvent event)
  {
    String viewId = event.getFacesContext().getViewRoot().getViewId();
    if (viewId.indexOf("Ajax") != -1)
    {
      handleAjaxRequest(event);
    }
  }
  private void handleAjaxRequest(PhaseEvent event)
  {
    FacesContext context = event.getFacesContext();
    HttpServletResponse response = (HttpServletResponse) context
        .getExternalContext().getResponse();
    Object object = context.getExternalContext().getRequest();
    if (!(object instanceof HttpServletRequest))
    {
      //Only handle HttpServletRequests 
      return;
    }

    HttpServletRequest request = (HttpServletRequest) object;
    String zipcode = request.getParameter("zip");
    Location location = ZipcodeManager.getZipcode(zipcode);

    // actually render using XML.
    StringBuffer returnXML = null;
    returnXML = new StringBuffer("\r\n<location>");
    returnXML.append("\r\n<city>"+
                        location.getCity()+"</city>");
    returnXML.append("\r\n<state>"+
                        location.getState()+"</state>");
    returnXML.append("\r\n</location>");
    
    response.setContentType("text/xml");
    response.setHeader("Cache-Control", "no-cache");
    try
    {
      response.getWriter().write(returnXML.toString());
      event.getFacesContext().responseComplete();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  public void beforePhase(PhaseEvent arg0)
  {
    //not used, but implemented to satisfy compiler
  }
  public PhaseId getPhaseId()
  {
    return PhaseId.RESTORE_VIEW;
  }
}
