<%-- 

    Document   : login
    Created on : 4-lug-2018, 15.51.29
    Author     : CRIRI

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Login sistema</title>
        <%@include file="WEB-INF/template/header.jspf" %>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script> 
        <style>
            body{
                background-image: url('images/hue.jpg'); 
                background-repeat: no-repeat; 
                background-size:100% 100%;
            }
        </style>
    </head>
    <body onload="retro()" >
        <div id="loader-wrapper">
            <div id="loader"></div>
            <div class="loader-section section-left"></div>
            <div class="loader-section section-right"></div>
        </div>
        <div class="mn-content valign-wrapper">
            <main class="mn-inner container">
                <div class="valign">
                    <div class="row">
                        <div class="col s12 l4 offset-l4 offset-m3">
                            <div class="col s12 offset-6">
                                <div class="card white darken-1">
                                    <div class="card-content ">
                                        <img class="responsive-img" src="images/quebin.png">
                                        <div class="row">
                                            <form method="post" action="main">
                                                <div class="input-field col s12">                                                   
                                                    <input id="user" type="text" name="user">
                                                    <input type="hidden" value="1" name="op">
                                                    <label for="username">                                                                                                                 
                                                        Usuario</label>
                                                </div>
                                                <div class="input-field col s12">
                                                    <input id="pass" type="password" name="pass">
                                                    <label for="password">Contraseña</label>
                                                </div>
                                                <div class="row">
                                                    <div class="input-field col s12">
                                                        <input class="btn waves-effect waves-light s12 btn-large" id="btnIngresar" value="Iniciar Sesión">
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </main>
        </div>                
        <%@include file="WEB-INF/template/footerMain2.jspf" %>
        <script src="js/logeo.js"></script>
    </body>
</html>
