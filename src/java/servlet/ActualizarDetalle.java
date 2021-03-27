/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controlador.detalleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.detalle_movimiento;

/**
 *
 * @author santy
 */
@WebServlet(name = "ActualizarDetalle", urlPatterns = {"/ActualizarDetalle"})
public class ActualizarDetalle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String descripcion = request.getParameter("descripcion");
        String cantidad = request.getParameter("cantidad");
        String precio = request.getParameter("precio");
        String iva = request.getParameter("iva");
        String subtotal = request.getParameter("subtotal");
        String productos_idproductos = request.getParameter("productos_idproductos");
        String movimiento_idmovimiento = request.getParameter("movimiento_idmovimiento");

        int Cantidad = Integer.parseInt(cantidad);
        int Precio = Integer.parseInt(precio);
        int Iva = Integer.parseInt(iva);
        int Subtotal = Integer.parseInt(subtotal);
        int Producto = Integer.parseInt(productos_idproductos);
        int Movimiento = Integer.parseInt(movimiento_idmovimiento);

        detalleDAO mi_detalle_dao = new detalleDAO();
        detalle_movimiento mi_detalle = new detalle_movimiento();

        mi_detalle.setCantidad(Cantidad);
        mi_detalle.setPrecio(Precio);
        mi_detalle.setIva(Iva);
        mi_detalle.setSubtotal(Subtotal);
        mi_detalle.setProductos_idproductos(Producto);
        mi_detalle.setMovimiento_idmovimiento(Movimiento);

        System.out.println("descripcion " + descripcion);
        String respuestaRegistrada = mi_detalle_dao.Adicionardetalle_Movimiento(mi_detalle);
        if (respuestaRegistrada.length() == 0) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('" + "Actualización Realizada." + "');");
            out.println("window.location.href = '/VISION/vista/GestionDetalle.jsp';");
            out.println("</script>");
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('" + "No se ha podido relizar la actualizacion." + "\n" + respuestaRegistrada + "');");
            out.println("</script>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
