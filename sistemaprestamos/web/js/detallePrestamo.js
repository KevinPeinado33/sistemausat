
$(document).ready(function () {

    listardtp();
});

/*
 * Listar Detalle Prestamo
 */
function listardtp() {
    $.get("Pc", {"opc": 2}, function (data) {
        var x = JSON.parse(data);
        var e;
        $("#tbldetpressm tbody tr").remove();
        for (var i = 0; i < x.length; i++) {
            if(x[i].nom_alumno===""){
                e="NINGUNO"
            } else{
                e=x[i].nom_alumno;
            }
            $("#tbldetpressm").append("\
<tr><td>" + (i + 1) + "</td>\n\
<td>" + x[i].nom_user + "</td>\n\
<td>" + x[i].fe_prestamo + "</td>\n\
<td>" + x[i].hora_pre + "</td>\n\
<td>" + x[i].fe_devolucion + "</td>\n\
<td>" + x[i].hora_devo + "</td>\n\
<td>" + x[i].aula + "</td>\n\
<td>" + x[i].nom_profe + "</td>\n\
<td>" + e + "</td>\n\
<td><a href='#modal1' onclick='detalleSeleccionado(" + x[i].idprestamo + ")' class='waves-effect waves-light modal-trigger' ><i class='material-icons'>remove_red_eye</i></a></td></td></tr>");
        }
    });
}

function detalleSeleccionado(x) {
    $('.modal-trigger').leanModal();
    $.get("DPC", {"idp":x,"opc": 2}, function (data) {
        var x = JSON.parse(data);
        $("#tbldetpres tbody tr").remove();
        for (var i = 0; i < x.length; i++) {
            var jop =x[i].estado;
            if (jop===1)
            {
                $("#tbldetpres").append("\
<tr><td>" + (i + 1) + "</td>\n\
<td>" + x[i].nom_prod + "</td>\n\
<td>" + x[i].codigo + "</td>\n\
<td><i class='small material-icons' style='color:#2ECC71'>check_circle</i></td></tr>");
            }
            if(jop===0)
            {
                
                $("#tbldetpres").append("\
<tr><td>" + (i + 1) + "</td>\n\
<td>" + x[i].nom_prod + "</td>\n\
<td>" + x[i].codigo + "</td>\n\
<td><i class='small material-icons' style='color:#EC7063'>cancel</i></td></tr>");
            }
            if(jop===2)
            {
                $("#tbldetpres").append("\
<tr><td>" + (i + 1) + "</td>\n\
<td>" + x[i].nom_prod + "</td>\n\
<td>" + x[i].codigo + "</td>\n\
<td><i class='small material-icons' style='color:#F1C40F'>remove_circle</i></td></tr>");
            }
            
        }
    });
} 
$("#search").keyup(function () {
    var tableReg = document.getElementById('tbldetpressm');
    var searchText = document.getElementById('search').value.toLowerCase();
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