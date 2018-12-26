package ru.job4j.userservlet;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthentificationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        if (request.getRequestURI().contains("/signin")) {
            chain.doFilter(req, response);
        } else {
            HttpSession session = request.getSession();
            if (session.getAttribute("login") == null ||
                    session.getAttribute("login").equals("incorrect")) {
                System.out.println("came into session login comparisson");
                ((HttpServletResponse) response).sendRedirect(String.format("%s/signin", ((HttpServletRequest) request).getContextPath()));
                return;
            }
            chain.doFilter(req, response);
        }
    }

    @Override
    public void destroy() {

    }
}
