package ru.job4j.userservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//todo
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
        //todo add form
        StringBuilder stringBuilder = new StringBuilder("<table style='width:100%'>");
        stringBuilder.append("<tr>" +
                "<td>" + user.getId() + "</td>" +
                "<td>" + user.getLogin() + "</td>" +
                "<td>" + user.getName() + "</td>" +
               // "<td>" +
                "</table>");
        writer.append(stringBuilder);
        writer.flush();
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
    }
}
/*
UserUpdateServlet

- doGet URL /edit?id={userId} - открывает форму для редактирования с заполенными полями.

- doPost - / - сохраняет пользователя.
 */