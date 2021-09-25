<%@page import="modelo.productos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlador.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int dato;
    String a = null;
    String b = null;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <title>Movimientos - Facturación</title>
    </head>
    <body onload="visualizaOculta('<%=request.getParameter("Vista")%>');">
        <% String buscando = request.getParameter("buscando");
            if (buscando == null) {
                buscando = "";
            }
        %>
        <div id="Registrar" class="bd-example">
            <div class="contenedor">
                <div class="modal-content">
                    <center>
                        <h3>Factura</h3>
                    </center>
                    <form action="" class="col-12" class="row g-3">
                        <center><a href="registrarVenta.jsp" class="btn btn-primary btn-md" type="submit"><b>Registrar venta</b></a></center>
                        <div class="form-row">
                            <div class="col-md-12">
                                <br>
                                <%
                                    out.println("<table class='table table-dark table-striped table-hover table-bordered'>");
                                    ProductoDAO proDAO = new ProductoDAO();
                                    ArrayList<productos> prod;
                                    if((a != null) && (b != null)){
                                        prod = proDAO.ConsultarCarrito(a, b);
                                    } else {
                                        prod = proDAO.listadoproductos("","");
                                    }
                                    int cont = 1;
                                    out.println("<tr>");
                                    for(productos P : prod){
                                        out.println("<td>");
                                        out.println("<br><center><div class='productosca d-none'>" + P.getReferenciaproducto() + "<div></center>");
                                            out.println("<br><center><div class='nameProduct'  >" + P.getNombreproducto()+ "<div></center>");
                                            out.println("<br><center><div class='preProduct'  >" + "Precio:" + " " + "<div>" + P.getPrecio()+ "</div>" + "<div></center>");
                                            out.println("<br><center><div class='nameProduct'  >" + P.getDescripcionproducto()+ "<div></center>");
                                        out.println("<br><center><a href=añadirCarrito.jsp?id='" + P.getReferenciaproducto()+"' class='btn btn-warning' type='submit'>Añadir Carrito</a></center>");
                                        String codigos = P.getReferenciaproducto();
                                        out.println("</td>");
                                        cont++;
                                        if(cont>3){
                                            cont=1;
                                            out.println("</tr>");
                                            out.println("<tr>");
                                        }
                                    }
                                    out.println("</table>");
                                %>
                            </div>
                        </div>
                        <div id="controlRegistro" class="bd-example d-none">
                            <input id="txt_bandera_reg" type="text" class="form-control" name="banderaRegistro">
                        </div>
                        <br>
                        <center>
                        </center>
                        <br>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
