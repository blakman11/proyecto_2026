alert("JavaScript conectado");

function registrarCliente() {

    const nombre = document.getElementById("nombre").value;
    const telefono = document.getElementById("telefono").value;
    const correo = document.getElementById("correo").value;
    const direccion = document.getElementById("direccion").value;

    fetch("clientes", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body:
            "nombre=" + encodeURIComponent(nombre) +
            "&telefono=" + encodeURIComponent(telefono) +
            "&correo=" + encodeURIComponent(correo) +
            "&direccion=" + encodeURIComponent(direccion)
    })
    .then(response => response.text())
    .then(data => {
        alert(data);
    })
    .catch(error => {
        console.error(error);
        alert("Error al conectar con el servidor");
    });
}