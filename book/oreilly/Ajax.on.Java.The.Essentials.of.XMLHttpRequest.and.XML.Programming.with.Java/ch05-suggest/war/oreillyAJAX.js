    var req; 
    function retrieveCityState(){ 
        var zip = document.getElementById("zipcode");
        var url = "/ch05-suggest/zipcodes?zip=" + escape(zip.value); 
        name.value="?"+name.value;
        if (window.XMLHttpRequest){ 
             req = new XMLHttpRequest(); 
         } 
         else if (window.ActiveXObject){ 
             req = new ActiveXObject("Microsoft.XMLHTTP"); 
        } 
        req.open("Get",url,true); 
        req.onreadystatechange = callbackCityState; 
        req.send(null);
    } 
        
    function init(){
    	clearUsernames();
    }
  
    function validateUsername(){ 
        var username = document.getElementById("ajax_username");
        var url = "/ch05-suggest/username?username=" + escape(username.value); 
        if (window.XMLHttpRequest){ 
             req = new XMLHttpRequest(); 
         } 
         else if (window.ActiveXObject){ 
             req = new ActiveXObject("Microsoft.XMLHTTP"); 
        } 
        req.open("Get",url,true); 
        req.onreadystatechange = callbackUsername; 
        req.send(null);
    } 

    
    function usernameCheck(){
        // we only want a boolean back. So no parsing is necessary
         userExists = req.responseText; 
         var username = document.getElementById("ajax_username"); 
         if (userExists == "true"){
            alert("Choose another username, "+username.value+" exists already");
            username.value="";
            username.focus();
         }
    }

    
    function populateCityState(){
        var jsonData = req.responseText;
        var myJSONObject = eval('(' + jsonData + ')');
        var city = document.getElementById('city');
        city.value=myJSONObject.location.city;
        
        var state = document.getElementById('state');
        state.value=myJSONObject.location.state;
    }
    function callbackCityState(){ 
    
        if (req.readyState==4){ 
            if (req.status == 200){ 
                populateCityState();
                
            } 
        } 
    } 
     
    function callbackUsername(){ 
        if (req.readyState==4){ 
            if (req.status == 200){ 
                usernameCheck();
            } 
        } 
    } 
 