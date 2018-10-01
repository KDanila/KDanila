package ru.job4j.siteparsing;

import org.quartz.SimpleTrigger;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class MainMethod {
    public MainMethod() {
    }


    void trigger(HTMLParser htmlParser){

    }

    public static void main(String[] args) {
        String path = "C:\\Projects\\KDanila\\chapter_006\\src\\main\\java\\ru\\job4j\\siteparsing\\config.properties";
        StoreSQL storeSQL = new StoreSQL(path);
        storeSQL.connectingToDB();
        // new HTMLParser().startParsing();
    }


}
