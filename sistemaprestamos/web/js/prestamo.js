$(document).ready(function () {
    ListarProd();
    VerificacionReserva();
    ListarDoc();
    var f = new Date();
    $("#fecha_pre").val( f.getDate() + " / " + (f.getMonth() + 1) + " / " + f.getFullYear());
});
function ListarProd() {
    $.get("Pc", {"opc": 4}, function (data) {
        var x = JSON.parse(data);
        $("#tablaPrestamo tbody tr").remove();
        for (var i = 0; i < x.length; i++) {
            if (x[i].estado === 0) {
                var e = "Mal estado";
            }
            if (x[i].estado === 1) {
                var e = "Buen estado";
            }
            if (x[i].estado === 2) {
                var e = "Estado intermedio"; 
            }
            $("#tablaPrestamo").append("<tr><td>" + (i + 1) + "</td><td>" + x[i].nomProd + "</td><td>" + x[i].codigo + "</td><td>" + e + "</td><td>" + x[i].nomTipo + "</td><td style='text-align:center'>" + x[i].stock + "</td>\n\
            <td><a href='#' id='bt"+x[i].idProducto+"' class='material-icons' style='background:none;border:none; color:lightblue' onclick='productoSeleccionado("+x[i].idProducto+")'>check_circle</a></td></tr>");       
        }
    });
}
$("#searchpro").keyup(function () {
    var tableReg = document.getElementById('tablaPrestamo');
    var searchText = document.getElementById('searchpro').value.toLowerCase();
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
$("#registrarPrestamo").click(function () {
    var produ = [];
    var alum = $("#responsable").val();
    //var fe_pre = $("#fecha_pre").val();
    var fe_dev = $("#fechadev").val();
    //var h_pre = $("#hora_pre").val();
    var h_dev = $("#hora_dev").val();
    var aul = $("#aula").val();
    var prof = $("#prof").val();
    var docu;
    if(alum===""){
        docu= 5;
    }
    else{
        docu= $("#docu").val();
    }
    var user = $("#idu").val();   
    if(fe_dev==="dd/mm/aaaa" || aul==="" || prof==="" || user===""){
        Materialize.toast("Completar todos los campos de datos", 1980);
    }
    else  {
        if($("#tablaDetalle tbody tr").length===0)
        {
            Materialize.toast("No hay equipos seleccionados", 1980);
        }
        else{
            $.post("Pc", {"alu": alum, "fe_devo": fe_dev, "horadev": h_dev, "aula": aul, "prof": prof, "docu": docu, "user": user, "opc": 1}, function (data) {
              var x = JSON.parse(data);
                if(x===0){
                    Materialize.toast("Error, prestamo no realizado!", 1980); 
                }
                else{
                    $('#tablaDetalle tbody tr').each(function () {
                    
                    var nom = $(this).find("td").eq(0).text();
                    produ.push(nom);
                    });
                        $.ajax({
                           url: "DPC",
                           type:'POST',
                           dataType:'json',
                           data: {
                               opc:1,
                               idp:x,
                               prod:produ
                           },
                           success:function(data){
                               if (data>0){
                               }
                           },
                           error:function(){
                               
                           }
                        });
                    produ=[];  
                   Materialize.toast("Prestamo exitoso", 1980); 
                   setTimeout("location.href='Prestamo.jsp'", 2100);
                   var idrr = $("#ress").val();
                    if(idrr!=="null"){
                        $.post("Pc",{"idres":idrr,"opc":8},function(){ 
                    });
                    }
                }
            });
        } 
     
   } 
});

function productoSeleccionado(x){
    $.get("Pc", {"id":x,"opc": 7}, function (data) {
        var y = JSON.parse(data);
        if(document.getElementById("bt"+y.idP+"").style.color === 'green')
        {
           Materialize.toast("El equipo ya esta en la lista!", 1980);  
        }
        else{
            if (y.est === 0) {
                var e = y.est = "Mal estado";

            }
            if (y.est === 1) {
                var e = y.est = "Buen estado";

            }
            if (y.est === 2) {
                var e = y.est = "Estado intermedio";

            }
        $("#tablaDetalle").append("<tr><td hidden>"+y.idP+"</td><td>" + y.nom + "</td><td>" + e + "</td><td>" + y.nomTip + "</td>\n\
        <td><button class='material-icons prefix' style='background:none;border:none; color:#D84A52' onclick='eliminarEquipo(this.parentNode.parentNode.rowIndex,"+y.idP+")'>highlight_off</button></td></tr>");
        document.getElementById("bt"+y.idP+"").style.color = 'green';
        }
     });
}

$("#dnipro").keyup(function () {
    var dni = $("#dnipro").val();
    if (dni.length === 8)
    {
        $.get("Pc", {"dni": dni, "opc": 5}, function (data) {
            var x = JSON.parse(data);
            $("#profe").val(x.nomApe);
            $("#prof").val(x.idProfesor);
            if($("#profe").val()===""){
            Materialize.toast("Error! ingresar DNI de un profesor",1980);
        }
        });
    }
});
$("#responsable").keyup(function () {

    if ($("#responsable").val() !== "" )
    {
        $('#docu').prop("disabled", false);
        $('#docu').material_select();
    }
    else{
        $('#docu').prop("disabled", true);
        $('#docu').material_select();
    }
});
function ListarDoc() {
    $.get("Pc", {"opc": 6}, function (data) {
        var x = JSON.parse(data);
        for (var i = 0; i < x.length; i++) {
            $("#docu").append("<option value='" + x[i].id + "'>" + x[i].nombre + "</option>");
        }
        $("#docu").material_select();
    });
}
function VerificacionReserva(){
        var x = $("#ress").val();
        if(x!=="null"){
            $.get("Pc", {"idd":x,"opc": 11}, function (data) {
            var y = JSON.parse(data);
            var e;
            for (var i = 0; i < y.length; i++) {
                document.getElementById("bt"+ y[i].idP +"").style.color = 'green';
                if (y[i].est === 0) {
                e  = "Mal estado";
            }
            if (y[i].est === 1) {
                e  = "Buen estado";

            }
            if (y[i].est === 2) {
                e = "Estado intermedio";

            }
                $("#tablaDetalle").append("<tr><td hidden>"+ y[i].idP +"</td><td>" + y[i].nom + "</td><td>" + e + "</td><td>" + y[i].nomTip + "</td>\n\
                <td><button class='material-icons prefix' style='background:none;border:none; color:#D84A52' onclick='eliminarEquipo(this.parentNode.parentNode.rowIndex,"+y[i].idP+")'>highlight_off</button></td></tr>");
            }
            $.get("Pc", {"idr":x,"opc": 10}, function (dat) {
                var y = JSON.parse(dat);             
                $("#fecha_pre").val(y.fe_prestamo);
                $("#fechadev").val(y.fe_devolucion);
                $("#hora_pre").val(y.hora_pre);
                $("#hora_dev").val(y.hora_devo);
                $("#aula").val(y.aula);
                $("#prof").val(y.id_profe);
                $("#profe").val(y.nom_profe);
            });
            if($("#tablaDetalle tbody tr").length===0){
                location.reload();
            }
            });
        }
        
}
function eliminarEquipo(x,y){
    document.getElementById("tablaDetalle").deleteRow(x);
    document.getElementById("bt"+y+"").style.color = 'lightblue';    
}

/**function validarFechita(fe_inicial, fe_final){
    try {
        var fechaf = fe_inicial.split("/");
        var day = fechaf[0];
        //var dia = fechaf[0];//dia
        var month = fechaf[1];// mes
        var year = fechaf[2];
        //var añito = fechaf[2];// año
        var date = new Date(year, month, '0');
        if ((day-0)>(date.getDate()-0)) {
            return false;
        }
        var dateInicial = date;
        //segunda fecha 
        var fechaf = fe_final.split("/");
        var year = fechaf[0];
        var month = fechaf[1];
        var year = fechaf[2];
        var date = new Date(year, month,'0');
        var dateFinal = date;
        if ((day-0)>(date.getDate()-0)) {
            return false;
        }
        return dateInicial <= dateFinal;
    } catch (errProcesando) {
        return false;
    }
}*/