package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
/**
 * TelephoneDirectory class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class TelephoneDirectory {
    /**
     * persons - list of persons.
     */
    private List<Person> persons = new ArrayList<Person>();

    /**
     * Add person method.
     * @param person - person class.
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getAddress().equals(key)
                    || person.getName().equals(key)
                    || person.getPhone().equals(key)
                    || person.getSurname().equals(key)) {
                result.add(person);
            }
        }
        return result;
    }
}
