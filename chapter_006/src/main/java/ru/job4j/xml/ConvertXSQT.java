package ru.job4j.xml;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


import java.io.ByteArrayInputStream;
import java.io.File;

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
        transformer.transform(text, new StreamResult(System.out));
    }

    public static void main(String[] args) throws TransformerException {
        ConvertXSQT cc = new ConvertXSQT();
        File source = new File("src\\main\\java\\ru\\job4j\\xml\\data.xml");
        File dest = new File("src\\main\\java\\ru\\job4j\\xml\\result.xml");
        File scheme = new File("src\\main\\java\\ru\\job4j\\xml\\template.xsl");
        String xsl = "<?xml version=\"1.0\"?>\n" +
                "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">\n" +
                "    <xsl:template match=\"/\">\n" +
                "        <entries>\n" +
                "            <xsl:for-each select=\"//entry\">\n" +
                "                <entry>\n" +
                "                    <xsl:attribute name=\"href\">\n" +
                "                        <xsl:value-of select=\"sum(fields/value)\"/>\n" +
                "                    </xsl:attribute>\n" +
                "                </entry>\n" +
                "            </xsl:for-each>\n" +
                "        </entries>\n" +
                "    </xsl:template>\n" +
                "</xsl:stylesheet>";

        String xml = "<entries>\n" +
                "    <entry>\n" +
                "        <fields>\n" +
                "            <value>0</value>\n" +
                "        </fields>\n" +
                "        <fields>\n" +
                "            <value>0</value>\n" +
                "        </fields>\n" +
                "        <fields>\n" +
                "            <value>0</value>\n" +
                "        </fields>\n" +
                "        <fields>\n" +
                "            <value>1</value>\n" +
                "        </fields>\n" +
                "        <fields>\n" +
                "            <value>1</value>\n" +
                "        </fields>\n" +
                "        <fields>\n" +
                "            <value>1</value>\n" +
                "        </fields>\n" +
                "    </entry>\n" +
                "    <entry>\n" +
                "        <fields>\n" +
                "            <value>0</value>\n" +
                "        </fields>\n" +
                "        <fields>\n" +
                "            <value>0</value>\n" +
                "        </fields>\n" +
                "        <fields>\n" +
                "            <value>0</value>\n" +
                "        </fields>\n" +
                "        <fields>\n" +
                "            <value>1</value>\n" +
                "        </fields>\n" +
                "        <fields>\n" +
                "            <value>1</value>\n" +
                "        </fields>\n" +
                "        <fields>\n" +
                "            <value>1</value>\n" +
                "        </fields>\n" +
                "    </entry>\n" +
                "</entries>";
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(
                new StreamSource(
                        new ByteArrayInputStream(xsl.getBytes()))
        );
        transformer.transform(new StreamSource(
                        new ByteArrayInputStream(xml.getBytes())),
                new StreamResult(System.out)
        );

        /*
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(
                new StreamSource(
                        new ByteArrayInputStream(xsl.getBytes()))
        );
        transformer.transform(new StreamSource(
                        new ByteArrayInputStream(xml.getBytes())),
                new StreamResult(System.out)
         */
    }
}
