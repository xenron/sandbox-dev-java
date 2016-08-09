<%@ taglib prefix="ajax" uri="javawebparts/taglib/ajaxtags"%>
<html>
  <head>
    <title>
      Java Web Parts - Ajax On Java Demo
    </title>
  </head>
  <body>
   <H1> Java Web Parts Dynamic Select </H1>
    <br />
    Select a state and JavaWebParts will populate the cities into the second select box.
    <br />
    <form name="StateSelectForm">
      <br />
      <select name="stateSelected">
          <option value="" selected="selected">
            Select a State
          </option>
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
        <ajax:event ajaxRef="StateSelectForm/stateSelectionChange" />
    </form>

    Cities:
    <div id="cities">
      <select name="citySelected">
        <option>Select a state in the above select box.</option>
      </select>
    </div>
    <br />
    <ajax:enable />
  </body>
</html>

