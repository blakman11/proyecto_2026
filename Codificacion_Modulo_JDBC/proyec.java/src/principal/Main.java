package principal;

// ======================================================
// IMPORTACIONES
// ======================================================

// Importamos Scanner para poder leer datos que escribe el usuario.
import java.util.Scanner;

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
        // OBJETOS PRINCIPALES
        // ======================================================

        // Scanner permite leer datos desde el teclado.
        Scanner teclado = new Scanner(System.in);

        // Creamos un objeto DAO para trabajar con la base de datos.
        clienteDAO dao = new clienteDAO();

        // Variable donde guardaremos la opción del menú.
        int opcion;

        // ======================================================
        // MENÚ PRINCIPAL
        // ======================================================
        // El ciclo do-while hace que el menú aparezca una y otra vez
        // hasta que el usuario decida salir.
        // ======================================================

        do {

            System.out.println("\n======================================");
            System.out.println("      SISTEMA DE CLIENTES");
            System.out.println("======================================");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("5. Salir");
            System.out.println("======================================");
            System.out.print("Seleccione una opción: ");

            // Guardamos la opción escrita por el usuario.
            opcion = teclado.nextInt();

            // Limpiamos el buffer del teclado.
            teclado.nextLine();

            // ==================================================
            // SWITCH
            // ==================================================
            // Dependiendo de la opción elegida,
            // se ejecutará un bloque diferente.
            // ==================================================

            switch (opcion) {

                // ==============================================
                // OPCIÓN 1
                // REGISTRAR CLIENTE
                // ==============================================

                case 1:

                    // Creamos un nuevo objeto cliente.
                    cliente cliente = new cliente();

                    System.out.println("\n===== REGISTRAR CLIENTE =====");

                    System.out.print("Código del cliente: ");
                    cliente.setCodigo_cliente(teclado.nextInt());
                    teclado.nextLine();

                    System.out.print("Nombre: ");
                    cliente.setNombre(teclado.nextLine());

                    System.out.print("Número: ");
                    cliente.setNumero(teclado.nextLine());

                    System.out.print("Correo electrónico: ");
                    cliente.setCorreo_elec(teclado.nextLine());

                    System.out.print("Dirección: ");
                    cliente.setDireccion(teclado.nextLine());

                    // Enviamos el objeto cliente al DAO
                    // para que lo guarde en MySQL.
                    dao.insertarCliente(cliente);

                    break;

                case 2:
                    System.out.println("Entró al case 2");

    dao.listarClientes();

    System.out.println("Salió del listar");
                    break;

                case 3:
                    System.out.println("\n===== ACTUALIZAR CLIENTE =====");
                    cliente clienteActualizar = new cliente();

                    System.out.print("Código del cliente a actualizar: ");
                    clienteActualizar.setCodigo_cliente(teclado.nextInt());
                    teclado.nextLine();

                    System.out.print("Nombre: ");
                    clienteActualizar.setNombre(teclado.nextLine());

                    System.out.print("Número: ");
                    clienteActualizar.setNumero(teclado.nextLine());

                    System.out.print("Correo electrónico: ");
                    clienteActualizar.setCorreo_elec(teclado.nextLine());

                    System.out.print("Dirección: ");
                    clienteActualizar.setDireccion(teclado.nextLine());

                    dao.actualizarCliente(clienteActualizar);
                    break;
                case 4:
                    System.out.println("\n===== ELIMINAR CLIENTE =====");
                    System.out.print("Código del cliente a eliminar: ");
                    int codigoEliminar = teclado.nextInt();
                    teclado.nextLine();
                    dao.eliminarCliente(codigoEliminar);
                    break;
                    

                // ==============================================
                // OPCIÓN 5
                // SALIR
                // ==============================================

                case 5:

                    System.out.println("\nGracias por utilizar el sistema.");

                    break;

                // ==============================================
                // CUALQUIER OTRA OPCIÓN
                // ==============================================

                default:

                    System.out.println("\nOpción no válida.");

            }

        } while (opcion != 5);

        // Cerramos el Scanner para liberar recursos.
        teclado.close();

    }

}