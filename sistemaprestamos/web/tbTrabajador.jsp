<%-- 
    Document   : tbTrabajador
    Created on : 24-07-2018, 23:29:35
    Author     : Emanuel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trabajador</title>
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
        <main class="mn-inner">
            <nav class="teal lighten-2" style="margin-top: -20px;">
                <div class="nav-wrapper">
                    <div class="row">
                        <div class="col s1">
                            <i class="material-icons" style="height:10px;">contacts</i>
                        </div>
                        <div class="col s11" style="position:absolute;left:30px;top:3px;">
                            <a href="tbTrabajador.jsp" class="breadcrumb">Gestion de Trabajadores</a>                        
                        </div>
                    </div>
                </div>   
            </nav>
            
            <div class="col s12">

                <div class="action-btn-wrapper">
                    <div class="fixed-action-btn my-custom-btn vertical">
                        <a class="btn-floating btn-large black">
                            <i class="large material-icons">settings</i>
                        </a>
                        <ul>
                            <li><a class="btn-floating orange lighten-2 tooltipped" data-position="left" data-delay="50" data-tooltip="Agregar Trabajador" href='RegistrarUsuario.jsp'><i class="material-icons">group_add</i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            
            <div class="row">
                <div class="col s12">
                 
                    <div class="page-title"><!--Titulo del cartel--></div>
                </div>
                <div class="col s12 m12 l12">
                    <div class="card">
                        <div class="card-content">
                            <table class="table highlight centered" id="tablaTrabajadores">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Nombres</th>
                                        <th>Apellidos</th>
                                        <th>Celular</th>
                                        <th>DNI</th>
                                        <th>Email</th>
                                        <th>Dirección</th>
                                        <th>Editar</th>
                                        <th>Deshabilitar</th>
                                        <th><th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>                                                                                                                                               
                    </div>
                </div>
            </div>     
        <!--FIN Contenido-->
        <!--MODAL N°1-->
        <div id="modal1" class="modal s12 m12 l12" style="max-width: 1200px;">
              <div class="modal-content" id="caja">
              <h5>Editar Datos del Trabajador</h5>
              <hr>
              <div id="cuerpo">
                  <div class="card-content">
                    <div class="row">  
                         <div>
                            <div class="col s5 row">
                                <div class="input-field">
                                    <i class="material-icons prefix" style='color:darkcyan;'>person</i>
                                    <input id="tNombres" type="text" class="validate center-align" placeholder="-" ><span id="evaluar"></span>
                                    <label for="nom">Nombres</label>
                                </div>
                                <div class="input-field">
                                    <i class="material-icons prefix" style='color:silver;'>person_add</i>
                                    <input id="tApellidos" type="text" class="validate center-align" placeholder="-" ><span id="evaluar"></span>
                                    <label for="ape">Apellidos</label>
                                </div>
                                <div class="input-field">
                                    <i class="material-icons prefix" style='color:blue;'>phone_android</i>
                                    <input id="tCelular" type="text" class="validate center-align" placeholder="-" required maxlength="9" ><span id="evaluar"></span>
                                    <label for="cel">Celular</label>
                                </div>
                                <div class="input-field">
                                    <i class="material-icons prefix" style='color:steelblue;'>code</i>
                                    <input id="tDNI" type="text" class="validate center-align" placeholder="-" required maxlength="8" ><span id="evaluar"></span>
                                    <label for="dni">DNI</label>
                                </div>
                                <div class="input-field">
                                    <i class="material-icons prefix" style='color:green;'>email</i>
                                    <input id="tCorreo" type="email" class="validate center-align" placeholder="-"><span id="evaluar"></span>
                                    <label for="correo">Correo Electrónico</label>
                                </div>
                                <div class="input-field">
                                    <i class="material-icons prefix" style='color:rosybrown;'>home</i>
                                    <input id="tDireccion" type="text" class="validate center-align" placeholder="-"><span id="evaluar"></span>
                                    <label for="direc">Dirección</label>
                                </div>
                            </div>
                            <div class="col s2 row center-align">
                                
                            </div>
                            
                            <div class="col s5 row">
                                <div class="input-field">
                                    <i class="material-icons prefix" style='color:darkgrey;'>account_circle</i>
                                    <input type="text" name="password" id="tUsuario" placeholder="-" class="validate center-align tooltipped" data-tooltip="Su usuario debe contener 7 caracteres o más"><span id="val2"></span>
                                    <label for="usu">Usuario</label>
                                </div>
                                <div class="input-field">
                                    <i class="material-icons prefix" style='color:peru;'>vpn_key</i>
                                    <input type="password" name="password" id="tPass" placeholder="-" class="validate center-align tooltipped" data-tooltip="Su contraseña debe contener 6 caracteres o más"><span id="val2"></span>
                                    <label for="pass">Contraseña</label>
                                </div>
                                <div class="col s12">
                                    <button class="btn btn-large black" id="btnActualizar">Guardar Cambios</button>
                                </div>
                            </div>
                     
                        </div>  
                    </div>
                  </div>
              </div>
              </div>
              <div class="modal-footer">
                  <a href="#!" id="cerrar" class="modal-action modal-close waves-effect waves-green btn-flat">Cerrar</a>
              </div>
        </div> 
        <!--Fin del MODAL N°1-->
    </div>
     
  </main>
    <%@include file="WEB-INF/template/footerMain.jspf" %>
    <script src="js/trabajadores.js" type="text/javascript"></script>
</body>
</html>
