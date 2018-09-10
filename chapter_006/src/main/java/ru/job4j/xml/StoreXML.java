package ru.job4j.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

public class StoreXML {

    private File storeInXML = null;

    StoreXML(File target) {
        this.storeInXML = target;
    }


/*

    public static void main(String[] args) throws JAXBException {
        List<Entry> list = new ArrayList<>();
        List<Field> fields = new ArrayList<>();
        fields.add(new Field(0));
        fields.add(new Field(0));
        fields.add(new Field(0));
        list.add(new Entry(fields));
        fields.add(new Field(1));
        fields.add(new Field(1));
        fields.add(new Field(1));
        list.add(new Entry(fields));
        JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(
                new Entries(list),
                new File("C:\\Projects\\KDanila\\chapter_006\\src\\test" +
                        "\\java\\ru\\job4j\\xml\\data.xml")
        );
    }
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
    //todo sax parser.
    public int fieldSum(File target){

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
