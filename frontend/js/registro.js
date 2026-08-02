document.addEventListener("DOMContentLoaded", function () {

    const formulario = document.getElementById("formRegistro");

    if (!formulario) {
        return;
    }

    formulario.addEventListener("submit", function (e) {

        e.preventDefault();

        let nombre = document.getElementById("nombre").value.trim();
        let documento = document.getElementById("documento").value.trim();
        let correo = document.getElementById("correo").value.trim();
        let telefono = document.getElementById("telefono").value.trim();
        let direccion = document.getElementById("direccion").value.trim();
        let usuario = document.getElementById("usuarioRegistro").value.trim();
        let clave = document.getElementById("claveRegistro").value.trim();
        let confirmar = document.getElementById("confirmarClave").value.trim();

        if (
            nombre === "" ||
            documento === "" ||
            correo === "" ||
            telefono === "" ||
            direccion === "" ||
            usuario === "" ||
            clave === "" ||
            confirmar === ""
        ) {
            alert("Por favor complete todos los campos.");
            return;
        }

        if (clave !== confirmar) {
            alert("Las contraseñas no coinciden.");
            return;
        }

        const cliente = {
            nombre,
            documento,
            correo,
            telefono,
            direccion,
            usuario,
            clave
        };

        localStorage.setItem("cliente", JSON.stringify(cliente));

        alert("Cliente registrado correctamente.");

        window.location.href = "index.html";
    });

});