package dao;

// ======================================================
// IMPORTACIONES
// ======================================================

// Importamos la clase Conexion para conectarnos a MySQL.
import conexion.Conexion;

// Importamos la clase cliente porque trabajaremos con objetos cliente.
import modelo.cliente;

// Librerías de JDBC.
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// ======================================================
// CLASE clienteDAO
// ======================================================
// DAO significa Data Access Object.
// Esta clase contiene los métodos que trabajan con la
// base de datos (INSERT, SELECT, UPDATE y DELETE).
// ======================================================

public class clienteDAO {

    // Variable donde guardaremos la conexión con MySQL.
    private Connection conexion;

    // ======================================================
    // CONSTRUCTOR
    // ======================================================
    // Cuando se crea un objeto clienteDAO,
    // automáticamente obtiene una conexión.
    // ======================================================

    public clienteDAO() {

        try {

            // Llamamos al método conectar() de la clase Conexion.
            conexion = Conexion.conectar();

            System.out.println("Conexión establecida correctamente.");

        } catch (Exception e) {

            System.out.println("Error al conectar con la base de datos.");

            e.printStackTrace();

        }

    }

    // ======================================================
    // MÉTODO INSERTAR CLIENTE
    // ======================================================
    // Este método recibe un objeto cliente y guarda sus
    // datos en la tabla tabla_clientes.
    // ======================================================

    public void insertarCliente(cliente cliente) {

        // Consulta SQL.
        String sql = "INSERT INTO tabla_clientes "
                + "(codigo_cliente, nombre, numero, correo_elec, direccion) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {

            // Preparamos la consulta.
            PreparedStatement ps = conexion.prepareStatement(sql);

            // Reemplazamos los signos ? por los datos del objeto cliente.
            ps.setInt(1, cliente.getCodigo_cliente());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getNumero());
            ps.setString(4, cliente.getCorreo_elec());
            ps.setString(5, cliente.getDireccion());

            // Ejecutamos el INSERT.
            ps.executeUpdate();

            System.out.println("Cliente registrado correctamente.");

            // Cerramos el PreparedStatement.
            ps.close();

        } catch (SQLException e) {

            System.out.println("Error al registrar el cliente.");

            e.printStackTrace();

        }

    }

    // ======================================================
// MÉTODO LISTAR CLIENTES
// ======================================================
// Este método consulta todos los clientes de la tabla
// y los muestra en la consola.
// ======================================================

public void listarClientes() {

    System.out.println("\n===== LISTA DE CLIENTES =====");
    // Consulta SQL.
    String sql = "SELECT * FROM tabla_clientes";

    try {

        // Preparamos la consulta.
        PreparedStatement ps = conexion.prepareStatement(sql);

        // ResultSet almacena los registros que devuelve MySQL.
        java.sql.ResultSet rs = ps.executeQuery();

        System.out.println("\n========= LISTA DE CLIENTES =========");

        // Mientras existan registros...
        while (rs.next()) {

            System.out.println("----------------------------");

            System.out.println("Código: " + rs.getInt("codigo_cliente"));

            System.out.println("Nombre: " + rs.getString("nombre"));

            System.out.println("Número: " + rs.getString("numero"));

            System.out.println("Correo: " + rs.getString("correo_elec"));

            System.out.println("Dirección: " + rs.getString("direccion"));

        }

        System.out.println("----------------------------");

        rs.close();
        ps.close();

    } catch (SQLException e) {

        System.out.println("Error al consultar clientes.");

        e.printStackTrace();

    }

}
 
 // ======================================================
// MÉTODO ACTUALIZAR CLIENTE
// ======================================================
// Este método modifica los datos de un cliente existente.
// Busca el cliente por su código.
// ======================================================

public void actualizarCliente(cliente cliente) {

    // Consulta SQL.
    String sql = "UPDATE tabla_clientes SET nombre = ?, numero = ?, correo_elec = ?, direccion = ? WHERE codigo_cliente = ?";

    try {

        // Preparamos la consulta.
        PreparedStatement ps = conexion.prepareStatement(sql);

        // Reemplazamos los signos ? con los datos del objeto cliente.
        ps.setString(1, cliente.getNombre());
        ps.setString(2, cliente.getNumero());
        ps.setString(3, cliente.getCorreo_elec());
        ps.setString(4, cliente.getDireccion());
        ps.setInt(5, cliente.getCodigo_cliente());

        // Ejecutamos la actualización.
        int filas = ps.executeUpdate();

        if (filas > 0) {
            System.out.println("Cliente actualizado correctamente.");
        } else {
            System.out.println("No se encontró el cliente.");
        }

        ps.close();

    } catch (SQLException e) {

        System.out.println("Error al actualizar el cliente.");
        e.printStackTrace();

    }

}

// ======================================================
// MÉTODO ELIMINAR CLIENTE
// ======================================================
// Este método elimina un cliente usando su código.
// ======================================================

public void eliminarCliente(int codigo_cliente) {

    // Consulta SQL.
    String sql = "DELETE FROM tabla_clientes WHERE codigo_cliente = ?";

    try {

        // Preparamos la consulta.
        PreparedStatement ps = conexion.prepareStatement(sql);

        // Reemplazamos el ? por el código del cliente.
        ps.setInt(1, codigo_cliente);

        // Ejecutamos la eliminación.
        int filas = ps.executeUpdate();

        if (filas > 0) {
            System.out.println("Cliente eliminado correctamente.");
        } else {
            System.out.println("No existe un cliente con ese código.");
        }

        ps.close();

    } catch (SQLException e) {

        System.out.println("Error al eliminar el cliente.");
        e.printStackTrace();

    }

}
}
