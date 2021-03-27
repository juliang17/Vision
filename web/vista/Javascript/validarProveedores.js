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





        
        




