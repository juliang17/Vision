/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import controlador.tipodocDAO;
import java.util.Scanner;
import modelo.tipo_doc_contable;

/**
 *
 * @author Jeffe
 */
public class pruebaModificartipodoc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        tipodocDAO mi_tipo_doc_dao = new tipodocDAO();
       tipo_doc_contable mi_tipo_doc = new tipo_doc_contable();
       
       Scanner teclado = new Scanner(System.in);
       
       int idtipodoccontable;
       String descripciontipodoccontable = ""; 
       
       
        System.out.println("Digite la descripción del tipo documento contable");
        descripciontipodoccontable = teclado.nextLine();
        
        System.out.println("Digite el id del tipo documento contable");
        idtipodoccontable = teclado.nextInt();
        
        mi_tipo_doc.setIdtipodoccontable(idtipodoccontable);
        mi_tipo_doc.setDescripciontipodoccontable(descripciontipodoccontable);
        
        mi_tipo_doc.setIdtipodoccontable(idtipodoccontable);

        mi_tipo_doc.setTipo_movimiento_idTipoMov(1);
        
        String miRespuesta = mi_tipo_doc_dao.ModificarTipoDocContable(mi_tipo_doc);
        
        if (miRespuesta.length() == 0) {
            
            System.out.println("Acción completada con éxito");
        }else {
            System.out.println("Ocurrio un error " + miRespuesta);
        
        } 
        
    }
    
}
