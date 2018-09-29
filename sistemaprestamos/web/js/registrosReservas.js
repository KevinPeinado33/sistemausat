$(document).ready(function () {
    //listarRegistroReservas();
    listarProductoActu();
    listarRegistroReserva();
});

var listData = new Array();//arreglo para la data de la bd -- reportes de reservas

var listRepeatIddr = new Array();//arreglo para guardar los idDetalle_Reserva  --reporte de reservas

function listarRegistroReserva() {
    $.post("rc", {"op": 6}, function (data) {
        var x = JSON.parse(data);
        for (var i = 0; i < x.length; i++) {
            var objeto = new Object();
            objeto.idr = x[i].idReserva;
            objeto.feRe = x[i].feReserva;
            objeto.idpro = x[i].idprofesor;
            objeto.nombres = x[i].nomProfesor + " " + x[i].aplProfesor;
            objeto.dni = x[i].dni;
            objeto.iddr = x[i].iddr;

            if (listData.length > 0) {// comparamos datos
                var j = 0;
                while (j < listData.length) {
                    if (listData[j].idr === objeto.idr) {
                        var q = new Object();
                        q.idRev = objeto.idr;
                        q.idDRv = objeto.iddr;
                        listRepeatIddr.push(q);
                        j = listData.length;
                        objeto = null;
                    }
                    j++;
                }
                if (objeto !== null) {
                    listData.push(objeto);//se mete el obj al arrego
                    var q = new Object();
                    q.idRev = objeto.idr;
                    q.idDRv = objeto.iddr;
                    listRepeatIddr.push(q);
                }
            } else {
                listData.push(objeto);// si sta vacia se me te al arreglo
                var q = new Object();
                q.idRev = objeto.idr;
                q.idDRv = objeto.iddr;
                listRepeatIddr.push(q);
            }
        }

        $("#tblRegistro tbody tr").remove();//listamos los datos filtrados 
        for (var i = 0; i < listData.length; i++) {
            $("#tblRegistro").append("<tr><td>"
                    + listData[i].feRe + "</td><td>"
                    + listData[i].nombres + "</td><td hidden>"
                    + listData[i].codigo + "</td><td>"
                    + listData[i].dni
                    + "</td><td><form action='editarReserva.jsp' method='POST'><input type='text' value='" + listData[i].idr + "' name='idr' hidden><button type='submit' class='material-icons' style='background:none;border:none; color:blue'>remove_red_eye</button></form></td>\n\
                    <td><a href = '#' onclick='eliminarReserva(" + listData[i].idr + ")'><i class='material-icons red-text'>delete_sweep</i></a></td>\n\
                    <td><form action='Prestamo.jsp' method='POST'><input type='text' value='"+ listData[i].idr +"' name='idr' hidden><button type='submit' class='material-icons' style='background:none;border:none; color:green'>featured_play_list</button></form></td></tr>");
        }
    });
}
function listarProductoActu() {
    $("#actuProd tbody tr").remove();
    $.get("rc", {"op": 2}, function (data) {
        var w = JSON.parse(data);
        for (var i = 0; i < w.length; i++) {
            $("#actuProd").append("<tr><td>" + w[i].idProducto + "</td><td>"
                    + w[i].nomProd + "</td><td>" + w[i].codigo + "</td><td>"
                    + w[i].nomTipo + "</td><td>" + w[i].stock + "</td><td>"
                    + "<a href='#' onclick='productoSeleccionado(" + w[i].idProducto + ")'>"
                    + "<i class = 'material-icons prefix'>check_circle</i></a></td</tr>");
        }
    });
}

function eliminarReserva(idr) {
    var newArr = listRepeatIddr.filter(function (quebin) {//filatramo el arreglo
        return (quebin.idRev === idr);
    });
    newArr.map(function (bar) {//imprimimos el arreglos filtrado de acuerdo a la busqueda
        var e = bar.idDRv;
        $.get("rc", {"op": 7, "iddr": e}, function () {
            $.get("rc", {"op": 8, "idr": idr}, function () {
                listarRegistroReserva();
                listData.length = 0; 
                listRepeatIddr.length = 0;
            });
        });
    });
}

$("#filtNom").keyup(function () {
    var tableReg = document.getElementById('tblRegistro');
    var searchText = document.getElementById('filtNom').value.toLowerCase();
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


/// PARTE PARA GERSON MALCA CODIGO

