/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controlador.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.detalle_movimiento;

/**
 *
 * @author santy
 */
@WebServlet(name = "grabarFactura", urlPatterns = {"/grabarFactura"})
public class grabarFactura extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
            ArrayList<detalle_movimiento> lista;
        HttpSession session=request.getSession();
        lista=(ArrayList<detalle_movimiento>)session.getAttribute("carrito");
        Conexion con = new Conexion();
        Connection cn = con.getConn();
        String query,numero_de_documento = "101";
        int medio_de_pago_idmediodepago=1,tipo_mov_id_tipo_mov=1,usuarios_idusuarios=1;
        int poriva,codmov=0,cantaux=0,coddetmov=0,cantpro=0;
        float ivac=0,totalc=0,subtotalc=0;
        String fecha,numdoc;
        Statement stm;
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Registrar Factura</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<script>");
        totalc=Float.parseFloat(request.getParameter("txttotal"));
        subtotalc=Float.parseFloat(request.getParameter("txtsubtotal"));
        ivac=Float.parseFloat(request.getParameter("txtiva"));
        fecha=request.getParameter("txtfecha");
        numdoc=request.getParameter("txtdocumento");        
        String clpost = request.getParameter("Clientepost");
        String mppost = request.getParameter("medioPost");
        String tdpost = request.getParameter("Tipodpost");
            //out.println("alert('"+fppost+"');");
        out.println("</script>");
        usuarios_idusuarios=Integer.parseInt(clpost);
        medio_de_pago_idmediodepago=Integer.parseInt(mppost);
        tipo_mov_id_tipo_mov=Integer.parseInt(tdpost);
        //Registrar Cabecera del Movimiento
        query="Insert into movimiento (numero_documento, fechamovimiento, subtotal, iva,total, medio_de_pago_idmediodepago, tipo_mov_id_tipo_mov, usuarios_idusuarios , estadoMov )" + "values (?,?,?,?,?,?,?,?,?);";
            try 
                {         
                PreparedStatement pst=cn.prepareStatement(query);
                pst.setString(1,numdoc);
                pst.setString(2,fecha);
                pst.setFloat(3,subtotalc);
                pst.setFloat(4,ivac);
                pst.setFloat(5,totalc);
                pst.setInt(6,medio_de_pago_idmediodepago);
                pst.setInt(7,tipo_mov_id_tipo_mov);
                pst.setInt(8,usuarios_idusuarios);
                pst.setInt(9,1);
                int n=pst.executeUpdate();
                if (n>0)
                {
                    //Obtener el último registro para los detalles
                    PreparedStatement stmtr = cn.prepareStatement("select * from movimiento order by idmovimiento desc limit 1");
                    ResultSet rsr = stmtr.executeQuery();
                    if(rsr.next())
                     {
                     codmov = rsr.getInt("idmovimiento");
                     }
                   //Registrar detalles del movimiento
                   if (lista!=null)
                     {
                      for(detalle_movimiento d: lista)
                        {
                            cantaux=0;
                            query="Insert into detalle_movimiento (cantidad, precio,subtotal,iva,total_producto, productos_idproductos, movimiento_idmovimiento)" + "values (?,?,?,?,?,?,?);";
                            pst=cn.prepareStatement(query);
                            pst.setInt(1,d.getCantidad());
                            pst.setFloat(2, d.getPrecio());
                            pst.setFloat(3,d.getSubtotal());
                            pst.setFloat(4,d.getIva());
                            pst.setFloat(5,d.getTotal_producto());
                            pst.setInt(6,d.getProductos_idproductos());
                            pst.setInt(7,codmov);
                            n=pst.executeUpdate();
                            
                            //Obtener cantidad existente del producto
                            stmtr = cn.prepareStatement("select * from productos where idproductos = '"+d.getProductos_idproductos()+"'");
                            rsr = stmtr.executeQuery();
                            if(rsr.next())
                             {
                             cantpro = rsr.getInt("cantidadproducto");
                             }
                            
                            //Actualizar Inventario
                            cantaux = cantpro - d.getCantidad();
                            query="Update productos set cantidadproducto = ? where idproductos = ?";
                            pst=cn.prepareStatement(query);
                            pst.setInt(1,cantaux);
                            pst.setInt(2,d.getProductos_idproductos());
                            n=pst.executeUpdate();
                            
                            //Obtener ultimo registro para el kardex
                            stmtr = cn.prepareStatement("select * from detalle_movimiento order by iddetallemovimiento desc limit 1");
                            rsr = stmtr.executeQuery();
                            if(rsr.next())
                             {
                             coddetmov = rsr.getInt("iddetallemovimiento");
                             }
                            
                            //Actualizar Kardex
                            query="Insert into inventario (entrada, salida, saldo, productos_idproductos, detalle_movimiento_iddetallemovimiento)" + "values (?,?,?,?,?);";
                            pst=cn.prepareStatement(query);
                            pst.setInt(1,0);
                            pst.setInt(2,d.getCantidad());
                            pst.setInt(3,cantaux);
                            pst.setInt(4,d.getProductos_idproductos());
                            pst.setInt(5,coddetmov);
                            n=pst.executeUpdate();
                            
                        }
                     
                     out.println("<script>");
                         out.println("alert('Venta Registrada');");
                         //Borrar Carrito
                         request.getSession().removeAttribute("carrito");
                         out.println("window.location.href = '../../VISION/vista/Formularios/GestionarMovimientos.jsp';");
                     out.println("</script>");
                     } 
                     
                   }
                   else
                   {
                   out.println("Error a la hora de registrar el movimiento");
                   }
                 }
                 catch (SQLException ex) 
                 {
                   out.println("Error al insertar " + ex.getMessage());
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
