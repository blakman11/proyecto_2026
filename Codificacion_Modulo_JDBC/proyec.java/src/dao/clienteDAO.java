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
            ps.setInt(3, cliente.getNumero());
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

}

