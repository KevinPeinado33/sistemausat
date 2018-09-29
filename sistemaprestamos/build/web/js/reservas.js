$(document).ready(function () {
    listarProducto();
    var f = new Date();
    $("#fecha").val(f.getFullYear() + "/" + (f.getMonth() + 1) + "/" + f.getDate());
});

//declaracion de variables
var listaReservados = new Array(); //arreglo para guardar los productos a emprestar por parte del profesor

$("#btnBuscar").click(function () {
    var codigo = $("#codigo").val();
    $("#nombres").val("");
    $("#idprofesor").val("");
    if (codigo !== "") {
        $.get("Pc", {"opc": 5, "dni": codigo}, function (data) {
            var x = JSON.parse(data);
            $("#nombres").val(x.nomApe);
            $("#idprofesor").val(x.idProfesor);
            if ($("#nombres").val() === "") {
                var toastContent = ('<span><i class="material-icons medium red-text">report</i></span><p>Codigo Incorrecto<p>');
                Materialize.toast(toastContent, 1500);
            }

        });
    } else {
        var toastContent = ('<span><i class="material-icons medium red-text">report</i></span><p>Ingrese codigo<p>');
        Materialize.toast(toastContent, 1500);
    }
});

function listarProducto() {
    $("#tblProductos tbody tr").remove();
    $.get("rc", {"op": 2}, function (data) {
        var w = JSON.parse(data);
        for (var i = 0; i < w.length; i++) {
            $("#tblProductos").append("<tr><td hidden>" + w[i].idProducto + "</td><td>"
                    + w[i].nomProd + "</td><td>" + w[i].codigo + "</td><td>"
                    + w[i].nomTipo + "</td><td hidden>" + w[i].stock + "</td><td>"
                    + "<a href='#' onclick='productoSeleccionado(" + w[i].idProducto + ")'>"
                    + "<i class = 'material-icons prefix'>check_circle</i></a></td</tr>");
        }
    });
}

function productoSeleccionado(w) {
    $.get("rc", {"op": 3, "idProducto": w}, function (data) {
        var x = JSON.parse(data);
        var obj = new Object();
        obj.idp = x[0].idproducto;
        obj.nombre = x[0].nomProducto;
        obj.codigo = x[0].codigo;
        añadirListado(obj);
        listarProdReservados();
    });
}

function añadirListado(objeto) {
    if (listaReservados.length > 0) {
        var j = 0;
        while (j < listaReservados.length) {
            if (listaReservados[j].codigo === objeto.codigo) {
                var toastContent = ('<span><i class="material-icons medium yellow-text">report</i></span><p>Producto en lista<p>');
                Materialize.toast(toastContent, 1500);
                j = listaReservados.length;
                objeto = null;
            }
            j++;
        }
        if (objeto !== null) {
            listaReservados.push(objeto);
        }
    } else {
        listaReservados.push(objeto);
    }
}

function listarProdReservados() {
    $("#tblRervado tbody tr").remove();
    for (var i = 0; i < listaReservados.length; i++) {
        $("#tblRervado").append("<tr><td hidden>" + listaReservados[i].idp
                + "</td><td>" + listaReservados[i].nombre + "</td><td>"
                + listaReservados[i].codigo
                + "</td><td><a href ='#' onclick='eliminar(" + i + ");'><i class='material-icons'>delete_sweep</i></a></td></tr>");
    }
}

function eliminar(q) {
    listaReservados.splice(q, 1);
    listarProdReservados();
}

$("#nomProducto").keyup(function () {
    var tableReg = document.getElementById('tblProductos');
    var searchText = document.getElementById('nomProducto').value.toLowerCase();
    for (var i = 1; i < tableReg.rows.length; i++) {
        var cellsOfRow = tableReg.rows[i].getElementsByTagName('td');
        var encontrado = false;
        for (var j = 0; j < cellsOfRow.length && !encontrado; j++) {
            var compareWith = cellsOfRow[j].innerHTML.toLowerCase();
            if (searchText.length === 0 || (compareWith.indexOf(searchText) > -1)) {
                encontrado = true;
            }
        }
        if (encontrado) {
            tableReg.rows[i].style.display = '';
        } else {
            tableReg.rows[i].style.display = 'none';
        }
    }
});

$("#btnRervar").click(function () {//funcion para guardar la reserva
    //obtenemos los valores de las variables requeridas
    var prods = JSON.stringify(listaReservados);
    var estado = 1;
    var fe_reserva = $("#fecha").val();
    var fe_devolucion = $("#fe_devolucion").val();
    var h_devolucion = $("#h_devolucion").val();
    var aula = $("#aula").val();
    var idProfe = parseInt($("#idprofesor").val());
    var fe_prestamo = $("#fe_prestamo").val();
    var h_prestamo = $("#h_prestamo").val();
    if (idProfe > 0) {
        $.post("rc", {"estado": estado, "fe_reserva": fe_reserva, "fe_devolucion": fe_devolucion, "aula": aula, "idp": idProfe, "fe_prestamo": fe_prestamo, "h_devolucion": h_devolucion, "h_prestamo": h_prestamo, "op": 4}, function (xy) {
            var idreserva = parseInt(xy);
            if (idreserva > 0) {
                $.post("rc", {"listProductos": prods, "iddr": idreserva, "op": 5}, function (data) {
                    if (data > 0) {
                        var toastContent = $('<h5 class="white-text">Reserva Realizada!</h5>');
                        Materialize.toast(toastContent, 1900);
                        cleanAll();
                    }
                });
            } else {
                var toastContent = ('<span><i class="material-icons medium red-text">report</i></span><p>Complete los datos por favor<p>');
                Materialize.toast(toastContent, 1500);

            }
        });
    } else {
        var toastContent = ('<span><i class="material-icons medium yellow-text">report</i></span><p>Por favor complete los datos<p>');
        Materialize.toast(toastContent, 1500);
    }
});

function cleanAll() {//metodo para limpiar todo el formulario
    $("#tblRervado tbody tr").remove();
    listaReservados.length = 0;
    $("#codigo").val("");
    $("#nombres").val("");
    $("#idprofesor").val("");
    $("#aula").val("");
    $("#fe_prestamo").val("");
    $("#h_prestamo").val("");
    $("#fe_devolucion").val("");
    $("#h_devolucion").val("");
    $("#nomProducto").val("");
}

$("#btnCancelar").click(function () {
    var toastContent = $('<span>Desea Cancelar la Reserva?<a class="btn-flat toast-action red-text" onclick="siCancelar();">Aceptar</a>'
            + '<a class="btn-flat toast-action red-text" onclick="no();">Cancelar</a></span>');
    Materialize.toast(toastContent, 1900);
});

function siCancelar() {
    cleanAll();
}

// complemento para el datapicker
$('.datepicker').pickadate({
    monthsFull: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
    monthsShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
    weekdaysFull: [' Dom ', ' Lun ', ' Mar ', ' Mié ', ' Jue ', 'Vie ', 'Sáb '],
    weekdaysShort: ['D', 'Lun', 'Mar', 'Mié', 'Jue', 'Vie', 'Sáb'],
    selectMonths: true,
    selectYears: 100,
    today: 'Hoy',
    clear: 'Limpiar',
    close: 'Ok',
    labelMonthNext: 'Siguiente mes',
    labelMonthPrev: 'Mes anterior',
    labelMonthSelect: 'Selecciona un mes',
    labelYearSelect: 'Selecciona un año',
    format: 'yyyy-mm-dd'
});

function irRegistroReservas() {
    if (listaReservados.length === 0) {
        $(location).attr('href', 'registrosReserva.jsp');
    } else {
        var opcion = confirm("Formulario Incompleto, ¿Desea salir?");
        if (opcion === true) {
            $(location).attr('href', 'registrosReserva.jsp');
        }
    }
}