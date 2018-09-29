$(document).ready(function ()
{
    listar();


});

function listar()
{
    $.get("pro", {"op": 1}, function (data) {
        var bibi = JSON.parse(data);
        var jop;
        $("#tablin tbody tr").remove();
        for (var i = 0; i < data.length; i++) {
            jop = bibi[i].est;
            if (jop === 1)
            {
                $("#tablin").append("<tr><td>" + (i + 1) + "</td><td>" + bibi[i].nom + "</td><td>" + bibi[i].cod + "</td><td>"
                        + "<p><i class='small material-icons' style='color:#2ECC71'>check_circle</i></p>" + "</td><td>" + bibi[i].nomTip + "</td><td><a class='waves-effect waves-light btn-floating red' onclick='eco(" + bibi[i].idP + ")'><i class='material-icons'>delete_forever</i></a></td><td><a class='waves-effect waves-light btn-floating modal-trigger' href='#modal2' onclick='nop(" + bibi[i].idP + ")'><i class='material-icons'>update</i></a></td></tr>");
            }
            if (jop === 0)
            {
                $("#tablin").append("<tr><td>" + (i + 1) + "</td><td>" + bibi[i].nom + "</td><td>" + bibi[i].cod + "</td><td>"
                        + "<p><i class='small material-icons' style='color:#EC7063'>cancel</i></p>" + "</td><td>" + bibi[i].nomTip + "</td><td><a class='waves-effect waves-light btn-floating red' onclick='eco(" + bibi[i].idP + ")'><i class='material-icons'>delete_forever</i></a></td><td><a class='waves-effect waves-light btn-floating modal-trigger' href='#modal2' onclick='nop(" + bibi[i].idP + ")'><i class='material-icons'>update</i></a></td></tr>");
            }
            if (jop === 2)
            {
                $("#tablin").append("<tr><td>" + (i + 1) + "</td><td>" + bibi[i].nom + "</td><td>" + bibi[i].cod + "</td><td>"
                        + "<p><i class='small material-icons' style='color:#F1C40F'>remove_circle</i></p>" + "</td><td>" + bibi[i].nomTip + "</td><td><a class='waves-effect waves-light btn-floating red' onclick='eco(" + bibi[i].idP + ")'><i class='material-icons'>delete_forever</i></a></td><td><a class='waves-effect waves-light btn-floating modal-trigger' href='#modal2' onclick='nop(" + bibi[i].idP + ")'><i class='material-icons'>update</i></a></td></tr>");
            }
        }
    });
}
function eliminar(x) {
    $.get("pro", {"idP": x, "op": 3}, function () {
        listar();

    });
}
function ji() {
    var toastHTML = '<span>Seguro que desea editar?<button class="btn-flat toast-action" onclick="jip()">Aceptar</button></span>';
    Materialize.toast(toastHTML, 1980);

}
function nop(x)
{
    idpro = x;
    $('.modal-trigger').leanModal();


}
function jip()
{
    var jip = $('#loc').val();
    var ip = parseInt(idpro);
    $('input[type="text"]').val('');
    $.get("pro", {"op": 4, "idP": ip, "est": jip}, function (data) {
        listar();
    });


}


function modal() {
    $('.modal-trigger').leanModal();
    $.post("pro", {"op": 8}, function (data) {
        var w = JSON.parse(data);
        for (var i = 0; i < w.length; i++) {
            $("#combin").append(
               "<option value='" + w[i].iTip + "'>" + w[i].nomTip + "</option>");
                    
        }
        $("#combin").material_select();
        
    });


}

function salva()
{
    var jop = $('#pro').val();
    var kop = $('#codi').val();
    var jip = $('#loco').val();
    var x = $("#combin").val();
    var ide = parseInt(x);
    $("#combin").remove();
 $('input[type="text"]').val('');
    $.post("pro", {"nom": jop, "cod": kop, "est": jip, "iTip": ide, "op": 2}, function ()
    {
        
        console.log("controlador op 2");
        listar();
    });
    var unito = '<span>Producto guardado correctamente</span>';
    Materialize.toast(unito, 1980);


}
function unin(x) {
    var toastHTML = '<span>Seguro que desea editar?<button class="btn-flat toast-action" onclick="ok(' + x + ')">Aceptar</button></span>';
    Materialize.toast(toastHTML, 1980);

}


function eco(x) {

    var toastContent = $('<span>Seguro que desea eliminar?<button class="btn-flat toast-action" onclick="eliminar(' + x + ')">Aceptar</button></span>');
    Materialize.toast(toastContent, 1980);

}
$("#nomp").keyup(function () {
    var tableReg = document.getElementById('tablin');
    var searchText = document.getElementById('nomp').value.toLowerCase();
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

function esta()
{
    var tiu = $('#tip').val();
     $('input[type="text"]').val('');
    if (tiu != "")
    {
        $.post("pro", {"nomTip": tiu, "op": 6}, function ()
        {
            console.log(6);
            var toastHTML = '<span>Tipo guardado correctamente</span>';
            Materialize.toast(toastHTML, 1980);
        });

    } else
    {
        var jipoe = '<span>Ingrese un valor</span>';
        Materialize.toast(jipoe, 1980);
    }


}

$("#btnActu").click(function () {
    var nom = $("#no").val();
    var idt = $("#idt").val();
    $.post("pro", {"idTipo": idt, "nomTip": nom, "op": 9}, function () {
        var holi = '<span>Tipo actualizado correctamente</span>';
        Materialize.toast(holi, 1980);
        moto();
    });

});

function moto()
{
    $('.modal-trigger').leanModal();
    $.get("pro", {"op": 7}, function (data) {
        var bibi = JSON.parse(data);
        $("#tabp tbody tr").remove();
        for (var i = 0; i < data.length; i++) {
            if (bibi[i].st = bibi[i].st ? bibi[i].st : 0)
            {
                $("#tabp").append("<tr><td hidden>" + (i + 1) + "</td><td>" + bibi[i].no + "</td><td>" + bibi[i].st + "</td><td><a class='waves-effect waves-light btn-floating modal-trigger' href='#modal16' onclick='pris(" + bibi[i].loco + ")'><i class='material-icons'>update</i></a></td></tr>");

            } else
            {
                $("#tabp").append("<tr><td hidden>" + (i + 1) + "</td><td>" + bibi[i].no + "</td><td>" + bibi[i].st + "</td><td><a class='waves-effect waves-light btn-floating modal-trigger' href='#modal16' onclick='pris(" + bibi[i].loco + ")'><i class='material-icons'>update</i></a></td></tr>");
            }


        }
    });
}

function pris(id) {
    $('.modal-trigger').leanModal();
    $.get("pro", {"op": 11, "idt": id}, function (data) {
        var x = JSON.parse(data);
        $("#no").val(x[0].nom);
        $("#idt").val(x[0].idt);
    });
}
