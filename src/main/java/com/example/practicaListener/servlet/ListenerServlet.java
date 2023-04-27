package com.example.practicaListener.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ListenerServlet", value = "/ListenerServlet")
public class ListenerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        String mensajeRequest = (String) req.getAttribute("mensaje");
        //Todos los servlets y páginas JSP dentro de la misma aplicación web pueden
        //acceder a esta variable.

        String mensajeApp = (String) getServletContext().getAttribute("mensaje");
        //Esta variable solo será accesible durante la duración de esa petición y solo
        //desde ese objeto de la petición específico.


        System.out.println(mensajeRequest+"----------------"+mensajeApp);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
