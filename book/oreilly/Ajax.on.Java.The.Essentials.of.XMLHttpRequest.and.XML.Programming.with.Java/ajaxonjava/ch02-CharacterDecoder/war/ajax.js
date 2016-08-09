  var req; 
  
  function convertToDecimal(){ 
    var key = document.getElementById("key"); 
    var keypressed = document.getElementById("keypressed"); 
    keypressed.value = key.value; 
    var url = "/ajaxdecimalcodeconverter/response?key=" + escape(key.value); 
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

  function callback(){ 
    if (req.readyState==4){ 
      if (req.status == 200){ 
        var decimal = document.getElementById('decimal'); 
        decimal.value = req.responseText; 
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