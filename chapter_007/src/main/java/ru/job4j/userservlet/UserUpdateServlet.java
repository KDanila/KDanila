package ru.job4j.userservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserUpdateServlet extends HttpServlet {

    private final ValidateService validateService;

    public UserUpdateServlet() {
        this.validateService = ValidateService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        int id = Integer.parseInt(req.getParameter("id"));
        PrintWriter pw = new PrintWriter(resp.getOutputStream());
        pw.append("<h1>Обновить данные пользователя</h1>" +
                "<form action ='" + req.getContextPath() + "/update' method ='post'>" +
            //    "<input type = 'text' name = 'id' value =" + id + ">" +
                "<input type = 'text' name = 'name' value =" + this.validateService.findById(id).getName() + ">" +
                "<input type = 'text' name = 'login'value =" + this.validateService.findById(id).getLogin() + ">" +
                "<input type = 'text' name = 'email'value =" + this.validateService.findById(id).getEmail() + ">" +
                "<input type ='submit' name = 'submit'>" +
                "</form>");
        pw.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Action.StoreAction action = Action.StoreAction.UPDATE;
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email"); User user = this.validateService.findById(Integer.parseInt(id));
        user.setName(name);
        user.setLogin(login);
        user.setEmail(email);
        this.validateService.update(user);
        resp.sendRedirect(String.format("%s/index.jsp", req.getContextPath()));
    }
}