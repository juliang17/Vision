function validarMedioPago() {

    var resultado = 'Correcto';
    var MedioPago = document.getElementById("txt_descripcionmediodepago_Reg").value;
    var referencia_pago = document.getElementById("txt_referenciapago").value;


    console.log("-- Informacion a validar -- ");
    console.log("MedioPago : " + MedioPago);
    console.log("referencia_pago : " + referencia_pago);


    if (MedioPago == '') {

        alert("El medio de pago no puede estar vacio");
        resultado = 'Error';
    } if (referencia_pago == ''){
     alert("La referencia de pago no puede estar vacia")   
    }
    $('#txt_Bandera_Reg').val(resultado);
    console.log('Resultado:' + $('#txt_Bandera_Reg').val());
    if (resultado == 'Correcto') {

        return true;

    } else {

        return false;
    }

}

function realizarBusqueda() {
    var textoBuscado = $('#txt_Id_Consultado').val();
    console.log("Texto: " + $('#txt_Id_Consultado').val());             
    window.location.href = '/VISION/vista/Formularios/GestionMedioPago.jsp?buscando=' + textoBuscado.trim() + '&';
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

function DefinirFoco(){
document.getElementById("txt_Id_Consultado").focus();
}

$('#txt_Id_Consultado').change(function(){
console.log("Texto" + $('#txt_Id_Consultado').val());
});




