function validacionMovimiento() {

    var resultado = 'Correcto';
    var fechamovimiento = $("#txt_fechamovimiento_Reg").val;
    var subtotal = $("#txt_subtotal_Reg").val;
    var iva = $("#txt_iva_Reg").val;
    var descuento = $("#txt_descuento_Reg").val;
    var total = $("#txt_total_Reg").val;
    var tipo_doc_contable_idtipodoccontable = $("#txt_tipo_doc_contable_idtipodoccontable_Reg").val;
    var medio_de_pago_idmediodepago = $("#txt_medio_de_pago_idmediodepago_Reg").val;

    console.log("-- Informacion a validar -- ");
    console.log("fechamovimiento : " + fechamovimiento);
    console.log("subtotal : " + subtotal);
    console.log("iva : " + iva);
    console.log("descuento : " + descuento);
    console.log("total : " + total);
    console.log("TipoDocC : " + tipo_doc_contable_idtipodoccontable);
    console.log("Medio de pago : " + medio_de_pago_idmediodepago);


    if (fechamovimiento == '') {

        alert("La fecha de movimiento no puede estar vacia");
        resultado = 'Error';
    }
    if (subtotal == '') {

        alert("El subtotal no puede estar vacia");
        resultado = 'Error';
    }
    if (iva == '') {

        alert("El iva no puede estar vacia");
        resultado = 'Error';
    }
    if (descuento == '') {

        alert("El descuento no puede estar vacio");
        resultado = 'Error';
    }
    if (total == '') {

        alert("El total no puede estar vacio");
        resultado = 'Error';
    }
    if (tipo_doc_contable_idtipodoccontable == '') {

        alert("El tipo de documento contable no puede estar vacio");
        resultado = 'Error';
    }
    if (medio_de_pago_idmediodepago == '') {

        alert("El medio de pago no puede estar vacio");
        resultado = 'Error';
    }
    $('#txt_Bandera_Reg').val(resultado);
    console.log('Resultado:' + $('#txt_Bandera_Reg').val());
    if (resultado == 'Correcto') {

        return true;

    } else {

        return false;
    }
}
function settipo_doc_contable_idtipodoccontable(x) {
    $('#txt_tipo_doc_contable_idtipodoccontable_Reg').val(x);
    console.log("valor : " + x);
}
function setmedio_de_pago_idmediodepago(x) {
    $('#txt_medio_de_pago_idmediodepago_Reg').val(x);
    console.log("valor : " + x);
}

function realizarBusqueda() {
    var textoBuscado = $('#txt_Id_Consultado').val();
    console.log("Texto: " + $('#txt_Id_Consultado').val());
    window.location.href = '/VISION/vista/Formularios/GestionMovimiento.jsp?buscando=' + textoBuscado.trim() + '&';
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


