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
     * File.
     */
    private File storeInXML = null;

    /**
     * Constructor.
     *
     * @param target - target.
     */
    StoreXML(File target) {
        this.storeInXML = target;
    }

    /**
     * Save method.
     *
     * @param list - of Entry to construct XML file.
     * @throws JAXBException - exception.
     */
    public void save(List<Entry> list) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(
                list,
                this.storeInXML
        );
    }

    /**
     * fieldSum method. Counting sum href number from result xml.
     *
     * @param target - target file in xml.
     * @return - field sum.
     */
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

    /**
     * Entries element.
     */
    @XmlRootElement
    static class Entries {
        /**
         * entry.
         */
        private List<Entry> entry;

        /**
         * Constructor.
         */
        Entries() {
        }

        /**
         * Constructor.
         *
         * @param entry - entry list.
         */
        Entries(List<Entry> entry) {
            this.entry = entry;
        }

        /**
         * Getter.
         *
         * @return entry list.
         */
        public List<Entry> getEntry() {
            return entry;
        }

        /**
         * Setter.
         *
         * @param entry - entry list.
         */
        public void setEntry(List<Entry> entry) {
            this.entry = entry;
        }
    }

    /**
     * Entry class.
     */
    @XmlRootElement
    static class Entry {
        /**
         * Field.
         */
        private List<Field> field;

        /**
         * Getter.
         *
         * @return field List.
         */
        public List<Field> getFields() {
            return field;
        }

        /**
         * Setter.
         *
         * @param fields - fields.
         */
        public void setFields(List<Field> fields) {
            this.field = fields;
        }

        /**
         * Constructor.
         */
        Entry() {

        }

        /**
         * Constructor.
         *
         * @param fields - list fields.
         */
        Entry(List<Field> fields) {
            this.field = fields;
        }

    }

    /**
     * Field class.
     */
    @XmlRootElement
    static class Field {
        /**
         * value.
         */
        private int value;

        /**
         * Constructor.
         */
        Field() {

        }

        /**
         * Constructor.
         *
         * @param value - int.
         */
        Field(int value) {
            this.value = value;
        }

        /**
         * Getter.
         *
         * @return value.
         */
        public int getValue() {
            return value;
        }

        /**
         * Setter.
         *
         * @param value - int.
         */
        public void setValue(int value) {
            this.value = value;
        }
    }
}
