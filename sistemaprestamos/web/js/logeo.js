$(document).ready(function () {

});

var cantRep = 0; // variable para almacenar las cantidades de veces que se equivoco
var idUsu = 0; // variable para almacenar el id del usuario repitente

$("#btnCont").click(function () {
    var x = $("#user").val();// caputaramos el usuario
    var y = $("#passw").val();// capturamos la contraseña
    if (x === "" || y === "") {
        // si los campos estan vacios 
        var toastContent = ('<span><i class="material-icons medium  yellow-text">report</i></span><p>Complete los campos<p>');
        Materialize.toast(toastContent, 1500);
    } else {
        // si los campos estan llenos
        $.post("uc", {"op": 1, "user": x, "pass": y}, function (data) {
            if (data.length > 1) {
                $(location).attr('href', 'menu.jsp'); // si el usuario y contraseña son correctas
            } else {
                $.post("uc", {"op": 2, "usus": x}, function (w) {
                    var q = JSON.parse(w);
                    if (q.length > 0) {
                        //  si el usuario es correcto pero la contraseña es [!]
                        var idu = q[0].idusu;
                        idUsu = parseInt(idu);
                        ++cantRep;
                        if (cantRep >= 5) {
                            $.get("uc", {"op": 3, "cantidad": cantRep, "idusuario": idUsu});
                            var tra = parseInt(q[0].idtra);
                            $.get("uc", {"op": 4, "estado": 2, "idtrab": tra});
                            var toastContent = ('<span><i class="material-icons medium  red-text">error_outline</i></span><p>Su Cuenta Se Deshabilito<p>');
                            Materialize.toast(toastContent, 2500);
                        }else{
                            var toastContent = ('<span><i class="material-icons medium  lime-text">mood_bad</i></span><p>Usuario o Contraseña No Encontrados<p>');
                        Materialize.toast(toastContent, 2500);
                        }
                    } else {
                        var toastContent = ('<span><i class="material-icons medium  lime-text">mood_bad</i></span><p>Usuario o Contraseña No Encontrados<p>');
                        Materialize.toast(toastContent, 2500);
                    }
                });
            }
        });
    }
});