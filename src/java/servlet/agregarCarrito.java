/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controlador.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.detalle_movimiento;
import modelo.movimiento;
import modelo.productos;

/**
 *
 * @author santy
 */
@WebServlet(name = "agregarCarrito", urlPatterns = {"/agregarCarrito"})
public class agregarCarrito extends HttpServlet {
    
    float total = 0;
    int cont = 0;

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
        
        HttpSession session=request.getSession();
        ArrayList<detalle_movimiento> carrito;
        if (session.getAttribute("carrito")==null)
        {
            carrito=new ArrayList<detalle_movimiento>();
            
        }
        else
        {
                carrito=(ArrayList<detalle_movimiento>)session.getAttribute("carrito");
        }
                float precio,ivaporpro,subtotal,porcen;
                int cantidad;
                ProductoDAO miProducto_dao = new ProductoDAO();
                productos prod = miProducto_dao.Consultaproductos(request.getParameter("txtCodigo"));
                detalle_movimiento d = new detalle_movimiento();
                movimiento m = new movimiento();
                cantidad=Integer.parseInt(request.getParameter("txtCantidad"));
                precio=Float.parseFloat(request.getParameter("txtPrecio"));
                total = total+(precio * cantidad);
                porcen = 1 + Float.parseFloat(request.getParameter("txtIva"))/100;
                subtotal=(cantidad*precio)/(porcen);
                ivaporpro=((precio*cantidad)-subtotal);
                d.setProductos_idproductos(Integer.parseInt(request.getParameter("txtCodigo")));
                d.setNombre_producto(request.getParameter("txtNombre"));
                d.setCantidad(Integer.parseInt(request.getParameter("txtCantidad")));
                d.setPrecio(Float.parseFloat(request.getParameter("txtPrecio")));
                d.setSubtotal(subtotal);
                d.setIva(ivaporpro);
                d.setTotal_producto(precio*cantidad);
                d.setIddetallemovimiento(Integer.parseInt(request.getParameter("txtCodigo")));
                carrito.add(d);               
                session.setAttribute("carrito",carrito);
                response.sendRedirect("vista/Formularios/GestionarMovimientos.jsp");
        
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
