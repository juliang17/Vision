function validaciondetalle() {

    var resultado = 'Correcto';
    var cantidad = document.getElementById("txt_cantidad_Reg").value;
    var precio = document.getElementById("txt_precio_Reg").value;
    var iva = document.getElementById("txt_iva_Reg").value;
    var subtotal = document.getElementById("txt_subtotal_Reg").value;
    var productos_idproductos = document.getElementById("txt_productos_idproductos_Reg").value();
    var movimiento_idmovimiento = document.getElementById("txt_movimiento_idmovimiento_Reg").value;


    console.log("-- Informacion a validar -- ");
    console.log("cantidad : " + cantidad);
    console.log("precio : " + precio);
    console.log("iva : " + iva);
    console.log("subtotal : " + subtotal);
    console.log("Producto : " + productos_idproductos);
    console.log("Movimiento : " + movimiento_idmovimiento);

    if (cantidad == '') {

        alert("La cantidad no puede estar vacia");
        resultado = 'Error';
    }
    if (precio == '') {

        alert("El precio no puede estar vacia");
        resultado = 'Error';
    }
    if (iva == '') {

        alert("El Iva no puede estar vacia");
        resultado = 'Error';
    }
    if (subtotal == '') {

        alert("El subtotal no puede estar vacia");
        resultado = 'Error';
    }
    if (productos_idproductos == '') {

        alert("El Producto no puede estar vacio");
        resultado = 'Error';
    }
    if (movimiento_idmovimiento == '') {

        alert("El movimiento no puede estar vacio");
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
function setProductos_idproductos(x) {
    $('#txt_productos_idproductos_Reg').val(x);
    console.log("valor : " + x);
}
function setmovimiento_idmovimiento(x) {
    $('#txt_movimiento_idmovimiento_Reg').val(x);
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
