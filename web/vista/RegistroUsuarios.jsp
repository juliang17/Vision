
<%@page import="modelo.genero"%>
<%@page import="controlador.GeneroDAO"%>
<%@page import="modelo.estado_usuario"%>
<%@page import="controlador.estado_usuarioDAO"%>
<%@page import="modelo.roles"%>
<%@page import="controlador.rolesDAO"%>
<%@page import="modelo.tipo_documento"%>
<%@page import="controlador.tipo_documentoDAO"%>
<%@page import="modelo.usuarios"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlador.usuariosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="../vista/Javascript/validarUsuarios.js" type="text/javascript"></script>
        <title>Registro Usuarios</title>
    </head>
    <body onload="visualizaOculta('<%=request.getParameter("Vista")%>');">
        <% String buscando = request.getParameter("buscando");
            if (buscando == null) {
                buscando = "";
            }
        %>
        <div class="row justify-content-md-center">
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
                <button type="button" class="btn btn-secondary" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false" onClick="VolverAlInicio()">
                    Volver al Inicio
                </button>
            </div>
        </div>
        <div id="Registrar" class="d-none">
            <h1>Registro de usuarios</h1>
            <form action="/VISION/RegistroUsuarios" method="post" onsubmit="return RegistroUsuarios()">
                <h5>Nombres </h5>
                <input type="text" name="nombreusuarios" class="form-control" placeholder="Nombres" id="txt_nombreusuarios_Reg"> 
                <br>
                <h5>Apellidos</h5>
                <input type="text" name="apellidousuarios" class="form-control" placeholder="Apellidos" id="txt_apellidousuarios_reg">
                <br>
                <label for="idtipodoc"><strong>Tipo documento</strong></label>
                <input id="txt_tipo_documento_idtipodoc_reg" type="text" class="form-control d-none" name= "idtipodoc"/> <br>
                <%
                    tipo_documentoDAO mitipodocDAO = new tipo_documentoDAO();
                    ArrayList<tipo_documento> mitipodoc = mitipodocDAO.Consultarlistadotipo_documento("");
                    out.println("<select class='form-control' id='Selectidtipodoc' size='1'>");
                    out.println("<option onclick='settipo_documento_idtipodoc(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                    for (tipo_documento T : mitipodoc) {
                        out.println("<option onclick='settipo_documento_idtipodoc(\"" + T.getidtipodoc() + "\")'>" + T.getdescripciontipodoc() + "</option>");
                    }
                    out.println("</select>");
                %>
                <br>
                <h5>Identificación Usuario</h5>
                <input type="text" name="numerodocusuarios" class="form-control" placeholder="Numero identificación" id="txt_numerodocusuarios_reg">
                <br>
                <h5>Contraseña</h5>
                <input type="password" name="contraseñausuario" class="form-control" placeholder="clave" id="txt_contraseñausuario_reg">
                <br>
                <h5>Telefono</h5>
                <input type="text" name="telefonousuarios" class="form-control" placeholder="Telefono" id="txt_telefonousuarios_reg">
                <br>
                <h5>Dirección</h5>
                <input type="text" name="direccionusuario" class="form-control" placeholder="Direccion" id="txt_direccionusuario_reg">
                <br>
                <h5>Correo</h5>
                <input type="text" name="correousuario" class="form-control" placeholder="Correo" id="txt_correousuario_reg">
                <br>
                <label for="idroles"><strong>Rol usuario</strong></label>
                <input id="txt_roles_idroles_reg" type="text" class="form-control d-none" name= "idroles"/> <br>
                <%
                    rolesDAO misrolesDAO = new rolesDAO();
                    ArrayList<roles> misroles = misrolesDAO.Consultarlistadoroles("");
                    out.println("<select class='form-control' id='Selectidroles' size='1'>");
                    out.println("<option onclick='setroles_idroles(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                    for (roles R : misroles) {
                        out.println("<option onclick='setroles_idroles(\"" + R.getidroles() + "\")'>" + R.getdescripcionrol() + "</option>");
                    }
                    out.println("</select>");
                %>
                <br>
                <br>
                <label for="idestadousuario"><strong>Estado usuario</strong></label>
                <input id="txt_estado_usuario_idestadousuario_reg" type="text" class="form-control d-none" name= "idestadousuario"/> <br>
                <%
                    estado_usuarioDAO miestadousuarioDAO = new estado_usuarioDAO();
                    ArrayList<estado_usuario> miestado = miestadousuarioDAO.Consultarlistadoestado_usuario("");
                    out.println("<select class='form-control' id='Selectidestadousuario' size='1'>");
                    out.println("<option onclick='setestado_usuario_idestadousuario(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                    for (estado_usuario E : miestado) {
                        out.println("<option onclick='setestado_usuario_idestadousuario(\"" + E.getidestadousuario() + "\")'>" + E.getdescripcionestadousuario() + "</option>");
                    }
                    out.println("</select>");
                %>
                <br>
                <br>
                <label for="idgenero"><strong>Genero</strong></label>
                <input id="txt_genero_idgenero_reg" type="text" class="form-control d-none" name= "idgenero"/> <br>
                <%
                    GeneroDAO migeneroDAO = new GeneroDAO();
                    ArrayList<genero> migenero = migeneroDAO.Consultarlistadogenero("");
                    out.println("<select class='form-control' id='Selectidgenero' size='1'>");
                    out.println("<option onclick='setgenero_idgenero(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                    for (genero G : migenero) {
                        out.println("<option onclick='setgenero_idgenero(\"" + G.getidgenero() + "\")'>" + G.getdescripciongenero() + "</option>");
                    }
                    out.println("</select>");
                %>
                <br>
                <br>
                <br>
                <div id="controlRegistro" class="bd-example d-none">
                    <input id="txt_bandera_reg" type="text" class="form-control" name="banderaRegistro">
                </div>
                <button type="submit" class="btn btn-success">Registrar</button>   

            </form>
        </div>

        <div class="container">
            <div class="row justify-content-md-center">
                <div id="Actualizar" class="bd-example d-none">
                    <h1>Actualizar usuarios</h1>
                    <form action="/VISION/ActualizarUsuario" method = "post">
                        <div class ="form-group">
                            <label>Identificacion</label>
                            <input type="text" class="form-control" readonly name="numerodocusuarios" value="<%=request.getParameter("numerodocusuarios")%>"/>
                        </div>
                        <div class ="form-group">
                            <label>Nombres</label>
                            <input type="text" class="form-control" name= "nombreusuarios" value="<%=request.getParameter("nombreusuarios")%>"/>
                        </div>
                        <div class ="form-group">
                            <label>Apellidos</label>
                            <input type = "text" class="form-control" name= "apellidousuarios" value="<%=request.getParameter("apellidousuarios")%>"/>
                        </div>
                        <div class ="form-group">
                            <label>Correo</label>
                            <input type = "text" class="form-control" name= "correousuarios" value="<%=request.getParameter("correousuarios")%>"/>
                        </div>
                        <div class ="form-group">
                            <label>Telefono</label>
                            <input type = "text" class="form-control" name= "telefonousuarios" value="<%=request.getParameter("telefonousuarios")%>"/>
                        </div>
                        <div class ="form-group">
                            <label>Direccion</label>
                            <input type = "text" class="form-control" name= "direccionusuario" value="<%=request.getParameter("direccionusuario")%>"/>
                        </div>
                        <div class ="form-group">
                            <label>Contraseña</label>
                            <input type = "text" class="form-control" name= "contraseñausuario" value="<%=request.getParameter("contraseñausuario")%>"/>
                        </div>
                        <div class ="form-group">
                            <label>Tipo documento</label>
                            <input type = "text" class="form-control" name= "tipo_documento_idtipodoc" value="<%=request.getParameter("tipo_documento_idtipodoc")%>"/>
                        </div>
                        <div class ="form-group">
                            <label>Rol</label>
                            <input type = "text" class="form-control" name= "roles_idroles" value="<%=request.getParameter("roles_idroles")%>"/>
                        </div>
                        <div class ="form-group">
                            <label>Genero</label>
                            <input type = "text" class="form-control" name= "genero_idgenero" value="<%=request.getParameter("genero_idgenero")%>"/>
                        </div>
                        <div class ="form-group">
                            <label>Estado usuario</label>
                            <input type = "text" class="form-control" name= "estado_usuario_idestadousuario" value="<%=request.getParameter("estado_usuario_idestadousuario")%>"/>
                        </div>
                        <div id="ControlRegistro" class="bd-example d-none">
                            <input type = "text" class="form-control" name=
                                   "BanderaActualiza"/>
                        </div>
                        <div class="row justify-content-md-center">
                            <div class="btn-group">
                                <input type = "submit" class="btn btn-primary form-control
                                       btn btn-login" value= "Actualizar"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>        


        <br>
        <div id="Listado" class="container">
            <form action="/VISION/ConsultarUsuarios" method="post">
                <div class="row justify-content-md-center">
                    <div id="Listado" class="bd-example">
                        <div id="ControlRegistro" class="input-group">
                            <input id ="txt_Id_Consultado" type = "text" class="form-control"
                                   name= "IdConsultado" value="<%=buscando%>" autofocus
                                   placeholder="Buscar por Identificacion,Nombres y Apellidos..."/>
                            <button type="button" class="btn btn-primary" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false"
                                    onClick="realizarBusqueda()">Buscar</button>
                        </div>
                        <div>
                            <h1>Listado Usuarios</h1>
                            <div id="Tabla_usuarios">

                                <% usuariosDAO misusuariosDAO = new usuariosDAO();
                                    ArrayList<usuarios> milistausuarios = new ArrayList<usuarios>();
                                    milistausuarios = misusuariosDAO.Consultarlistadousuarios(buscando, buscando, buscando);
                                    out.println("<table class='table table-dark'><tr><td>Identificacion</td><td>Nombre</td><td>Apellido</td><td>Correo</td><td>Telefono</td><td>Direccion</td><td>Rol</td><td>Genero</td><td>Estado</td><td>Tipo documento</td><td>Editar</td><td>Eliminar</td></tr>");
                                    for (usuarios U : milistausuarios) {
                                        out.println("<tr>");
                                        out.println("<td>" + U.getnumerodocusuario() + "</td>");
                                        out.println("<td>" + U.getnombreusuarios() + "</td>");
                                        out.println("<td>" + U.getapellidousuarios() + "</td>");
                                        out.println("<td>" + U.getcorreousuarios() + "</td>");
                                        out.println("<td>" + U.gettelefonousuarios() + "</td>");
                                        out.println("<td>" + U.getdireccionusuario() + "</td>");
                                        out.println("<td>" + U.getroles_idroles() + "</td>");
                                        out.println("<td>" + U.getgenero_idgenero() + "</td>");
                                        out.println("<td>" + U.getestado_usuario_idestadousuario() + "</td>");
                                        out.println("<td>" + U.gettipo_documento_idtipodoc() + "</td>");
                                        out.println("<td>" + "<input type = 'submit' class='btn btn-primary form-control btn btn-login' value='Actualizar'name='Actualizar'onclick='SetIdConsulta(" + U.getnumerodocusuario() + ")'/>"
                                                + "</td>");
                                        out.println("<td>" + "<input type = 'submit' class='btn btn-warning form-control btn btn-login' value= 'Eliminar'name='Eliminar'onclick='SetIdConsulta(" + U.getnumerodocusuario() + ")'/>"
                                                + "</td>");
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
    </body>
</html>