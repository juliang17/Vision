<%-- 
    Document   : RegistroProveedores
    Created on : 27/11/2020, 08:19:29 AM
    Author     : santy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="../Javascript/ValidacionRegistroProveedor.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro proveedores</h1>
        <form action="/VISION/RegistroProveedores" method="post" onsubmit="return ValidarProveedores()">
            <label>Nombre</label>
            <input type="text" name="nombreproveedores" class="form-control"
                   placeholder="Nombre de proveedor" id="txt_nombreproveedores_reg">
            <br> <br>
            <label>Correo</label>
            <input type="text" name="correoproveedores" class="form-control"
                   placeholder="Correo de proveedor" id="txt_correoproveedores_reg">
            <br> <br>
            <label>Telefono</label>
            <input type="text" name="telefonoproveedores" class="form-control"
                   placeholder="Telefono de proveedor" id="txt_telefonoproveedores_reg">
            <br> <br>
            <div id="ControlsitoRegistro" class="bd-example none">
                <input id="txt_Banderota_Reg" type="text" class="form-control" name="BanderaReg">
            </div>
            <br> <br>
            <button type="submit" class="boton">Registrar</button>
        </form>
    </body>
</html>
