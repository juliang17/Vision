function validacionInventario() {

    var resultado = 'Correcto';
    var Entrada = document.getElementById("txt_entrada_Reg").value;
    var Salida = document.getElementById("txt_salida_Reg").value;
    var Saldo = document.getElementById("txt_saldo_Reg").value;


    console.log("-- Informacion a validar -- ");
    console.log("Entrada : " + Entrada);
    console.log("Salida : " + Salida);
    console.log("Saldo : " + Saldo);


    if (Entrada == '') {

        alert("La entrada no puede estar vacia");
        resultado = 'Error';
    }
    if (Salida == '') {

        alert("La salida no puede estar vacia");
        resultado = 'Error';
    }
    if (Saldo == '') {

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
    window.location.href = '/VISION/vista/Formularios/GestionInventarios.jsp?buscando=' + textoBuscado.trim() + '&';
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



