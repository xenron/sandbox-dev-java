<script>    
function retrieveCityState()
{
    var zip = document.getElementById('zipcodeId');   
    var url = 'urlName?zip=' + escape(zip.value);   
    if (window.XMLHttpRequest)
    {
        req = new XMLHttpRequest();
    }
    else if (window.ActiveXObject)
    {
      req = new ActiveXObject('Microsoft.XMLHTTP');
    }         
    req.open('Get',url,true);
    req.onreadystatechange = callbackCityState;    
    req.send(null);    
}
function populateCityState()
{   
  var jsonData = req.responseText; 
  var myJSONObject = eval('(' + jsonData + ')'); 
  var city = document.getElementById('cityId');   
  city.value=myJSONObject.location.city;   
  var state = document.getElementById('stateId');   
  state.value=myJSONObject.location.state;
}
function callbackCityState()
{    
  if (req.readyState==4)
  {        
    if (req.status == 200)
    {            
      populateCityState();       
    }   
  }
}
</script> 
