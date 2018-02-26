package ru.job4j.search;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Telephone Directory Testing class.
 */
public class TelephoneDirectoryTest {
    /**
     * Testing searh name.
     */
    @Test
    public void whenFindByName() {
        TelephoneDirectory phones = new TelephoneDirectory();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    /**
     * Testing searh surname.
     */
    @Test
    public void whenFindBySurname() {
        TelephoneDirectory phones = new TelephoneDirectory();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("Arsentev");
        assertThat(persons.iterator().next().getName(), is("Petr"));
    }

    /**
     * Testing two duplicate persons.
     */
    @Test
    public void whenFindByTwoSurname() {
        TelephoneDirectory phones = new TelephoneDirectory();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );

        List<Person> persons = phones.find("Arsentev");
        assertThat(persons.get(0).getName(), is("Petr"));
        assertThat(persons.get(1).getName(), is("Petr"));
    }

}
