// 
//  Document   : ajax_call
//  Author     : Osama Oransa
//  Create For : Java Enterprise Edition 7 Performance Tuning (EN6428)
//
var xmlHttp = null ;
currentAction=0;
basketSize=0;
function addToBasket(id){
    currentAction=1;
    ajax_call("AddToBasket?id="+id);
}
function ajax_call(url){
    createXmlHttpRequest();
    xmlHttp.onreadystatechange = handleRequest;
    running=true;
    xmlHttp.open("POST",url,true);
    xmlHttp.send("<?XML version=\"1.0\" encoding=\"UTF-8\"?>");
}
function createXmlHttpRequest(){
    if(window.ActiveXObject){
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    else if(window.XMLHttpRequest){
        xmlHttp = new XMLHttpRequest();
    }
}

function handleRequest(){
    if(xmlHttp.readyState == 4){
     xmlvalue=xmlHttp.responseText;
     if(xmlvalue == null){
         xmlvalue = xmlHttp.responseXML;
     }
     //action 1 = add to basket
     if(currentAction==1){
        if(xmlvalue=='0'){
            alert('Stock is empty, sorry for that!'); 
        } else if(xmlvalue>=1){
            //
            basketSize=xmlvalue;
            document.getElementById("counter").innerHTML="("+basketSize+")";
        }else {
            alert('Cannot add to basket, try again later!');
        }
     }
   }
}



