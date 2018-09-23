package ru.job4j.xml;

import org.junit.Test;

import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ConvertXSQTTest {

    @Test
    public void convertXSQTTest() throws IOException, TransformerException {
        ConvertXSQT cc = new ConvertXSQT();
        File source = new File("C:\\Projects\\KDanila\\chapter_006\\src\\main\\java\\ru\\job4j\\xml\\data.xml");
        File scheme = new File("C:\\Projects\\KDanila\\chapter_006\\src\\main\\java\\ru\\job4j\\xml\\template.xsl");
        File dest = new File("C:\\Projects\\KDanila\\chapter_006\\src\\main\\java\\ru\\job4j\\xml\\result.xml");
        dest.createNewFile();
        cc.convert(source, dest, scheme);
        assertThat(true, is(dest.exists()));
    }
}

