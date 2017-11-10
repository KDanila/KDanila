package src.main.java.ru.job4j.profession;

/**
 * Doctor class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Doctor extends Profession {
    /**
     * @param profession - person who get treatment.
     * @param health     - current level of health
     * @return health after treatment
     */
    public Health treat(Profession profession, Health health) {
        return new Health();
    }
}
