package com.maizon.conexion;

// Importamos las clases necesarias para conectarnos a MySQL
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    // Dirección de la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/maizon";

    // Usuario de MySQL
    private static final String USUARIO = "root";

    // Contraseña de MySQL
    private static final String PASSWORD = "2007";

    // Método que realiza la conexión con la base de datos
    public static Connection conectar() {
        try {

            // Cargamos el controlador de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Intentamos conectarnos a la base de datos
            Connection conexion = DriverManager.getConnection(
                URL,
                USUARIO,
                PASSWORD
            );

            // Mensaje para comprobar que la conexión fue exitosa
            System.out.println("¡Conexión exitosa a la base de datos Maizon!");

            // Devolvemos la conexión
            return conexion;

        } catch (Exception e) {

            // Mostramos el error real si la conexión falla
            System.out.println("ERROR REAL DE CONEXION:");
            e.printStackTrace();

            // Si ocurre un error, devolvemos null
            return null;
        }
    }
}