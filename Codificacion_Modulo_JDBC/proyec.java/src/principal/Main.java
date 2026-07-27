package principal;

// ======================================================
// IMPORTACIONES
// ======================================================

// Importamos la clase cliente.
import modelo.cliente;

// Importamos la clase clienteDAO.
import dao.clienteDAO;

// ======================================================
// CLASE PRINCIPAL
// ======================================================

public class Main {

    public static void main(String[] args) {

        // ======================================================
        // PASO 1
        // Creamos un objeto cliente.
        // ======================================================

        cliente cliente = new cliente();

        // ======================================================
        // PASO 2
        // Asignamos los datos al cliente.
        // Estos datos son los que se enviarán a MySQL.
        // ======================================================

        cliente.setCodigo_cliente(1);
        cliente.setNombre("Brayan Gil");
        cliente.setNumero(320123456);
        cliente.setCorreo_elec("brayan@gmail.com");
        cliente.setDireccion("Guamo - Tolima");

        // ======================================================
        // PASO 3
        // Creamos un objeto clienteDAO.
        // Este objeto se conecta automáticamente a MySQL.
        // ======================================================

        clienteDAO dao = new clienteDAO();

        // ======================================================
        // PASO 4
        // Llamamos al método insertarCliente().
        // Le enviamos el objeto cliente para que lo guarde
        // en la tabla tabla_clientes.
        // ======================================================

        dao.insertarCliente(cliente);

        // ======================================================
        // FIN DEL PROGRAMA
        // ======================================================

        System.out.println("Programa finalizado.");

    }

}