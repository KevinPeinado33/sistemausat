$(document).ready(function () {
    listarRegisProfesores();
    /**console.log("funciona: JQUERY");
    $('select').formSelect();*/
   
    
});

/**
 * funciones para abrir otros .jsp's
 */
$("#btnRegistrar").click(function () {
    $(location).attr('href', 'registrarProfesores.jsp');
});
$("#btnRegistro").click(function () {
    $(location).attr('href', 'tablaProfesores.jsp');
});

/**
 * funciones para el crud de profesor
 */

function listarRegisProfesores(){
    $.get("pc",{"op":1}, function (datos) {
        
        var data = JSON.parse(datos);
        $("#tblProfesores tbody tr").remove();
       
        for (var i = 0; i < data.length; i++) {
                              
        $("#tblProfesores").append("<tr><td>" + data[i].dni + "</td><td>" + data[i].codigo+"</td><td>"+data[i].nombres + "</td><td>"
        + data[i].apellidos+
        "</td><td><form action='InformProfesor.jsp' method='POST'><input type='text' value='"+ data[i].idProfesor +"' name='idProfesor' hidden><button class='btn-floating red' onclick='verProfesor(" + data[i].idProfesor + ");'><i class='material-icons'>portrait</i></button></td><td><a  class='btn-floating' onclick='eliminarr(" + data[i].idProfesor + ")'><i class='material-icons'>delete</i></a></td></tr></tr>");                      
        }
    });
}

function verProfesor(x){        
    
       var ids=x.toString();
      $("#lol").val(ids);
       window.location='InformProfesor.jsp';  
        
}


function eliminarr(s){        
    alert(s);  
        
}





