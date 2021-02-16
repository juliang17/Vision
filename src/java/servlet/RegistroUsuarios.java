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
        String contraseñausuario = request.getParameter("contraseñausuario");
        String Tipod = request.getParameter("tipo_documento_idtipodoc");
        String Roles = request.getParameter("roles_idroles");
        String Genero = request.getParameter("genero_idgenero");
        String Estado = request.getParameter("estado_usuario_idestadousuario");
        String Banderaestado = request.getParameter("Banderaregistro");

        int tipo_documento_idtipodoc = Integer.parseInt(Tipod);
        int roles_idroles = Integer.parseInt(Roles);
        int genero_idgenero = Integer.parseInt(Genero);
        int estado_usuario_idestadousuario = Integer.parseInt(Estado);

        usuariosDAO misusuariosDAO = new usuariosDAO();
        usuarios misusuarios = new usuarios();

        misusuarios.setnumerodocusuario(numerodocusuario);
        misusuarios.setnombreusuarios(nombreusuarios);
        misusuarios.setapellidousuarios(apellidousuarios);
        misusuarios.setcorreousuarios(correousuarios);
        misusuarios.settelefonousuarios(telefonousuarios);
        misusuarios.setdireccionusuario(direccionusuario);
        misusuarios.setcontraseñausuario(contraseñausuario);
        misusuarios.settipo_documento_idtipodoc(tipo_documento_idtipodoc);
        misusuarios.setroles_idroles(roles_idroles);
        misusuarios.setgenero_idgenero(genero_idgenero);
        misusuarios.setestado_usuario_idestadousuario(estado_usuario_idestadousuario);

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