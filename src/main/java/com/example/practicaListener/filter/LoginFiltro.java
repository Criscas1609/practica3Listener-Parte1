package com.example.practicaListener.filter;

import com.example.practicaListener.service.LoginService;
import com.example.practicaListener.service.impl.LoginServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionListener;

import java.io.IOException;
import java.util.Optional;


@WebFilter({"/index2.jsp"})//url que deseamos aplique el filtro
public class LoginFiltro implements Filter, ServletContextListener, ServletRequestListener, HttpSessionListener {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        LoginService service = new LoginServiceImpl();
        Optional<String> username = service.getUsername((HttpServletRequest)
                request);
        System.out.printf("Filtro 1");
        if (username.isPresent()) {
            System.out.printf("Filtro");
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse)response).sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "No estás autorizado para ingresar a esta página!");
        }
    }


}
