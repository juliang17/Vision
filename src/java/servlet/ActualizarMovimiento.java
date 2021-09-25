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

        String numero_documento = request.getParameter("numero_documento");
        String fechamovimiento = request.getParameter("fechamovimiento");
        String subtotal = request.getParameter("subtotal");
        String iva = request.getParameter("iva");
        String estadoMov = request.getParameter("estadoMov");
        String total = request.getParameter("total");
        String usuarios_idusuarios = request.getParameter("usuarios_idusuarios");
        String tipo_mov_id_tipo_mov = request.getParameter("tipo_mov_id_tipo_mov");
        String medio_de_pago_idMedioDePago = request.getParameter("medio_de_pago_idMedioDePago");

        int sub = Integer.parseInt(subtotal);
        int Iv = Integer.parseInt(iva);
        int tot = Integer.parseInt(total);
        int usuarios = Integer.parseInt(usuarios_idusuarios);
        int TipoMov = Integer.parseInt(tipo_mov_id_tipo_mov);
        int medio = Integer.parseInt(medio_de_pago_idMedioDePago);
        int estadoM = Integer.parseInt(estadoMov);

        movimientoDAO MovDAO = new movimientoDAO();
        movimiento Mov = new movimiento();

        Mov.setNumero_documento(numero_documento);
        Mov.setFechamovimiento(fechamovimiento);
        Mov.setSubtotal(sub);
        Mov.setIva(Iv);
        Mov.setEstadoMov(estadoM);
        Mov.setTotal(tot);
        Mov.setUsuarios_idusuarios(usuarios);
        Mov.setMedio_de_pago_idmediodepago(medio);
        Mov.setTipo_mov_id_tipo_mov(TipoMov);

        System.out.println("fecha de movimiento " + fechamovimiento);
        String respuestaRegistrada = MovDAO.ActualizarMovimiento(Mov);
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
