
<%@page import="modelo.usuarios"%>
<%@page import="controlador.usuariosDAO"%>
<%@page import="modelo.genero"%>
<%@page import="controlador.GeneroDAO"%>
<%@page import="modelo.estado_usuario"%>
<%@page import="controlador.estado_usuarioDAO"%>
<%@page import="modelo.roles"%>
<%@page import="controlador.rolesDAO"%>
<%@page import="modelo.tipo_documento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlador.tipo_documentoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="./Javascript/validarUsuarios.js"></script>
        <script src="https://kit.fontawesome.com/4d836167dd.js" crossorigin="anonymous"></script>
        <link href="css/usuarios.css" rel="stylesheet" type="text/css"/>
        <title>Registro Usuarios</title>
    </head>
    <body onload="visualizaOculta('<%=request.getParameter("Vista")%>');">
        <% String buscando = request.getParameter("buscando");
            if (buscando == null) {
                buscando = "";
            }
        %>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="../PaginaPrincipal.jsp">MAXILINI</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="Formularios/GestionTipodocumento.jsp">Gestión tipo documento</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="Formularios/GestionRoles.jsp">Gestión roles</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="Formularios/GestionEstadoUsuario.jsp">Gestión estado usuarios</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="Formularios/GestionGenero.jsp">Gestión género</a>
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
                <button type="button" class="btn btn-secondary boton" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false"
                        onClick="visualizaOculta('Listado')">
                    Consultar
                </button>
            </div>
        </div>
        <div id="Registrar" class="container bd-example d-none">
            <h1>Registro de usuarios</h1>
            <br>
            <form action="/VISION/RegistrarUsuarios" method="post" onsubmit="return RegistroUsuarios()" class="row g-3">
                <div class="form-floating col-md-6">
                    <input type="text" name="nombreusuarios" class="form-control" placeholder="" id="txt_nombreusuarios_Reg">
                    <label for="floatingInput">Nombres</label>
                </div>
                <div class="form-floating col-md-6">
                    <input type="text" name="apellidousuarios" class="form-control" placeholder="" id="txt_apellidousuarios_reg">
                    <label for="floatingInput">Apellidos</label>
                </div>
                <div class="form-floating col-md-6">
                    <input type="number" name="tipo_documento_idtipodoc" class="form-control d-none" id="txt_tipo_documento_idtipodoc_reg">
                    <%
                        tipo_documentoDAO mitipodocDAO = new tipo_documentoDAO();
                        ArrayList<tipo_documento> mitipodoc = mitipodocDAO.Listadotipo_documento("", "");
                        out.println("<select class='form-control' id='Selectidtipodoc' size='1'>");
                        out.println("<option onclick='settipo_documento_idtipodoc(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                        for (tipo_documento T : mitipodoc) {
                            out.println("<option onclick='settipo_documento_idtipodoc(\"" + T.getIdtipodoc() + "\")'>" + T.getDescripciontipodoc() + "</option>");
                        }
                        out.println("</select>");
                    %>
                    <label for="floatingInput">Tipo de documento</label>
                </div>
                <div class="form-floating col-md-6">
                    <input type="number" name="numerodocusuario" class="form-control" placeholder="" id="txt_numerodocusuarios_reg">
                    <label for="floatingInput">Numero de documento</label>
                </div>
                <div class="form-floating col-md-6">
                    <input type="text" name="claveusuario" class="form-control" placeholder="" id="txt_claveusuario_reg">
                    <label for="floatingInput">Contraseña</label>
                </div>
                <div class="form-floating col-md-6">
                    <input type="number" name="telefonousuarios" class="form-control" placeholder="" id="txt_telefonousuarios_reg">
                    <label for="floatingInput">Telefono</label>
                </div>
                <div class="form-floating col-12">
                    <input type="text" name="direccionusuario" class="form-control" placeholder="" id="txt_direccionusuario_reg">
                    <label for="floatingInput">Direccion</label>
                </div>
                <div class="form-floating col-md-6">
                    <input type="email" name="correousuarios" class="form-control" placeholder="" id="txt_correousuarios_reg">
                    <label for="floatingInput">Correo</label>
                </div>
                <div class="form-floating col-md-6">
                    <input type="number" name="roles_idroles" class="form-control d-none" id="txt_roles_idroles_reg">
                    <%
                        rolesDAO misrolesDAO = new rolesDAO();
                        ArrayList<roles> misroles = misrolesDAO.Consultarlistadoroles("", "");
                        out.println("<select class='form-control' id='Selectidroles' size='1'>");
                        out.println("<option onclick='setroles_idroles(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                        for (roles R : misroles) {
                            out.println("<option onclick='setroles_idroles(\"" + R.getIdroles() + "\")'>" + R.getDescripcionrol() + "</option>");
                        }
                        out.println("</select>");
                    %>
                    <label for="floatingInput">Rol</label>
                </div>
                <div class="form-floating col-md-6">
                    <input type="number" name="estado_usuario_idestadousuario" class="form-control d-none" id="txt_estado_usuario_idestadousuario_reg">
                    <%
                        estado_usuarioDAO miestadousuarioDAO = new estado_usuarioDAO();
                        ArrayList<estado_usuario> miestado = miestadousuarioDAO.Consultarlistadoestado_usuario("", "");
                        out.println("<select class='form-control' id='Selectidestadousuario' size='1'>");
                        out.println("<option onclick='setestado_usuario_idestadousuario(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                        for (estado_usuario E : miestado) {
                            out.println("<option onclick='setestado_usuario_idestadousuario(\"" + E.getIdestadousuario() + "\")'>" + E.getDescripcionestadousuario() + "</option>");
                        }
                        out.println("</select>");
                    %>
                    <label for="floatingInput">Estado usuario</label>
                </div>
                <div class="form-floating col-md-6">
                    <input type="number" name="genero_idgenero" class="form-control d-none" id="txt_genero_idgenero_reg">
                    <%
                        GeneroDAO migeneroDAO = new GeneroDAO();
                        ArrayList<genero> migenero = migeneroDAO.Listadogenero("", "");
                        out.println("<select class='form-control' id='Selectidgenero' size='1'>");
                        out.println("<option onclick='setgenero_idgenero(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                        for (genero G : migenero) {
                            out.println("<option onclick='setgenero_idgenero(\"" + G.getIdgenero() + "\")'>" + G.getDescripciongenero() + "</option>");
                        }
                        out.println("</select>");
                    %>
                    <label for="floatingInput">Genero</label>
                </div>
                <div id="controlRegistro" class="bd-example d-none">
                    <input id="txt_bandera_reg" type="text" class="form-control" name="banderaRegistro">
                </div>
                <button type="submit" class="btn btn-success">Registrar</button>
            </form>
        </div>

        <div id="Actualizar" class="d-none">
            <h1>Actualizar usuarios</h1>
            <form action="/VISION/ActualizarUsuarios" method="post">
                <h5>Nombres </h5>
                <input type="text" name="nombreusuarios" class="form-control" id="txt_nombreusuarios_Reg" value="<%=request.getParameter("Nombres")%>">
                <br>
                <h5>Apellidos</h5>
                <input type="text" name="apellidousuarios" class="form-control" id="txt_apellidousuarios_reg" value="<%=request.getParameter("Apellidos")%>">
                <br>
                <h5><strong>Tipo documento</strong></h5>
                <input type="number" name="tipo_documento_idtipodoc" class="form-control" id="txt_tipo_documento_idtipodoc_reg" value="<%=request.getParameter("Tipo_doc")%>"> <br>
                <br>
                <h5>Identificación Usuario</h5>
                <input type="number" name="numerodocusuario" class="form-control" id="txt_numerodocusuario_reg" value="<%=request.getParameter("NumeroDoc")%>">
                <br>
                <h5>Contraseña</h5>
                <input type="text" name="claveusuario" class="form-control" id="txt_claveusuario_reg" value="<%=request.getParameter("Contrasena")%>">
                <br>
                <h5>Telefono</h5>
                <input type="number" name="telefonousuarios" class="form-control" id="txt_telefonousuarios_reg" value="<%=request.getParameter("Telefono")%>">
                <br>
                <h5>Dirección</h5>
                <input type="text" name="direccionusuario" class="form-control" id="txt_direccionusuario_reg" value="<%=request.getParameter("Direccion")%>">
                <br>
                <h5>Correo</h5>
                <input type="text" name="correousuarios" class="form-control" id="txt_correousuarios_reg" value="<%=request.getParameter("Correo")%>">
                <br>
                <h5><strong>Rol usuario</strong></h5>
                <input type="number" name="roles_idroles" class="form-control" id="txt_roles_idroles_reg" value="<%=request.getParameter("Tipo_usuario")%>">
                <br>
                <br>
                <h5><strong>Estado usuario</strong></h5>
                <input type="number" name="estado_usuario_idestadousuario" class="form-control" id="txt_estado_usuario_idestadousuario_Reg" value="<%=request.getParameter("Estado_usuario")%>">
                <br>
                <br>
                <h5><strong>Genero</strong></h5>
                <input type="number" name="genero_idgenero" class="form-control" id="txt_genero_idgenero_reg" value="<%=request.getParameter("Genero")%>">
                <button type="submit" class="btn btn-success">Actualizar</button>
            </form>
        </div>    

        <br>
        <div id="Listado" class="bd-example">
            <form action="/VISION/ConsultaUsuarios" method="post">
                <div class="row justify-content-md-center">
                    <div id="ControlRegistro" class="input-group">
                        <input id="txt_Id_Consultado" type="text" class="form-control input-search" name="IdConsultado" value="<%=buscando%>" autofocus="autofocus" placeholder="Ingresar Número de documento."/>
                        <button type="button" class="btn btn-primary" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="realizarBusqueda()">Buscar</button>
                    </div>    
                    <div>
                        <h2 class="title-table">Listado Usuarios</h2>
                        <div id="Tabla_usuarios">

                            <% usuariosDAO misusuariosDAO = new usuariosDAO();
                                ArrayList<usuarios> milistausuarios = new ArrayList<usuarios>();
                                milistausuarios = misusuariosDAO.Consultarlistadousuarios(buscando, buscando);
                                out.println("<table class='table table-dark table-striped table-hover table-bordered'><tr><td>Identificacion</td><td>Nombre</td><td>Apellido</td><td>Contraseña</td><td>Correo</td><td>Telefono</td><td>Direccion</td><td>Rol</td><td>Genero</td><td>Estado</td><td>Tipo documento</td><td>Editar</td><td>Eliminar</td></tr>");
                                for (usuarios U : milistausuarios) {
                                    out.println("<tr>");
                                    out.println("<td>" + U.getNumerodocusuario() + "</td>");
                                    out.println("<td>" + U.getNombreusuarios() + "</td>");
                                    out.println("<td>" + U.getApellidousuarios() + "</td>");
                                    out.println("<td>" + U.getClaveusuario() + "</td>");
                                    out.println("<td>" + U.getCorreousuarios() + "</td>");
                                    out.println("<td>" + U.getTelefonousuarios() + "</td>");
                                    out.println("<td>" + U.getDireccionusuario() + "</td>");
                                    out.println("<td>" + U.getRoles_idroles() + "</td>");
                                    out.println("<td>" + U.getGenero_idgenero() + "</td>");
                                    out.println("<td>" + U.getEstado_usuario_idestadousuario() + "</td>");
                                    out.println("<td>" + U.getTipo_documento_idtipodoc() + "</td>");
                                    out.println("<td>" + "<button type = 'submit' class='btn btn-primary btn btn-login' value=''name='Actualizar'onclick='SetIdConsulta(" + U.getNumerodocusuario() + ")'/>" + "" + "<i class='fas fa-pencil-alt'></i>" + "</button>" +  "</td>");
                                    out.println("<td>" + "<button type = 'submit' class='btn btn-danger btn btn-login' value=''name='Eliminar'onclick='SetIdConsulta(" + U.getNumerodocusuario() + ")'/>" + "" + "<i class='fas fa-trash-alt'></i>" + "</button>" + "</td>");
                                    out.println("</tr>");
                                }
                                out.println("</table>");
                            %>
                        </div>  
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>