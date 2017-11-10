package src.main.java.ru.job4j.profession;

/**
 * Teacher class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Teacher extends Profession {
    /**
     * @param profession       - person who get education.
     * @param teacherEducation - level od teacher's knowledge.
     * @return education.
     */
    public Education study(Profession profession, Education teacherEducation) {
        return new Education();
    }
}
