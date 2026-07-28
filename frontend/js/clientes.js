//=========================
// Módulo de Clientes
// Proyecto_2026
// Autor: gloria carvajal
//=========================

alert("JavaScript conectado");

// Arreglo para almacenar clientes
let clientes = [];

// Función para registrar clientes
function registrarCliente() {
    const nombre = document.getElementById("nombre").value;

    if (nombre === "") {
        alert("Ingrese el nombre del cliente.");
        return;
    }

    clientes.push(nombre);

    // Obtener la lista del HTML
    const lista = document.getElementById("listaClientes");

    // Crear un nuevo elemento de la lista
    const nuevoCliente = document.createElement("li");

    // Asignar el nombre
    nuevoCliente.textContent = nombre;

    // Agregarlo a la lista
    lista.appendChild(nuevoCliente);

    // Limpiar el campo
    document.getElementById("nombre").value = "";

    // Colocar nuevamente el cursor
    document.getElementById("nombre").focus();

    // Mensaje
    alert("Cliente registrado correctamente.");
}