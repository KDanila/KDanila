package ru.job4j.xml;


import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;


/**
 * ConvertXSQT class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ConvertXSQT {

    /**
     * Метод convert(File source, File dest, File scheme) - читает файл source и преобразовывает его
     * в файл dest за счет XSL схемы scheme.
     *
     * @param source - original xml.
     * @param dest   - resulting xml by xls scheme.
     * @param scheme - xls file.
     * @throws TransformerException - exception.
     */
    public void convert(File source, File dest, File scheme) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xsl = new StreamSource(scheme);
        Transformer transformer = factory.newTransformer(xsl);
        Source text = new StreamSource(source);
        transformer.transform(text, new StreamResult(dest));
    }
}
