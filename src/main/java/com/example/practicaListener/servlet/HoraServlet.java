package com.example.practicaListener.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "HoraServlet", value = "/HoraServlet")
public class HoraServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html;charset=UTF-8");
            resp.setHeader("refresh", "1");
            LocalTime hora = LocalTime.now();
            DateTimeFormatter df = DateTimeFormatter.ofPattern("hh:mm:ss");
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(" <head>");
                out.println(" <meta charset=\"UTF-8\">");
                out.println(" <title>La hora actualizada</title>");
                out.println(" </head>");
                out.println(" <body>");
                out.println(" <h1>La hora actualizada!</h1>");
                out.println("<h3>" + hora.format(df) + "</h3>");
                out.println(" </body>");
                out.println("</html>");
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
