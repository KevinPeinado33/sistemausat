$(document).ready(function () {
    cardVer();

});

function cardVer() {
    var id = $("#idP").val();
    var idpars = parseInt(id);
    $.get("pc", {"op": 2, "idp": idpars}, function (data) {
        var w = JSON.parse(data);
          
        $("#nombres").text(w[0].nombres + " " + w[0].apellidos);
        $("#dni").text(w[0].numDni);
        $("#codigo").text(w[0].codigo);
        $("#celular").text(w[0].numCelular);
        $("#email").text(w[0].email);
        $("#grado").text(w[0].grado);
        $("#escuela").text(w[0].nomEscuela);
        $("#direccion").text(w[0].direccion);

        $("#txtnombre").val(w[0].nombres);
        $("#txtapellido").val(w[0].apellidos);
        $("#txtdni").val(w[0].numDni);
        $("#txtcodigo").val(w[0].codigo);
        $("#txtcelular").val(w[0].numCelular);
        $("#txtemail").val(w[0].email);
        $("#txtgrado").val(w[0].grado);
        $("#txtescuela").val(w[0].nomEscuela);
        $("#txtdireccion").val(w[0].direccion);
        actualizapro();
    });
}

$("#btnMostrar").click(function () {
    var x = $("#secFacultad").val();
    var idf = parseInt(x);
    if (idf !== 0) {
        $.get("pc", {"op": 3, "idf": idf}, function (data) {
            var w = JSON.parse(data);
            for (var i = 0; i < w.length; i++) {
                $("#comboEscuela").append(
                        "<option value='" + w[i].idEscuela + "'>" + w[i].nomEscuela + "</option>");
            }
            $("#comboEscuela").material_select();
        });
        $("#comboEscuela option").remove();
    } else {
        alert("seleccione un valor para la caja de texto");
    }

});


function actualizapro() {
    var id = $("#idP").val();
    var idpars = parseInt(id);
    $.get("pc", {"idProf": idpars, "op": 8}, function (datas) {
        var w = JSON.parse(datas);
        for (var i = 0; i < w.length; i++) {
            if (w[i].esta === "1")
            {

                $("#tblprestamos").append("<tr><td hidden>" + w[i].idprestamo + "</td><td>"
                        + w[i].fechaP + "</td><td>" + w[i].fechaD + "</td><td>"
                        + w[i].horaP + "</td><td>" + w[i].horaD + "</td><td><i class = 'material-icons prefix'>do_not_disturb_on</i></td></tr>");

            }
            if (w[i].esta === "0")
            {

                $("#tblprestamos").append("<tr><td hidden>" + w[i].idprestamo + "</td><td>"
                        + w[i].fechaP + "</td><td>" + w[i].fechaD + "</td><td>"
                        + w[i].horaP + "</td><td>" + w[i].horaD + "</td><td><i class = 'material-icons prefix'>done_all</i></td></tr>");
            }


        }

    });
}



$("#editar").click(function () {

    var id = $("#idP").val();
    var idpars = parseInt(id);
    var nombre = $("#txtnombre").val();
    var apellido = $("#txtapellido").val();
    var dni = $("#txtdni").val();
    var celular = $("#txtcelular").val();
    var email = $("#txtemail").val();
    var escuela = $("#txtescuela").val();
    var direccion = $("#txtdireccion").val();
    var combo = $("#comboEscuela").val();
    var idparss = parseInt(combo);

    $.post("pc", {
        "id": idpars,
        "nombre": nombre,
        "apellido": apellido,
        "dni": dni,
        "celular": celular,
        "direccion": direccion,
        "email": email,
        "ides": idparss,
        "op": 5}, function () {             
        location.href = "tablaProfesores.jsp";        
    });
});


function verproductos(x) {
    var idf = parseInt(x);
    $('.modal-trigger').leanModal();
    $.get("pc", {"idPres": idf, "op": 9}, function (datas) {
        var w = JSON.parse(datas);
        for (var i = 0; i < w.length; i++) {
            $("#tablita").append("<tr><td>" + w[i].nombre + "</td></tr>");

        }
    });

}
//idProf
