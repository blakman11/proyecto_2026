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

@WebServlet("/clientes")
public class ClienteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Clientedao dao;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        dao = new Clientedao();
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        List<Cliente> lista = dao.listar();

        String json = gson.toJson(lista);

        response.getWriter().print(json);
    }
    @Override
protected void doPost(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    BufferedReader reader = request.getReader();

    Cliente cliente = gson.fromJson(reader, Cliente.class);

    boolean guardado = dao.guardar(cliente);

    if (guardado) {
        response.setStatus(HttpServletResponse.SC_CREATED);
        response.getWriter().print("{\"mensaje\":\"Cliente guardado correctamente\"}");
    } else {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.getWriter().print("{\"mensaje\":\"Error al guardar cliente\"}");
    }
}
@Override
protected void doPut(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    BufferedReader reader = request.getReader();

    Cliente cliente = gson.fromJson(reader, Cliente.class);

    boolean actualizado = dao.actualizar(cliente);

    if (actualizado) {
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().print("{\"mensaje\":\"Cliente actualizado correctamente\"}");
    } else {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.getWriter().print("{\"mensaje\":\"Error al actualizar cliente\"}");
    }
}
@Override
protected void doDelete(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    String codigo = request.getParameter("id");

    if (codigo == null || codigo.isEmpty()) {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.getWriter().print("{\"mensaje\":\"Debe enviar el id del cliente\"}");
        return;
    }

    boolean eliminado = dao.eliminar(Integer.parseInt(codigo));

    if (eliminado) {
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().print("{\"mensaje\":\"Cliente eliminado correctamente\"}");
    } else {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.getWriter().print("{\"mensaje\":\"Error al eliminar cliente\"}");
    }
}
}