<%-- 
    Document   : devolucion
    Created on : 05/07/2018, 04:08:05 PM
    Author     : Emanuel Pinaud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Devolucion</title>
        <%@include file="WEB-INF/template/header.jspf"%>
        <link href="cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.css"/>

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
        %><%@include file="WEB-INF/template/PrincipalTrabajador.jspf"%><%
                                         }
                                     }

                                 } catch (Exception e) {
                                     System.out.println("Error: " + e);

                                 }
        %>
   
    <!--INICIO Devolucion.jsp -->
    <main class="mn-inner">
        <nav class="teal lighten-2" style="margin-top: -20px;">
            <div class="nav-wrapper">
                <div class="row">
                    <div class="col s1">
                        <i class="material-icons" style="height:10px;">devices_other</i>
                    </div>
                    <div class="col s11" style="position:absolute;left:30px;top:3px;">
                        <a href="devolucion.jsp" class="breadcrumb">Devolución</a>                        
                    </div>

                </div>
            </div>   
        </nav>
        <div class="row">          
            <div class="col s12 m12 l12">
                <div class="card">
                    
                    <div class="col s12 m12 l12">
                        <div class="card">
                            <div class="card-content">
                                <div class="col s4">
                                    
                                        <div class="input-field">
                                            <i class="material-icons prefix">search</i>
                                            <label for="nomp">Buscar</label>
                                            <input type="text" name="nomp" required id="nomp" >
                                        </div>
                                   
                                </div>
                                <table class="table highlight centered" id="tb_prestamos">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                            <th>Fecha de Préstamo</th>
                                            <th>Devolución Programada</th>
                                            <th>Hora pedido</th>
                                            <th>Hora devolucion</th>
                                            <th>Productos</th>
                                            </tr>
                                    </thead>
                                    <tbody></tbody>
                                </table> 
                            </div>
                        </div>
                    </div>
                    <!-- ABRIR MODAL N°8 -->
                    <div class="col s12">
                        <div class="action-btn-wrapper">
                            <div class="fixed-action-btn my-custom-btn vertical">
                                <a class="btn-floating btn-large red">
                                    <i class="large material-icons">settings</i>
                                </a>
                                <ul>
                                    <li><a class="btn-floating #f06292 green lighten-2 modal-trigger" href='#modal8' onclick="okp()"><i class="material-icons">assignment</i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="left-sidebar-hover"></div>
                </div>                   
            </div>
        </div>
    </main>
    <!--FIN DEVOLUCION.JSP-->
    
    <!-- MODAL N°1 DE LISTADO DE PRODUCTOS -->
    <div id="modal1" class="modal s12 m12 l12" style="max-width: 350px;">
        <div class="modal-content" id="caja">
        <h5>Devolución de Productos</h5>
        <hr>
        <div id="cuerpo">
            
        </div>
        </div>
        <div class="modal-footer">
            <a href="#!" id="cerrar" class="modal-action modal-close waves-effect waves-green btn-flat">Cerrar</a>
        </div>
    </div> 
    <!--Fin del MODAL N°1 LISTADO DE PRODUCTOS-->
    
    <!--MODAL N°8-->
    <div id="modal8" class="modal s12 m12 l12 modal-fixed-footer" style="max-width: 530px;">        
        <div class="modal-content">
            <h5 for="tipos">EQUIPOS CON OBSERVACIONES</h5>
                <div class="col-sm-8 contact-form" style="margin-top: 20px" > 
                    <form id="contact" method="post" class="form" role="form" >
                    <div class="row">
                        <div class="col l12 m12 s12">
                            <div class="card">
                                <div class="card-content">
                                    <table class="table highlight centered" id="tabp">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Equipo</th>
                                            <th>Detalle</th>                    
                                        </tr>
                                    </thead>
                                    <tbody></tbody>
                                    </table> 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
        <div class="modal-footer">
            <a  class="modal-action modal-close btn grey darken-3">Cerrar</a>
        </div>
    </div>
    <div class="left-sidebar-hover"></div>
    <!--Fin del MODAL N°8 -->

    <%@include file="WEB-INF/template/footerMain.jspf" %>
    <script src="js/devolucion.js" type="text/javascript"></script>

    </body>
</html>
