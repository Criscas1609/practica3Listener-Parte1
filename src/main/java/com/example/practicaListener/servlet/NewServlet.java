package com.example.practicaListener.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "NewServlet", value = "/NewServlet")
public class NewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String metodoHttp = req.getMethod();
        //Este método lo que hace es indicar que tipo de formulario envia la información en este caso es un metodo Get
        String requestUri = req.getRequestURI();
        //Devuelve la url sin el ip o host y tambien sin el esquema
        String requestUrl = req.getRequestURL().toString();
        //Este request lo que hace es obtener toda la información de la url incluyendo el nombre del servidor
        String contexPath = req.getContextPath();
        //Devuelve en forma de texto el nombre del proycto en este caso cabeceras o a ruta de acceso del servlet que está manejando la solicitud HTTP actual
        String servletPath = req.getServletPath();
        //Obtiene la ruta de acceso del servlet donde es manejada la solicitud
        String ipCliente = req.getRemoteAddr();
        //Como el nombre de la variable lo indica, obtiene la ip del cliente
        String ip = req.getLocalAddr();
        //Nos indica el ip del servidor
        int port = req.getLocalPort();
        //Nos dice cual es el puerto que usamos
        String scheme = req.getScheme();
        //Nos muestra el tipo de protocolo que se utiliza, en este caso es http
        String host = req.getHeader("host");
        //Identifica el host en el cual se esta ejecutando el codigo
        String url = scheme + "://" + host + contexPath + servletPath;
        //Retorna la direccion con el host
        String url2 = scheme + "://" + ip + ":" + port + contexPath + servletPath;
        //Retorna la direccion con la direccion ip

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
