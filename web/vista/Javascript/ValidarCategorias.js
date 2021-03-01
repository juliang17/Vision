function RegistroCategorias() {

    var resultado = 'correcto';
    var descripcioncategorias = $('#txt_descripcioncategorias_reg').val();

    console.log('Información a validar');
    console.log('descripcioncategorias: ' + descripcioncategorias + ".");

    if (descripcioncategorias == '') {
        alert('La categoria no puede estar vacia');
        resultado = 'Error';
    } else {
        resultado = 'correcto';
    }
    $('#txt_bandera_reg').val(resultado);
    console.log('Resultado:' + $('#txt_bandera_reg').val());
    if (resultado == 'correcto') {
        return true;
    } else {
        return false;
    }
}
function realizarBusqueda()
{
    var textoBuscado = $('#txt_Id_Consultado').val();
    console.log("Texto: " + $('#txt_Id_Consultado').val());
    window.location.href = '/VISION/Formularios/GestionCategorias.jsp?buscando=' + textoBuscado.trim() + '&';
}

function SetIdConsulta(x) {
    $('#txt_Id_Consultado').val(x);
    console.log("valor : " + x);
}

$('#txt_Id_Consultado').change(function () {
    console.log("Texto" + $('#txt_Id_Consultado').val());
});

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


