<%@page import="modelo.productos"%>
<%@page import="controlador.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String codigos = request.getParameter("id");

    ProductoDAO proDAO = new ProductoDAO();
    productos pro = proDAO.Consultaproductos(codigos);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>        <title>Agregar al carrito</title>
    </head>
    <body>
        <table class='table table-dark table-striped table-hover table-bordered'>
            <tr>
                <th><center><a href="GestionarMovimientos.jsp" class="btn btn-success"><b>Catálogo</b></a>
                <a href="../../PaginaPrincipal.jsp" class="btn btn-danger"><b>Regresar menú</b></a></center></th>
    </tr>
</table>
<br>
<div class="contenedor">
    <div class="row">
        <div class="col-sm-5 mx-auto">
            <h2 align="center"><p>Añadir producto a carrito</p></h2>
            <form action="/VISION/agregarCarrito" method="Post">
                <table class='table table-dark table-striped table-hover table-bordered'>
                    <tr>
                        <th><label class="form-control"><b>Código</b></label></th>
                        <th><input type="text" class="form-control" name="txtCodigo" value="<%=pro.getIdproductos()%>" readonly></th>
                    </tr>
                    <tr>
                        <th><label class="form-control"><b>Descripción</b></label></th>
                        <th><input type="text" class="form-control" name="txtNombre" value="<%=pro.getDescripcionproducto()%>" readonly></th>
                    </tr>
                    <tr>
                        <th><label class="form-control"><b>Precio</b></label></th>
                        <th><input type="text" class="form-control" name="txtPrecio" value="<%=pro.getPrecio()%>" readonly></th>
                    </tr>
                    <tr>
                        <th><label class="form-control"><b>Cantidad</b></label></th>
                        <th><input type="number" class="form-control" name="txtCantidad" min="1" value="1" pattern="^[0-9]+"></th>
                    </tr>
                    <tr>
                        <th>Iva:</th>
                        <th><input type="text" name="txtIva" value="<%=pro.getIvaproducto()%>" readonly></th>
                    </tr>
                    <tr>
                        <th colspan="3"><center><input type="submit" class="btn btn-success" name="btnAñadir" value="Añadir"></center></th>
                    <input type="hidden" name="accion" value="añadirCarrito">
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>

</body>
</html>
