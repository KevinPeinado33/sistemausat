<%-- 
    Document   : editarReserva
    Created on : 11-jul-2018, 16:20:45
    Author     : Kevin Peinado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edicion de Reservas</title>
        <%@include file="WEB-INF/template/header.jspf" %>
        <link href="css/estilos-quebin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            String id = request.getParameter("idr");
        %>


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
        <div class="mn-inner">
            <nav class="teal lighten-2" style="margin-top: -20px;">
                <div class="nav-wrapper">
                    <div class="col s12">
                        <a href="reservas.jsp" class="breadcrumb">Realizar Reserva</a>
                        <a href="registrosReserva.jsp" class="breadcrumb">Lista Reservas</a> 
                        <a href="editarReserva.jsp" class="breadcrumb">Editar Reservas</a>  
                        <input id="idresquebin" value="<%=id%>" hidden>
                    </div>
                </div>
            </nav>
            <div class="row">
                <div class="col s7 ">
                    <div class="card ">                        
                        <div class="card-content "> 
                            <div class="row">                                
                                <div class="col s3">
                                    <label for="codigo_r"><i class="large material-icons black-text">assignment_ind
                                        </i></label>
                                </div>
                                <div class="col s6">             
                                    <label for="nombres_r">Nombres Completos</label>
                                    <div class="input-field">
                                        <input id="nombres_r" type="text" class="validate" disabled="true">
                                        <input type="hidden" id="idprofesor">
                                    </div>
                                </div>
                                <div class="col s3">
                                    <label for="aula_r">Aula</label>
                                    <div class="input-field">
                                        <input id="aula_r" type="text" class="validate">
                                    </div>
                                </div>                  
                            </div>
                            <div class="row">
                                <div class="col s3">
                                    <label for="fe_prestamo_r">Fecha Prestamo</label>
                                    <div class="input-field">
                                        <input type="text" id="fe_prestamo_r" class="datepicker">
                                    </div>
                                </div>
                                <div class="col s3">      
                                    <label for="h_prestamo_r">HPrestamo</label>
                                    <div class="input-field">
                                        <input type="text" id="h_prestamo_r">
                                    </div>
                                </div>
                                <div class="col s3">      
                                    <label for="fe_devolucion_r">Fecha Devolucion</label>
                                    <div class="input-field">
                                        <input type="text" id="fe_devolucion_r" class="datepicker">
                                    </div>
                                </div>
                                <div class="col s3">
                                    <label for="h_devolucion_r">Hora Devolución</label>                                    
                                    <div class="input-field">
                                        <input type="text" id="h_devolucion_r">
                                    </div>
                                </div>
                            </div>  
                            <div class="row center">
                                <div class="col s6">
                                    <a class="btn-floating btn-large pulse grey darken-4" id="btnRegresar"><i class="material-icons">restore_page</i></a>                                                                         
                                </div>
                                <div class="col s6">
                                    <a class="btn-floating btn-large pulse light-blue darken-4" id="btnActualizar"><i class="material-icons">edit</i></a>
                                </div>
                            </div>

                        </div>
                    </div>                    
                </div>
                <div class="col s5">
                    <div class="card" style="height: 350px;">
                        <div class="car-contend">

                            <div class="row" >
                                <div class="col s12 center-align" style="margin-top: 20px;">
                                    <a href="#modal1" class=" btn-large teal lighten-2 modal-trigger" id="btnProd"><i class="material-icons right">dns</i>Añadir Productos</a>                            
                                </div>
                            </div>

                            <div class="row centered">
                                <div class="col s12">
                                    <div class="quebintrf">
                                        <table class="highlight responsive-table centered" id="reservado">
                                            <thead>
                                                <tr>
                                                    <th>Nombre</th>
                                                    <th>Codigo</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            </tbody>
                                        </table>        
                                    </div>
                                </div>                               
                            </div>                         
                        </div>                                         
                    </div>                                                
                </div>
                <!--sdsdsd-->
                <div class="action-btn-wrapper">
                    <div class="fixed-action-btn my-custom-btn vertical">
                        <a class="btn-floating btn-large green-text tooltipped" id="btnAttoGM" data-position="left" data-delay="50" data-tooltip="Guardar Cambios">
                            <i class="large material-icons">save</i>
                        </a>
                    </div>
                </div>
                <!--Modal-->
                <div id="modal1" class="modal modal-fixed-footer">
                    <div class="modal-content">
                        <h4>Busqueda de Productos</h4>
                        <div class="row">
                            <div class="col s1"></div>
                            <div class="col s10">
                                <div class="input-field">
                                    <i class="material-icons prefix" style="color: green">shopping_cart</i>
                                    <label for="nomProducto">Nombre o Codigo</label>
                                    <input type="text" name="nomProducto" required id="nomProducto">
                                </div>
                            </div>
                            <div class="col s1"></div>
                        </div>
                        <div class="row">
                            <div class="col s12">
                                <div class="tabla-contenedor">
                                    <table class="highlight responsive-table" id="actuProd">
                                        <thead id="tblCa">
                                            <tr>
                                                <th>Nombres</th>
                                                <th>Codigo</th>
                                                <th>Tipo</th>
                                                <th>Stock</th>
                                                <th>Añadir</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <!-- data de los productos -->
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Cerrar</a>
                    </div>
                </div>
                <!--Fin del Modal-->

            </div>
            <%@include file="WEB-INF/template/footerMain.jspf" %>
            <!--<script src="js/reservas.js" type="text/javascript"></script>-->
            <!--<script src="js/registrosReservas.js" type="text/javascript"></script>-->
            <script src="js/actualizarReserva.js" type="text/javascript"></script>
    </body>
</html>