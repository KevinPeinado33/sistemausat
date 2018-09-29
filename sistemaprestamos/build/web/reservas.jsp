<%-- 
    Document   : reservas
    Created on : 06-jul-2018, 11:35:04
    Author     : Kevin Peinado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reserva</title>
        <%@include file="WEB-INF/template/header.jspf" %>
        <link href="css/estilos-quebin.css" rel="stylesheet" type="text/css"/>
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

        <main class="mn-inner"> 
            <nav class="teal lighten-2" style="margin-top: -20px;">
                <div class="nav-wrapper">
                    <div class="row">
                        <div class="col s1">
                            <i class="material-icons" style="height:10px;">date_range</i>
                        </div>
                        <div class="col s11" style="position:absolute;left:30px;top:3px;">
                            <a href="reservas.jsp" class="breadcrumb">Realizar Reserva</a>                        
                        </div>

                    </div>
                </div>   
            </nav>

            <div class="row">
                <div class="col s8">
                    <div class="card" style="margin-top: 40px;">
                        <div class="card-content">
                            <div class="row">

                                <div class="col s4">
                                    <div class="input-field">
                                        <i class="material-icons prefix">perm_contact_calendar</i>
                                        <label for="codigo">Ingrese DNI</label>
                                        <input type="text" name="codigo" required id="codigo" maxlength="20">
                                    </div>
                                </div>
                                <div class="col s2">
                                    <div class="input-field">
                                        <a class="btn red" id="btnBuscar">Buscar</a>
                                    </div>
                                </div>
                                <div class="col s6">
                                    <div class="input-field">
                                        <div class="input-field">
                                            <i class="material-icons prefix">face</i>
                                            <input type="text" name="nombres" required id="nombres" disabled>
                                            <input type="hidden" name="nombres" required id="idprofesor" disabled>
                                        </div>                                    </div>
                                </div>                                
                            </div>

                            <div class="row">
                                <div class="col s4">
                                    <div class="input-field">
                                        <i class="material-icons prefix">account_balance</i>
                                        <label for="aula">Aula</label>
                                        <input type="text" name="aula" required id="aula" maxlength="6">
                                    </div>

                                </div>

                                <div class="col s4">
                                    <div class="input-field">
                                        <i class="material-icons prefix">event</i>                                       
                                        <input type="text" name="fecha" required id="fecha" disabled>
                                        <label for="fecha">Fecha Actual</label>
                                    </div>

                                </div>

                                <div class="col s4">

                                    <div class="input-field">
                                        <i class="material-icons prefix">event</i>
                                        <!--<input type="date" id="fe_prestamo">-->
                                        <input type="text" id="fe_prestamo" class="datepicker" placeholder="Año-Mes-Dia">
                                        <label>Fecha de Prestamo</label>
                                    </div>

                                </div>                                                                                                                                                                                                
                            </div>  

                            <div class="row">
                                <div class="col s4">
                                    <label>Hora de Prestamo</label>
                                    <div class="input-field">
                                        <i class="material-icons prefix">access_time</i>                                        
                                        <input type="time" required name="h_prestamo" id="h_prestamo" maxlength="5">
                                    </div>
                                </div>

                                <div class="col s4">
                                    <label>Fecha de Devolución</label>
                                    <div class="input-field">
                                        <i class="material-icons prefix">assignment_turned_in</i>
                                        <input type="text" id="fe_devolucion" class="datepicker"  placeholder="Año-Mes-Dia">
                                    </div>
                                </div>

                                <div class="col s4">
                                    <label>Hora de Devolucion</label>
                                    <div class="input-field">
                                        <i class="material-icons prefix">access_alarms</i>                                        
                                        <input type="time" name = "h_devolucion"required id="h_devolucion" >
                                    </div>
                                </div>                                                                
                            </div>                                                                                    
                        </div>
                    </div>

                </div>


                <div class="col s4">
                    <div class="card" style="margin-top: 40px;">
                        <div class="card-content">
                            <div class="row">
                                <div class="col s12 center-align">
                                    <a class="waves-effect waves-light btn modal-trigger btn-large grey darken-3" href="#modal1">Seleccionar Equipos
                                        <i class="material-icons right">add_circle_outline</i></a>
                                </div>                                                                
                            </div>                            
                            <div class="row">                           
                                <div class="col s12 center-align">
                                    <div class="tabla-contenedor2">
                                        <table class="highlight responsive-table centered" id="tblRervado">
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

                                <div class="action-btn-wrapper">


                                    <div class="fixed-action-btn my-custom-btn vertical">

                                        <a class="btn-floating  btn-large blue tooltipped" onclick="irRegistroReservas();" data-position="left" data-delay="50" data-tooltip="Ir a Registros Reservas"><i class="material-icons">assignment</i></a>

                                    </div>

                                </div>   

                            </div>  
                            <div class="row centered">  

                                <div class="col s6 centered">
                                    <button class="btn teal lighten-2" type="submit" name="action" id="btnRervar">Reservar
                                        <i class="material-icons right">save</i>
                                    </button>
                                </div>
                                <div class="col s6">
                                    <button class="btn grey darken-3" type="submit" name="action" id="btnCancelar">Cancelar
                                        <i class="material-icons right">delete_forever</i>
                                    </button>
                                </div>
                            </div>  
                        </div>                                                                                             
                    </div>


                    <!-- nuevo diseño-->


                    <!--Modal-->
                    <div id="modal1" class="modal modal-fixed-footer">
                        <div class="modal-content">
                            <h4>Busqueda de Productos</h4>
                            <div class="row">
                                <div class="col s1"></div>
                                <div class="col s10">
                                    <div class="input-field">
                                        <i class="material-icons prefix" style="color: green">find_in_page</i>
                                        <label for="nomProducto">Nombre o Codigo</label>
                                        <input type="text" name="nomProducto" required id="nomProducto">
                                    </div>
                                </div>
                                <div class="col s1"></div>
                            </div>
                            <div class="row">
                                <div class="col s12">
                                    <div class="tabla-contenedor">
                                        <table class="highlight responsive-table centered" id="tblProductos">
                                            <thead >
                                                <tr>
                                                    <th>Nombres</th>
                                                    <th>Codigo</th>
                                                    <th>Tipo</th>
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
                            <a href="#!" class="modal-action modal-close btn grey darken-3">Cerrar</a>
                        </div>
                    </div>
                    <!--Fin del Modal-->
                </div>



                <div class="left-sidebar-hover"></div>
        </main>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
        <%@include file="WEB-INF/template/footerMain.jspf" %>
        <script src="js/reservas.js" type="text/javascript"></script>
    </body>
</html>
