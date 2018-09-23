package ru.job4j.xml;


import javax.xml.transform.*;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;


import java.io.*;

public class ConvertXSQT {

    /**
     * Метод convert(File source, File dest, File scheme) - читает файл source и преобразовывает его
     * в файл dest за счет XSL схемы scheme.
     *
     * @param source
     * @param dest
     * @param scheme
     * @throws TransformerException
     */
    public void convert(File source, File dest, File scheme) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xsl = new StreamSource(scheme);
        Transformer transformer = factory.newTransformer(xsl);
        Source text = new StreamSource(source);
        transformer.transform(text, new StreamResult(dest));
    }
}
