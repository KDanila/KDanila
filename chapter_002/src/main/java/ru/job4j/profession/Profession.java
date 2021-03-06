package ru.job4j.profession;

/**
 * Profession class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class Profession {
    /**
     * name -имя.
     */
    private String name;
    /**
     * surname - фамилия.
     */
    private String surName;
    /**
     * money - деньги.
     */
    private int money;
    /**
     * Health - здоровье.
     */
    private Health health;
    /**
     * Education - образование.
     */
    private Education education;

    /**
     * @param doctor - doctor who get treatment.
     * @param health - health of person now
     * @return health after treatment
     */
    public Health getTreatment(Doctor doctor, Health health) {
        return new Health();
    }

    /**
     * @param teacher   - teacher who study.
     * @param education - current level of education
     * @return education - after all.
     */
    public Education getEducation(Teacher teacher, Education education) {
        return new Education();
    }

    /**
     * @param time - amount of time.
     * @return money
     */
    public int makeMoney(Time time) {
        return 0;
    }
}
