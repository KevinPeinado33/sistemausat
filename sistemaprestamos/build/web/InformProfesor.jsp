<%-- 
    Document   : InformProfesor
    Created on : 23-jul-2018, 17:21:38
    Author     : dieguito
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
            String id = request.getParameter("idProfesor");
        %>
        
        
        <%
            try{
             HttpSession sesion = request.getSession();
                 if(sesion.getAttribute("idr")==null){
                     response.sendRedirect("logeoUsu.jsp");
                    	
                 }
                 else{
                     String rol = sesion.getAttribute("idr").toString();
                     if(rol.equals("2")){
        %><%@include file="WEB-INF/template/Principal.jspf"%><%	
                    }
                                         
                     if(rol.equals("1")){
        %><%	response.sendRedirect("login.jsp");
                    } 
                 }                                                                   
                 
            }
         catch(Exception e){
             System.out.println("Error: "+e);
                 
         }
        %>
         
         <main class="mn-inner">
              <input id="idP" value="<%=id%>" hidden>
             <nav class="teal lighten-2" style="margin-top: -20px;">
                 <div class="nav-wrapper">
                     <div class="col s12">
                         <a href="tablaProfesores.jsp" class="breadcrumb">Gestion Profesores</a>
                         <a href="InformProfesor.jsp" class="breadcrumb">Ver Profesor</a>  
                     </div>
                 </div>
             </nav>
            
             <div class="row" style="margin-top: 30px;">
                 <div class="col s3">
                     <div class="card">
                         <div class="card-content">    
                               <div class="row center">
                               <img src="images/profesor.png" alt=""/>
                               </div>
                                
                                <div class="row center">
                                    <label style="font-size: 15px;color:black;" id="nombres"></label><br> 
                                    
                                </div>
                                
                             <div class="container">
                                <div class="row ">
                                    Dni: <label id="dni"></label><br>
                                    Codigo: <label id="codigo"></label><br>
                                    Celular: <label id="celular"></label><br>
                                    Email:<label id="email"></label><br>
                                    Grado: <label id="grado"></label><br>
                                    Escuela: <label id="escuela"></label><br>
                                    Direccion: <label id="direccion"></label><br>
                                </div>
                             </div>
                             
                             
                             
                             
                         </div>    
                     </div>
                 </div>
                  <div class="col s9">
                      <div class="card" >
                          <div class="card-content">
                              <div class="row">
                                  <div class="col s12">
                                      <ul class="tabs">
                                          <li class="tab col s3"><a href="#test1">Editar Profesor</a></li>
                                          <li class="tab col s3"><a class="active" href="#test2">Lista de Prestamos</a></li>
                                         
                                      </ul>
                                  </div>
                                  <div id="test1" class="col s12">
                                      
                                      <div class="container" >
                                          
                                          <div class="row" style="margin-top:20px;">
                                              <div class="input-field col s4">
                                                <input placeholder="Placeholder" id="txtnombre" type="text" class="validate">
                                                <label for="first_name" class="active">Nombres</label>
                                              </div> 
                                          
                                              <div class="input-field col s4">
                                                  <input placeholder="Placeholder" id="txtapellido" type="text" class="validate">
                                                  <label for="first_name" class="active">Apellidos</label>
                                              </div>   
                                              
                                              <div class="input-field col s4">
                                                  <input placeholder="Placeholder" id="txtdni" type="text" class="validate">
                                                  <label for="first_name" class="active">Dni</label>
                                              </div> 
                                          </div>
                                          
                                          <div class="row">
                                              <div class="input-field col s4">
                                                  <input placeholder="" id="txtcelular" type="text" class="validate">
                                                  <label for="txtcelular" class="active">Celular</label>
                                              </div> 

                                              <div class="input-field col s4">
                                                  <input placeholder="" id="txtdireccion" type="text" class="validate">
                                                  <label for="first_name" class="active">Dirección</label>
                                              </div>   

                                              <div class="input-field col s4">
                                                  <input placeholder="" id="txtemail" type="text" class="validate">
                                                  <label for="first_name" class="active">Email</label>
                                              </div> 
                                          </div>                                                                                   
                                          
                                          <div class="row">
                                              <div class="input-field col s5">                                               
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
                                              <div class="col s2 center-align">
                                                  <a class="btn-floating btn-medium waves-effect waves-light blue-grey" id="btnMostrar"><i class="material-icons">keyboard_arrow_right</i></a>
                                              </div>

                                              <div class="input-field col s5">
                                                  <select id="comboEscuela" name="selectBox">
                                                      <option value="0" disabled selected>Escuelas de la UPeU</option>             
                                                  </select>
                                                  <label>Escuelas</label>
                                              </div>

                                          </div>
                                          
                                          <div class="row">    
                                              <div class="col s12 left">
                                              
                                                  <a class="waves-effect waves-light btn" id="editar">Editar</a>
                                              
                                              </div>
                                          
                                          </div>
                                      </div>
                                  </div>
                                  
                                  
                                  
                                  <div id="test2" class="col s12">
                                  <table id="tblprestamos">
                                      <thead>
                                          <tr>
                                              <th>Fecha Prestamo</th>
                                              <th>Fecha Devolucion</th>
                                              <th>Hora Prestamo</th>
                                              <th>Hora Devolucion</th>                                              
                                              <th>Estado</th>
                                            
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
                
          
             
            
                
             
                 
          
              
              
              
                 
         </main>
         <!--FIN Contenido-->
  
    <div class="left-sidebar-hover"></div>
         
         
        <%@include file="WEB-INF/template/footerMain.jspf" %>
        <script src="js/DatosProfesor.js" type="text/javascript"></script>
    </body>
</html>
