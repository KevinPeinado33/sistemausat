<%-- 
    Document   : Prestamo
    Created on : 05/07/2018, 02:17:04 PM
    Author     : nicob
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prestamo </title>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize-stepper.min.css" rel="stylesheet" type="text/css"/>
        <%@include file="WEB-INF/template/header.jspf" %>
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
        <main class="mn-inner" >
            <div class="card">
                <center>
                    <div class="wizard-header text-center" >
                        <input id="ress" value="<%=id%>" hidden>
                        <br>
                        <h3 class="wizard-title" >Prestamo de equipos</h3>
                        <p class="category">Esta informacion es importante.</p>
                    </div>
                </center>
                <div class="section scrollspy" id="horizontal-stepper">
                    <div class="horizontal">
                        <ul class="stepper vertical" style="margin-left: 5%;">
                            <li class="step active" id="about">
                                <a href="#about" data-toggle="tab">
                                    <div class="step-title waves-effect waves-dark">
                                        <i class="ti-arrow-up"><i class="material-icons medium prefix">chrome_reader_mode</i></i>
                                        Datos
                                    </div>
                                </a>

                                <!--Steep #1-->
                                <div class="step-content" id="about">
                                    <center><div><h5 class="info-text"> Porfavor ingresar datos requeridos</h5></div></center>
                                    <div class="row">
                                        <div class="container" name="1">
                                            <center> 
                                                <div class="row  ">
                                                    <div class="row center col s6" name="rigth">
                                                        <div class="row center col s10">                                                       
                                                            <div class="input-field">
                                                                <i class="material-icons prefix">picture_in_picture_alt</i>
                                                                <label for="dnipro">Ingrese DNI profesor</label>
                                                                <input id="idu" type="text" value="${sessionScope.iduser}" hidden>
                                                                <input  id="dnipro" class="autocomplete" type="text" maxlength="8" name="dnipro" important>
                                                            </div>                                                       
                                                        </div>
                                                        <div class="input-field col s12">
                                                            <i class="material-icons prefix">school</i>
                                                            <label for="responsable">Alumno</label>
                                                            <input type="text" name="responsable" id="responsable" required>
                                                        </div>
                                                        <!--<div class="col s12 input-field">
                                                            <form name="horas" id="horas">
                                                                <i class="material-icons prefix active">access_time</i>
                                                                <label for="hor" class="active">Hora prestamo</label>
                                                                <input name="hora" id="hora_pre" type="time" class="validate">
                                                            </form>
                                                        </div>-->
                                                        <div class="col s12 input-field">
                                                            <form name="horas" id="horas">
                                                                <i class="material-icons prefix active">access_time</i>
                                                                <label for="hora" class="active">Hora devolucion</label>
                                                                <input name="hora" id="hora_dev" type="time" class="validate">
                                                            </form>
                                                        </div> 

                                                    </div>
                                                    <div class="row center col s6 " name="left">
                                                        <div class="input-field">
                                                            <i class="material-icons prefix">person</i>
                                                            <input  id="profe" type="text" class="validate" disabled>
                                                            <input  id="prof" class="autocomplete" type="hidden" name="dnipro" required>
                                                        </div>
                                                    </div>
                                                    <div class="col s6 input-field">
                                                        <select id="docu" disabled>
                                                        </select>
                                                        <label>Documento Alumno</label>
                                                    </div>
                                                    <!--<div class="col s6 input-field">                                                        
                                                        <form name="fechas" id="fechas">
                                                            <i class="material-icons prefix active">insert_invitation</i>
                                                            <label for="fechawe" class="active">Fecha prestamo</label> 
                                                            <input id="fecha_pre" name="fecha" type="text" class="validate">
                                                        </form> 
                                                    </div>-->

                                                    <!--Fecha devolucion-->
                                                    <div class="col s6 input-field">
                                                        <form name="fechasdev" id="fechasdev">
                                                            <i class="material-icons prefix active">insert_invitation</i>
                                                            <label for="fechadev" class="active">Fecha Devolucion</label>
                                                            <input id="fechadev" name="fecha_dev" type="date">
                                                        </form>
                                                    </div>
                                                    <div class="col s16 input-field">
                                                        <i class="material-icons prefix">pin_drop</i>
                                                        <label for="aula">Aula</label>
                                                        <input type="text" name="aula" id="aula" required>
                                                    </div>
                                                </div>
                                            </center>
                                        </div>
                                    </div>
                                    <div class="step-actions">
                                        <input location.href="#account" type='button' class='waves-effect waves-dark btn blue previous-step' name='next' value='Siguiente' />                              
                                    </div>
                                </div>
                                <!--Final Steep #1-->
                            </li>
                            <li  class="step" id="account">
                                <a data-toggle="tab">
                                    <div class="step-title waves-effect waves-dark">
                                        <i class="ti-arrow-up"><i class="material-icons medium prefix">important_devices</i></i>
                                        Equipos
                                    </div>
                                </a>
                                <!--Steep #2-->
                                <div class="step-content" id="account">
                                    <center><div><h5 class="info-text"> Equipos </h5></div></center>
                                    <div class="row">
                                        <div class="container input-field col s12" >
                                            <br>
                                            <center>
                                                <a class="waves-effect waves-light modal-trigger" href="#modalequi" >Seleccionar Equipos
                                                    <i class="material-icons right">important_devices</i></a>
                                            </center>
                                            <!--Modal-->
                                            <div id="modalequi" class="modal modal-fixed-footer">
                                                <div class="modal-content">
                                                    <div class="col s12 input-field">
                                                        <i class="material-icons prefix">scanner</i>
                                                        <label for="searchpro">Equipo</label>
                                                        <input  id="searchpro"  type="text">
                                                    </div>
                                                    <div class=" center col s12" id="visualizarProducto" style="border: 1px solid #eae8e8; border-radius: 5px; margin: 10px 0px 5px 0px; padding: 10pX 10Px 0px 10px; ">
                                                        <table class="table" id="tablaPrestamo">
                                                            <thead>
                                                                <tr>
                                                                    <th scope="col">#</th>
                                                                    <th scope="col">NOMBRE</th>
                                                                    <th scope="col">CODIGO</th>
                                                                    <th scope="col">ESTADO</th>
                                                                    <th scope="col">TIPO</th>
                                                                    <th scope="col">DISPONIBLE</th>
                                                                    <th scope="col">ACCION</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody></tbody>
                                                        </table>
                                                    </div>

                                                </div>
                                                <div class="modal-footer">
                                                    <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Cerrar</a>
                                                </div>
                                            </div>
                                            <!--Fin del Modal-->

                                            <div class="center col s12">
                                                <table class="table" id="tablaDetalle" >
                                                    <thead>
                                                        <tr>
                                                            <th>EQUIPO</th>
                                                            <th>ESTADO</th>
                                                            <th>TIPO</th>
                                                            <th>ELIMINAR</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>

                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                    <br>
                                    <br>
                                    <hr>
                                    <center>
                                        <div class="step-actions ">
                                            <input href="#account" type='button' class='waves-effect waves-dark btn-flat previous-step' name='next' value='Regresar' />
                                            <input  type='button' class='waves-effect waves-dark btn blue' name='finish' value='Completar' id="registrarPrestamo" />
                                        </div></center>
                                </div>
                                <!--Final Steep #2-->                          
                            </li>
                        </ul>
                        <div class="col hide-on-small-only m3 l2">
                            <div class="toc-wrapper" style="top: 0px;">
                            </div>
                        </div>
                    </div>
                    <div class="wizard-footer">
                        <div class="clearfix"></div>
                        <div class="col s12">
                            <div class="action-btn-wrapper">
                                <div class="fixed-action-btn my-custom-btn vertical">
                                    <a class="btn-floating btn-large red">
                                        <i class="large material-icons">build</i>
                                    </a>
                                    <ul>
                                        <li><a class="btn-floating #f06292 blue lighten-2 tooltipped" data-position="left" data-delay="50" href="registrosReserva.jsp" data-tooltip="Ver Reservas"><i class="material-icons">remove_red_eye</i></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div> 
                </div>
            </div>
        </main>
        <%@include file="WEB-INF/template/footerMain.jspf" %>
    </body>
    <script type="text/javascript">
        function someFunction() {
            setTimeout(function () {
                $('#feedbacker').nextStep();
            }, 1000);
        }

        function someOtherFunction() {
            return true;
        }

        $(document).ready(function () {
            $('.toc-wrapper').pushpin({
                top: $('.toc-wrapper').offset().top,
                offset: 77
            });
            $('.scrollspy').scrollSpy();
            $('.stepper').activateStepper();
        });
    </script>
    <script src="js/material/jquery.validate.min.js"></script>
    <script src="js/material/materialize-stepper.min.js" type="text/javascript"></script>
    <script src="js/prestamo.js" type="text/javascript"></script>
</html>