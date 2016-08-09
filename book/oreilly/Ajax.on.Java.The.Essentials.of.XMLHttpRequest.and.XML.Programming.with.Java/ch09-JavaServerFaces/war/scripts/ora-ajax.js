
var debugPane = null;
function retrieveCityState() {
    var zip = document.getElementById("zipcodeId");   
    // the url in this case must be .faces to be detected.
    var url = "ZipCode-Ajax.faces?zip=" + escape(zip.value);
    if (window.XMLHttpRequest) {
        req = new XMLHttpRequest();
    } else {
        if (window.ActiveXObject) {
            req = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    req.open("Get", url, true);
    req.onreadystatechange = callbackCityState;
    req.send(null);
}
function getAjaxURL() {
    return (window.document.forms[0].action);
}
function populateCityState() {
    var jsonData = req.responseText;
    var myJSONObject = eval("(" + jsonData + ")");
    var city = document.getElementById("cityId");
    city.value = myJSONObject.location.city;
    var state = document.getElementById("stateId");
    state.value = myJSONObject.location.state;
}
function callbackCityState() {
    if (req.readyState == 4) {
        if (req.status == 200) {
            if (window.XMLHttpRequest) {
                nonMSPopulate();
            } else {
                if (window.ActiveXObject) {
                    alert("mspopulate");
                    msPopulate();
                }
            }
        }
    }
}
function createDebugWindow() {
    debugPane = document.createElement("div");
    debugPane.className = "debuginfo";
    debugPane.style.zIndex = "3";
    document.body.appendChild(debugPane);
}
function nonMSPopulate() {
    var resp = req.responseText;
    var parser = new DOMParser();
    var dom = parser.parseFromString(resp, "text/xml");
    cityValue = dom.getElementsByTagName("city");
    var city = document.getElementById("cityId");
    city.value = cityValue[0].childNodes[0].nodeValue;
    stateValue = dom.getElementsByTagName("state");
    var state = document.getElementById("stateId");
    state.value = stateValue[0].childNodes[0].nodeValue;
}
function msPopulate() {
    var resp = req.responseText;
    var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
    xmlDoc.async = "false";
    xmlDoc.loadXML(resp);
    cityValue = xmlDoc.getElementsByTagName("city");
    var cityField = document.getElementById("cityId");
    cityField.value = cityValue[0].firstChild.data;
    stateValue = xmlDoc.getElementsByTagName("state");
    alert("state" + stateValue);
    var state = document.getElementById("stateId");
    state.value = stateValue[0].firstChild.data;
}

