/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controlador.movimientoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.movimiento;

@WebServlet(name = "RegistroMovimientos", urlPatterns = {"/RegistroMovimientos"})
public class RegistroMovimientos extends HttpServlet {

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
           
        String fechamovimiento = request.getParameter("fechamovimiento");
        String subtotal = request.getParameter("subtotal");
        String iva = request.getParameter("iva");
        String descuento = request.getParameter("descuento");
        String total = request.getParameter("total");
        String tipo_doc_contable_idtipodoccontable = request.getParameter("tipo_doc_contable_idtipodoccontable");
        String medio_de_pago_idmediodepago = request.getParameter("medio_de_pago_idmediodepago");

        String BanderaEstado = request.getParameter("BanderaRegistro");
        
        int Subtotal = Integer.parseInt(subtotal);
        int Iva = Integer.parseInt(iva);
        int Descuento = Integer.parseInt(descuento);
        int Total = Integer.parseInt(total);
        int Tipo = Integer.parseInt(tipo_doc_contable_idtipodoccontable);
        int Medio = Integer.parseInt(medio_de_pago_idmediodepago);
        
        
        movimientoDAO mdao = new movimientoDAO();
        movimiento m = new movimiento();
        
        m.setFechamovimiento(fechamovimiento);
        m.setSubtotal(Subtotal);
        m.setIva(Iva);
        m.setDescuento(Descuento);
        m.setTotal(Total);
        m.setTipo_doc_contable_idtipodoccontable(Tipo);
        m.setMedio_de_pago_idmediodepago(Medio);
        
        System.out.println("El valor es " + BanderaEstado);
        if (BanderaEstado.equals("Correcto")) {
            String respuestaRegistrada = mdao.AdicionarMovimiento(m);
            System.out.println("Res " + respuestaRegistrada);
            System.out.println("Res " + respuestaRegistrada.length());
            if (respuestaRegistrada.length() == 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('" + "Movimiento registrado con éxito." + "');");
                out.println("window.location.href = '/VISION/vista/Formularios/GestionMovimiento.jsp';");
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
