function realizarBusqueda()
{ var textoBuscado = $('#txt_Id_Consultado').val();
console.log("Texto: " + $('#txt_Id_Consultado').val());
window.location.href = '/VISION/RegistroUsuarios.jsp?buscando='+textoBuscado.trim()+'&';
}
