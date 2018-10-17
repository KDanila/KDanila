package ru.job4j.userservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {
/*
Метод doGet - должен отдавать список всех пользователей в системе.

Метод doPost - должен  уметь делать три вещи, создавать пользователя,
обновлять поля пользователя, удалять пользователя.
 */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter writer = new PrintWriter(res.getOutputStream());
        writer.append("hello world");
        writer.flush();
    }
/*
Создание нового пользователя.
action=add - ключ указывает какое действие выполнить. у нас будут три ключа add,
update, delete. их мы должно обработать в doPost.
name=petr - ключ указывает имя пользователя.
на стороне сервера мы извлекаем эти данные с помощью метода request.getParameter("action")
Обновление пользователя.
action=update
id=1 - первичный ключ - генерируется один раз. по нему мы будем искать пользователя в коллекции.
name=ivan - новое имя.
Удаление пользователя.
action=delete
id=1 - по ключу мы удаляем пользователя.
 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}


