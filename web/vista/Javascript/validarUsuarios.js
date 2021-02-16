function RegistroUsuarios() {

    var resultado = 'Correcto';
    var numerodocusuarios = $('#txt_numerodocusuarios_reg').val();
    var nombreusuarios = $('#txt_nombreusuarios_Reg').val();
    var apellidousuarios = $('#txt_apellidousuarios_reg').val();
    var correousuario = $('#txt_correousuario_reg').val();
    var telefonousuarios = $('#txt_telefonousuarios_reg').val();
    var direccionusuario = $('#txt_direccionusuario_reg').val();
    var contraseñausuario = $('#txt_contraseñausuario_reg').val();
    var tipo_documento_idtipodoc = $('#txt_tipo_documento_idtipodoc_reg').val();
    var roles_idroles = $('#txt_roles_idroles_reg').val();
    var genero_idgenero = $('#txt_genero_idgenero_reg').val();
    var estado_usuario_idestadousuario = $('#txt_estado_usuario_idestadousuario_reg').val();


    console.log('Información a validar');
    console.log('numerodocusuarios: ' + numerodocusuarios + ".");
    console.log('nombreusuarios: ' + nombreusuarios + ".");
    console.log('apellidousuarios: ' + apellidousuarios) + ".";
    console.log('correousuario: ' + correousuario + ".");
    console.log('telefonousuarios: ' + telefonousuarios + ".");
    console.log('direccionusuario: ' + direccionusuario + ".");
    console.log('contraseñausuario: ' + contraseñausuario + ".");
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
    } else if (contraseñausuario == '') {
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
    $('#txt_bandera_reg').val(resultado);
    console.log('Resultado:' + $('#txt_bandera_reg').val());
    if (resultado == 'Correcto') {
        return true;
    } else {
        return false;
    }
}

function settipo_documento_idtipodoc(x) {
    $('#txt_tipo_documento_idtipodoc_reg').val(x);
    console.log("valor : " + x);
}
function setroles_idroles(x) {
    $('#txt_roles_idroles_reg').val(x);
    console.log("valor : " + x);
}
function setgenero_idgenero(x) {
    $('#txt_genero_idgenero_reg').val(x);
    console.log("valor : " + x);
}
function setestado_usuario_idestadousuario(x) {
    $('#txt_estado_usuario_idestadousuario_reg').val(x);
    console.log("valor : " + x);
}

function realizarBusqueda()
{
    var textoBuscado = $('#txt_Id_Consultado').val();
    console.log("Texto: " + $('#txt_Id_Consultado').val());
    window.location.href = '/VISION/RegistroUsuarios.jsp?buscando=' + textoBuscado.trim() + '&';
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



