function ValidarProveedores() {
    var resultado = 'Correcto';
    var nombreproveedores = $('#txt_nombreproveedores_reg').val();
    var correoproveedores = $('#txt_correoproveedores_reg').val();
    var telefonoproveedores = $('#txt_telefonoproveedores_reg').val();

    console.log("-- Informacion a validar --");
    console.log("nombreproveedores : ." + nombreproveedores + ".");
    console.log("correoproveedores : ." + correoproveedores + ".");
    console.log("telefonoproveedores : ." + telefonoproveedores + ".");

    if (nombreproveedores == '') {
        alert("El nombre del proveedor no puede ser nulo");
        resultado = 'Error';
    } else if (correoproveedores == '') {
        alert("El correo del proveedor no puede ser nulo");
        resultado = 'Error';
    } else if (telefonoproveedores == '') {
        alert("El telefono del proveedor no puede ser nulo");
        resultado = 'Error';
    } else if (isNaN(telefonoproveedores)) {
        alert("El telefono debe ser numerico");
        resultado = 'Error';
    } else {
        resultado = 'Correcto';
    }
    $('#txt_Banderota_Reg').val(resultado);
    console.log("Resultado: " + $('#txt_Banderota_Reg').val());
    if (resultado == 'Correcto') {
        return true;
    } else {
        return false;
    }
}


