package ru.job4j.xml;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * StoreXML class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class StoreXMLTest {
    /**
     * Test method.
     * <p>
     * field sum.
     */
    @Test
    public void fieldSumTestWhenReadingFieldValuesTheCorrectReturn() {
        File file = new File("src/main/java/ru/job4j/xml/result.xml");
        StoreXML storeXML = new StoreXML(file);
        assertThat(storeXML.fieldSum(file), is(6));
    }
}