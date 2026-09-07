package com.maizon.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // DATOS DE ACCESO A LA BASE DE DATOS
    private static final String URL = "jdbc:mysql://localhost:3306/maizon";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "2007";

    // MÉTODO PARA CONECTARSE
    public static Connection conectar() {
        try {
            // Intenta abrir la conexión con MySQL usando los datos de arriba
            Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("¡Conexión exitosa a la base de datos Maizon!");
            return conexion;

        } catch (SQLException e) {
            // Si algo falla (contraseña incorrecta, servidor apagado), avisa en consola
            System.out.println("Error de conexión: " + e.getMessage());
            return null;
        }
    }
}