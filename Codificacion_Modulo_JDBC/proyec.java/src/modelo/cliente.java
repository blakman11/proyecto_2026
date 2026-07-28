package modelo;

import javax.print.DocFlavor.STRING;

// ======================================================
// CLASE cliente
// ======================================================
// Esta clase representa un cliente dentro del programa.
//
// No se conecta a la base de datos.
// Solo sirve para guardar información del cliente.
//
// Cada objeto cliente tendrá:
// - Código
// - Nombre
// - Número
// - Correo
// - Dirección
// ======================================================

public class cliente {

    // ======================================================
    // ATRIBUTOS
    // ======================================================

    // Código del cliente.
    // Debe ser int porque en MySQL la columna codigo_cliente es INT.
    private int codigo_cliente;

    // Nombre del cliente.
    private String nombre;

    // Número del cliente.
    private String numero;

    // Correo electrónico.
    private String correo_elec;

    // Dirección.
    private String direccion;

    // ======================================================
    // CONSTRUCTOR VACÍO
    // ======================================================
    // Permite crear un objeto sin enviar datos.
    //
    // Ejemplo:
    // cliente c = new cliente();
    // ======================================================

    public cliente() {

    }

    // ======================================================
    // CONSTRUCTOR CON PARÁMETROS
    // ======================================================
    // Permite crear un cliente enviando todos los datos
    // desde el momento de crearlo.
    //
    // Ejemplo:
    //
    // cliente c = new cliente(
    //      1,
    //      "Brayan",
    //      320123456,
    //      "brayan@gmail.com",
    //      "Guamo"
    // );
    // ======================================================

    public cliente(int codigo_cliente,
                   String nombre,
                   String numero,
                   String correo_elec,
                   String direccion) {

        this.codigo_cliente = codigo_cliente;
        this.nombre = nombre;
        this.numero = numero;
        this.correo_elec = correo_elec;
        this.direccion = direccion;
    }

    // ======================================================
    // GETTERS
    // ======================================================
    // Los getters sirven para obtener la información.
    // ======================================================

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumero() {
        return numero;
    }

    public String getCorreo_elec() {
        return correo_elec;
    }

    public String getDireccion() {
        return direccion;
    }

    // ======================================================
    // SETTERS
    // ======================================================
    // Los setters sirven para guardar o modificar datos.
    // ======================================================

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCorreo_elec(String correo_elec) {
        this.correo_elec = correo_elec;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}