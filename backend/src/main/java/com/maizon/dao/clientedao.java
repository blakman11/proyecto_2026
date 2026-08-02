package com.maizon.dao;

import com.maizon.conexion.Conexion;
import com.maizon.modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Clientedao {

    Connection con;

    public Clientedao() {
        con = Conexion.conectar();
    }

    public boolean guardar(Cliente cliente) {

        String sql = "INSERT INTO tabla_clientes(nombre, numero, correo_elec, direccion) VALUES(?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getTelefono());
            ps.setString(3, cliente.getCorreo());
            ps.setString(4, cliente.getDireccion());

            ps.executeUpdate();

            ps.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}