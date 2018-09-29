$(document).ready(function () {
    desabi();
    DatosByReserva();
    deshabilitarAll();
});

var arregloReservaProd = new Array();// arreglo para guardar los datos de la reserva

var arregloProductoByIdDr = new Array();// arreglo para guardar los iddr(id de detalle reserva)

var productosReserva = new Array();//arreglo para guardar productos de la reserva-- productos antiguos

var prodCompar = new Array();// arreglo para comparar

var cantidadProd; //variable para alamcenar la cantidad de productos en el arreglo

$("#nomProducto").keyup(function () {
    var tableReg = document.getElementById('actuProd');
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

function DatosByReserva() {// imprimimos los datos necesarios para la edicion
    //1 imprimimos los productos para que sean seleccionados
    $("#actuProd tbody tr").remove();
    $.get("rc", {"op": 2}, function (data) {
        var w = JSON.parse(data);
        for (var i = 0; i < w.length; i++) {
            $("#actuProd").append("<tr><td hidden>" + w[i].idProducto + "</td><td>"
                    + w[i].nomProd + "</td><td>" + w[i].codigo + "</td><td>"
                    + w[i].nomTipo + "</td><td>" + w[i].stock + "</td><td>"
                    + "<a href='#' onclick='productoSeleccionado(" + w[i].idProducto + ")'>"
                    + "<i class = 'material-icons prefix'>check_circle</i></a></td</tr>");
        }
        // fin 1

        //imprimimos los datos de la reserva seleccionada
        //$("#reservado tbody tr").remove();// limpiamos la tabla 
        var id = $("#idresquebin").val();// obtenemos el valor del id
        var x = parseInt(id);
        //funcion get para los primero datos
        $.get("rc", {"op": 12, "idreserva": x}, function (data) {
            var w = JSON.parse(data);
            //enviamos valores a los input's
            $("#codigo_r").val(w[0].codigo);
            $("#nombres_r").val(w[0].nombres + " " + w[0].apellidos);
            $("#idprofesor").val(w[0].idprofesor);//valor oculto ID
            $("#aula_r").val(w[0].aula);
            $("#fe_prestamo_r").val(w[0].fe_prestamo);
            $("#h_prestamo_r").val(w[0].h_prestamo);
            $("#fe_devolucion_r").val(w[0].fe_devolucion);
            $("#h_devolucion_r").val(w[0].h_devolucion);
            //mostramos los datos de lista de equipos reservados
            $.get("rc", {"op": 9, "idreserva": x}, function (dtos) {
                var y = JSON.parse(dtos);
                for (var i = 0; i < y.length; i++) {
                    $("#reservado").append("<tr><td hidden>" + y[i].idreserva + "</td><td hidden>" + y[i].iddr + "</td><td hidden>" + y[i].idproducto + "</td><td>" + y[i].nomprod + "</td><td>" + y[i].codprod + "</td><td> </td></tr>");
                    // creamos el objeto y despues llenamos en 2 arreglos
                    var obj = new Object();
                    obj.idr = y[i].idreserva;
                    obj.iddr = y[i].iddr;
                    obj.idp = y[i].idproducto;
                    obj.nombre = y[i].nomprod;
                    obj.codigo = y[i].codprod;
                    prodCompar.push(obj);// llenamos estos datos para comparar los arreglos
                    productosReserva.push(obj);
                    cantidadProd = productosReserva.length;// le asignamos la cantidad de productos que llegaron
                }
            });
        });
    });
}

function desabi() {
    $('#btnAttoGM').attr("disabled", true);
}

function productoSeleccionado(w) {
    $("reservado tbody tr").remove();
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
    if (productosReserva.length > 0) {
        var j = 0;
        while (j < productosReserva.length) {
            if (productosReserva[j].codigo === objeto.codigo) {
                var toastContent = $('<span class="white-text"><b>Producto en lista!!</b></span>');
                Materialize.toast(toastContent, 1800);
                j = productosReserva.length;
                objeto = null;
            }
            j++;
        }
        if (objeto !== null) {
            productosReserva.push(objeto);
        }
    } else {
        productosReserva.push(objeto);
    }
}

function listarProdReservados() {
    $("#reservado tbody tr").remove();
    for (var i = 0; i < productosReserva.length; i++) {
        $("#reservado").append("<tr><td hidden>" + productosReserva[i].idp
                + "</td><td>" + productosReserva[i].nombre + "</td><td>"
                + productosReserva[i].codigo
                + "</td><td><a href ='#' onclick='eliminar(" + i + ");'><i class='material-icons'>delete_sweep</i></a></td></tr>");
    }
}

function eliminar(i) {
    productosReserva.splice(i, 1);
    listarProdReservados();
}

$("#btnRegresar").click(function () {
    $(location).attr('href', 'registrosReserva.jsp');
});

$("#btnActualizar").click(function () {
    listarProdReservados();
    $("#aula_r").removeAttr('disabled');
    $("#fe_prestamo_r").removeAttr('disabled');
    $("#h_prestamo_r").removeAttr('disabled');
    $("#fe_devolucion_r").removeAttr('disabled');
    $("#h_devolucion_r").removeAttr('disabled');
    $('#btnProd').attr("disabled", false);
    $('#btnAttoGM').attr("disabled", false);
    $("#btnActualizar").attr("disabled", true);
});

function deshabilitarAll() {
    $("#aula_r").attr('disabled', 'disabled');
    $("#fe_prestamo_r").attr('disabled', 'disabled');
    $("#h_prestamo_r").attr('disabled', 'disabled');
    $("#fe_devolucion_r").attr('disabled', 'disabled');
    $("#h_devolucion_r").attr('disabled', 'disabled');
    $('#btnProd').attr("disabled", true);

}
function desaAll2() {
    $("#aula_r").attr('disabled', 'disabled');
    $("#fe_prestamo_r").attr('disabled', 'disabled');
    $("#h_prestamo_r").attr('disabled', 'disabled');
    $("#fe_devolucion_r").attr('disabled', 'disabled');
    $("#h_devolucion_r").attr('disabled', 'disabled');
    $('#btnProd').attr("disabled", true);
    $('#btnAttoGM').attr("disabled", true);
    $("#btnActualizar").removeAttr("disabled");
}
$("#btnAttoGM").click(function () { // funcion para guardar cambios ---------------BUG-120
    //asginamos valores para la actualizacion
    var x = $("#idresquebin").val();
    var idr = parseInt(x);
    var aula = $("#aula_r").val();
    var fepres = $("#fe_prestamo_r").val();
    var hpres = $("#h_prestamo_r").val();
    var fedevo = $("#fe_devolucion_r").val();
    var hdevo = $("#h_devolucion_r").val();
    $.get("rc", {"op": 10, "idr": idr, "aula": aula, "fePrest": fepres, "hpre": hpres, "feDevo": fedevo, "hDevo": hdevo}, function () {
        if (cantidadProd < productosReserva.length) {// los producto se han agregado
            for (var j = 0; j < productosReserva.length; j++) {
                var queb = new Object();
                queb.idp = productosReserva[j].idp;
                queb.nombre = productosReserva[j].nombre;
                queb.codigo = productosReserva[j].codigo;
                arregloReservaProd.push(queb);
            }
            var listaa = JSON.stringify(arregloReservaProd);
            for (var o = 0; o < prodCompar.length; o++) {
                var e = prodCompar[o].iddr;
                $.get("rc", {"op": 7, "iddr": e});
            }
            $.post("rc", {"listProductos": listaa, "iddr": idr, "op": 5}, function (data) {
                if (data > 0) {
                    var toastContent = $('<h5 class="white-text">Actualización Correcta!</h5>');
                    Materialize.toast(toastContent, 1900);
                    prodCompar.length = 0;
                    desaAll2();
                    productosReserva.length = 0;
                    arregloReservaProd.length = 0;
                    cantidadProd = 0;

                    setTimeout("location.href='registrosReserva.jsp'", 1800);
                } else {
                    var toastContent = $('<h5 class="yellow-text">Oops! Algo salio mal</h5>');
                    Materialize.toast(toastContent, 1900);
                }
            });
        }

        if (cantidadProd === productosReserva.length) {// la cantidad de productos agregados
            var encuentra = false;
            for (var i = 0; i < productosReserva.length; i++) {
                encuentra = false;
                for (var j = 0; j < prodCompar.length; j++) {
                    if (productosReserva[i] === prodCompar[j]) {
                        encuentra = true;
                        break;
                    }
                }
                if (!encuentra) {
                    for (var j = 0; j < productosReserva.length; j++) {
                        var queb = new Object();
                        queb.idp = productosReserva[j].idp;
                        queb.nombre = productosReserva[j].nombre;
                        queb.codigo = productosReserva[j].codigo;
                        arregloReservaProd.push(queb);
                    }
                    var listaa = JSON.stringify(arregloReservaProd);
                    for (var o = 0; o < prodCompar.length; o++) {
                        var e = prodCompar[o].iddr;
                        $.get("rc", {"op": 7, "iddr": e});
                    }
                    $.post("rc", {"listProductos": listaa, "iddr": idr, "op": 5}, function (data) {
                        if (data > 0) {
                            var toastContent = $('<h5 class="white-text">Actualización Correcta!</h5>');
                            Materialize.toast(toastContent, 1900);
                            prodCompar.length = 0;
                            desaAll2();
                            productosReserva.length = 0;
                            arregloReservaProd.length = 0;
                            cantidadProd = 0;
                            setTimeout("location.href='registrosReserva.jsp'", 1800);
                        } else {
                            var toastContent = $('<h5 class="yellow-text">Oops! Algo salio mal</h5>');
                            Materialize.toast(toastContent, 1900);
                        }
                    });
                    break;
                }
            }
        }

        if (cantidadProd > productosReserva.length) { // los productos han menorado 
            for (var j = 0; j < productosReserva.length; j++) { // seleccion de los valores necesarios
                var queb = new Object();
                queb.idp = productosReserva[j].idp;
                queb.nombre = productosReserva[j].nombre;
                queb.codigo = productosReserva[j].codigo;
                arregloReservaProd.push(queb);
            }
            var listaa = JSON.stringify(arregloReservaProd);
            for (var o = 0; o < prodCompar.length; o++) {
                var e = prodCompar[o].iddr;
                $.get("rc", {"op": 7, "iddr": e});
            }
            $.post("rc", {"listProductos": listaa, "iddr": idr, "op": 5}, function (data) {
                if (data > 0) {
                    var toastContent = $('<h5 class="white-text">Actualización Correcta!</h5>');
                    Materialize.toast(toastContent, 1900);
                    prodCompar.length = 0;
                    desaAll2();
                    productosReserva.length = 0;
                    arregloReservaProd.length = 0;
                    cantidadProd = 0;
                    setTimeout("location.href='registrosReserva.jsp'", 1800);
                } else {
                    var toastContent = $('<h5 class="yellow-text">Oops! Algo salio mal</h5>');
                    Materialize.toast(toastContent, 1900);
                }
            });
        }

    });
    // hacemos que se recarge la pagina :)
    //location.reload();
});