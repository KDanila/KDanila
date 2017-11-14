package main.java.ru.job4j.tracker;

public class Item {
    protected String name;
    public String description;
    public long create;
    private String id;

    public Item() {
    }

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }
}
