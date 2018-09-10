package ru.job4j.xml;

public class MainMethod {
    public static void main(String[] args) {
        StoreSQL ssql = new StoreSQL();
        ssql.connectingToDB();
        ssql.generate(10);
    }
}
