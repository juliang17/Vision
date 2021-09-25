function validacionProducto() {

    var resultado = 'Correcto';
    var referenciaproducto = document.getElementById("referenciaproducto").value;
    var nombreproducto = document.getElementById("nombreproducto").value;
    var cantidadproducto = document.getElementById("cantidadproducto").value;
    var ivaproducto = document.getElementById("ivaproducto").value;
    var descripcionproducto = document.getElementById("descripcionproducto").value;
    var precio = document.getElementById("precio").value;
    var categorias_idcategorias = document.getElementById("categorias_idcategorias").value;
    var marca_idmarca = document.getElementById("marca_idmarca").value;
    var proveedores_idproveedores = document.getElementById("proveedores_idproveedores").value;
    var unidad_de_medida_idunidadmedida = document.getElementById("unidad_de_medida_idunidadmedida").value;
    var estado_producto_idestado_producto = document.getElementById("estado_producto_idestado_producto").value;

    console.log("-- Informacion a validar -- ");
    console.log("referenciaproducto : " + referenciaproducto);
    console.log("nombreproducto : " + nombreproducto);
    console.log("cantidadproducto : " + cantidadproducto);
    console.log("ivaproducto : " + ivaproducto);
    console.log("descripcionproducto : " + descripcionproducto);
    console.log("precio : " + precio);
    console.log("categorias_idcategorias : " + categorias_idcategorias);
    console.log("marca_idmarca : " + marca_idmarca);
    console.log("proveedores_idproveedores : " + proveedores_idproveedores);
    console.log("unidad_de_medida_idunidadmedida : " + unidad_de_medida_idunidadmedida);
    console.log("estado_producto_idestado_producto : " + estado_producto_idestado_producto)

    if (referenciaproducto == '') {

        alert("La referencia no puede estar vacia");
        resultado = 'Error';

    } else if (nombreproducto == '') {

        alert("El nombre no puede estar vacio");
        resultado = 'Error';


    } else if (cantidadproducto == '') {

        alert("La cantidad no puede estar vacia");
        resultado = 'Error';


    } else if (ivaproducto == '') {

        alert("El iva no puede estar vacio");
        resultado = 'Error';


    } else if (descripcionproducto == '') {

        alert("La descripción no puede estar vacia");
        resultado = 'Error';


    } else if (precio == '') {

        alert("El precio no puede estar vacio");
        resultado = 'Error';


    } else if (categorias_idcategorias == '') {

        alert("La categoria no puede estar vacia");
        resultado = 'Error';

    } else if (marca_idmarca == '') {

        alert("La marca no puede estar vacia");
        resultado = 'Error';

    } else if (proveedores_idproveedores == '') {

        alert("El proveedor no puede estar vacio");
        resultado = 'Error';
    } else if (unidad_de_medida_idunidadmedida == '') {

        alert("La unidad de medida no puede estar vacia");
        resultado = 'Error';
    } else if(estado_producto_idestado_producto == ''){
        alert("El estado del producto no puede estar vacio")
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


function setCtegoria(x) {

    $('#categorias_idcategorias').val(x);
    console.log("valor : " + x);

}

function setp(x) {

    $('#proveedores_idproveedores').val(x);
    console.log("valor : " + x);

}

function setMarca(x) {

    $('#marca_idmarca').val(x);
    console.log("valor : " + x);
}
function setUnidad(x) {

    $('#unidad_de_medida_idunidadmedida').val(x);
    console.log("valor : " + x);
}
function setEstado(x){
    
    $('#estado_producto_idestado_producto').val(x);
    console.log("valor : " + x);
}


function realizarBusqueda() {
    var textoBuscado = $('#txt_Id_Consultado').val();
    console.log("Texto: " + $('#txt_Id_Consultado').val());
    window.location.href = '/VISION/vista/RegistroProductos.jsp?buscando=' + textoBuscado.trim() + '&';
}

function SetIdConsulta(x) {
    $('#txt_Id_Consultado').val(x);
    console.log("valor : " + x);


    $('#txt_Id_Consultado').change(function () {
        console.log("Texto" + $('#txt_Id_Consultado').val());
    });

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


