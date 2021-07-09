/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controlador.referenciaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.referencia_de_pago;

/**
 *
 * @author santy
 */
@WebServlet(name = "ActualizarReferencia", urlPatterns = {"/ActualizarReferencia"})
public class ActualizarReferencia extends HttpServlet {

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
            
        String fechadepago = request.getParameter("fechadepago");
        String medio_de_pago_idMedioDePago = request.getParameter("medio_de_pago_idMedioDePago");

        int Medio = Integer.parseInt(medio_de_pago_idMedioDePago);

        referenciaDAO mi_referenciae_pago_dao = new referenciaDAO();
        referencia_de_pago mi_referencia_pago = new referencia_de_pago();

        mi_referencia_pago.setFechadepago(fechadepago);
        mi_referencia_pago.setMedio_de_pago_idMedioDePago(Medio);
        
        System.out.println("fecha de pago " + fechadepago);
        String respuestaRegistrada = mi_referenciae_pago_dao.ActualizarReferencia_de_pago(mi_referencia_pago);
        if(respuestaRegistrada.length() == 0) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('"+"Actualización Realizada."+"');");
            out.println("window.location.href = '/VISION/vista/Formularios/GestionReferencia.jsp';");
            out.println("</script>");
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('"+"No se ha podido realizar la actualizacion."+"\n"+respuestaRegistrada +"');");
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
