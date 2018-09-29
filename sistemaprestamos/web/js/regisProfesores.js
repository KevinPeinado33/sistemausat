$(document).ready(function () {
    //$('select').formSelect();
    //$("#secEscuela").formSelect();

});




$("#secFacultad").on('change', function () {
    var value = $(this).val();
    var idf = parseInt(value);

    $.get("pc", {"op": 3, "idf": idf}, function (data) {
        var w = JSON.parse(data);
        for (var i = 0; i < w.length; i++) {
            $("#comboEscuela").append(
                    "<option value='" + w[i].idEscuela + "'>" + w[i].nomEscuela + "</option>");
        }
        $("#comboEscuela").material_select();
    });
    $("#comboEscuela option").remove();

});
/*
 $("#btnMostrar").click(function () {
 var x = $("#secFacultad").val();
 var idf = parseInt(x);   
 $.get("pc", {"op": 3, "idf": idf}, function (data) {
 var w = JSON.parse(data);
 for (var i = 0; i < w.length; i++) {  
 $("#comboEscuela").append(
 "<option value='"+w[i].idEscuela+"'>"+w[i].nomEscuela+"</option>");
 }            
 $("#comboEscuela").material_select();
 });
 $("#comboEscuela option").remove();      
 });
 */

$("#btnRegistrar").click(function () {

    var nombres = $("#nombres").val();
    var apellidos = $("#apellidos").val();
    var celular = $("#celular").val();
    var email = $("#email").val();
    var direccion = $("#direccion").val();
    var grado = $("#grado").val();
    var dni = $("#dni").val();// dni
    var codigo = $("#codigo").val();
    var x = $("#comboEscuela").val();
    var ide = parseInt(x);

    if (nombres === "" || apellidos === "" || celular === "" || email === "" || direccion === "" || grado === "" || dni === "" || codigo === "") {
        var toastContent = ('<span><i class="material-icons medium red-text">report</i></span><p>Complete los datos por favor<p>');
        Materialize.toast(toastContent, 1500);

    } else {
        $.get("pc", {"op": 4, "nombres": nombres, "apellidos": apellidos, "celular": celular, "email": email, "direccion": direccion, "grado": grado, "dni": dni, "codigo": codigo, "escuela": ide, "estado": 1}, function () {
            var toastContent = ('<span><i class="material-icons medium green-text">assignment_turned_in</i></span><p>Profesor registrado<p>');
            Materialize.toast(toastContent, 1500);
            limpiar();
        });
    }

});


function limpiar() {
    $("#nombres").val("");
    $("#apellidos").val("");
    $("#celular").val("");
    $("#email").val("");
    $("#direccion").val("");
    $("#grado").val("");
    $("#dni").val("");
    $("#codigo").val("");
}
function valida(e) {
    tecla = (document.all) ? e.keyCode : e.which;

    //Tecla de retroceso para borrar, siempre la permite
    if (tecla === 8) {
        return true;
    }

    // Patron de entrada, en este caso solo acepta numeros
    patron = /[0-9]/;
    tecla_final = String.fromCharCode(tecla);
    return patron.test(tecla_final);
}

function soloLetras(e) {
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
    especiales = [8, 37, 39, 46];

    tecla_especial = false;
    for (var i in especiales) {
        if (key === especiales[i]) {
            tecla_especial = true;
            break;
        }
    }

    if (letras.indexOf(tecla) === -1 && !tecla_especial)
        return false;
}
function limpia() {
    var val = document.getElementById("nombres").value;
    var tam = val.length;
    for (i = 0; i < tam; i++) {
        if (!isNaN(val[i]))
            document.getElementById("nombres").value = '';
    }
}
function limpia2() {
    var val = document.getElementById("apellidos").value;
    var tam = val.length;
    for (i = 0; i < tam; i++) {
        if (!isNaN(val[i]))
            document.getElementById("apellidos").value = '';
    }
}


document.getElementById("email").addEventListener('keyup', sanear);

function sanear(e) {
  let contenido = e.target.value;
  e.target.value = contenido.toUpperCase().replace(" ", "");
}