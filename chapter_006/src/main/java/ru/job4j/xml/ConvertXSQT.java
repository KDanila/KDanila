package ru.job4j.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ConvertXSQT {

    /**
     * Метод convert(File source, File dest, File scheme) - читает файл source и преобразовывает его
     * в файл dest за счет XSTL схемы scheme.
     *
     * @param source
     * @param dest
     * @param scheme
     * @throws TransformerException
     */
    public void convert(File source, File dest, File scheme) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(scheme);
        Transformer transformer = factory.newTransformer(xslt);
        Source text = new StreamSource(source);
        transformer.transform(text, new StreamResult(dest));
    }
}
