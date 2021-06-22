function validacionDetalle() {

    var resultado = 'Correcto';

    var descripcion = $("#txt_descripcion_Reg").val;
    var cantidad = $("#txt_cantidad_Reg").val;
    var precio = $("#txt_precio_Reg").val;
    var iva = $("#txt_iva_Reg").val;
    var subtotal = $("#txt_subtotal_Reg").val;
    var productos_idproductos = $("#txt_productos_idproductos_Reg").val;
    var movimiento_idmovimiento = $("movimiento_idmovimiento").val;
    


    console.log("-- Informacion a validar -- ");
    console.log("descripcion : " + descripcion);
    console.log("cantidad : " + cantidad);
    console.log("precio : " + precio);
    console.log("iva : " + iva);
    console.log("subtotal : " + subtotal);
    console.log("productos_idproductos : " + productos_idproductos);
    console.log("movimiento_idmovimiento : " + movimiento_idmovimiento);


    if (descripcion == '') {

        alert("La entrada no puede estar vacia");
        resultado = 'Error';
    }
    if (cantidad == '') {

        alert("La salida no puede estar vacia");
        resultado = 'Error';
    }
    if (precio == '') {

        alert("El saldo no puede estar vacia");
        resultado = 'Error';
    }
    if (iva == '') {

        alert("El saldo no puede estar vacia");
        resultado = 'Error';
    }
    if (subtotal == '') {

        alert("El saldo no puede estar vacia");
        resultado = 'Error';
    }
    if (productos_idproductos == '') {

        alert("El saldo no puede estar vacia");
        resultado = 'Error';
    }
    if (movimiento_idmovimiento == '') {

        alert("El saldo no puede estar vacia");
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

function realizarBusqueda() {
    var textoBuscado = $('#txt_Id_Consultado').val();
    console.log("Texto: " + $('#txt_Id_Consultado').val());
    window.location.href = '/VISION/vista/Formularios/GestionDetalleMovimiento.jsp?buscando=' + textoBuscado.trim() + '&';
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

function setProductos_idproductos(x){
    $('#txt_productos_idproductos_Reg').val(x);
    console.log("valor : " + x);   
}
function setmov(x){
    $('#txt_movimiento_idmovimiento_Reg').val(x);
    console.log("valor : " + x);   
}

