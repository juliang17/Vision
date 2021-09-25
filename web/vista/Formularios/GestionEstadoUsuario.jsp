
<%@page import="controlador.estado_usuarioDAO"%>
<%@page import="modelo.estado_producto"%>
<%@page import="controlador.estado_productoDAO"%>
<%@page import="modelo.estado_usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="../Javascript/ValidarEstadousuario.js" type="text/javascript"></script>
        <script src="https://kit.fontawesome.com/4d836167dd.js" crossorigin="anonymous"></script>
        <link href="../css/usuarios.css" rel="stylesheet" type="text/css"/>
        <title>Estado usuario</title>
    </head>
    <body onload="visualizaOculta('<%=request.getParameter("Vista")%>');">
        <% String buscando = request.getParameter("buscando");
            if (buscando == null) {
                buscando = "";
            }
        %>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="../../PaginaPrincipal.jsp">MAXILINI</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="GestionGenero.jsp">Gestión género</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="GestionTipodocumento.jsp">Gestión tipo documento</a>
                        </li>
                                                <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="GestionRoles.jsp">Gestión roles</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="../RegistroUsuarios.jsp">Gestión usuarios</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="row justify-content-md-center menu">
            <div class="btn-group">
                <button type="button" class="btn btn-secondary" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false"
                        onClick="visualizaOculta('Registrar')">
                    Registrar
                </button>
                <button type="button" class="btn btn-secondary" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false"
                        onClick="visualizaOculta('Listado')">
                    Consultar
                </button>
            </div>
        </div>

        <!--REGISTRAR-->

        <div id="Registrar" class="container bd-example d-none">
                <h1>Registrar Estado Usuario</h1>
                <br>
                <form action="/VISION/RegistroEstadoUsuario" method="post" onsubmit="return validarEstadoUsuario()" class="row g-3">
                        <div class="form-floating col-md-6" >
                            <input type="text" name="descripcionestadousuario" class="form-control" placeholder="Digite el estado del usuario" id="txt_descripcionestadousuario_Reg">
                            <label for="floatingInput">Estado usuario</label>
                        </div> 
                    <div id="ControlRegistro" class="bd-example d-none">
                        <input id="txt_Bandera_Reg" type="text" class="form-control" name="BanderaRegistro">
                    </div>
                    <button type="submit" class="btn btn-success">Registrar</button>
                </form>
        </div>

        <!--REGISTRAR-->

        <!--Actualizar-->

        <div class="container">
            <div class="row justify-content-md-center">
                <div id="Actualizar" class="bd-example d-none">
                    <h1>Actualizar estado usuario</h1>
                    <form action="/VISION/ActualizarEstadoUsuario" method = "post">
                        <div class ="form-group">
                            <label>Estado usuario</label>
                            <input type="text" class="form-control" readonly name="descripcionestadousuario" value="<%=request.getParameter("descripcionestadousuario")%>"/>
                        </div>
                        <div id="ControlRegistro" class="bd-example d-none">
                            <input type = "text" class="form-control" name="BanderaActualiza"/>
                        </div>
                        <div class="row justify-content-md-center">
                            <div class="btn-group">
                                <button type="submit" class="btn btn-success">Actualizar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
                        <br>
        <!--Actualizar-->

        <!--Listar-->

        <div id="Listado" class="container">
            <form action="/VISION/ConsultarEstadoUsuario" method="post">
                <div class="row justify-content-md-center">
                    <div id="Listado" class="bd-example">
                        <div id="ControlRegistro" class="input-group">
                            <input id ="txt_Id_Consultado" type = "text" class="form-control"
                                   name= "IdConsultado" value="<%=buscando%>" autofocus
                                   placeholder="Buscar por Descripcion"/>
                            <button type="button" class="btn btn-primary" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false"
                                    onClick="realizarBusqueda()">Buscar</button>
                        </div>
                        <div>
                            <h1>Listado estado usuario</h1>
                            <div id="Tabla_estado_usuario">

                                <% estado_usuarioDAO miestadousuarioDAO = new estado_usuarioDAO();
                                    ArrayList<estado_usuario> miestado = new ArrayList<estado_usuario>();
                                    miestado = miestadousuarioDAO.Consultarlistadoestado_usuario(buscando, buscando);
                                    out.println("<table class='table table-dark table-striped table-hover table-bordered'><tr><td>Descripcion</td><td>Editar</td><td>Eliminar</td></tr>");
                                    for (estado_usuario E : miestado) {
                                        out.println("<tr>");
                                        out.println("<td>" + E.getDescripcionestadousuario() + "</td>");
                                        out.println("<td>" + "<button type = 'submit' class='btn btn-primary form-control btn btn-login' value=''name='Actualizar'onclick='SetIdConsulta(" + E.getIdestadousuario() + ")'/>" + "" + "<i class='fas fa-pencil-alt'></i>" + "</button>" + "</td>");
                                        out.println("<td>" + "<button type = 'submit' class='btn btn-danger form-control btn btn-login' value= ''name='Eliminar'onclick='SetIdConsulta(" + E.getIdestadousuario() + ")'/>" + "" + "<i class='fas fa-trash-alt'></i>" + "</button>" + "</td>");
                                        out.println("</tr>");
                                    }
                                    out.println("</table>");
                                %>
                            </div>  
                        </div>       
                    </div>
                </div>
            </form>
        </div>
                            <!--Listar-->
    </body>
</html>
