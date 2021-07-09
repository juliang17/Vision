function validacionReferencia() {

    var resultado = 'Correcto';
    var fechadepago = $("#txt_fechadepago_Reg").val;
    var medio_de_pago_idMedioDePago = $("#txt_medio_de_pago_idMedioDePago_Reg").val;


    console.log("-- Informacion a validar -- ");
    console.log("fechadepago : " + fechadepago);
    console.log("medio_de_pago_idMedioDePago : " + medio_de_pago_idMedioDePago);


    if (fechadepago == '') {

        alert("La fecha no puede estar vacia");
        resultado = 'Error';
    }
    else if (medio_de_pago_idMedioDePago == '') {

        alert("El medio no puede estar vacia");
        resultado = 'Error';
    } else if (isNaN(medio_de_pago_idMedioDePago)) {
        alert('El medio de pago debe ser numérico');
        resultado = 'Error'; 
    
    } else {
        resultado = 'Correcto';
    }
    $('#txt_Bandera_Reg').val(resultado);
    console.log('Resultado:' + $('#txt_Bandera_Reg').val());
    if (resultado == 'Correcto') {
        return true;
    } else {
        return false;
    }

}

function setMedio_de_pago_idMedioDePago(x){
    $('#txt_medio_de_pago_idMedioDePago_Reg').val(x);
    console.log("valor : " + x);   
}

function realizarBusqueda() {
    var textoBuscado = $('#txt_Id_Consultado').val();
    console.log("Texto: " + $('#txt_Id_Consultado').val());
    window.location.href = '/VISION/vista/Formularios/GestionReferencias.jsp?buscando=' + textoBuscado.trim() + '&';
}

function SetIdConsulta(x) {
    $('#txt_Id_Consultado').val(x);
    console.log("valor : " + x);
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

function DefinirFoco() {
    document.getElementById("txt_Id_Consultado").focus();
}

$('#txt_Id_Consultado').change(function () {
    console.log("Texto" + $('#txt_Id_Consultado').val());
});

function setmedio_de_pago_idmediodepago(x) {
    $('#txt_medio_de_pago_idmediodepago_Reg').val(x);
    console.log("valor : " + x);
}



