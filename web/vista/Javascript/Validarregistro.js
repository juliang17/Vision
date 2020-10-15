function validacionReg() {
    var resultado = 'correcto';
    var Identificacion = $('#txt_numerodocusuarios_Reg').val();
    var nombres = $('#txt_nombreusuarios_Reg').val();
    var apellidos = $('#txt_apellidousuarios_Reg').val();
    var correo = $('#txt_correousuarios_Reg').val();
    var telefono = $('#txt_telefonousuarios_Reg').val();
    var direccion = $('#txt_direccionusuario_Reg').val();
    var contraseña = $('#txt_contraseñausuario_Reg').val();
    var tipodocumento = $('#txt_idtipodoc_Reg').val();
    var roles = $('#txt_idroles_Reg').val();
    var genero = $('#txt_idgenero_Reg').val();
    var estado = $('#txt_idestadousuario_Reg').val();

    console.log(" -- Informacion y validar -- ");
    console.log("Identificacion : " + Identificacion);
    console.log("nombres : " + nombres + ".");
    console.log("apellidos : " + apellidos);
    console.log("correo : " + correo);
    console.log("telefono : " + telefono);
    console.log("direccion : " + direccion);
    console.log("contraseña : " + contraseña);
    console.log("tipodocumento : " + tipodocumento);
    console.log("roles : " + roles);
    console.log("genero : " + genero);
    console.log("estado : " + estado);

    if (Identificacion == '') {
        alert("La identifiacion no puede ser nula");
        resultado = 'Error';
    } else if (nombres == '') {
        alert("El nombre no puede ser nulo");
        resultado = 'Error';
    } else if (apellidos == '') {
        alert("El apellido no puede ser nulo");
        resultado = 'Error';
    } else if (correo == '') {
        alert("El correo no puede ser nulo");
        resultado = 'Error';
    } else if (telefono == '') {
        alert("El telefono no puede ser nulo");
        resultado = 'Error';
    } else if (direccion == '') {
        alert("La direccion no puede ser nula");
        resultado = 'Error';
    } else if (contraseña == '') {
        alert("La contraseña no puede ser nula");
        resultado = 'Error';
    } else if (tipodocumento == '') {
        alert("El tipo de documento no puede ser nulo");
        resultado = 'Error';
    } else if (roles == '') {
        alert("El rol no puede ser nulo");
        resultado = 'Error';
    } else if (genero == '') {
        alert("El genero no puede ser nulo");
        resultado = 'Error';
    } else if (estado == '') {
        alert("El estado no puede ser nulo");
        resultado = 'Error';

    } else if (isNaN(Identificacion)) {
        alert("La identifiacion debe ser numerica")
        resultado = 'Error';
    } else if (isNaN(telefono)) {
        alert("El telefono debe ser numerico")
        resultado = 'Error';
    } else {
        resultado = 'correcto';
    }
    $('#txt_Bandera_Reg').val(resultado);
    console.log("Resultado : " + $('#txt_Bandera_Reg').val());
    if (resultado == 'correcto') {
        return true;
    } else {
        return false;
    }
}


