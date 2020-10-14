<%-- 
    Document   : Registrarusuarios
    Created on : 13/10/2020, 10:23:47 PM
    Author     : santy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>MAXILINI</h1>
            <h2>Registro de usuarios</h2>
            <form action="Registrarusuarios" method="post" onsubmit="return ValidacionReg">
                <div class="formularioR">
                    <label 
                        for="Identificacion"><strong>Identificacion</strong></label>
                    <input id="txt_numerodocusuarios_reg" type="text" class="form-control" 
                    value="" placeholder="Numero de identificacion" name="identificacion"/>
                    <br><br>
                    <label
                        for="Nombre"><strong>Nombre</strong></label>
                    <input id="txt_nombreusuarios_reg" type="text" class="form-control"
                           value="" placeholder="Digite su nombre" name="Nombre"/>
                    
                </div>  
            </form>
    </body>
</html>
