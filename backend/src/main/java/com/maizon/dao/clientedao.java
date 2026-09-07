package com.maizon.dao;

import com.maizon.conexion.Conexion;
import com.maizon.modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Clientedao {

    private Connection con;

    public Clientedao() {
        // Initialize connection using the conexion helper
        con = new Conexion().conectar();
    }

    // Guardar cliente
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

    // Listar clientes
    public List<Cliente> listar() {

        List<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM tabla_clientes";

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setCodigo(rs.getInt("codigo_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("numero"));
                cliente.setCorreo(rs.getString("correo_elec"));
                cliente.setDireccion(rs.getString("direccion"));

                lista.add(cliente);
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Buscar cliente por código
    public Cliente buscarPorCodigo(int codigo) {

        String sql = "SELECT * FROM tabla_clientes WHERE codigo_cliente=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setCodigo(rs.getInt("codigo_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("numero"));
                cliente.setCorreo(rs.getString("correo_elec"));
                cliente.setDireccion(rs.getString("direccion"));

                rs.close();
                ps.close();

                return cliente;
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Actualizar cliente
    public boolean actualizar(Cliente cliente) {

        String sql = "UPDATE tabla_clientes SET nombre=?, numero=?, correo_elec=?, direccion=? WHERE codigo_cliente=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getTelefono());
            ps.setString(3, cliente.getCorreo());
            ps.setString(4, cliente.getDireccion());
            ps.setInt(5, cliente.getCodigo());

            ps.executeUpdate();
            ps.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar cliente
    public boolean eliminar(int codigo) {

        String sql = "DELETE FROM tabla_clientes WHERE codigo_cliente=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);

            ps.executeUpdate();
            ps.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}