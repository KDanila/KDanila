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
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        String id = req.getParameter("id");
        User user = this.validateService.findById(Integer.parseInt(id));
        writer.append("<table style='width:100%'>"+
                "<tr>" +
                "<td>" + user.getId() + "</td>" +
                //todo form to send in post
                "<td>" + user.getLogin() + "</td>" +
                "<td>" + user.getName() + "</td>" +
                "<td>"+
                "<form name = 'update' action ='" + req.getContextPath() + "/update' method ='post'>" +
                "   <input type ='submit' value = 'update'>" +
                "   <input type='hidden' name = 'id' value='" + user.getId() + "'>" +
                "</form>" +
                "</td>" +
                "</table>");
        writer.flush();
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Action.StoreAction action = Action.StoreAction.UPDATE;
        User u = this.validateService.findById(Integer.parseInt(id));
        DispatchPattern dp = new DispatchPattern();
        dp.init();
        dp.action(() -> action, ValidateService.getInstance(), u);
    }
}
/*
UserUpdateServlet

- doGet URL /edit?id={userId} - открывает форму для редактирования с заполенными полями.

- doPost - / - сохраняет пользователя.
 */