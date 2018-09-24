package ru.job4j.xml;

import org.junit.Test;

import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * ConvertXSQTTest class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ConvertXSQTTest {
    /**
     * ConverXSQT test.
     *
     * @throws IOException          - ex.
     * @throws TransformerException - ex.
     */
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

