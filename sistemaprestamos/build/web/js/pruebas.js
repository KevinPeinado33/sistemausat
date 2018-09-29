$(document).ready(function () {
    Materialize.toast('Toast al inicio', 4000);
});
$('.datepicker').pickadate({
    monthsFull: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
    monthsShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
    weekdaysFull: [' Dom ', ' Lun ', ' Mar ', ' Mié ', ' Jue ', 'Vie ', 'Sáb '],
    weekdaysShort: ['D', 'Lun', 'Mar', 'Mié', 'Jue', 'Vie', 'Sáb'],
    selectMonths: true,
    selectYears: 100, // Puedes cambiarlo para mostrar más o menos años
    today: 'Hoy',
    clear: 'Limpiar',
    close: 'Ok',
    labelMonthNext: 'Siguiente mes',
    labelMonthPrev: 'Mes anterior',
    labelMonthSelect: 'Selecciona un mes',
    labelYearSelect: 'Selecciona un año',
    format: 'yyyy-mm-dd'
});

function toast() {
    Materialize.toast('toas jquery', 4000);
    var toastContent = $('<span>I am toast content<a class="btn blue" onclick="funciona();">maincra</a></span>');
    Materialize.toast(toastContent, 10000);

    var toastContent = $('<span>I am toast content<a class="btn-flat toast-action red-text" onclick="funciona();">maincra</a><a class="btn-flat toast-action red-text" onclick="funciona();">maincraF</a></span>');
    Materialize.toast(toastContent, 10000);
    var toastContent = $('<h1>Ella no te ama</h1>');
    Materialize.toast(toastContent, 10000);
}

function funciona() {
    alert("funciona");
}
