function ValidarReferencia() {

    var resultado = 'Correcto';
    var fechadepago = document.getElementById("txt_fechadepago_Reg").value;
    var medio_de_pago_idMedioDePago = document.getElementById("txt_medio_de_pago_idMedioDePago_Reg").value;


    console.log('Información a validar');
    console.log('fechadepago: ' + fechadepago + ".");
    console.log('medio_de_pago_idMedioDePago: ' + medio_de_pago_idMedioDePago + ".");


    if (fechadepago == '') {
        alert('La fecha de pago no puede estar vacia');
        resultado = 'Error';
    } else if (medio_de_pago_idMedioDePago == '') {
        alert('El medio de pago no puede estar vacio');
        resultado = 'Error';
    } else if (isNaN(medio_de_pago_idMedioDePago)) {
        alert('El medio de pago debe ser numérico');
        resultado = 'Error';
   
    } else {
        resultado = 'Correcto';
    }
    $('#txt_bandera_reg').val(resultado);
    console.log('Resultado:' + $('#txt_bandera_reg').val());
    if (resultado == 'Correcto') {
        return true;
    } else {
        return false;
    }
}

function setmedio_de_pago_idMedioDePago(x){
    $('#txt_medio_de_pago_idMedioDePago_reg').val(x);
    console.log("valor : " + x);   
}

$('#txt_Id_Consultado').change(function(){
console.log("Texto" + $('#txt_Id_Consultado').val());
});

function SetIdConsulta(x) {
    $('#txt_Id_Consultado').val(x);
    console.log("valor : " + x);
}

function realizarBusqueda() {
    var textoBuscado = $('#txt_Id_Consultado').val();
    console.log("Texto: " + $('#txt_Id_Consultado').val());
    window.location.href = '/VISION/vista/RegistroUsuarios.jsp?buscando=' + textoBuscado.trim() + '&';
}

function visualizaOculta(Dato) {

    console.log("Viene " + Dato);
    if (Dato == "Registrar") {

        $("#Registrar").removeClass('d-none');
        $("#Actualizar").addClass('d-none');
        $("#Listado").addClass('d-none');


    } else if (Dato == "Actualizar") {

        $("#Registrar").addClass('d-none');
        $("#Actualizar").removeClass('d-none');
        $("#Listado").addClass('d-none');


    } else if (Dato == "Listado") {

        $("#Listado").removeClass('d-none');
        $("#Registrar").addClass('d-none');
        $("#Actualizar").addClass('d-none');

    }
}










