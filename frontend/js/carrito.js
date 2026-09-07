let carrito = JSON.parse(localStorage.getItem("carrito")) || [];

function mostrarCarrito(){

    let lista = document.getElementById("listaCarrito");

    let subtotal = 0;

    lista.innerHTML = "";

    if(carrito.length === 0){

        lista.innerHTML = "<h3>🛒 Tu carrito está vacío.</h3>";

        document.getElementById("subtotal").innerHTML="$0";
        document.getElementById("total").innerHTML="$5.000";

        return;
    }

    carrito.forEach(function(producto, index){

        subtotal += producto.precio * producto.cantidad;

        lista.innerHTML += `
            <div class="producto">

                <div>

                    <h3>${producto.nombre}</h3>

                    <p>$${producto.precio.toLocaleString()}</p>

                </div>

                <div>

                    <button onclick="restar(${index})">-</button>

                    <strong>${producto.cantidad}</strong>

                    <button onclick="sumar(${index})">+</button>

                </div>

            </div>
        `;

    });

    document.getElementById("subtotal").innerHTML =
    "$"+subtotal.toLocaleString();

    document.getElementById("total").innerHTML =
    "$"+(subtotal+5000).toLocaleString();

}

function sumar(i){

    carrito[i].cantidad++;

    guardar();

}

function restar(i){

    carrito[i].cantidad--;

    if(carrito[i].cantidad<=0){

        carrito.splice(i,1);

    }

    guardar();

}

function guardar(){

    localStorage.setItem("carrito",JSON.stringify(carrito));

    mostrarCarrito();

}

function vaciarCarrito(){

    carrito=[];

    guardar();

    document.getElementById("mensaje").innerHTML=
    "🗑 Carrito vaciado correctamente.";

}

function finalizarCompra(){

    if(carrito.length===0){

        alert("El carrito está vacío.");

        return;

    }

    alert("✅ Gracias por comprar en Maizon Toro.");

    carrito=[];

    guardar();

}

mostrarCarrito();