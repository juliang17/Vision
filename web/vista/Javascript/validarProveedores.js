function validarProveedores() {

    var resultado = 'Correcto';
    var nombreproveedores = $('#nombre').val();
    var identificacionproveedores = $('#identificacion').val();
    var correoproveedores = $('#correo').val();
    var telefonoproveedores = $('#telefono').val();

    console.log('Información a validar');
    console.log('nombreproveedores: ' + nombreproveedores + ".");
    console.log('identificacionproveedores: ' + identificacionproveedores) + ".";
    console.log('correoproveedores: ' + correoproveedores + ".");
    console.log('telefonoproveedores: ' + telefonoproveedores + ".");


    if (nombreproveedores == '') {
        alert('El nombre del proveedor no puede estar vacio');
        resultado = 'Error';
    } else if (identificacionproveedores == '') {
        alert('La identificación no puede estar vacia');
        resultado = 'Error';
    } else if (correoproveedores == '') {
        alert('El correo no puede estar vacio');
        resultado = 'Error';
    } else if (telefonoproveedores == '') {
        alert('El número telefónico no puede estar vacio');
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
function realizarBusqueda() {
    var textoBuscado = $('#txt_Id_Consultado').val();
    console.log("Texto: " + $('#txt_Id_Consultado').val());
    window.location.href = '/VISION/vista/RegistroProveedores.jsp?buscando=' + textoBuscado.trim() + '&';
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







        
        




