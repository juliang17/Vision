package pruebas;

import controlador.movimientoDAO;
import java.util.Scanner;
import modelo.movimiento;

public class PruebaAdicionarMovimiento {

    public static void main(String[] args) {

        movimientoDAO MovDAO = new movimientoDAO();
        movimiento Mov = new movimiento();

        Scanner respuesta = new Scanner(System.in);

        String fechamovimiento;
        int subtotal;
        int iva;
        int descuento;
        int total;
        int tipo_doc_contable_idtipodoccontable;
        int medio_de_pago_idmediodepago;

        System.out.println("Por favor ingrese la fecha del movimiento");
        fechamovimiento = respuesta.nextLine();

        System.out.println("Por favor ingrese el subtotal");
        subtotal = respuesta.nextInt();
        
        System.out.println("Por favor ingrese el iva");
        iva = respuesta.nextInt();
        
        System.out.println("Por favor ingrese el descuento");
        descuento = respuesta.nextInt();
        
        System.out.println("Por favor ingrese el total");
        total = respuesta.nextInt();
        
        System.out.println("Por favor ingrese el tipo de documento contable");
        tipo_doc_contable_idtipodoccontable = respuesta.nextInt();
        
        System.out.println("Por favor ingrese el medio de pago");
        medio_de_pago_idmediodepago = respuesta.nextInt();

        Mov.setFechamovimiento(fechamovimiento);
        Mov.setSubtotal(subtotal);
        Mov.setIva(iva);
        Mov.setDescuento(descuento);
        Mov.setTotal(total);
        Mov.setTipo_doc_contable_idtipodoccontable(tipo_doc_contable_idtipodoccontable);
        Mov.setMedio_de_pago_idmediodepago(medio_de_pago_idmediodepago);

        String miRespuesta = MovDAO.AdicionarMovimiento(Mov);

        if (miRespuesta.length() == 0) {

            System.out.println("registro exitoso");

        } else {

            System.out.println("Ocurrio un error" + miRespuesta);

        }

    }

}
