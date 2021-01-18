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
@WebServlet(name = "RegistroUsuarios", urlPatterns = {"/RegistroUsuarios"})
public class RegistroUsuarios extends HttpServlet {

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

        String numerodocusuarios = request.getParameter("numerodocusuarios");
        String nombreusuarios = request.getParameter("nombreusuarios");
        String apellidousuarios = request.getParameter("apellidousuarios");
        String correousuarios = request.getParameter("correousuarios");
        String telefonousuarios = request.getParameter("telefonousuarios");
        String direccionusuario = request.getParameter("direccionusuario");
        String contraseñausuario = request.getParameter("contraseñausuario");
        String tipo_documento_idtipodoc = request.getParameter("tipo_documento_idtipodoc");
        String roles_idroles = request.getParameter("roles_idroles");
        String genero_idgenero = request.getParameter("genero_idgenero");
        String estado_usuario_idestadousuario = request.getParameter("estado_usuario_idestadousuario");
        String BanderaEstado = request.getParameter("banderaRegistro");

        int EstadoUsuario = Integer.parseInt(estado_usuario_idestadousuario);
        int RolUsuario = Integer.parseInt(roles_idroles);
        int TipoDocumento = Integer.parseInt(tipo_documento_idtipodoc);
        int TipoGenero = Integer.parseInt(genero_idgenero);

        usuariosDAO misusuariosDAO = new usuariosDAO();
        usuarios misusuarios = new usuarios();

        misusuarios.setnumerodocusuario(numerodocusuarios);
        misusuarios.setnombreusuarios(nombreusuarios);
        misusuarios.setapellidousuarios(apellidousuarios);
        misusuarios.setcorreousuarios(correousuarios);
        misusuarios.settelefonousuarios(telefonousuarios);
        misusuarios.setdireccionusuario(direccionusuario);
        misusuarios.setcontraseñausuario(contraseñausuario);
        misusuarios.settipo_documento_idtipodoc(TipoDocumento);
        misusuarios.setroles_idroles(RolUsuario);
        misusuarios.setgenero_idgenero(TipoGenero);
        misusuarios.setestado_usuario_idestadousuario(EstadoUsuario);

        System.out.println("El valor es " + BanderaEstado);
        if (BanderaEstado.equals("Correcto")) {
            String respuestaRegistrada = misusuariosDAO.adicionarusuarios(misusuarios);
            System.out.println("Res " + respuestaRegistrada);
            System.out.println("Res " + respuestaRegistrada.length());
            if (respuestaRegistrada.length() == 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('" + "Usuario Registrado con éxito." + "');");
                out.println("window.location.href = '/VISION/index.jsp';");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('" + respuestaRegistrada + "');");
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
