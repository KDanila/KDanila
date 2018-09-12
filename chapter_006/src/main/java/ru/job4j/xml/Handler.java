package ru.job4j.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler {


    private int fieldSum = 0;
    private String element = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.element = qName;
        if(qName.equals("value")) {

        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch,start,length);
        if(str.contains("<")||element==null){
            return;
        }
        if(str.equals("value")){
            this.fieldSum+=Integer.valueOf(str);
        }
    }


    public int getFieldSum() {
        return fieldSum;
    }
}
