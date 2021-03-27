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

        String numerodocusuario = request.getParameter("Numerodocusuario");
        String nombreusuarios = request.getParameter("Nombreusuarios");
        String apellidousuarios = request.getParameter("Apellidousuarios");
        String correousuarios = request.getParameter("correousuarios");
        String telefonousuarios = request.getParameter("telefonousuarios");
        String direccionusuario = request.getParameter("direccionusuario");
        String claveusuario = request.getParameter("claveusuario");
        String tipo_documento_idtipodoc = request.getParameter("tipo_documento_idtipodoc");
        String roles_idroles = request.getParameter("roles_idroles");
        String genero_idgenero = request.getParameter("genero_idgenero");
        String estado_usuario_idestadousuario = request.getParameter("estado_usuario_idestadousuario");
        String Banderaestado = request.getParameter("Banderaregistro");

        int Tipod = Integer.parseInt(tipo_documento_idtipodoc);
        int Roles = Integer.parseInt(roles_idroles);
        int Genero = Integer.parseInt(genero_idgenero);
        int Estado = Integer.parseInt(estado_usuario_idestadousuario);

        usuariosDAO misusuariosDAO = new usuariosDAO();
        usuarios misusuarios = new usuarios();

        misusuarios.setNumerodocusuario(numerodocusuario);
        misusuarios.setNombreusuarios(nombreusuarios);
        misusuarios.setApellidousuarios(apellidousuarios);
        misusuarios.setCorreousuarios(correousuarios);
        misusuarios.setTelefonousuarios(telefonousuarios);
        misusuarios.setDireccionusuario(direccionusuario);
        misusuarios.setClaveusuario(claveusuario);
        misusuarios.setTipo_documento_idtipodoc(Tipod);
        misusuarios.setRoles_idroles(Roles);
        misusuarios.setGenero_idgenero(Genero);
        misusuarios.setEstado_usuario_idestadousuario(Estado);

        System.out.println("El valor es " + Banderaestado);
        if (Banderaestado.equals("Correcto")) {
            String Respuestaregistrada = misusuariosDAO.adicionarusuarios(misusuarios);
            System.out.println("Res " + Respuestaregistrada);
            System.out.println("Res " + Respuestaregistrada.length());
            if (Respuestaregistrada.length() == 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('" + "Usuario Registrado con Exito." + "');");
                out.println("window.location.href = '/VISION/index.jsp';");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('" + Respuestaregistrada + "');");
                out.println("alert('" + "Error Encontrado: "
                        + Respuestaregistrada.replace("'", "") + "');");
                out.println("window.history.back();");
                out.println("</script>");
            }
        } else {
            System.out.println("El valor no es correcto " + Banderaestado);
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
