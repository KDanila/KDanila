package ru.job4j.xml;

import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * StoreXML class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class StoreXML {
    /**
     * File
     */
    private File storeInXML = null;

    StoreXML(File target) {
        this.storeInXML = target;
    }


    public void save(List<Entry> list) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(
                list,
                this.storeInXML
        );
    }

    public int fieldSum(File target) {
        Handler handler = new Handler();
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        SAXParser saxParser = null;
        try {
            saxParser = spf.newSAXParser();
            saxParser.parse(target, handler);
        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return handler.getFieldSum();
    }
    /*
    SAXParser saxParser = spf.newSAXParser();
XMLReader xmlReader = saxParser.getXMLReader();
xmlReader.setContentHandler(new SAXLocalNameCount());
xmlReader.parse(convertToFileURL(filename));
     */

    @XmlRootElement
    static class Entries {
        private List<Entry> entry;

        public Entries() {
        }

        public Entries(List<Entry> entry) {
            this.entry = entry;
        }

        public List<Entry> getEntry() {
            return entry;
        }

        public void setEntry(List<Entry> entry) {
            this.entry = entry;
        }
    }

    @XmlRootElement
    static class Entry {
        private List<Field> field;

        public List<Field> getFields() {
            return field;
        }

        public void setFields(List<Field> fields) {
            this.field = fields;
        }

        Entry() {

        }

        Entry(List<Field> fields) {
            this.field = fields;
        }

    }

    @XmlRootElement
    static class Field {
        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        private int value;

        Field() {

        }

        public Field(int value) {
            this.value = value;
        }
    }
}
