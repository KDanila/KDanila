package ru.job4j.userconvert;

import java.util.HashMap;
import java.util.List;

/**
 * userconvert class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class UserConvert {

    /**
     * Принимает в себя список пользователей и конвертирует его в Map с ключом Integer id и
     * соответствующим ему User.
     *
     * @param list -input List<User>.
     * @return HashMap<Integer,User>.
     */

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> toReturn = new HashMap<Integer, User>();
        for (User user : list) {
            toReturn.put(user.getId(), user);
        }
        return toReturn;
    }

}
