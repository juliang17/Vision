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
 * @author Famil
 */
@WebServlet(name = "RegistroDetalle", urlPatterns = {"/RegistroDetalle"})
public class RegistroDetalle extends HttpServlet {

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
            
        String cantidad = request.getParameter("cantidad");
        String precio = request.getParameter("precio");
        String iva = request.getParameter("iva");
        String subtotal = request.getParameter("subtotal");
        String productos = request.getParameter("productos_idproductos");
        String movimiento = request.getParameter("movimiento_idmovimiento");

        String BanderaEstado = request.getParameter("BanderaRegistro");
        
        int C = Integer.parseInt(cantidad);
        int P = Integer.parseInt(precio);
        int I = Integer.parseInt(iva);
        int S = Integer.parseInt(subtotal);
        int PR = Integer.parseInt(productos);
        int M = Integer.parseInt(movimiento);
        
        
        detalleDAO ddao = new detalleDAO();
        detalle_movimiento d = new detalle_movimiento();
        
        d.setCantidad(C);
        d.setPrecio(P);
        d.setIva(I);
        d.setSubtotal(S);
        d.setProductos_idproductos(PR);
        d.setMovimiento_idmovimiento(M);
        
        System.out.println("El valor es " + BanderaEstado);
        if (BanderaEstado.equals("Correcto")) {
            String respuestaRegistrada = ddao.AdicionarDetalle(d);
            System.out.println("Res " + respuestaRegistrada);
            System.out.println("Res " + respuestaRegistrada.length());
            if (respuestaRegistrada.length() == 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('" + "Detalle Movimiento registrado con éxito." + "');");
                out.println("window.location.href = '/VISION/vista/Formularios/GestionDetalleMovimiento.jsp';");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                //out.println("alert('" + respuestaRegistrada + "');");
                out.println("alert('" + "Error encontrado: " + respuestaRegistrada.replace("'", "") + "');");
                out.println("window.history.back();");
                out.println("</script>");

            }
        } else {
            System.out.println("El valor no es correcto " + BanderaEstado);
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
