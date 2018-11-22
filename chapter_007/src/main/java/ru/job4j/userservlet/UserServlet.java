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
public class    UserServlet extends HttpServlet {
        private final ValidateService validateService ;


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
    //todo
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter writer = new PrintWriter(res.getOutputStream());
       StringBuilder stringBuilder = new StringBuilder("<table>");
        for(User user:this.validateService.findAll().values()){
            stringBuilder.append("<tr><td>"+user.getLogin()+"</tr></td>");
        }
       stringBuilder.append("</table>");
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
    //todo remove
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String action = req.getParameter("action");
        User u = new User.UserBuilder(name).build();
        DispatchPattern dp = new DispatchPattern();
        dp.init();
        dp.action(() -> Action.StoreAction.valueOf(action), ValidateService.getInstance(), u);
/*        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(" action: " + action);
        writer.append(" user: " + u);
        writer.append(" validate serv: " + ValidateService.getInstance().findAll());
        dp.action(()->Action.StoreAction.UPDATE,ValidateService.getInstance(),new User.UserBuilder("TEST").build());
        writer.append("\n"+"va11"+ ValidateService.getInstance().findAll());
        writer.flush();*/
    }
}


