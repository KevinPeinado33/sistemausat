$(document).ready(function () {
    $('#btnAcept').css('visibility', 'hidden'); 
    $('#usu').attr("disabled", true);
    $('#contra').attr("disabled", true);
    $("#unin").css('visibility', 'hidden'); 
    listado();
});

function editar(){ 
   $('#usu').attr("disabled", false);
   $('#contra').attr("disabled", false);
   $('#btnActualizar').css('visibility', 'hidden'); 
   $('#btnAcept').css('visibility', 'visible');  
}

function acept(){
    var usu=$("#usu").val();
    var pass=$("#contra").val();
    var idu=$("#unin").val();
    $.post("UsuCon",{"idu":idu,"user":usu,"contra":pass,"op":9}, function () {
      var toastHTML = "<span>Usuario actualizado</span>";
      Materialize.toast( toastHTML,1800);  
      setTimeout("location.href='lgt'", 2100);   
    });
}

function listado(){
    var idu= $("#unin").val();
    $.get("pro",{"id":idu,"op":10}, function (data) {
          var x = JSON.parse(data);
          $("#nop").text(x[0].nom + " " +x[0].ape);
          $("#dn").text(x[0].dn);
          $("#celuar").text(x[0].nucel);
          $("#dire").text(x[0].dire);
          $("#corre").text(x[0].corr);
          $("#ro").text(x[0].nor);     
   });
}