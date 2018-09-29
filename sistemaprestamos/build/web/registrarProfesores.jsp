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
        <title>Profesor</title>
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
        %><%@include file="WEB-INF/template/PrincipalTrabajador.jspf"%><%
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
                        <a href="tablaProfesores.jsp" class="breadcrumb">Gestion Profesor</a>
                        <a href="RegistrarProfesores.jsp" class="breadcrumb">Añadir Profesor
                        </a>

                    </div>
                </div>
            </nav>
            <div class="col s12">

                <div class="action-btn-wrapper">
                    <div class="fixed-action-btn my-custom-btn vertical">
                        <a class="btn-floating btn-large red">
                            <i class="large material-icons">settings
                            </i>
                        </a>
                        <ul>
                            <li><a class="btn-floating #f06292 blue lighten-2 tooltipped" data-position="left" data-delay="50" data-tooltip="Añadir Profesor" href='registrarProfesores.jsp' ><i class="material-icons">add</i></a></li>
                            <li><a class="btn-floating #f06292 green lighten-2 tooltipped" data-position="left" data-delay="50" data-tooltip="Lista de Profesores" href='tablaProfesores.jsp'><i class="material-icons">grid_on
                                    </i></a></li>

                        </ul>
                    </div>
                </div>

            </div>


            <div class="row">

                <div class="col s12 m12 l12">
                    <div class="card" style="padding:20px;">

                        <div class="card-content">

                            <div class="row">
                                <div class="row">
                                    <div class="col s4">
                                        <div class="input-field">
                                            <i class="material-icons prefix">face</i>
                                            <label for="nombres">Nombres</label>
                                            <input id="nombres" type="text" class="validate" placeholder="" onkeypress="return soloLetras(event)" onblur="limpia()">
                                        </div>

                                    </div>
                                    <div class="col s4">
                                        <div class="input-field">
                                            <label for="apellidos">Apellidos</label>
                                            <input id="apellidos" type="text" class="validate" placeholder="" onkeypress="return soloLetras(event)" onblur="limpia2()">

                                        </div>
                                    </div>
                                    <div class="col s4">
                                        <div class="input-field">
                                            <label for="celular">Numero de Celular</label>
                                            <input class="validate" type="text" name="celular" placeholder="#"  required maxlength="9" id="celular" onkeypress="return valida(event)">


                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col s6">
                                        <div class="input-field">
                                            <i class="material-icons prefix">mail</i>
                                            <input type="text" name="email"  id="email" placeholder="">
                                            <label for="email">Email</label>
                                        </div>
                                    </div>
                                    <div class="col s6">
                                        <div class="input-field">
                                            <input class="validate" type="text" name="direccion" required id="direccion" placeholder="">
                                            <label for="direccion">Dirección</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col s4">
                                        <div class="input-field">
                                            <i class="material-icons prefix">school</i>

                                            <input type="text" class="validate" name="grado" required id="grado" placeholder="">
                                            <label for="grado">Grado Profesional</label>
                                        </div>
                                    </div>
                                    <div class="col s4">
                                        <div class="input-field">

                                            <input type="text" name="dni" class="validate" required maxlength="8" id="dni" placeholder="#" onkeypress="return valida(event)">
                                            <label for="dni">Ingrese Dni</label>

                                        </div>
                                    </div>
                                    <div class="col s4">
                                        <div class="input-field">
                                            <input type="text" name="codigo" class="validate" required maxlength="9" id="codigo" placeholder="#">
                                            <label for="codigo">Ingrese Codigo</label>

                                        </div>
                                    </div>
                                </div>   

                                <div class="row">
                                    <div class="input-field col s4">
                                        <i class="material-icons prefix">class</i>
                                        <select id="secFacultad">
                                            <option value="0" disabled selected>Facultades de la UPeU</option>
                                            <option value="1">FIA</option>
                                            <option value="2">FACTEO</option>
                                            <option value="3">FCE</option>
                                            <option value="4">FACIHED</option>
                                            <option value="5">Ciencias de la Salud</option>
                                        </select>
                                        <label>Facultades</label>
                                    </div>
                                   

                                    <div class="input-field col s4">
                                        <select id="comboEscuela" name="selectBox">
                                            <option value="0" disabled selected>Escuelas de la UPeU</option>             
                                        </select>
                                        <label>Escuelas</label>
                                    </div>
                                     <div class="col s4 center-align">
                                           <button class="btn-large teal lighten-2" type="submit" name="action" id="btnRegistrar">Registrar
                                        <i class="material-icons right">save</i>
                                    </button>
                                    </div>

                                </div>
                            </div>
                         
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <div class="left-sidebar-hover"></div>
        <%@include file="WEB-INF/template/footerMain.jspf" %>
        <script src="js/regisProfesores.js" type="text/javascript"></script>
    </body>
</html>
