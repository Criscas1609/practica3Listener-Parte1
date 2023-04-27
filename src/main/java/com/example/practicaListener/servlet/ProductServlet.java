package com.example.practicaListener.servlet;

import com.example.practicaListener.service.ProductoService;
import com.example.practicaListener.service.impl.ProductoServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {

    ProductoService service = new ProductoServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        Boolean b = service.validateExistence(id);
        if (b) {
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(" <head>");
                out.println(" <meta charset=\"UTF-8\">");
                out.println(" <title>La hora actualizada</title>");
                out.println(" </head>");
                out.println(" <body>");
                out.println(" <h1>Producto Si existe</h1>");
                out.println(" </body>");
                out.println("</html>");
            }
        }else resp.sendError(HttpServletResponse.SC_NOT_FOUND, "El recurso solicitado no se encuentra en el servidor.");
    }
}
