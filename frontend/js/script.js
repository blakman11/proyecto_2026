document.addEventListener("DOMContentLoaded", function () {

    const formulario = document.getElementById("formulario");

    if (formulario) {

        formulario.addEventListener("submit", function (e) {

            e.preventDefault();

            let usuario = document.getElementById("usuario").value.trim();
            let clave = document.getElementById("clave").value.trim();

            if (usuario === "" || clave === "") {

                alert("Por favor complete todos los campos");
                return;
            }

            const cliente = JSON.parse(localStorage.getItem("cliente"));

            if (!cliente) {

                alert("Primero debe registrarse.");
                return;

            }

            if (usuario === cliente.usuario && clave === cliente.clave) {

                alert("Inicio de sesión exitoso");
                window.location.href = "productos.html";

            } else {

                alert("Usuario o contraseña incorrectos.");

            }

        });

    }

});

// Función para agregar productos al carrito
function agregarCarrito(nombre, precio) {

    let carrito = JSON.parse(localStorage.getItem("carrito")) || [];

    let existe = carrito.find(producto => producto.nombre === nombre);

    if (existe) {
        existe.cantidad++;
    } else {
        carrito.push({
            nombre: nombre,
            precio: precio,
            cantidad: 1
        });
    }

    localStorage.setItem("carrito", JSON.stringify(carrito));

    let mensaje = document.getElementById("mensaje");

    if (mensaje) {
        mensaje.innerHTML = "✅ Producto agregado al carrito.";
    }

}