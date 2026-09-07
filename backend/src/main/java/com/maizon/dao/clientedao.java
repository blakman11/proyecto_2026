package com.maizon.dao;

// IMPORTACIONES DEL PROYECTO
import com.maizon.conexion.Conexion;
import com.maizon.modelo.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Ajustado el nombre para que coincida exactamente con tu archivo: Clientedao
public class Clientedao {

    private Connection con;

    // CONSTRUCTOR: Llama directamente a tu método estático para conectar
    public Clientedao() {
        this.con = Conexion.conectar();
    }

    // 1. GUARDAR UN NUEVO CLIENTE
    public boolean guardar(Cliente cliente) {
        String sql = "INSERT INTO tabla_clientes(nombre, numero, correo_elec, direccion) VALUES(?,?,?,?)";
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getTelefono());
            ps.setString(3, cliente.getCorreo());
            ps.setString(4, cliente.getDireccion());
            
            ps.executeUpdate();
            return true; 
        } catch (SQLException e) {
            System.out.println("Error al guardar cliente: " + e.toString());
            return false; 
        }
    }

    // 2. OBTENER LA LISTA DE TODOS LOS CLIENTES
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM tabla_clientes";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodigo(rs.getInt("codigo_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("numero"));
                cliente.setCorreo(rs.getString("correo_elec"));
                cliente.setDireccion(rs.getString("direccion"));
                
                lista.add(cliente); 
            }
        } catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e.toString());
        }
        return lista;
    }

    // 3. BUSCAR UN CLIENTE POR SU CÓDIGO
    public Cliente buscarPorCodigo(int codigo) {
        String sql = "SELECT * FROM tabla_clientes WHERE codigo_cliente=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new Cliente(); 
                    cliente.setCodigo(rs.getInt("codigo_cliente"));
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setTelefono(rs.getString("numero"));
                    cliente.setCorreo(rs.getString("correo_elec"));
                    cliente.setDireccion(rs.getString("direccion"));
                    return cliente; 
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar cliente: " + e.toString());
        }
        return null; 
    }

    // 4. ACTUALIZAR LOS DATOS DE UN CLIENTE
    public boolean actualizar(Cliente cliente) {
        String sql = "UPDATE tabla_clientes SET nombre=?, numero=?, correo_elec=?, direccion=? WHERE codigo_cliente=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getTelefono());
            ps.setString(3, cliente.getCorreo());
            ps.setString(4, cliente.getDireccion());
            ps.setInt(5, cliente.getCodigo());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e.toString());
            return false;
        }
    }

    // 5. ELIMINAR UN CLIENTE
    public boolean eliminar(int codigo) {
        String sql = "DELETE FROM tabla_clientes WHERE codigo_cliente=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.toString());
            return false;
        }
    }
}