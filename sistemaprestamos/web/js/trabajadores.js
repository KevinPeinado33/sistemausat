$(document).ready(function(){
    listarTrabajadores();
});
;
var lista=[];
function listarTrabajadores(){
    $.get("UsuCon",{"op":6},function(data){  
        var x=JSON.parse(data);
        for (var i = 0; i < x.length; i++) {
            $("#tablaTrabajadores tbody").append("<tr><td>"+x[i].idTrabajador+"</td><td>"+x[i].nomTrabajador+"</td><td>"+x[i].apelTrabajador+"</td><td>"+x[i].numCelular+"</td><td>"+x[i].numDni+"</td><td>"+x[i].email+"</td><td>"+x[i].direccion+"</td><td><a class='btn btn-primary yellow' onclick='editar("+x[i].idTrabajador+");'><i class='large material-icons'>create</i></a></td><td><a class='btn btn-primary red' onclick='eliminar("+x[i].idTrabajador+")'><i class='large material-icons'>loop</i></a></td></tr>");
            validacion();
        }
      
    });
}

function validacion(){
    var obj=new Object();
    $("#tablaTrabajadores tr").each(function () {
        obj.idTrabajador = $(this).find("td").eq(0).html();
        obj.nomTrabajador = $(this).find("td").eq(1).html();
        obj.apelTrabajador = $(this).find("td").eq(2).html();
        obj.numCelular = $(this).find("td").eq(3).html();
        obj.numDni = $(this).find("td").eq(4).html();
        obj.email = $(this).find("td").eq(5).html();
        obj.direccion = $(this).find("td").eq(6).html();
        
    });
    addObject(obj);
    listarObject();
}

function addObject(c){
    //SE EVALUA QUE EL ARRAY ESTÉ VACIO//
    if (lista.length > 0) {
        var d = 0;
        while (d < lista.length) {
            if (lista[d].nomTrabajador=== c.nomTrabajador && lista[d].numDni===c.numDni) {
                d = lista.length;
                c = null;
            }
            d++;
        }
        if (c !== null) {
            //SE AGREGAN LOS DATOS DEL OBJETO AL ARRAY//
            lista.push(c);
        }
    } else {
        //SE AGREGAN LOS DATOS DEL OBJETO AL ARRAY//
        lista.push(c);
    }
}

function listarObject() {
    //ESTO ES EL LISTADO DEL OBJETO DESPUES DE SU VALIDACION//
 $("#tablaTrabajadores tbody").remove();
   $("#tablaTrabajadores").append("<tbody></tbody>");
    for (var j = 0; j < lista.length; j++) {
        $("#tablaTrabajadores tbody").append("<tr><td>"+(j+1)+"</th><td>"+lista[j].nomTrabajador+"</td><td>"+lista[j].apelTrabajador+"</td><td>"+lista[j].numCelular+"</td><td>"+lista[j].numDni+"</td><td>"+lista[j].email+"</td><td>"+lista[j].direccion+"</td><td><a class='btn btn-primary yellow modal-trigger' href='#modal1' onclick='editar("+lista[j].idTrabajador+");'><i class='large material-icons'>create</i></a></td><td><a class='btn btn-primary red' onclick='eliminar("+lista[j].idTrabajador+");'><i class='large material-icons'>loop</i></a></td></tr>");
    }

}


function editar(id){
    $('.modal-trigger').leanModal();
    datosPersona(id);
}

var a=[];
function datosPersona(id){
    $.get("UsuCon",{"op":8,"idtra":id},function(data){  
        var x=JSON.parse(data);
        $("#tNombres").val(x[0].nomTrabajador);
        $("#tApellidos").val(x[0].apelTrabajador);
        $("#tCelular").val(x[0].numCelular);
        $("#tDNI").val(x[0].numDni);
        $("#tCorreo").val(x[0].email);
        $("#tDireccion").val(x[0].direccion);
        $("#tUsuario").val(x[0].user);
        $("#tPass").val(x[0].contrauser);
        a.push(id);
    });
}

$("#btnActualizar").click(function(){
        var id=(a[a.length-1]);
        var nom=$("#tNombres").val();
        var ape=$("#tApellidos").val();
        var cel=$("#tCelular").val();
        var dn=$("#tDNI").val();
        var cor=$("#tCorreo").val();
        var dir=$("#tDireccion").val();
        var us=$("#tUsuario").val();
        var pas=$("#tPass").val();
        
        if(nom!=="" && ape!=="" && cel.length===9 && dn.length===8 && cor!=="" && dir!=="" && us.length>6 && pas.length>5){
            $.get("UsuCon",{"op":3,"no":nom,"ape":ape,"dir":dir,"num":cel,"numDn":dn,"ema":cor,"idt":id,"user":us,"contra":pas},function(data){
                Materialize.toast("Información Actualizada con éxito", 1980);
                lista.length=0;
                $("#tablaTrabajadores tbody").remove();
                $("#tablaTrabajadores").append("<tbody></tbody>");
                listarTrabajadores();
            });
        }else{
            Materialize.toast("Modificación no cumple con los Requisitos Solicitados", 1980);
        }
        
});



function eliminar(id){
    $.get("UsuCon",{"op":7,"idt":id},function(data){ 
        lista.length=0;
        $("#tablaTrabajadores tbody").remove();
        $("#tablaTrabajadores").append("<tbody></tbody>");
        listarTrabajadores();  
    });
      
}   