<%-- 
    Document   : Menu
    Created on : 05/07/2018, 06:43:38 PM
    Author     : Quebin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="icon" href="images/lo.png" sizes="24x24">
        <%@include file="WEB-INF/template/headerMain.jspf" %>            
        <title>Menu Principal</title>
        <style>
            a{          
                transition: transform .2s; /* Animation */            
            }
            a:hover {
                transform: scale(1.5); /* (150% zoom - Note: if the zoom is too large, it will go outside of the viewport) */
            }          
            #nombresito{
                font-size: 40px;
            }
        </style>

    </head>
    <body>
        <%
            try {
                HttpSession sesion = request.getSession();
                if (sesion.getAttribute("idr") == null) {
                    response.sendRedirect("login.jsp");

                }

            } catch (Exception e) {
                System.out.println("Error: " + e);

            }
        %>

        <div id="loader-wrapper">
            <div id="loader"></div>
            <div class="loader-section section-left"></div>
            <div class="loader-section section-right"></div>
        </div>

        <header class="mn-header navbar-fixed">
            <nav class="blue-grey">
                <div class="nav-wrapper row">
                    <div class="header-title col s3">          
                        <div class="row">
                            <div class="col s2" style="margin-top: 8px;">
                                <img class="responsive-img" src="images/lo.png" style="max-width: 30px;">
                            </div>
                            <div class="col s2"><b class="brand-logo" style="font-size:20px;">PRESUP</b></div>
                            <div class="col s7"></div>
                        </div>
                    </div>

                </div>
            </nav>
        </header>


        <div class="container" style="width:1500px;margin-top:160px;">                                                                                                                          
            <div style="">
                <div class="row center">
                    <div class="col s3">
                        <a href="registrosReserva.jsp" class="btn-floating btn-large waves-effect waves-light blue-grey center" style="margin-bottom:30px;width: 150px;height: 150px;" >
                            <i class="material-icons" style="font-size:100px;position: absolute;top: 50px;left:0px;">assignment</i></a>
                        <p class="title bold" id="nombresito">Registros de Reservas</p>
                    </div>
                    <div class="col s3">
                        <a href="reservas.jsp" class="btn-floating btn-large waves-effect waves-light green center" style="margin-bottom:30px;width: 150px;height: 150px;" >
                            <i class="material-icons" style="font-size:100px;position: absolute;top: 50px;left:0px;">date_range</i></a>
                        <p class="title bold" id="nombresito">Gestionar Reserva</p>
                    </div>    
                    <div class="col s3">
                        <a href="Prestamo.jsp" class="btn-floating btn-large waves-effect waves-light blue center" style="margin-bottom:30px;width: 150px;height: 150px;" >
                            <i class="material-icons" style="font-size:100px;position: absolute;top: 50px;left:0px;">developer_board</i></a>
                        <p class="title bold" id="nombresito">Gestionar Prestamo</p>
                    </div> 
                    <div class="col s3">
                        <a href="devolucion.jsp" class="btn-floating btn-large waves-effect waves-light red center" style="margin-bottom:30px;width: 150px;height: 150px;" >
                            <i class="material-icons" style="font-size:100px;position: absolute;top: 50px;left:0px;">devices_other</i></a>
                        <p class="title bold" id="nombresito">Gestionar Devolución</p>
                    </div> 

                </div>
            </div>                                                
        </div>                                                                                                                                                                        
        <%@include file="WEB-INF/template/footerMain.jspf" %>
        <script src="js/menu.js" type="text/javascript"></script>
    </body>
</html>
