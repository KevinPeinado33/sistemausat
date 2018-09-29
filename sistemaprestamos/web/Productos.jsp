<%-- 
    Document   : Productos
    Created on : 07/07/2018, 11:04:46 PM
    Author     : EMILY 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Equipos</title>
        <%@include file="WEB-INF/template/header.jspf" %>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">

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
                            <i class="material-icons" style="height:10px;">local_mall</i>
                        </div>
                        <div class="col s11" style="position:absolute;left:30px;top:3px;">
                            <a href="reservas.jsp" class="breadcrumb">Gestion Equipos</a>                        
                        </div>

                    </div>
                </div>   
            </nav>

            <div class="col s12 m12 l12">                        
                <div class="card">                            
                    <div class="card-content">                              
                        <div class="row">
                            <div class="col s12">
                                <div class="row">
                                    <div class="col s10">
                                        <div class="input-field">

                                            <label for="nomp">Buscar..</label>
                                            <input type="text" name="nomp" required id="nomp" style="width: 320px">
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <table class="table highlight centered" id="tablin">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Nombre</th>
                                        <th>Código</th>
                                        <th>Estado</th>
                                        <th>Tipo</th>
                                    </tr>
                                </thead>
                                <tbody> 
                                </tbody>

                            </table> 
                        </div>

                    </div>

                </div>
                <div class="col s12">
                    <div class="action-btn-wrapper">
                        <div class="fixed-action-btn my-custom-btn vertical">
                            <a class="btn-floating btn-large red">
                                <i class="large material-icons">settings</i>
                            </a>
                            <ul>
                                <li><a class="btn-floating #f06292 red lighten-2 modal-trigger " href='#modal1' onclick="modal()"><i class="material-icons">add</i></a></li>
                                <li><a class="btn-floating #f06292 green lighten-2 modal-trigger" href='#modal3' ><i class="material-icons">assignment</i></a></li>
                                <li><a class="btn-floating #f06292 orange lighten-2 modal-trigger" href='#modal8' onclick="moto()" ><i class="material-icons">grid_on</i></a></li>

                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <div id="modal1" class="modal s12 m12 l12" style="max-width: 520px;">
                <div class="modal-content">

                    <div class="col-sm-8 contact-form" > <!-- div da direita -->
                        <form id="contact" method="post" class="form" role="form">
                            <div class="row">
                                <div class="row">
                                    <div class="col s6">
                                        <div class="input-field">
                                            <i class="material-icons prefix">local_mall</i>
                                            <input type="text" name="producto"  id="pro" placeholder="equipo">
                                            <label for="producto">Equipo</label>

                                        </div>
                                    </div>
                                    <div class="col s6">
                                        <div class="input-field">
                                            <i class="material-icons prefix">looks_5</i>
                                            <input type="text" name="codigo"  id="codi" placeholder="codigo">
                                            <label for="codigo">Codigo</label>

                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="input-field col s6">
                                        <select id="loco">
                                            <option value="" disabled selected>Selecciona un estado</option> 
                                            <option value="1">BUEN ESTADO</option>
                                            <option value="0">MAL ESTADO</option>
                                            <option value="2">REGULAR</option>
                                        </select>
                                        <label>Seleciona un estado</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <select id="combin" name="selectBox">
                                            <option value="0" disabled selected>Selecciona un tipos</option>             
                                        </select>
                                        <label>Tipos</label>

                                    </div>


                                </div>
                            </div>
                            <div class="modal-footer">
                                <a  class="modal-action modal-close waves-effect waves-green btn-flat" onclick='salva()'>Registrar</a>
                                <a  class="modal-action modal-close waves-effect waves-green btn-flat">Cerrar</a>

                            </div>
                    </div>
                </div>
            </div>




            <div id="modal2" class="modal s12 m12 l12" style="max-width: 530px;">
                <div class="modal-content">
                    <label for="kop">Registra un nuevo tipo..</label>            
                    <div class="col-sm-8 contact-form" style="margin-top: 20px" > 
                        <form id="contact" method="post" class="form" role="form" >


                            <div class="row">

                                <div class="input-field col s6">
                                    <select id="loc">
                                        <option value="" disabled selected>Selecciona un estado</option>
                                        <option value="1">BUEN ESTADO</option>
                                        <option value="0">MAL ESTADO</option>
                                        <option value="2">REGULAR</option>
                                    </select>
                                    <label>Seleciona un estado</label>
                                </div>

                            </div>


                    </div>
                </div>
                <div class="modal-footer">
                    <a  class="modal-action modal-close waves-effect waves-green btn-flat" onclick='ji()'>Registrar</a>
                    <a  class="modal-action modal-close waves-effect waves-green btn-flat">Cerrar</a>

                </div>
            </div>





            <div id="modal3" class="modal s12 m12 l12" style="max-width: 530px;">
                <div class="modal-content">

                    <div class="col-sm-8 contact-form" style="margin-top: 20px" > 
                        <form id="contact" method="post" class="form" role="form" >
                            <div class="row">

                                <div class="col s6">
                                    <div class="input-field">
                                        <i class="material-icons prefix">view_comfy</i>
                                        <input type="text" name="tipo"  id="tip" placeholder="tipo">
                                        <label for="tiip">Tipo</label>

                                    </div>
                                </div>

                            </div>


                    </div>
                </div>
                <div class="modal-footer">
                    <a  class="modal-action modal-close waves-effect waves-green btn-flat" onclick='esta()'>Registrar</a>
                    <a  class="modal-action modal-close waves-effect waves-green btn-flat">Cerrar</a>

                </div>
            </div>
            <div id="modal8" class="modal s12 m12 l12 modal-fixed-footer" style="max-width: 530px;">
                <div class="modal-content">
                    <label for="tipos">Tipos</label>

                    <div class="col-sm-8 contact-form" style="margin-top: 20px" > 
                        <form id="contact" method="post" class="form" role="form" >
                            <div class="row">
                                <div class="col s1"></div>
                                <div class="col s10">
                                    <table class="table highlight centered" id="tabp">
                                        <thead>
                                            <tr>
                                                <th>Nombre</th>
                                                <th>Stock</th>
                                                <th>Accion</th>

                                            </tr>
                                        </thead>
                                        <tbody> 
                                        </tbody>

                                    </table> 


                                </div>
                                <div class="col s1"></div>

                            </div>


                    </div>
                </div>
                <div class="modal-footer">

                    <a  class="modal-action modal-close waves-effect waves-green btn-flat">Cerrar</a>

                </div>
            </div>



            <div id="modal16" class="modal s12 m12 l12 modal-fixed-footer" style="max-width: 300px; max-height: 280px;">
                <div class="modal-content">
                    <label for="tipos">Actualizar Tipo</label>

                    <div class="col-sm-8 contact-form" style="margin-top: 20px" > 
                        <form id="contact" method="post" class="form" role="form" >
                            <div class="row">

                                <div class="input-field col s12">
                                    <a></a>
                                    <input  id="no" type="text" class="validate">
                                    <input id="idt" type="hidden">
                                    <label for=""></label>
                                </div>        

                            </div>



                    </div>
                </div>
                <div class="modal-footer">
                    <a  class="modal-action modal-close waves-effect waves-green btn-flat" id="btnActu"> Guardar</a>

                    <a  class="modal-action modal-close waves-effect waves-green btn-flat">Cerrar</a>

                </div>
            </div>

        </main>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>

        <%@include file="WEB-INF/template/footerMain.jspf" %>

        <script src="js/producto.js" type="text/javascript"></script> 
    </body>
</html>
