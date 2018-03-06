package ru.job4j.UserConvert;

import java.util.HashMap;
import java.util.List;

public class UserConvert {

    /*Создать класс User с полями id, name, city.
    Cоздать клаcc UserConvert.
    В классе UserConvert написать метод public HashMap<Integer, User> process(List<User> list) {},
     который принимает в себя список пользователей и конвертирует его в Map с ключом Integer id и
     соответствующим ему User.*/

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> toReturn = new HashMap<Integer, User>();
        for (User user : list) {
            toReturn.put(user.getId(),user);
        }
        return toReturn;
    }

}
