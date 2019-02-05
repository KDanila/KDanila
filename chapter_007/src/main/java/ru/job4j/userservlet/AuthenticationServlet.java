package ru.job4j.userservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationServlet extends HttpServlet {

    ValidateService validateService = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/Views/AuthView.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        if (this.validateService.isAccessAllowed(login, password)) {
            session.setAttribute("login", "correct");
            resp.sendRedirect(String.format("%s/", req.getContextPath()));
        } else {
            session.setAttribute("login", "incorrect");
            resp.sendRedirect(String.format("%s/signin", req.getContextPath()));
        }

    }
}
