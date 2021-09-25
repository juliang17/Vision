<%@page import="java.util.ArrayList"%>
<%@page import="modelo.medio_de_pago"%>
<%@page import="controlador.mediodepagoDAO"%>
<%@page import="modelo.tipo_mov"%>
<%@page import="controlador.tipo_movDAO"%>
<%@page import="modelo.usuarios"%>
<%@page import="controlador.usuariosDAO"%>
<%@page import="modelo.detalle_movimiento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ArrayList<detalle_movimiento> listaD;
    listaD = null;
    double total = 0, subtotal = 0, iva = 0;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <title>Registrar Venta</title>
    </head>
    <br>
    <div class="contenedor">
        <div class="row">
            <div class="col-sm-8 mx-auto">
                <h2 align="center"><p>Registrar venta</p></h2>
                <br>
                <form action="/VISION/grabarFactura" method="Post">
                    <table class='table table-dark table-striped table-hover table-bordered'>
                        <tr>
                            <th><label class="form-control"><b>Fecha</b></label></th>
                            <th colspan="3"><input class="form-control" type="date" id="txtfecha" name="txtfecha" required></th>
                        <script>
                            var now = new Date();
                            var day = ("0" + now.getDate()).slice(-2);
                            var month = ("0" + (now.getMonth() + 1)).slice(-2);
                            var today = now.getFullYear() + "-" + (month) + "-" + (day);
                            $("#txtfecha").val(today);
                        </script>
                        <th><label class="form-control"><b>Documento</b></label></th>
                        <th colspan="3"><input class="form-control" type="text" id="txtdocumento" name="txtdocumento" required=></th>
                        </tr>
                        <tr>
                            <th><label class="form-control"><b>Cliente</b></label></th>
                            <th colspan="4">
                                <%
                                    usuariosDAO userDAO = new usuariosDAO();
                                    ArrayList<usuarios> user = userDAO.Consultarlistadousuarios("", "");
                                    out.println("<select class='form.control' id='Clientepost' name='Clientepost' required>");
                                    for (usuarios U : user) {
                                        String completo = U.getNombreusuarios() + " " + U.getApellidousuarios();
                                        out.println("<option value='" + U.getIdusuarios() + "'>" + completo + "</option>");
                                    }
                                    out.println("</select>");
                                %>
                            </th>
                        </tr>
                        <tr>
                            <th><label class="form-control"><b>Tipo Movimiento</b></label></th>
                            <th colspan="3">
                                <%
                                    tipo_movDAO tipoMovDAO = new tipo_movDAO();
                                    ArrayList<tipo_mov> tipoMov = tipoMovDAO.ListadoTipoMov("", "");
                                    out.println("<select class='form-control' id='Tipodpost' name='Tipodpost' required>");
                                    for (tipo_mov T : tipoMov) {
                                        out.println("<option value='" + T.getId_tipo_mov() + "'>" + T.getDescripcionTipoMov() + "</option>");
                                    }
                                    out.println("</select>");
                                %>
                            </th>
                            <th><label class="form-control"><b>Forma de pago</b></label></th>
                            <th colspan="3">
                                <%
                                    mediodepagoDAO medioDAO = new mediodepagoDAO();
                                    ArrayList<medio_de_pago> medio = medioDAO.ListadoMedioDePago("", "");
                                    out.println("<select class='form-control' id='medioPost' name='medioPost' required>");
                                    for (medio_de_pago M : medio) {
                                        out.println("<option value='" + M.getIdMedioDePago() + "'>" + M.getDescripcionmediodepago() + "</option");
                                    }
                                    out.println("</select>");
                                %>
                            </th>
                        </tr>
                    </table>
                    <table class='table table-dark table-striped table-hover table-bordered'>
                        <tr>
                            <td align="center">Nombre</td>
                            <td align="center">Precio</td>
                            <td align="center">Cantidad</td>
                            <td align="center">Subtotal</td>
                            <td align="center">Iva</td>
                            <td align="center">Total</td>
                            <td align="center">Acción</td>
                        </tr>
                        <%
                            total = 0;
                            subtotal = 0;
                            iva = 0;
                            listaD = (ArrayList<detalle_movimiento>) session.getAttribute("carrito");
                            if (listaD != null) {
                                for (detalle_movimiento d : listaD) {
                        %>
                        <tr>
                            <td><%=d.getNombre_producto()%></td>
                            <td align="right"><%=d.getPrecio()%></td>
                            <td align="right"><%=d.getCantidad()%></td>
                            <td align="right"><%=Math.round(d.getSubtotal() * 100.0) / 100.0%></td>
                            <td align="right"><%=Math.round(d.getIva() * 100.0) / 100.0%></td>
                            <td align="right"><%=Math.round(d.getTotal_producto() * 100.0) / 100.0%></td>
                            <% subtotal = subtotal + d.getSubtotal(); %>
                            <% iva = iva + d.getIva(); %>
                            <% total = total + d.getTotal_producto();%>
                            <td><a href="../../VISION/removerElementoCarrito?txteli=<%=d.getProductos_idproductos()%>" class="btn btn-danger" >Eliminar</a></td>
                        </tr>    
                        <%
                                }
                            }
                        %>
                        <style>
                            .valores
                            {
                                font-size: 17px;
                                color: black;
                                background: white;
                            }
                        </style>
                        <tr>
                            <th colspan="3"></th>
                            <th><div align="right" class="valores"><%=String.format("%.2f", subtotal)%></div><input type="hidden" id="txtsubtotal" name="txtsubtotal" value="<%=subtotal%>"/></th>
                            <th><div align="right" class="valores"><%=String.format("%.2f", iva)%></div><input type="hidden" id="txtiva" name="txtiva" value="<%=iva%>"/></th>
                            <th><div align="right" class="valores"><%=String.format("%.2f", total)%></div><input type="hidden" id="txttotal" name="txttotal" value="<%=total%>"/></th>
                                <% session.setAttribute("FTotal", total); %>
                        </tr>
                        <tr>
                            <th colspan="7">
                                <% if (listaD != null) {
                                %>
                        <center><input type="submit" class="btn btn-success btn-sm" name="RegistroDetalleMovimiento" value="Registrar"></center>
                            <%
                            } else {
                            %>
                        <center><input disabled="true" type="submit" class="btn btn-secondary btn-sm" name="RegistroDetalleMovimiento" value="Registrar"></center>
                            <%
                                }
                            %>

                        </th>
                        </tr>
                        <tr>
                            <th colspan="7"><center><a href="GestionarMovimientos.jsp" class="btn btn-warning btn-sm" type="submit"><b>Seguir comprando</b></a> 
                            <% if (listaD != null) { %>
                        </center> <% }%></th>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</html>
