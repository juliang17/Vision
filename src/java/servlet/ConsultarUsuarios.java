/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controlador.usuariosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.usuarios;

/**
 *
 * @author santy
 */
@WebServlet(name = "ConsultarUsuarios", urlPatterns = {"/ConsultarUsuarios"})
public class ConsultarUsuarios extends HttpServlet {

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

        String numerodocusuario = request.getParameter("IdConsultado");
        usuariosDAO misUsuariosDAO = new usuariosDAO();
        usuarios Usuario = null;

        Usuario = misUsuariosDAO.Consultarusuarios(numerodocusuario);
        if (Accion != null) {

            if (Usuario != null) {
                response.sendRedirect("/VISION/vista/RegistroUsuarios.jsp?numerodocusuario="
                        + Usuario.getNumerodocusuario().toString() + "&"
                        + "nombreusuarios=" + Usuario.getNombreusuarios() + "&"
                        + "apellidousuarios=" + Usuario.getApellidousuarios() + "&"
                        + "correousuarios=" + Usuario.getCorreousuarios().toString() + "&"
                        + "telefonousuarios=" + Usuario.getTelefonousuarios().toString() + "&"
                        + "direccionusuario=" + Usuario.getDireccionusuario().replace("#", "No.") + "&"
                        + "claveusuario=" + Usuario.getClaveusuario().toString() + "&"
                        + "tipo_documento_idtipodoc=" + Usuario.getTipo_documento_idtipodoc() + "&"
                        + "roles_idroles=" + Usuario.getRoles_idroles() + "&"
                        + "genero_idgenero=" + Usuario.getGenero_idgenero() + "&"
                        + "estado_usuario_idestadousuario=" + Usuario.getEstado_usuario_idestadousuario() + "&"
                        + "Vista=" + "Actualizar" + "&");
                System.out.println("Salio");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('" + "No se ha podido relizar la consulta." + "\n"
                        + "Por favor verificar la identificacion: " + numerodocusuario + "');");
                out.println("</script>");
            }
        } else {
            if (Usuario != null) {
                String RespuestaRegistrada = misUsuariosDAO.Eliminarusuario(Usuario);
                if (RespuestaRegistrada.length() == 0) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('" + "Eliminacion Realizada." + "');");
                    out.println("window.location.href ='/VISION/vista/RegistroUsuarios.jsp';");
                    out.println("</script>");
                } else {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('" + "No se ha podido relizar la eliminacion." + RespuestaRegistrada.replace("'", "") + "');");
                    out.println("</script>");
                }

            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('" + "No se ha podido relizar la consulta." + "\n"
                        + "Por favor verificar la identificacion: " + numerodocusuario
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