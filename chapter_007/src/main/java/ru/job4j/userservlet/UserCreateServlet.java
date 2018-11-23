package ru.job4j.userservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//todo
public class UserCreateServlet extends HttpServlet {

    private final ValidateService validateService;

    public UserCreateServlet() {
        this.validateService = ValidateService.getInstance();
    }

    /**
     * Метод doGet - должен отдавать список всех пользователей в системе.
     *
     * @param req - request.
     * @param res - response.
     * @throws IOException - ioex.
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter writer = new PrintWriter(res.getOutputStream());
      /*  writer.append("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "    <meta charset=\"UTF-8\">" +
                "    <title>Title</title>" +
                "</head>" +
                "<body>" +
                "</body>" +
                "<form action ='" + req.getContextPath() + "/create' method ='post'>" +
                "Name:<input type = 'text' name = 'login'/>" +
                "<input type = 'submit'/>" +
                "</form>" +
                "</html>");*/
        writer.append(
                "   <caption>Создание нового пользователя</caption>" +
                        "<form action ='" + req.getContextPath() + "/create' method ='post'>" +
                        "   <input type = 'text' name = 'name'/>" +
                        "   <input type = 'text' name = 'login'/>" +
                        "   <input type = 'text' name = 'email'/> " +
                        "   <input type ='submit' name = 'submit'>" +
                        "   </form>");
        writer.flush();
    }

    /**
     * Метод doPost - должен  уметь делать три вещи, создавать пользователя,
     * обновлять поля пользователя, удалять пользователя.
     * Создание нового пользователя.
     * action=add - ключ указывает какое действие выполнить. у нас будут три ключа add,
     * update, delete. их мы должно обработать в doPost.
     * name=petr - ключ указывает имя пользователя.
     * на стороне сервера мы извлекаем эти данные с помощью метода request.getParameter("action")
     * Обновление пользователя.
     * action=update
     * id=1 - первичный ключ - генерируется один раз. по нему мы будем искать пользователя в коллекции.
     * name=ivan - новое имя.
     * Удаление пользователя.
     * action=delete
     * id=1 - по ключу мы удаляем пользователя.
     *
     * @param req  - request.
     * @param resp - response.
     * @throws ServletException - servlet excep.
     * @throws IOException      - io excep.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        // String action = req.getParameter("action");
        User u = new User.UserBuilder(name).login(login).email(email).build();
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(u.toString());
        writer.append(req.getAuthType());
        writer.append(req.getPathInfo());
        writer.append(req.getQueryString());
        writer.append(req.getServletPath());
        writer.flush();

    }
}
/*
UserCreateServlet

- doGet URL /create - Открывает форму для создания нового пользователя.

- doPost - / - сохраняет пользователя.
 */