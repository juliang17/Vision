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

/**
 *
 * @author santy
 */
@WebServlet(name = "ActualizarMovimiento", urlPatterns = {"/ActualizarMovimiento"})
public class ActualizarMovimiento extends HttpServlet {

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
        String medio_de_pago_idMedioDePago = request.getParameter("medio_de_pago_idMedioDePago");

        int sub = Integer.parseInt(subtotal);
        int Iv = Integer.parseInt(iva);
        int des = Integer.parseInt(descuento);
        int tot = Integer.parseInt(total);
        int TipoDocC = Integer.parseInt(tipo_doc_contable_idtipodoccontable);
        int medio = Integer.parseInt(medio_de_pago_idMedioDePago);

        movimientoDAO MovDAO = new movimientoDAO();
        movimiento Mov = new movimiento();

        Mov.setFechamovimiento(fechamovimiento);
        Mov.setSubtotal(sub);
        Mov.setIva(Iv);
        Mov.setDescuento(des);
        Mov.setTotal(tot);
        Mov.setTipo_doc_contable_idtipodoccontable(TipoDocC);
        Mov.setMedio_de_pago_idmediodepago(medio);

        System.out.println("fecha de movimiento " + fechamovimiento);
        String respuestaRegistrada = MovDAO.Actualizarmovimiento(Mov);
        if (respuestaRegistrada.length() == 0) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('" + "Actualización Realizada." + "');");
            out.println("window.location.href = '/VISION/vista/Formularios/GestionMovimiento.jsp';");
            out.println("</script>");
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('" + "No se ha podido realizar la actualizacion." + "\n" + respuestaRegistrada + "');");
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
