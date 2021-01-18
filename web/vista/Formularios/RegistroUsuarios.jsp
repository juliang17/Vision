<%-- 
    Document   : RegistroUsuarios
    Created on : 25/11/2020, 04:23:21 PM
    Author     : santy
--%>

<%@page import="modelo.usuarios"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlador.usuariosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
        <link href="../css/Sesion.css" rel="stylesheet" type="text/css"/>
        <script src="vista/Javascript/validacionRegistrarUsuarios.js" type="text/javascript"></script>
        <script src="../Javascript/VisualizaOculta.js" type="text/javascript"></script>
        <script src="../Javascript/RealizarBusqueda.js" type="text/javascript"></script>
        <script src="JavaScript/jquery-1.11.0.min.js"></script>
        <title>JSP Page</title>
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
        <h1>Registro de usuarios</h1>
        <form action="NuevosUsuarios" method="post" onsubmit="return RegistroUsuarios()">
            <h5>Nombres </h5>
            <input type="text" name="nombreusuarios" class="form-control" placeholder="Nombres" id="txt_nombreusuarios_Reg"> 
            <br>
            <h5>Apellidos</h5>
            <input type="text" name="apellidousuarios" class="form-control" placeholder="Apellidos" id="txt_apellidousuarios_reg">
            <br>
            <br>
            <p>Seleccione un número para seleccionar un tipo de documento</p>
            <li>1 = Cedula de ciudadania</li>
            <li>2 = Tarjeta de identidad</li >
            <br>
            <h5>Tipo de documento</h5>
            <input type="number" name="tipo_documento_idtipodoc" class="form-control" placeholder="Tipo documento" id="txt_tipo_documento_idtipodoc_reg">
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
            <p>Seleccione un número para escoger un rol de usuario</p>
            <li>1 = Administrado</li>
            <li>2 = Empleado</li>
            <br>
            <h5>Roles</h5>
            <input type="number" name="roles_idroles" class="form-control" placeholder="Roles" id="txt_roles_idroles_reg">
            <br>
            <p>Seleccione un número para seleccionar el estado de usuario</p>
            <li>1 = Activo</li>
            <li>2 = Inactivo</li>
            <br>
            <h5>Estado Usuario</h5>
            <input type="number" name="estado_usuario_idestadousuario" class="form-control" placeholder="Estado usuario" id="txt_estado_usuario_idestadousuario_reg">
            <br>
            <p>Seleccione un número para seleccionar un genero de usuario</p>
            <li>1 = Masculino</li>
            <li>2 = Femenino</li>
            <br>
            <h5>Genero</h5>
            <input type="number" name="genero_idgenero" class="form-control" placeholder="Genero" id="txt_genero_idgenero_reg">
            <br>
            <br>
            <div id="controlRegistro" class="bd-example d-none">
                <input id="txt_bandera_reg" type="text" class="form-control" name="banderaRegistro">
            </div>
            <button type="submit" class="boton">Registrar</button>   
            <br>
        </form>
        <div class="container">
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
                                        out.println("<td>" + "<input type = 'submit' class='btnbtn-primary form-control btn btn-login' value='Actualizar'name='Actualizar'onclick='SetIdConsulta(" + U.getnumerodocusuario() + ")'/>"
                                                + "</td>");
                                        out.println("<td>" + "<input type = 'submit' class='btnbtn-danger form-control btn btn-login' value= 'Eliminar'name='Eliminar'onclick='SetIdConsulta(" + U.getnumerodocusuario() + ")'/>"
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
