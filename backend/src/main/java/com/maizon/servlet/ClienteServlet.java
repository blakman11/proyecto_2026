package com.maizon.servlet;

import com.maizon.dao.Clientedao;
import com.maizon.modelo.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/clientes")
public class ClienteServlet extends HttpServlet {

    private Clientedao dao = new Clientedao();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        response.getWriter().println("<h1>Modulo clientes MaizON funcionando</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException, ServletException {

        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String direccion = request.getParameter("direccion");

        Cliente cliente = new Cliente();

        cliente.setNombre(nombre);
        cliente.setTelefono(telefono);
        cliente.setCorreo(correo);
        cliente.setDireccion(direccion);

        boolean guardado = dao.guardar(cliente);

        if (guardado) {
            response.getWriter().println("Cliente guardado correctamente");
        } else {
            response.getWriter().println("Error al guardar cliente");
        }
    }
}