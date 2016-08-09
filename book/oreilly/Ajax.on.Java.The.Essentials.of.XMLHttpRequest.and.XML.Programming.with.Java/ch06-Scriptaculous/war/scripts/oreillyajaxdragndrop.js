//Copyright (c) 2006 O'Reilly Media
//Copyright (c) 2005 Thomas Fuchs (http://script.aculo.us, http://mir.aculo.us)
 
  var shoppingCartDiv = null;
  var productsdiv = null;
  var loginmessageDiv = null;
  var loginDiv = null;
  var buttonsDiv = null;
  var signupDiv =null;
  
  var username_global = null;
  function init(){
    loginDiv = document.getElementById("loginDivId");
    signupDiv = document.getElementById("signupDivId");
    signupDiv.style.visibility ="hidden";
    shoppingCartDiv = document.getElementById("cart");
    loginmessageDiv = document.getElementById("loginmessage");
    shoppingCartDiv.style.visibility="hidden";
    productsdiv = document.getElementById("products");
    productsdiv.style.visibility="hidden";
    buttonsDiv = document.getElementById("buttonsDiv");
    buttonsDiv.style.visibility="hidden";
  }
  function signup(){
    loginDiv.style.visibility="hidden";
    signupDiv.style.visibility="visible";
  }
  window.onload = function () {
    init();
    obj = document.getElementById("username");
    obj.focus();
    loginDiv.onkeydown = function (inEvent) 
    {
        if (!inEvent) 
        {
            inEvent = window.event;
        }    
        keyDownHandler(inEvent);
    }      
   
  }

    function keyDownHandler(inEvent ){

    switch(inEvent.keyCode) {
     
        /* Enter key = 13 */
        case 13: 
        login();
        break;
    }
}

function emptyShoppingCart(){
        parameterString = "function=2";
        new Ajax.Request("emptycart", {
                asynchronous: true,
                method: "get",
                parameters: parameterString,
                onSuccess: function(request) {
                updateCart(request);
                },
                onFailure: function(request) {
                    alert('failed to delete cart');
                }
        });
    }

    function getProductList(){
        new Ajax.Request("products", {
                asynchronous: true,
                method: "get",
                onSuccess: function(request) {
                updateProductList(request);
                },
                onFailure: function(request) {
                    alert('failed to get product list');
                }
        });
    
    }
    function addToCart(item){
        parameterString = "item="+item;
        
        new Ajax.Request("shoppingcart", {
                asynchronous: true,
                method: "get",
                parameters: parameterString,
                onSuccess: function(request) {
                updateCart(request);
                },
                onFailure: function(request) {
                    alert('failed to add item to cart');
                }
        });
    }
  function login(){
                var username = document.getElementById("username");
                var password = document.getElementById('password');
                
                parameterString = "username="+username.value+"&password="+password.value;
                new Ajax.Request("login", {
                asynchronous: true,
                method: "get",
                parameters: parameterString,
                onSuccess: function(request) {

                    var result = request.responseText;
                    if(result != "fail"){
                        username_global = username.value;
                        loginmessageDiv.style.visibility = "visible";
                        productsdiv.style.visibility = "visible";
                        shoppingCartDiv.style.visibility = "visible";
                        document.getElementById("loginDivId").innerHTML="logged in as: "+username_global; 
                        buttonsDiv.style.visibility = "visible";
                        getProductList();
                        signupDiv.innerHTML="";
                        signupDiv.innerText="";
                        updateCart(request);
                    }       
                    else
                        alert("invalid login: "+username.value + " is not a valid username or the password is invalid");
                },
                onFailure: function(request) {
                    alert('failed to login. Ajax.Request failed.');
                }
        });
    }
    
function updateCart(req){
  var jsonData = req.responseText;
  var myJSONObject = eval('(' + jsonData + ')');
  var cartdiv = document.getElementById("cart");
  // clear cart
  var output="<p> Your shopping cart: (drag products here) </p>";
  for(i=0;i<myJSONObject.cartcontents.length-1;i++)
  {
    output+='<div><img src="images/'+myJSONObject.cartcontents[i].filename+ '"> ' 
        +myJSONObject.cartcontents[i].description+'('+myJSONObject.cartcontents[i].value+') $'+myJSONObject.cartcontents[i].price+'ea. <CENTER> total: $'+myJSONObject.cartcontents[i].total+'</CENTER></div><br />';
  }
  output+='<div height:32px; style="background-color:#FFFF99; margin-bottom:10px;"><CENTER> total: $'+myJSONObject.cartcontents[myJSONObject.cartcontents.length-1].total+'</CENTER></div><br />';
  cartdiv.innerHTML=output;
}
  
  function updateProductList(req){
   
        jsonData = req.responseText;
        var myJSONObject = eval('(' + jsonData + ')');
        // clear cart
        productsdiv.innerHTML="<p>Here are your products</p>";
        for(i=0;i<myJSONObject.products.length;i++)
        {
            productsdiv.innerHTML+='<img height="100px" alt='+myJSONObject.products[i].description+
            ' class="products" id="'+myJSONObject.products[i].name+'" name="'+
            myJSONObject.products[i].name+'" src="images/'+
            myJSONObject.products[i].filename+'"/>';
        }
        //I should be able to put the draggable in the above loop, however, that doesn't work so I had to do this in a separate loop. Strange, but true.
        for (i=0;i<myJSONObject.products.length;i++)
        {
            new Draggable(myJSONObject.products[i].name, {revert:true});
        }
        Droppables.add('cart',  {
                       onDrop:function(element){
                             addToCart(element.id);
                       }
             });
  }
  function retrieveCityState(zip){
        parameterString = "zip=" + escape(zip);
        
        new Ajax.Request("zipcodes", {
                asynchronous: true,
                method: "get",
                parameters: parameterString,
                onSuccess: function(request) {
                fillCityAndState(request);
                },
                onFailure: function(request) {
                    alert('failed to get zipcode');
                }
        });
    }
        
    function usernameCheck(req){
        // we only want a boolean back. So no parsing is necessary
         userExists = req.responseText; 
         var username = document.getElementById("ajax_username"); 
         if (userExists == "true"){
            alert("Choose another username, "+username.value+" exists already");
            username.value="";
            username.focus();
         }
    }
function validateUsername(username){
        parameterString = "username=" + escape(username);
        
        new Ajax.Request("username", {
                asynchronous: true,
                method: "get",
                parameters: parameterString,
                onSuccess: function(request) {
                usernameCheck(request);
                },
                onFailure: function(request) {
                    alert('failed to get lookup username');
                }
        });
    }
    function fillCityAndState(data){
        var jsonData = data.responseText;

        var myJSONObject = eval('(' + jsonData + ')');
     
        var city = document.getElementById('city').value=myJSONObject.location.city;
        var city = document.getElementById('state').value=myJSONObject.location.state;
    }
    
    function addUser(){
        var ajaxUsername = document.getElementById("ajax_username");
        var password = document.getElementById("confirmpassword");
        var ajax_password = document.getElementById("ajax_password");
        if(ajax_password.value != password.value)
        {
            alert("passwords don't match: "+password.value+" != "+ajax_password.value);
            return;
        }
        var firstName = document.getElementById("firstname");
        var lastName = document.getElementById("lastname");
        var email = document.getElementById("email");
        var address = document.getElementById("address");
        var city = document.getElementById("city");
        var state = document.getElementById("state");
        if(state.length > 2)
        {
            alert("State can only have 2 characters: "+state+" has more than 2 characters");
            return;
        }
        var zipcode = document.getElementById("zipcode");
        alert("username="+ajaxUsername.value+" password:"+password.value);
        parameterString = "username=" + escape(ajaxUsername.value)+
                          "&password=" +escape(ajax_password.value)+
                          "&firstname=" +escape(firstName.value)+
                          "&lastname=" +escape(lastName.value)+
                          "&email="+escape(email.value)+
                          "&address="+escape(address.value)+
                          "&city="+escape(city.value)+
                          "&state="+escape(state.value)+
                          "&zipcode="+escape(zipcode.value);
                          
           new Ajax.Request("signup", {
                asynchronous: true,
                method: "get",
                parameters: parameterString,
                onSuccess: function(request) {
                alert('signup successful, welcome '+ajaxUsername.value+", please login");
                
                window.location.reload( false );
                
                },
                onFailure: function(request) {
                    alert('failed to signup username');
                }
        });
    }