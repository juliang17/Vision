function validacionMovimiento() {

    var resultado = 'Correcto';
    var numero_documento = document.getElementById("numero_documento").value;
    var fechamovimiento = document.getElementById("fechamovimiento").value;
    var subtotal = document.getElementById("subtotal").value;
    var iva = document.getElementById("iva").value;
    var estadoMov = document.getElementById("estadoMov").value;
    var total = document.getElementById("total").value;
    var usuarios_idusuarios = document.getElementById("usuarios_idusuarios").value;
    var tipo_mov_id_tipo_mov = document.getElementById("tipo_mov_id_tipo_mov").value;
    var medio_de_pago_idmediodepago = document.getElementById("medio_de_pago_idmediodepago");

    console.log("-- Informacion a validar -- ");
    console.log("numero_documento :" + numero_documento);
    console.log("fechamovimiento : " + fechamovimiento);
    console.log("subtotal : " + subtotal);
    console.log("iva : " + iva);
    console.log("estadoMov : " + estadoMov);
    console.log("total : " + total);
    console.log("usuarios_idusuarios : " + usuarios_idusuarios);
    console.log("tipo_mov_id_tipo_mov : " + tipo_mov_id_tipo_mov);
    console.log("Medio de pago : " + medio_de_pago_idmediodepago);


    if (numero_documento == '') {

        alert("El documento no puede estar vacio");
        resultado = 'Error';
    }
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
    if (estadoMov == '') {

        alert("El estado de movimiento no puede estar vacio");
        resultado = 'Error';
    }
    if (total == '') {

        alert("El total no puede estar vacio");
        resultado = 'Error';
    }
    if (usuarios_idusuarios == '') {
        alert("El usuario no puede estar vacio");
        resultado = 'Error';
    }
    if (tipo_mov_id_tipo_mov == '') {

        alert("El tipo de movimiento no puede estar vacio");
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
function setusuarios_idusuarios(x){
    $('#usuarios_idusuarios').val(x);
    console.log("valor : " + x);
}

function settipo_mov_id_tipo_mov(x) {
    $('#tipo_mov_id_tipo_mov').val(x);
    console.log("valor : " + x);
}
function setmedio_de_pago_idmediodepago(x) {
    $('#medio_de_pago_idmediodepago').val(x);
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


