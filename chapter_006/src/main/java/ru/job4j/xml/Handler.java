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
            System.out.println("!!!!!!in!!!!!!!!!");
            System.out.println(attributes.getValue(0));
            System.out.println(attributes.getValue(qName));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch,start,length);
        if(str.contains("<")||element==null){
            return;
        }
        if(str.equals("value")){
            System.out.println(Integer.valueOf(str));
        }
        //String str = new String(ch, start, length);

        //fieldSum+=Integer.parseInt(str);
        //System.out.print(Integer.getInteger(str));
    }
}
