<%-- 
    Document   : registroProfesores
    Created on : 04-jul-2018, 22:35:43
    Author     : Kevin Peinado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
        <%@include file="WEB-INF/template/header.jspf" %>
    </head>
    <body>


        <%
            try {
                HttpSession sesion = request.getSession();
                if (sesion.getAttribute("idr") == null) {
                    response.sendRedirect("logeoUsu.jsp");

                } else {
                    String rol = sesion.getAttribute("idr").toString();
                    if (rol.equals("2")) {
        %><%@include file="WEB-INF/template/Principal.jspf"%><%
                            }

                            if (rol.equals("1")) {
        %><% response.sendRedirect("login.jsp");
                                     }
                                 }

                             } catch (Exception e) {
                                 System.out.println("Error: " + e);

                             }
        %>

        <!--INICIO Contenido -->
        <main class="mn-inner" >
            <nav class="teal lighten-2" style="margin-top: -20px;">
                <div class="nav-wrapper">
                    <div class="col s12">
                        <a href="RegistrarUsuario.jsp" class="breadcrumb">Registro de Trabajador</a>
                    </div>
                </div>
            </nav>
            <div class="col s12">

                <div class="action-btn-wrapper">
                    <div class="fixed-action-btn my-custom-btn vertical">
                        <a class="btn-floating btn-large red">
                            <i class="large material-icons">settings</i>
                        </a>
                        <ul>
                            <li><a class="btn-floating #f06292 green lighten-2 tooltipped" data-position="left" data-delay="50" data-tooltip="Lista de Trabajadores" href='tbTrabajador.jsp'><i class="material-icons">grid_on</i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            
            
            <!--Modal-->
            <div id="modalusu" class="col s12 l12 m12 modal modal-fixed-footer" style="max-width: 450px;">
                <div class="modal-content">
                    <div class="card-content">
                        <h5>Crear Usuario</h5>
                        <hr>
                        <div class="row">
                            <div class="center">
                                <div class="col s10 m10 l10 row center-align">
                                    <div class="input-field">
                                        <i class="material-icons prefix">person_pin</i>
                                        <input id="nomusu" type="text" class="validate tooltipped"  data-tooltip="Su usuario debe contener al menos 7 caracteres"><span id="evaluar"></span>
                                        <label for="nomusu">Nombre de Usuario</label>
                                    </div>
                                </div>
                                <div class="col s10 m10 l10 row center-align">
                                    <div class="input-field">
                                        <i class="material-icons prefix">lock_outline</i>
                                        <input type="password" name="password" id="pass1" class="validate tooltipped" data-tooltip="Su contraseña debe contener 6 caracteres o más"><span id="val2"></span>
                                         <label for="pass">Contraseña</label>
                                    </div>
                                </div>
                                <div class="col s10 m10 l10 row center-align">
                                    <div class="input-field">
                                        <i class="material-icons prefix">vpn_key</i>
                                        <input type="password" name="password" id="pass2" class="validate tooltipped" data-tooltip="Por favor vuelva a ingresar su contraseña"><span id="val"></span>
                                        <label for="pass">Confirmar Contraseña</label>
                                    </div>
                                </div>
                            </div>   
                            <div class="row ">
                                <div class="input-field col s10 m10 l10">
                                    <i class="material-icons prefix">portrait</i>
                                    <select id="secRol">
                                        <option value="0" disabled="disabled">ROL</option>
                                        <option value="1">ASISTENTE</option>
                                        <option value="2">ADMINSTRADOR</option>
                                    </select>
                                    <label>ROLES</label>
                                </div>
                            </div>
                        </div>
                        <button class="modal-action btn btn-primary teal right" type="submit" name="action" id="btnRegistrarUser">Registrar<i class="material-icons right">save</i></button>
                    </div>
                    
                </div>
                <div class="modal-footer">
                    <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Cerrar</a>
                </div>
            </div>
            <!--Fin del Modal-->
            
            
            <div class="row">
                <div class="col s12 m12 l12">
                    <div class="card" style="padding:20px;">
                        <div class="row">
                            <div class="row">
                                <div class="center col s12 m12 l12">
                                    <div class="input-field col s6 m6 l6">
                                        <i class="material-icons prefix">face</i>
                                        <label for="nombres">Nombres</label>
                                        <input id="nombres" type="text" class="validate">
                                    </div>
                                    <div class="input-field col s6 m6 l6">
                                        <i class="material-icons prefix">person_pin</i>
                                        <label for="apellidos">Apellidos</label>
                                        <input id="apellidos" type="text" class="validate">
                                    </div>

                                </div>
                                <div class=" center col s12 m12 l12">
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix">dialer_sip</i>
                                        <label for="celular">Numero de Celular</label>
                                        <input class="validate" type="text" name="celular" placeholder="#"  required maxlength="9" id="celular">
                                    </div>
                                    <div class="input-field col s6 m6 l6">
                                        <i class="material-icons prefix">assignment</i>

                                        <input type="text" name="dni" class="validate" required maxlength="8" id="dni" placeholder="#">
                                        <label for="dni">Ingrese Dni</label>

                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col s6 m6 l6">
                                    <div class="input-field">
                                        <i class="material-icons prefix">mail</i>
                                        <input type="email" name="email"  id="email" class="validate">
                                        <label for="email">Email</label>

                                    </div>
                                </div>
                                <div class="col s6 m6 l6">
                                    <div class="input-field">
                                        <i class="material-icons prefix">location_city</i>                                           
                                        <input class="validate" type="text" name="direccion" required id="direccion" placeholder="">
                                        <label for="direccion">Dirección</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col m6 l6 s6">
                                    <button class="btn-large teal lighten-2 tooltipped" id="btnRegistrarTrabajador" data-tooltip="Registrar Trabajador">Registrar Trabajador
                                    <i class="material-icons right">save</i>    
                                    </button>
                                </div>
                                
                                <div class="col s3 m3 l3">
                                    
                                </div>
                                <div class="col s6 m6 l6">
                                    <button class="btn-large black lighten-2 modal-trigger tooltipped" data-tooltip="Crear Usuario"  href="#modalusu" type="submit" name="action" id="btnCrearUsuario">Crear Usuario
                                        <i class="material-icons right">add</i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <div class="left-sidebar-hover"></div>
        <%@include file="WEB-INF/template/footerMain.jspf" %>
        <script src="js/regisUsuario.js" type="text/javascript"></script>
    </body>
</html>
