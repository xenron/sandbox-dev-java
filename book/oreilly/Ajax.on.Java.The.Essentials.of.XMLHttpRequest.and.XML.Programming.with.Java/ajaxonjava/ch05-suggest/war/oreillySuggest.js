var lookAheadArray = null;
var suggestionDiv = null;
var cursor;
var inputTextField;
var debugPane = null;
var urlbase = '/ch05-suggest'; 


function createDebugWindow()
{
   debugPane = document.createElement("div");
   debugPane.className = "debuginfo";
   debugPane.style.zIndex = "3";
   document.body.appendChild(debugPane);
}
function debugInfo(message) 
{
    debugPane.innerHTML += "\n"+message;  
    debugPane.style.backgroundImage = "url(transparent50.png)";
    debugPane.style.visibility = "visible";
}

function createDiv(){
    suggestionDiv = document.createElement("div");
    suggestionDiv.style.zIndex = "2";
    suggestionDiv.style.opacity ="0.8";
    suggestionDiv.style.repeat = "repeat";
    suggestionDiv.style.filter = "alpha(opacity=80)";
    suggestionDiv.className = "suggestions";
    suggestionDiv.style.visibility = "hidden";
    suggestionDiv.style.width = inputTextField.offsetWidth;
    suggestionDiv.style.backgroundColor = "white";
    suggestionDiv.style.autocomplete = "off";
    suggestionDiv.style.backgroundImage = "url(transparent50.png)";
    //when the user clicks on the a suggestion, get the text (innerHTML)
    //and place it into a inputTextField
    suggestionDiv.onmouseup = function() 
    {
        inputTextField.focus();
    }
    suggestionDiv.onmouseover = function(inputEvent) 
    {
        inputEvent = inputEvent || window.event;
        sugTarget = inputEvent.target || inputEvent.srcElement;
        highlightSuggestion(sugTarget);
    }
    suggestionDiv.onmousedown = function(inputEvent) 
    {
        inputEvent = inputEvent || window.event;
        sugTarget = inputEvent.target || inputEvent.srcElement;
        inputTextField.value = sugTarget.firstChild.nodeValue;
        lookupUsername(inputTextField.value);
        hideSuggestions();
        debugInfo("textforLookup"+sugTarget.firstChild.nodeValue);
    }
    document.body.appendChild(suggestionDiv);
}

function keyDownHandler(inEvent ){

    switch(inEvent.keyCode) {
        /* up arrow */
        case 38: 
            if (suggestionDiv.childNodes.length > 0 && cursor > 0) 
            {
                var highlightNode = suggestionDiv.childNodes[--cursor];
                highlightSuggestion(highlightNode);
                   inputTextField.value = highlightNode.firstChild.nodeValue;   
            }
        break;
        /* Down arrow */
        case 40: 
             if (suggestionDiv.childNodes.length > 0 && cursor < suggestionDiv.childNodes.length-1) 
             {
                 var newNode = suggestionDiv.childNodes[++cursor];
                highlightSuggestion(newNode);
                inputTextField.value = newNode.firstChild.nodeValue; 
             }
        break;
        /* Enter key = 13 */
        case 13: 
        var lookupName = inputTextField.value;
        hideSuggestions();
        lookupUsername(lookupName);
        break;
    }
}

function keyUpHandler(inEvent) {

    var potentials = new Array();
    var enteredText = inputTextField.value;
    var iKeyCode = inEvent.keyCode;
       
    if (iKeyCode == 32 || iKeyCode == 8 || ( 45 < iKeyCode && iKeyCode < 112) || iKeyCode > 123) /*keys to consider*/
    {
        if (enteredText.length > 0){
            for (var i=0; i < lookAheadArray.length; i++) { 
                if (lookAheadArray[i].indexOf(enteredText) == 0) 
                {
                    potentials.push(lookAheadArray[i]);
            
                } 
            }
            debugInfo('enteredd' + potentials);
                showSuggestions(potentials);
        }
        if (potentials.length > 0) 
        {
            if (iKeyCode != 46 && iKeyCode != 8) 
            {
                typeAhead(potentials[0]);
            }
            showSuggestions(potentials);
        } 
        else 
        {
            hideSuggestions();
           }
    }
}

function hideSuggestions () 
{
    suggestionDiv.style.visibility = "hidden";
}

function highlightSuggestion(suggestionNode) 
{
    for (var i=0; i < suggestionDiv.childNodes.length; i++) 
    {
        var sNode = suggestionDiv.childNodes[i];
        if (sNode == suggestionNode) 
        {
            sNode.className = "current"
        } 
        else if (sNode.className == "current") 
        {
            sNode.className = "";
        }
    }
}

function init (field) 
{
   alert('init:'+field);
   inputTextField = document.getElementById(field);
   cursor = -1;
    createDebugWindow();
    fillArrayWithAllUsernames();
    inputTextField.onkeyup = function (inEvent) 
    {
    
        if (!inEvent) 
        {
            inEvent = window.event;
        }    
        keyUpHandler(inEvent);
    }
    
    inputTextField.onkeydown = function (inEvent) 
    {
        if (!inEvent) 
        {
            inEvent = window.event;
        }    
        keyDownHandler(inEvent);
    }
    inputTextField.onblur = function () 
    {
        hideSuggestions();
    }

    createDiv();
}

function selectRange(start , end ) 
{
    if (inputTextField.createTextRange) {
        var sRange = inputTextField.createTextRange(); 
        sRange.moveStart("character", start); 
        sRange.moveEnd("character", end - inputTextField.value.length);      
        sRange.select();
    } else if (inputTextField.setSelectionRange) {
        inputTextField.setSelectionRange(start, end);
    }     
    inputTextField.focus();      
} 

function showSuggestions(suggestions) 
{
    var sDiv = null;
    suggestionDiv.innerHTML = "";  
    
    for (i=0; i < suggestions.length; i++) 
    {
        sDiv = document.createElement("div");
        sDiv.appendChild(document.createTextNode(suggestions[i]));
        suggestionDiv.appendChild(sDiv);
    }
    
    suggestionDiv.style.top = (inputTextField.offsetTop+inputTextField.offsetHeight) + "px";
    suggestionDiv.style.left = inputTextField.offsetLeft + "px";
    suggestionDiv.style.visibility = "visible";
}


function typeAhead(suggestion) 
{
    if (inputTextField.createTextRange || inputTextField.setSelectionRange)
    {
        var iLen = inputTextField.value.length; 
        inputTextField.value = suggestion; 
        selectRange(iLen, suggestion.length);
    }
}

function fillArrayWithAllUsernames()
{ 
    var url = urlbase+"/lookup?username=*"+"&type="+ escape("3"); 
    alert('url submitting:'+url);
    if (window.XMLHttpRequest)
    { 
        req = new XMLHttpRequest(); 
    } 
       else if (window.ActiveXObject)
    { 
        req = new ActiveXObject("Microsoft.XMLHTTP"); 
    } 
    req.open("Get",url,true); 
    req.onreadystatechange =  callbackFillUsernames;
    req.send(null);
} 
    
    
function callbackFillUsernames()
{ 
    if (req.readyState==4)
    { 
       if (req.status == 200)
        { 
               debugInfo('calledback');
            populateUsernames();
        } 
       } 
} 
   
function populateUsernames()
{
    var nameString = req.responseText;
    debugInfo('name array'+nameString);
    var nameArray = nameString.split(',');

    lookAheadArray = nameArray;
}
 
      /*
      * lookupUsername gets the customer information from the database
      */
      function lookupUsername(foundname){ 
      
      debugInfo('looking up :'+foundname);
        var username = document.getElementById("ajax_username");
        var url = urlbase+"/lookup?username=" + escape(foundname)+"&type="+ escape("2"); 
      alert('url submitting:'+url);
        if (window.XMLHttpRequest){ 
             req = new XMLHttpRequest(); 
         } 
         else if (window.ActiveXObject){ 
             req = new ActiveXObject("Microsoft.XMLHTTP"); 
        } 
        req.open("Get",url,true); 
        req.onreadystatechange = callbackLookupUser; 
        req.send(null);
    }     
    
    function callbackLookupUser(){ 
        if (req.readyState==4){ 
            if (req.status == 200){ 
                debugInfo('hit populate info');
                populateCustomerInfo();
            } 
        } 
    }
        /*
     * populateCustomerInfo puts the data from the database into the form fields.
     */
    function populateCustomerInfo(){  
        var jsonData = req.responseText;
        debugInfo("jsonData"+jsonData);
        
        var myJSONObject = eval('(' + jsonData + ')');
        
        var password = document.getElementById('password');
        password.value=myJSONObject.customer.PASSWORD;
       
        var email = document.getElementById('email');
        email.value=myJSONObject.customer.EMAIL;
       
        var name = document.getElementById('name');
        name.value=myJSONObject.customer.NAME;
       
        var address = document.getElementById('address');
        address.value=myJSONObject.customer.ADDRESS;
       
        var zip = document.getElementById('zipcode');
        zip.value=myJSONObject.customer.ZIPCODE;
       
        var city = document.getElementById('city');
        city.value=myJSONObject.customer.CITY;
        
        var state = document.getElementById('state');
        state.value=myJSONObject.customer.STATE;
    }
     
    function callbackUsername(){ 
        if (req.readyState==4){ 
            if (req.status == 200){ 
                usernameCheck();
            } 
        } 
        clear(); 
    } 
 