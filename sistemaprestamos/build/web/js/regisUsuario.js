$(document).ready(function () {
    $("#btnCrearUsuario").attr("disabled", true);
});

var li=[];
$("#btnRegistrarTrabajador").click(function () {
    var nomusu = $("#nombres").val();
    var apellido=$("#apellidos").val();
    var celular=$("#celular").val();
    var dni=$("#dni").val();
    var email=$("#email").val();
    var direccion=$("#direccion").val();
    if(nomusu==="" && apellido==="" && celular==="" && celular==="" && dni==="" && email==="" && direccion===""){
        Materialize.toast("Complete todos los campos por favor", 1980);
    }else{
        $.get("UsuCon", {"op": 2, "nom": nomusu, "apel": apellido,"dir": direccion,"celular": celular,"numDni": dni,"email": email}, function (d) {
            var x=JSON.parse(d);
            li.push(x);
            Materialize.toast("Trabajador Registrado con éxito", 1980);
            LimpiarTra();
            $("#btnCrearUsuario").attr("disabled", false);
        });
    }
});

$("#btnRegistrarUser").click(function() {     
    var idt=li[0];
    console.log(idt);
    var nomusu = $("#nomusu").val();
    var password = $("#pass1").val();
    var pass2=$("#pass2").val();
    var cod = document.getElementById("secRol").value;
    if(nomusu!=="" && password===pass2 && password!=="" && pass2!=="" && cod!==0){
        $.get("UsuCon", {"op": 1, "usu": nomusu, "cont": pass2, "idr": cod, "idt": idt}, function (data) {
            Materialize.toast("Usuario Registrado con éxito", 1980);
            LimpiarUsu();
        });  
    }else{
        Materialize.toast("Complete todos los campos por favor", 1980);
    }
    
});

$("#nomusu").keyup(function(){
     var usuario=$("#nomusu").val();
     var lista=[];
     $.get("UsuCon",{"op":4},function(data){
        var x=JSON.parse(data);
        for (var i = 0; i < x.length; i++) {
            lista.push(x[i].user);
        }
        if(lista.includes(usuario)===false && usuario.length>6){
            $("#evaluar").append("<i id='ok' class='material-icons prefix' style='color:black;'>check</i>");
        }else{
            $("#ok").remove();
        }
     });  
});
 
$("#pass1").keyup(function(){
     var confir=$("#pass1").val();
     if(confir.length>5){
        $("#val2").append("<i id='ok2' class='material-icons prefix' style='color:black;'>check</i>");
     }else{
         $("#ok2").remove();
     }
});

$("#pass2").keyup(function(){
     var confi=$("#pass2").val();
     var pas=$("#pass1").val();
     if(confi===pas && pas.length>5){
        $("#val").append("<i id='ico' class='material-icons prefix' style='color:black;'>check</i>");
     }else{
        $("#ico").remove();
     }
});

function LimpiarTra(){
    $("#nombres").val("");
    $("#apellidos").val("");
    $("#celular").val("");
    $("#dni").val("");
    $("#email").val("");
    $("#direccion").val("");
}

function LimpiarUsu(){
    $("#nomusu").val("");
    $("#pass1").val("");
    $("#pass2").val("");
    $("#ok2").remove();
    $("#ok").remove();
    $("#ico").remove();
    $("#btnCrearUsuario").attr("disabled", true);
}