function validacionInventario() {

    var resultado = 'Correcto';
    var Entrada = $('#txt_entrada_Reg').val();
    var Salida = $('#txt_salida_Reg').val();
    var Saldo = $('#txt_saldo_Reg').val();
    var productos_idproductos = $('#txt_productos_idproductos_Reg').val();


    console.log("-- Informacion a validar -- ");
    console.log("Entrada : " + Entrada);
    console.log("Salida : " + Salida);
    console.log("Saldo : " + Saldo);
    console.log("Producto : " + productos_idproductos);


    if (Entrada == '') {

        alert("La entrada no puede estar vacia");
        resultado = 'Error';
    } else if (Salida == '') {

        alert("La salida no puede estar vacia");
        resultado = 'Error';
    } else if (Saldo == '') {

        alert("El saldo no puede estar vacia");
        resultado = 'Error';
    } else if (productos_idproductos == '') {

        alert("El Producto no puede estar vacio");
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

function setProductos_idproductos(x) {
    $('#txt_productos_idproductos_Reg').val(x);
    console.log("valor : " + x);
}

function realizarBusqueda() {
    var textoBuscado = $('#txt_Id_Consultado').val();
    console.log("Texto: " + $('#txt_Id_Consultado').val());
    window.location.href = '/vigiwebB/vista/inventario.jsp?buscando=' + textoBuscado.trim() + '&';
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
