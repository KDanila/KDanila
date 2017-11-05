package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * BubbleSort ArrayDuplicateTest class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicateTest {
    /**
     * Test {"Привет", "Мир", "Привет", "Супер", "Мир"}----->{"Привет", "Мир", "Супер"}.
     */
    @Test
    public void whenTenNumbersNotSortedThenSorted() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] expectedArray = {"Привет", "Мир", "Супер"};
        String[] arrayToChange = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] resultArray = arrayDuplicate.remove(arrayToChange);
        assertThat(resultArray, is(expectedArray));
    }

    /**
     * Test {"Привет", "Мир", "Привет", "Супер", "Мир", "Привет", "Мир", "Привет","Нет", "Привет", "Да"}
     * ----->{"Привет", "Мир", "Да", "Супер", "Нет"}.
     */
    @Test
    public void whenLongArrayWithTooMuchCopiesUnsortedThenSorted() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] expectedArray = {"Привет", "Мир", "Да", "Супер", "Нет"};
        String[] arrayToChange = {"Привет", "Мир", "Привет", "Супер", "Мир", "Привет", "Мир", "Привет", "Нет", "Привет", "Да"};
        String[] resultArray = arrayDuplicate.remove(arrayToChange);
        assertThat(resultArray, is(expectedArray));
    }

}
