<%-- 
    Document   : logeoUsu
    Created on : 12-sep-2018, 9:09:25
    Author     : Kevin Peinado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>logeo</title>
        <%@include file="WEB-INF/template/header.jspf" %>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script> 
        <style>
            body{
                /*background-image: url('images/hue.jpg');*/ 
                /*background-repeat: no-repeat; 
                background-size:100% 100%;*/
            }
        </style> 
    </head>
    <body>
        <!-- carga de pagina -->
        <div id="loader-wrapper">
            <div id="loader"></div>
            <div class="loader-section section-left"></div>
            <div class="loader-section section-right"></div>
        </div>
        <!-- fin carga de pagina -->
        <div class="mn-content valign-wrapper">
            <main class="mn-inner container">
                <div class="valign">
                    <div class="row">
                        <!-- rour -->
                        <div class="col s3"></div>
                        <div class="col s6">
                            <div class="card white darken-5">
                                <div class="card-content">
                                    <div class="row">
                                        <div class="col s12 center-align">
                                            <img class="responsive-img" src="images/loguito.png">
                                        </div>
                                        <div class="col s12 center-align">
                                            <h5>Iniciar sesión</h5>
                                        </div>
                                        <div class="col s12 center-align">
                                            <p>Ir a presup</p>
                                        </div>
                                    </div>
                                    <!--<img class="responsive-img" src="images/quebin.png">-->
                                    <div class="row">
                                        <div class="col m12">
                                            <div class="input-field col s12">                                                   
                                                <input id="user" type="text" name="user">
                                                <label for="username">Usuario</label>
                                            </div>
                                        </div>
                                        <div class="col m12">
                                            <div class="input-field col s12">                                                   
                                                <input id="passw" type="password" name="passw">
                                                <label for="passw">Contraseña</label>
                                            </div>
                                        </div>
                                        <div class="col m12 right-align">
                                            <button class="btn waves-light" style="background-color: #992d45" id="btnCont">Continuar
                                                <i class="material-icons right">send</i>
                                            </button>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col s3"></div>
                        <!-- fin rour -->
                    </div>
                </div>
        </div>
    </main>
</div>

<!-- importamos los componentes -->
<%@include file="WEB-INF/template/footerMain2.jspf" %>
<script src="js/logeo.js"></script>
</body>
</html>
