<%-- 
    Document   : prueba
    Created on : 30-jul-2018, 12:41:23
    Author     : Kevin Peinado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function retro() {
                alert("fghjkl");
                window.location.hash = "no-back-button";
                window.location.hash = "Again-No-back-button"; //chrome
                window.onhashchange = function () {
                    window.location.hash = "no-back-button";
                }
            }
        </script>
    </head>
    <body onload="retro()">
        <h1>Hello World!</h1>
    </body>
</html>
