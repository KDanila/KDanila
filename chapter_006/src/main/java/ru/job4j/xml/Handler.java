package ru.job4j.xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Handler class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Handler extends DefaultHandler {
    /**
     * fieldSum -  it is sum of href attributes in xml file.
     */
    private int fieldSum = 0;

    /**
     * Start element.
     *
     * @param uri        - uri.
     * @param localName  - localName.
     * @param qName      - qName.
     * @param attributes - attributes.
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if ("entry".equals(qName)) {
            fieldSum += Integer.valueOf(attributes.getValue(0));
        }
    }

    /**
     * getFieldSum() - getter.
     *
     * @return int - fieldSum.
     */
    public int getFieldSum() {
        return fieldSum;
    }
}
