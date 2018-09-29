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
        <title>Profesores</title>
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
        <main class="mn-inner">
            <nav class="teal lighten-2" style="margin-top: -20px;">
                <div class="nav-wrapper">
                    <div class="row">
                        <div class="col s1">
                            <i class="material-icons" style="height:10px;">contacts</i>
                        </div>
                        <div class="col s11" style="position:absolute;left:30px;top:3px;">
                            <a href="tablaProfesores.jsp" class="breadcrumb">Gestion Profesores</a>                        
                        </div>

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
                            <li><a class="btn-floating #f06292 blue lighten-2 tooltipped" data-position="left" data-delay="50" data-tooltip="Añadir Profesor" href='registrarProfesores.jsp' ><i class="material-icons">add</i></a></li>
                            <li><a class="btn-floating #f06292 green lighten-2 tooltipped" data-position="left" data-delay="50" data-tooltip="Lista de Profesores" href='tablaProfesores.jsp'><i class="material-icons">grid_on
                                    </i></a></li>
                            
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
                            
                            <div class="row">
                                <div class="col s4">
                                <div class="input-field">
                                            <i class="material-icons prefix">search</i>
                                            <label for="nomp">Buscar</label>
                                            <input type="text" name="nomp" required id="nomp" >
                                        </div>
                                
                                
                                </div>
                                </div>
                            <table class="highlight centered" id="tblProfesores">
                                <thead>
                                    <tr>
                                        <th>DNI</th>
                                        <th>Codigo</th>
                                        <th>Nombres</th>
                                        <th>Apellidos</th>
                                        <th>Información</th>
                                        <th>Eliminar</th>
                                    </tr>
                                </thead>

                                <tbody>
                                </tbody>
                            </table>                                                                                               
                           
                                                                              
                    </div>
                </div>
            </div>
      
                
        <!--FIN Contenido-->
    </div>
            
        
                  
  </main>
    


    <%@include file="WEB-INF/template/footerMain.jspf" %>
    
    <script src="js/Profesores.js" type="text/javascript"></script>
   
    <!--<script src="js/gestionProfesores.js" type="text/javascript"></script>-->
   
</body>
</html>
