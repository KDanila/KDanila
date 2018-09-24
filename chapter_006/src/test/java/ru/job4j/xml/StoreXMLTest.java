package ru.job4j.xml;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StoreXMLTest {
    @Test
    public void fieldSumTestWhenReadingFieldValuesTheCorrectReturn() {
        File file = new File("C:\\Projects\\KDanila\\chapter_006\\src\\main\\java\\ru\\job4j\\xml\\result.xml");
        StoreXML storeXML = new StoreXML(file);
        assertThat(storeXML.fieldSum(file),is(6));
    }
}