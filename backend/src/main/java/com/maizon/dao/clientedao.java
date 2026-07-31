package com.maizon.dao;

import com.maizon.conexion.Conexion;
import com.maizon.modelo.cliente;

import java.sql.Connection;

public class clientedao {

  
    
    Connection con;
    private cliente client;

    public clientedao() {
        con = Conexion.conectar();
    }

}