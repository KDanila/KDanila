package ru.job4j.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.print.attribute.IntegerSyntax;

public class Handler extends DefaultHandler {


    private int fieldSum = 0;
    private String element = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.element = qName;
        System.out.println("getQName "+attributes.getQName(0));
        System.out.println("getValue "+attributes.getValue(0));
        this.fieldSum+= Integer.valueOf(attributes.getValue(0));
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch,start,length);
        if(str.contains("<")||element==null){
            return;
        }
        if(str.equals("entries")){
            this.fieldSum+=Integer.valueOf(str);
        }
    }


    public int getFieldSum() {
        return fieldSum;
    }
}
