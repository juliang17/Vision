function RegistroDetalle() {

    var resultado = 'Correcto';
    var descripcion = $('#txt_descripcion_reg').val();
    var cantidad = $('#txt_cantidad_Reg').val();
    var precio = $('#txt_precio_reg').val();
    var iva = $('#txt_iva_reg').val();
    var subtotal = $('#txt_subtotal_reg').val();
    var productos_idproductos = $('#txt_productos_idproductos_reg').val();
    var movimiento_idmovimiento = $('#txt_movimiento_idmovimiento_reg').val();


    console.log('Información a validar');
    console.log('descripcion: ' + descripcion + ".");
    console.log('cantidad: ' + cantidad + ".");
    console.log('precio: ' + precio) + ".";
    console.log('iva: ' + iva + ".");
    console.log('subtotal: ' + subtotal + ".");
    console.log('productos_idproductos: ' + productos_idproductos + ".");
    console.log('movimiento_idmovimiento: ' + movimiento_idmovimiento + ".");


    if (descripcion == '') {
        alert('La descripcion no puede estar vacia');
        resultado = 'Error';
    } else if (cantidad == '') {
        alert('La cantidad no puede estar vacio');
        resultado = 'Error';
    } else if (precio == '') {
        alert('El precio no puede estar vacio');
        resultado = 'Error';
    } else if (iva == '') {
        alert('El iva no puede estar vacio');
        resultado = 'Error';
    } else if (subtotal == '') {
        alert('El subtotal no puede estar vacio');
        resultado = 'Error';
    } else if (productos_idproductos == '') {
        alert('El producto no puede estar vacia');
        resultado = 'Error';
    } else if (movimiento_idmovimiento == '') {
        alert('El movimiento no puede estar vacia');
        resultado = 'Error';
        
 } else if (isNaN(cantidad)) {
        alert('El cantidad debe ser numérico');
        resultado = 'Error';
    } else if (isNaN(precio)) {
        alert('El precio debe ser numérico');
        resultado = 'Error';
    } else if (isNaN(iva)) {
        alert('El iva debe ser numérico');
        resultado = 'Error';
    } else if (isNaN(subtotal)) {
        alert('El subtotal debe ser numérico');
        resultado = 'Error';
   } else if (isNaN(productos_idproductos)) {
        alert('El producto debe ser numérico');
        resultado = 'Error';
        } else if (isNaN(movimiento_idmovimiento)) {
        alert('El movimiento debe ser numérico');
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

function setproductos_idproductos(x){
    $('#txt_productos_idproductos_reg').val(x);
    console.log("valor : " + x);   
}

function setmovimiento_idmovimiento(x){
    $('#txt_movimiento_idmovimiento_reg').val(x);
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
    window.location.href = '/VISION/vista/GestionDetalle.jsp?buscando=' + textoBuscado.trim() + '&';
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