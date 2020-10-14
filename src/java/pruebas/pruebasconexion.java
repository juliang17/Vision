
package pruebas;

import controlador.Conexion;
import java.sql.Connection;

public class pruebasconexion {

    
    public static void main(String[] args) {
        
        Conexion con = new Conexion ();
        Connection reg = con.getConn();
        
    }
    
}
