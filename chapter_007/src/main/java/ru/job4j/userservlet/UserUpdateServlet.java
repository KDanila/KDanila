package ru.job4j.userservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserUpdateServlet extends HttpServlet {

    private final ValidateService validateService;

    public UserUpdateServlet() {
        this.validateService = ValidateService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("user", this.validateService.findById(id));
        req.getRequestDispatcher("/WEB-INF/Views/UpdateUserView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");

        User user = this.validateService.findById(Integer.valueOf(id));
        user.setName(name);
        user.setLogin(login);
        user.setEmail(email);

        boolean isUserAlreadyExist = this.validateService.isUserUnique(user);
        if (isUserAlreadyExist) {
            this.validateService.update(id, user);
        }

        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}