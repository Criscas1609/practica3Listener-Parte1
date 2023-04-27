package com.example.practicaListener.servlet;

import com.example.practicaListener.service.LoginService;
import com.example.practicaListener.service.impl.LoginServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    final static String USERNAME = "admin";
    public final static String PASSWORD = "12345";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService auth = new LoginServiceImpl();
        Optional<String> cookieOptional = auth.getUsername(req);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            if (cookieOptional.isPresent()) {
                resp.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = resp.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println(" <head>");
                    out.println(" <meta charset=\"UTF-8\">");
                    out.println(" <title>Hola " + cookieOptional.get() +
                            "</title>");
                    out.println(" </head>");
                    out.println(" <body>");
                    out.println(" <h1>Hola " + cookieOptional.get() + " has iniciado sesión con éxito!</h1>");
                    out.println("<p><a href='" + req.getContextPath() +
                            "/index.jsp'>volver</a></p>");
                    out.println("<p><a href='" + req.getContextPath() +
                            "/Session.jsp'>cerrar sesión</a></p>");
                    out.println(" </body>");
                    out.println("</html>");
                }
            }

        }else {
            getServletContext().getRequestDispatcher("/Login.jsp").forward(req,
                    resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String username = req.getParameter("username");
            String password = req.getParameter("password");
            if (USERNAME.equals(username) && PASSWORD.equals(password)) {
                Cookie usernameCookie = new Cookie("username", username);
                resp.addCookie(usernameCookie);
                resp.setContentType("text/html;charset=UTF-8");
                HttpSession session = req.getSession();
                session.setAttribute("username", username);
                try (PrintWriter out = resp.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println(" <head>");
                    out.println(" <meta charset=\"UTF-8\">");
                    out.println(" <title>Login correcto</title>");
                    out.println(" </head>");
                    out.println(" <body>");
                    out.println(" <h1>Login correcto!</h1>");
                    out.println(" <h3>Hola " + username + " has iniciado sesión con éxito!</h3>");
                    out.println(" <a href=\"Product.jsp\">Producto id</a></br>");
                    out.println(" </body>");
                    out.println("</html>");
                }
            } else {
                resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no " +
                        "esta autorizado para ingresar a esta página!");
            }





        /*String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            Cookie usernameCookie = new Cookie("username", username);
            resp.addCookie(usernameCookie);
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(" <head>");
                out.println(" <meta charset=\"UTF-8\">");
                out.println(" <title>Login correcto</title>");
                out.println(" </head>");
                out.println(" <body>");
                out.println(" <h1>Login correcto!</h1>");
                out.println(" <h3>Hola "+ username + " has iniciado sesión con éxito!</h3>");
                out.println(" </body>");
                out.println("</html>");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no esta autorizado para ingresar a esta página!");
        }
*/

    }
}
