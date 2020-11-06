<%-- 
    Document   : Registrarusuarios
    Created on : 15/10/2020, 09:22:45 PM
    Author     : santy
--%>

<%@page import="modelo.estado_usuario"%>
<%@page import="controlador.estado_usuarioDAO"%>
<%@page import="modelo.genero"%>
<%@page import="controlador.GeneroDAO"%>
<%@page import="modelo.roles"%>
<%@page import="controlador.rolesDAO"%>
<%@page import="modelo.tipo_documento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlador.tipo_documentoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de usuarios</h1>
        <form form action="Registrarusuarios" method= "post" onsubmit="return validacionReg()">
            <div class="form-group">
                <label 
                    for="Identificacion"><strong>Identificacion</strong></label>
                <input id="txt_numerodocusuarios_Reg" type="text" class="form-control"
                       value="" placeholder="Numero de identificacion" 
                       name="numerodocusuarios">
                <br>                        <br>   
                <label 
                    for="nombres"><strong>nombres</strong></label>
                <input id="txt_nombreusuarios_Reg" type="text" class="form-control"
                       value="" placeholder="Digite su nombre" 
                       name="nombreusuarios">
                <br>                        <br> 
                <label 
                    for="apellidos"><strong>apellidos</strong></label>
                <input id="txt_apellidousuarios_Reg" type="text" class="form-control"
                       value="" placeholder="Digite su apellido" 
                       name="apellidousuarios">
                <br>                        <br> 
                <label 
                    for="correo"><strong>correo</strong></label>
                <input id="txt_correousuarios_Reg" type="text" class="form-control"
                       value="" placeholder="Digite su correo" 
                       name="correousuarios">
                <br>                        <br> 
                <label 
                    for="telefono"><strong>telefono</strong></label>
                <input id="txt_telefonousuarios_Reg" type="text" class="form-control"
                       value="" placeholder="Numero de telefono" 
                       name="telefonousuarios">
                <br>                        <br> 
                <label 
                    for="direccion"><strong>direccion</strong></label>
                <input id="txt_direccionusuario_Reg" type="text" class="form-control"
                       value="" placeholder="Digite su direccion" 
                       name="direccionusuario">
                <br>                        <br> 
                <label 
                    for="contraseña"><strong>contraseña</strong></label>
                <input id="txt_contraseñausuario_Reg" type="password" class="form-control"
                       value="" placeholder="Digite su contraseña" 
                       name="contraseñausuario">
                <br>                        <br> 
                <label for="idtipodoc"><strong>Tipo de documento</strong></label>
                <input id="txt_idtipodoc_Reg"  type="text" class="form-control d-none"
                       name="idtipodoc">
                 <br> <br>
                <%
                    tipo_documentoDAO mitipodocDAO = new tipo_documentoDAO();
                    ArrayList<tipo_documento> listatipodoc = mitipodocDAO.Consultarlistadotipo_documento("");
                    out.println("<select class='form-control ' id='Selectdescripciontipodoc' size='1'>");
                    out.println("<option onclick='setidtipodoc(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                    for (tipo_documento T : listatipodoc) {
                        out.println("<option onclick='setidtipodoc(\"" + T.getidtipodoc() + "\")'>" + T.getdescripciontipodoc() + "</option>");
                    }
                    out.println("</select>");
                %>
                <br> <br>
                <label for="idroles"><strong>Rol</strong></label>
                <input id="txt_idroles_Reg" type="text" class="form-control d-none"
                       name="idroles">
                 <br> <br>
                <%
                    rolesDAO misrolesDAO = new rolesDAO();
                    ArrayList<roles> milistaroles = misrolesDAO.Consultarlistadoroles("");
                    out.println("<select class='form-control' id='Selectdescripcionrol' size='1'>");
                    out.println("<option onclick='setidroles(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                    for (roles R : milistaroles) {
                        out.println("<option onclick='setidroles(\"" + R.getidroles() + "\")'>" + R.getdescripcionrol() + "</option>");
                    }
                    out.println("</select>");
                %>
                <br> <br>
                <label for="idgenero"><strong>Genero</strong></label>
                <input id="txt_idgenero_Reg" type="text" class="form-control d-none"
                       name="idgenero">
                 <br> <br>
                <%
                    GeneroDAO migeneroDAO = new GeneroDAO();
                    ArrayList<genero> milistagenero = migeneroDAO.Consultarlistadogenero("");
                    out.println("<select class='form-control' id='Selectdescripciongenero' size='1'>");
                    out.println("<option onclick='setidgenero(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                    for (genero G : milistagenero) {
                        out.println("<option onclick='setidgenero(\"" + G.getidgenero() + "\")'>" + G.getdescripciongenero() + "</option>");
                    }
                    out.println("</select>");
                %>
                <br> <br> 
                <label for="idestadousuario"><strong>Estado usuario</strong></label>
                <input id="txt_idestadousuario_Reg" type="text" class="form-control d-none"
                       name="idestadousuario">
                 <br> <br>
                <%
                    estado_usuarioDAO miestadousuarioDAO = new estado_usuarioDAO();
                    ArrayList<estado_usuario> milistaestado = miestadousuarioDAO.Consultarlistadoestado_usuario("");
                    out.println("<select class='form-control' id='Selectdescripcionestadousuario' size='1'>");
                    out.println("<option onclick='setidestadousuario(\"" + "" + "\")'>" + "--Seleccionar--" + "</option>");
                    for (estado_usuario E : milistaestado) {
                        out.println("<option onclick='setidgenero(\"" + E.getidestadousuario() + "\")'>" + E.getdescripcionestadousuario() + "</option>");
                    }
                    out.println("</select>");
                %>
                <br> <br>
                <div id="ControlRegistro" class="BD-example">
                    <input id="txt_Bandera_Reg" type="text" class="form-control" 
                           name="BanderaRegistro">
                </div>
                <input type="submit" class="btn btn_success btn_block 
                       bg_warning" value="Registrar">
                <input type="reset" class="btn btn_success btn_block 
                       bg_warning" value="Borrar">
                </html>

            </div>

        </form>
    </body>
