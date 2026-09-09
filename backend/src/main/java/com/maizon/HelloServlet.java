package com.maizon;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// RUTA DE PRUEBA: Si entras en el navegador a "/hello-servlet" verás este código
@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {

    // MÉTODO GET: Se activa automáticamente cuando alguien entra a la ruta desde el navegador
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Le dice al navegador que lo que va a recibir es una página web (HTML)
        response.setContentType("text/html");

        // Objeto "out" sirve para escribir código directamente en la pantalla del usuario
        PrintWriter out = response.getWriter();
        out.println("<h1>Hola Mundo</h1>"); // Pinta un título grande en la página
    }
}