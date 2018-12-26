package ru.job4j.userservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserCreateServlet extends HttpServlet {

    private final ValidateService validateService;

    public UserCreateServlet() {
        this.validateService = ValidateService.getInstance();
    }

    /**
     * Метод doGet.
     *
     * @param req - request.
     * @param res - response.
     * @throws IOException - ioex.
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

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
        boolean unique = this.validateService
                .findAll()
                .values()
                .stream()
                .filter(u->u.getEmail()!=null)
                .noneMatch(u -> u.getEmail().equals(email)
                        || u.getLogin().equals(login));
        if(unique) {
            User user = new User.UserBuilder(name).login(login).email(email).build();
            this.validateService.add(user);
        }
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
/*
UserCreateServlet

- doGet URL /create - Открывает форму для создания нового пользователя.

- doPost - / - сохраняет пользователя.
 */