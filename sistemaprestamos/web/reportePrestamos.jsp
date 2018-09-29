<%-- 
    Document   : tablaProfesores
    Created on : 04-jul-2018, 23:29:35
    Author     : Kevin Peinado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reportes</title>
        <%@include file="WEB-INF/template/header.jspf" %>
        <!-- Compiled and minified CSS -->
        <!-- Compiled and minified CSS -->
    </head>
    <body>                          
        <%
            try {
                HttpSession sesion = request.getSession();
                if (sesion.getAttribute("idr") == null) {
                    response.sendRedirect("login.jsp");

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
            <div class="row">
                <div class=" center-align">
                    <div class="page-title"> <i class="material-icons smoll" >content_paste</i><span>Reporte de prestamos</span></div>
                </div>
                <div class="col s12 ">
                    <div class="card">
                        <div class="card-content">
                            <div class="row center col s10">                                                       
                                <div class="input-field">
                                    <i class="material-icons prefix">assignment</i>
                                    <label for="usua">Buscar por usuario,profesor y fecha</label>
                                    <input  id="search" class="autocomplete" type="text" name="usua">
                                </div>                                                       
                            </div>    

                            <table class="highlight" id="tbldetpressm">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Usuario</th>
                                        <th>Fecha Prestamo</th>
                                        <th>Hora Prestamo</th>
                                        <th>Fecha Devolucion</th>
                                        <th>Hora Devolucion</th>
                                        <th>Aula</th>
                                        <th>Profesor</th>
                                        <th>Alumno</th>
                                    </tr>
                                </thead>

                                <tbody>
                                </tbody>
                            </table>                                                                                               
                            <!-- Modal Structure -->
                            <div id="modal1" class="modal modal-fixed-footer" style="max-width: 890px;">
                                <div class="modal-content">
                                    <h4>Equipos Emprestados</h4>
                                    <table class="highlight" id="tbldetpres">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Equipo</th>
                                                <th>Codigo</th>
                                                <th>Estado</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        </tbody>
                                    </table>                   
                                </div>
                                <div class="modal-footer">
                                    <a  class="modal-action modal-close waves-effect waves-green btn-flat">Cerrar</a>         
                                </div>
                            </div>

                            <div id="modal3" class="modal s12" style="max-width: 890px;">
                                <div class="modal-content">
                                    <div class="s12 contact-form" > 
                                        <div class="row">
                                            <table class="highlight" id="tbldetpro">
                                                <thead>
                                                    <tr>
                                                        <th>#</th>
                                                        <th>Orden de Prestamo</th>
                                                        <th>Nombre</th>
                                                        <th>Cantidad</th>
                                                    </tr>
                                                </thead>

                                                <tbody>
                                                </tbody>
                                            </table>                   
                                        </div>
                                        <div class="modal-footer">

                                            <a  class="modal-action modal-close waves-effect waves-green btn-flat">Cerrar</a>         
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </main>
        <!--FIN Contenido-->
    </div>

    <div class="left-sidebar-hover"></div>


    <%@include file="WEB-INF/template/footerMain.jspf" %>
</body>
<script src="js/detallePrestamo.js" type="text/javascript"></script>
</html>
