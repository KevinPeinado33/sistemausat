$(document).ready(function () {

});

$("#btnIngresar").click(function () {
    var x = $("#user").val();
    var y = $("#pass").val();
    alert(x + y);
    $.post("main", {"user": x, "pass": y, "opc": 1}, function (data) {
        alert(data);
        if (data > 0)
        {
            $(location).attr('href', 'http://localhost:8080/sistemaprestamos/main.jsp');
            
        } else {
    
        }
    });
});
