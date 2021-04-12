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
@WebServlet(name = "ConsultarMovimiento", urlPatterns = {"/ConsultarMovimiento"})
public class ConsultarMovimiento extends HttpServlet {

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

        String Accion = request.getParameter("Actualizar");
        System.out.println("Accion " + Accion);

        String fechamovimiento = request.getParameter("IdConsultado");
        
        movimientoDAO MovDAO = new movimientoDAO();
        movimiento Mov = null;

        Mov = MovDAO.Consultarmovimiento("");
        if (Accion != null) {

            if (Mov != null) {
                response.sendRedirect("/VISION/vista/Formularios/GestionMovimiento.jsp?fechamovimiento="
                        + Mov.getFechamovimiento().toString() + "&"
                        + "subtotal=" + Mov.getSubtotal() + "&"
                        + "iva=" + Mov.getIva() + "&"
                        + "descuento=" + Mov.getDescuento() + "&"
                        + "total=" + Mov.getTotal() + "&"
                        + "tipo_doc_contable_idtipodoccontable=" + Mov.getTipo_doc_contable_idtipodoccontable() + "&"
                        + "medio_de_pago_idmediodepago=" + Mov.getMedio_de_pago_idmediodepago() + "&"
                        + "Vista=" + "Actualizar" + "&");
                System.out.println("Salio");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('" + "No se ha podido realizar la consulta." + "\n"
                        + "Por favor verificar la fecha de movimiento: " + fechamovimiento + "');");
                out.println("</script>");
            }
        } else {
            if (Mov != null) {
                String RespuestaRegistrada = MovDAO.Eliminarmovimiento(Mov);
                if (RespuestaRegistrada.length() == 0) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('" + "Eliminacion Realizada." + "');");
                    out.println("window.location.href ='/VISION/vista/Formularios/GestionMovimiento.jsp';");
                    out.println("</script>");
                } else {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('" + "No se ha podido realizar la eliminacion." + RespuestaRegistrada.replace("'", "") + "');");
                    out.println("</script>");
                }

            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('" + "No se ha podido relizar la consulta." + "\n"
                        + "Por favor verificar la identificacion: " + fechamovimiento
                        + "');");
                out.println("</script>");
            }
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
