$("#btn1").click(function () {
    Swal.fire({
        title: '¿Estás seguro de salir?',
        text: "Para volver a ingresar, debes iniciar sesión",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        cancelButtonText: '¡Cancelar!',
        confirmButtonText: 'Si, ¡No hay problema!'
    }).then((result) => {
        if (result.isConfirmed) {
            Swal.fire(
                    '¡Hasta pronto!',
                    'Gracias por estar en el sistema. Ten un excelente día!',
                    'success'
                    ).then(function () {
                window.location = "../index.jsp";
            });
        }
    })

});
