package com.maizon.servlet;

import com.google.gson.Gson;
import com.maizon.dao.Clientedao;
import com.maizon.modelo.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

// RUTA DE LA API: La página web llamará a este Servlet usando la url "/clientes"
@WebServlet("/clientes")
public class ClienteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Clientedao dao;
    private Gson gson; // Herramienta para convertir texto JSON a objetos Java y viceversa

    // 1. INICIALIZACIÓN: Se ejecuta una sola vez cuando arranca el servidor
    @Override
    public void init() throws ServletException {
        dao = new Clientedao();
        gson = new Gson();
    }

    // 2. CONSULTAR (GET): Envía la lista de todos los clientes a la página web en formato JSON
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        List<Cliente> lista = dao.listar(); // Busca los clientes en la base de datos
        String json = gson.toJson(lista);   // Convierte la lista de Java a texto JSON

        response.getWriter().print(json);   // Envía el resultado a la página web
    }

    // 3. REGISTRAR (POST): Recibe un nuevo cliente desde la página web y lo guarda
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        BufferedReader reader = request.getReader(); // Lee los datos JSON que vienen de la página web
        Cliente cliente = gson.fromJson(reader, Cliente.class); // Convierte ese JSON en un objeto Cliente de Java

        boolean guardado = dao.guardar(cliente); // Intenta guardarlo en la base de datos

        // Responde a la página web si se pudo guardar o no
        if (guardado) {
            response.setStatus(HttpServletResponse.SC_CREATED);
            response.getWriter().print("{\"mensaje\":\"Cliente guardado correctamente\"}");
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().print("{\"mensaje\":\"Error al guardar cliente\"}");
        }
    }

    // 4. MODIFICAR (PUT): Recibe los datos editados de un cliente y los actualiza
    @Override
    protected void doPut(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        BufferedReader reader = request.getReader();
        Cliente cliente = gson.fromJson(reader, Cliente.class); // Convierte el JSON modificado a Java

        boolean actualizado = dao.actualizar(cliente); // Actualiza los datos en la base de datos

        // Responde a la página web si se pudo editar o no
        if (actualizado) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().print("{\"mensaje\":\"Cliente actualizado correctamente\"}");
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().print("{\"mensaje\":\"Error al actualizar cliente\"}");
        }
    }

    // 5. ELIMINAR (DELETE): Recibe el ID de un cliente y lo borra de la base de datos
    @Override
    protected void doDelete(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String codigo = request.getParameter("id"); // Captura el ?id= de la URL

        // Validación: Verifica que sí hayan enviado un ID válido
        if (codigo == null || codigo.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().print("{\"mensaje\":\"Debe enviar el id del cliente\"}");
            return;
        }

        // Convierte el ID de texto a número y lo elimina en la base de datos
        boolean eliminado = dao.eliminar(Integer.parseInt(codigo));

        // Responde a la página web el resultado de la eliminación
        if (eliminado) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().print("{\"mensaje\":\"Cliente eliminado correctamente\"}");
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().print("{\"mensaje\":\"Error al eliminar cliente\"}");
        }
    }
}