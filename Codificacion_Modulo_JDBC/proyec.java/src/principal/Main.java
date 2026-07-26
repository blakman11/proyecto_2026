package principal;

import conexion.Conexion;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        Connection conexion = Conexion.conectar();

        if (conexion != null) {
            System.out.println("Conexión realizada correctamente.");
        } else {
            System.out.println("No fue posible conectar con la base de datos.");
        }

    }
}