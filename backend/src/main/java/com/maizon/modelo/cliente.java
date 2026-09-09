package com.maizon.modelo; 

public class Cliente {

    //  DATOS DEL CLIENTE
    private int codigo;
    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;

    //  CONSTRUCTOR VACÍO (Para que Java cree el objeto sin datos iniciales)
    public Cliente() {
    }

    //  CONSTRUCTOR CON DATOS (Para crear el cliente con toda su información de golpe)
    public Cliente(int codigo, String nombre, String telefono, String correo, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    //  MÉTODOS GETTERS Y SETTERS (GET para obtener el dato / SET para cambiar el dato)
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}