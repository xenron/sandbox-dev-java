  var req; 
  
  function convertToXML(){ 
    var key = document.getElementById("key"); 
    var keypressed = document.getElementById("keypressed"); 
    keypressed.value = key.value; 
    var url = "/ch04-ajaxcodeconverterJSON/response?key="+escape(key.value); 
    if (window.XMLHttpRequest){ 
      req = new XMLHttpRequest(); 
    } 
    else if (window.ActiveXObject){ 
      req = new ActiveXObject("Microsoft.XMLHTTP"); 
    } 
    req.open("Get",url,true); 
    req.onreadystatechange = callback; 
    req.send(null);
  } 

  function populateJSON(){
    var jsonData = req.responseText;

    var myJSONObject = eval('(' + jsonData + ')');

    var decimal = document.getElementById('decimal');

    decimal.value=myJSONObject.conversion.decimal;
    
    var hexadecimal = document.getElementById('hexadecimal');
    hexadecimal.value=myJSONObject.conversion.hexadecimal;
                  
    var octal = document.getElementById('octal');
    octal.value=myJSONObject.conversion.octal;
                  
    var binary = document.getElementById('binary');
    binary.value=myJSONObject.conversion.binary;
        
    var hyper = document.getElementById('hyper');
    hyper.value=myJSONObject.conversion.hyper;
  }
    
  
  function callback(){ 
    if (req.readyState==4){ 
      if (req.status == 200){ 
          populateJSON();
      } 
    } 
    clear(); 
  } 

  function clear(){ 
    var key = document.getElementById("key"); 
    key.value=""; 
  }
  function focusIn(){ 
    document.getElementById("key").focus();
  }