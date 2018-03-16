package ru.job4j.usersort;


import java.util.Set;
import java.util.List;
import java.util.Collections;
import java.util.TreeSet;
import java.util.Comparator;

/**
 * UserSort class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.0.1
 */
public class UserSort {

    /**
     * Return SortedSet of users.
     *
     * @param users - list.
     * @return set.
     */
    public Set<User> sort(List<User> users) {
        return new TreeSet<User>(users);
    }

    /**
     * Method return sorted List by name.
     *
     * @param users - users list.
     * @return sorted list.
     */

    public List<User> sortNameLength(List<User> users) {
        Comparator<User> nameLengthComparator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return (o1.getName().length()) - (o2.getName().length());
            }
        };
        Collections.sort(users, nameLengthComparator);
        return users;
    }

    /**
     * Sjrting by two fields List<User>. First name, then age.
     *
     * @param users - List unsorted.
     * @return - list after sorting.
     */
    public List<User> sortByAllFields(List<User> users) {
        Comparator<User> sortByAllFieldsComparator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int temp = o1.getName().compareTo(o2.getName());
                if (o1.getName().equals(o2.getName())) {
                    temp = o1.getAge() - o2.getAge();
                }
                return temp;
            }
        };
        Collections.sort(users, sortByAllFieldsComparator);
        return users;
    }
}
