package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
     
public class Conexion {

    private Connection conn;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String user = "root";
    private String password = "";
    private String baseDatos = "vision";
    private String url = "jdbc:mysql://localhost:3306/" + baseDatos + "?useTimezone=true&serverTimezone=UTC";

    public Conexion() {

        conn = null;

        try {

            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if (conn == null) {

                System.out.println("No se establecio la conexion" + "/n" + url);
            } else {

                System.out.println("Conexion establecida prueba Vision");
            }
        } catch (Exception ex) {

            System.err.println(ex.getMessage());

        }
    }

    public Connection getConn() {
        return conn;
    }
}
