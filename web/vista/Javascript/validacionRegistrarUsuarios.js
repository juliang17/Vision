var Buscar;







function validacionAct() {
    var resultado = 'Correcto';
    var numerodocusuarios = $('#txt_numerodocusuarios_Act').val();
    var nombreusuarios = $('#txt_nombreusuarios_Act').val();
    var apellidousuarios = $('#txt_apellidousuarios_Act').val();
    var correousuario = $('#txt_correousuario_Act').val();
    var telefonousuarios = $('#txt_telefonousuarios_Act').val();
    var direccionusuario = $('#txt_direccionusuario_Act').val();
    var claveusuario = $('#txt_claveusuario_Act').val();
    var tipo_documento_idtipodoc = $('#txt_tipo_documento_idtipodoc_Act').val();
    var roles_idroles = $('#txt_roles_idroles_Act').val();
    var genero_idgenero = $('#txt_genero_idgenero_Act').val();
    var estado_usuario_idestadousuario = $('#txt_estado_usuario_idestadousuario_Act').val();


    console.log('Información a validar');
    console.log('numerodocusuarios: ' + numerodocusuarios + ".");
    console.log('nombreusuarios: ' + nombreusuarios + ".");
    console.log('apellidousuarios: ' + apellidousuarios) + ".";
    console.log('correousuario: ' + correousuario + ".");
    console.log('telefonousuarios: ' + telefonousuarios + ".");
    console.log('direccionusuario: ' + direccionusuario + ".");
    console.log('claveusuario: ' + claveusuario + ".");
    console.log('tipo_documento_idtipodoc: ' + tipo_documento_idtipodoc + ".");
    console.log('roles_idroles: ' + roles_idroles + ".");
    console.log('genero_idgenero: ' + genero_idgenero + ".");
    console.log('estado_usuario_idestadousuario: ' + estado_usuario_idestadousuario + ".");


    if (numerodocusuarios == '') {
        alert('La identificacion no puede estar vacia');
        resultado = 'Error';
    } else if (nombreusuarios == '') {
        alert('El nombre del usuario no puede estar vacio');
        resultado = 'Error';
    } else if (apellidousuarios == '') {
        alert('El apellido no puede estar vacio');
        resultado = 'Error';
    } else if (correousuario == '') {
        alert('El correo no puede estar vacio');
        resultado = 'Error';
    } else if (telefonousuarios == '') {
        alert('El número telefónico no puede estar vacio');
        resultado = 'Error';
    } else if (direccionusuario == '') {
        alert('La dirección no puede estar vacia');
        resultado = 'Error';
    } else if (claveusuario == '') {
        alert('La contraseña no puede estar vacia');
        resultado = 'Error';
    } else if (tipo_documento_idtipodoc == '') {
        alert('El tipo de documento no puede estar vacio');
        resultado = 'Error';
    } else if (roles_idroles == '') {
        alert('El rol de usuario no puede estar vacio');
        resultado = 'Error';
    } else if (genero_idgenero == '') {
        alert('El genero de usuario no puede estar vacio');
        resultado = 'Error';
    } else if (estado_usuario_idestadousuario == '') {
        alert('El estado de usuario no puede estar vacio');
        resultado = 'Error';

    } else if (isNaN(numerodocusuarios)) {
        alert('El número de identificacion debe ser numérico');
        resultado = 'Error';

    } else if (isNaN(telefonousuarios)) {
        alert('El número telefónico debe ser numérico');
        resultado = 'Error';
    } else if (isNaN(estado_usuario_idestadousuario)) {
        alert('El estado usuario debe ser numérico');
        resultado = 'Error';
    } else if (isNaN(roles_idroles)) {
        alert('El rol de  usuario debe ser numérico');
        resultado = 'Error';
    } else if (isNaN(genero_idgenero)) {
        alert('El genero debe ser numérico');
        resultado = 'Error';
    } else if (isNaN(tipo_documento_idtipodoc)) {
        alert('El tipo documento debe ser numérico');
        resultado = 'Error';


    } else {
        resultado = 'Correcto';
    }
    $('#txt_bandera_Act').val(resultado);
    console.log('Resultado:' + $('#txt_bandera_Act').val());
    if (resultado == 'Correcto') {
        return true;
    } else {
        return false;
    }
}

