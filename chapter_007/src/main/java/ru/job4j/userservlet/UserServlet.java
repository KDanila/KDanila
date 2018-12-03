package ru.job4j.userservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * UserServlet class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class UserServlet extends HttpServlet {
    private final ValidateService validateService;


    public UserServlet() {
        this.validateService = ValidateService.getInstance();
        //this.validateService.add(new User.UserBuilder("test").build());
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
        StringBuilder stringBuilder = new StringBuilder("<table style='width:100%'>");
        for (User user : this.validateService.findAll().values()) {
            stringBuilder.append("<tr>" +
                    "<td>" + user.getId() + "</td>" +
                    "<td>" + user.getLogin() + "</td>" +
                    "<td>" + user.getName() + "</td>" +
                    "<td>" +
                    //todo
                    "<form name = 'update' action ='" + req.getContextPath() + "/update method ='post'> " +
                    "   <input type='submit' value='update'>" +
                    "   <input type='hidden' name = 'id' value='"+user.getId()+"'>" +
                    "</form>" +
                    "</td>" +
                    "<td>" +
                    "<form name = 'delete' action ='" + req.getContextPath() + "/user' method ='post'>" +
                    "   <input type ='submit' value = 'delete'>" +
                    "   <input type='hidden' name = 'id' value='"+user.getId()+"'>" +
                    "</form>" +
                    "</td>" +
                    "</tr>");
        }
        stringBuilder.append("</table>");
        writer.append(stringBuilder);
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
        String id = req.getParameter("id");
        Action.StoreAction action = Action.StoreAction.DELETE;


        User u = this.validateService.findById(Integer.parseInt(id));
        DispatchPattern dp = new DispatchPattern();
        dp.init();
        dp.action(() -> action, ValidateService.getInstance(), u);



/*        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(" action: " + action);
        writer.append(" user: " + u);
        writer.append(" validate serv: " + ValidateService.getInstance().findAll());
        dp.action(()->Action.StoreAction.UPDATE,ValidateService.getInstance(),new User.UserBuilder("TEST").build());
        writer.append("\n"+"va11"+ ValidateService.getInstance().findAll());
        writer.flush();*/
    }
}


