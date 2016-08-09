<%@ page pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa" %>
<%
    ArrayList cityList = (ArrayList)session.getAttribute("cityList");
    ArrayList stateList = (ArrayList)session.getAttribute("stateList");
%>
<script src="aa.js"></script>
<script>ajaxAnywhere.formName = "main";</script>

<H1> Ajax Anywhere Demo </h1><br>
<div>
Click on a state. The City select box will display all of the cities in that state.<br /> Then click on one of the cities to see how many states have a city with the same name.
</div>
<br />

<table border = "1">
<tr>
<th width="30%">State</th>
<th width="30%">City</th>
<th width="30%">States with that city</th>
</tr>
<TR>
<td align="center" valign="top">
<form method="POST" ACTION="AjaxAnywhereSupport" name="main" >
    <select size="10" name="state" onchange="ajaxAnywhere.submitAJAX('function=state');">

          <option value="AL">
            Alabama
          </option>
          <option value="AK">
            Alaska
          </option>
          <option value="AZ">
            Arizona
          </option>
          <option value="AR">
            Arkansas
          </option>
          <option value="CA">
            California
          </option>
          <option value="CO">
            Colorado
          </option>
          <option value="CT">
            Connecticut
          </option>
          <option value="DE">
            Delaware
          </option>
          <option value="DC">
            District Of Columbia
          </option>
          <option value="FL">
            Florida
          </option>
          <option value="GA">
            Georgia
          </option>
          <option value="HI">
            Hawaii
          </option>
          <option value="ID">
            Idaho
          </option>
          <option value="IL">
            Illinois
          </option>
          <option value="IN">
            Indiana
          </option>
          <option value="IA">
            Iowa
          </option>
          <option value="KS">
            Kansas
          </option>
          <option value="KY">
            Kentucky
          </option>
          <option value="LA">
            Louisiana
          </option>
          <option value="ME">
            Maine
          </option>
          <option value="MD">
            Maryland
          </option>
          <option value="MA">
            Massachusetts
          </option>
          <option value="MI">
            Michigan
          </option>
          <option value="MN">
            Minnesota
          </option>
          <option value="MS">
            Mississippi
          </option>
          <option value="MO">
            Missouri
          </option>
          <option value="MT">
            Montana
          </option>
          <option value="NE">
            Nebraska
          </option>
          <option value="NV">
            Nevada
          </option>
          <option value="NH">
            New Hampshire
          </option>
          <option value="NJ">
            New Jersey
          </option>
          <option value="NM">
            New Mexico
          </option>
          <option value="NY">
            New York
          </option>
          <option value="NC">
            North Carolina
          </option>
          <option value="ND">
            North Dakota
          </option>
          <option value="OH">
            Ohio
          </option>
          <option value="OK">
            Oklahoma
          </option>
          <option value="OR">
            Oregon
          </option>
          <option value="PA">
            Pennsylvania
          </option>
          <option value="RI">
            Rhode Island
          </option>
          <option value="SC">
            South Carolina
          </option>
          <option value="SD">
            South Dakota
          </option>
          <option value="TN">
            Tennessee
          </option>
          <option value="TX">
            Texas
          </option>
          <option value="UT">
            Utah
          </option>
          <option value="VT">
            Vermont
          </option>
          <option value="VA">
            Virginia
          </option>
          <option value="WA">
            Washington
          </option>
          <option value="WV">
            West Virginia
          </option>
          <option value="WI">
            Wisconsin
          </option>
          <option value="WY">
            Wyoming
          </option>
    </select>
</td>
<td align="center" valign="top"> 
<aa:zone name="citiesList">
    <select size="10" name="city" onchange="ajaxAnywhere.submitAJAX('function=city')" >
       <%
        String cityName = "";
        StringBuffer sb = new StringBuffer();
        if(cityList != null)
        {
        Iterator it = cityList.iterator();
        
        while(it.hasNext())
        {
          cityName = (String)it.next();
          sb.append("<option value=\""+cityName+"\">"+cityName+"</option> \n");
        }
        out.println(sb.toString());
        }
        else
          out.println("<option></option>");
        %>
    </select>
</form>
</aa:zone>
</td><td  align="center" valign="top">
<aa:zone name="stateswcityList">
    <select size="10" name="statewcity" >
       <%
        String stateName = "";
        StringBuffer sb2 = new StringBuffer();
        if(stateList != null)
        {
          Iterator it = stateList.iterator();
        
          while(it.hasNext())
          {
            stateName = (String)it.next();
            sb2.append("<option value=\""+stateName+"\">"+stateName+"</option> \n");
          }
          out.println(sb2.toString());
        }
        else
          out.println("<option></option>");
        %>
    </select>
</aa:zone>
</td>
</tr>
</table>
</form>