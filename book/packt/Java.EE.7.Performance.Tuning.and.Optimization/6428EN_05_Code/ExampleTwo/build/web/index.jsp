<!DOCTYPE html>
<%-- 
    Document   : index
    Author     : Osama Oransa
    Create For : Java Enterprise Edition 7 Performance Tuning (EN6428)
--%>
<html>
    <head>
        <title>Welcome in Our Product Catalog</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
        <div>Welcome in Our Product Catalog</div>
        <div>Click Continue to check the catalog</div>
        <form action="Browse">
            <button name="Continue" onclick="document.forms[0].submit();">Click to continue</button>
        </form>
    </body>
</html>
