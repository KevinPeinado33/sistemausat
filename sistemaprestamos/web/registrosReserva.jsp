<%-- 
    Document   : registrosReserva
    Created on : 10-jul-2018, 15:06:22
    Author     : Kevin Peinado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Reservas</title>
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
                    <div class="col s12">
                        <a href="reservas.jsp" class="breadcrumb">Realizar Reserva</a>
                        <a href="registrosReserva.jsp" class="breadcrumb">Lista Reservas</a>  
                    </div>
                </div>
            </nav>
            <div class="card">
                <div class="card-content">

                    <div class="row">
                        <div class="col s3"></div>
                        <div class="col s6">
                            <div class="input-field">
                                <i class="material-icons prefix">account_circle</i>
                                <input id="filtNom" type="text" class="validate" name="filtNom">
                                <label for="filtNom">Nombre o Codigo del Profesor</label>
                            </div>
                        </div>
                        <div class="col s3"></div>
                    </div>
                    <div class="row">
                        <div class="col s1"></div>
                        <div class="col s10">
                            <div>
                                <table class="striped highlight responsive-table centered" id="tblRegistro">
                                    <thead >
                                        <tr>
                                            <th>Fecha Reserva</th>
                                            <th>Nombres Profesor</th>
                                            <th>#Dni</th>
                                            <th>Ver</th>
                                            <th>Eliminar</th>
                                            <th>Prestamo</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <!-- data de la bd -->
                                    </tbody>
                                </table>

                            </div>
                        </div>
                        <div class="col s1"></div>
                    </div>
                </div>
            </div>
        </main>
        <%@include file="WEB-INF/template/footerMain.jspf" %>
        <script src="js/registrosReservas.js" type="text/javascript"></script>
    </body>
</html>
