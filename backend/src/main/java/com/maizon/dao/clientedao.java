package com.maizon.dao;

import com.maizon.conexion.Conexion;
import com.maizon.modelo.Cliente;

import java.sql.Connection;

public class Clientedao {

    Connection con;

    public Clientedao() {
        con = Conexion.conectar();
    }

}