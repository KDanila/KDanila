package ru.job4j.xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler {


    private int fieldSum = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if ("entry".equals(qName)) {
            fieldSum += Integer.valueOf(attributes.getValue(0));
        }
    }

    public int getFieldSum() {
        return fieldSum;
    }
}
