package ru.job4j.siteparsing;

import org.quartz.SimpleTrigger;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class MainMethod {
    public MainMethod() {

    }

    void trigger(HTMLParser htmlParser){
        SimpleTrigger trigger = newTrigger()
                .withIdentity("trigger3", "group1")
                .startAt(myTimeToStartFiring)  // if a start time is not given (if this line were omitted), "now" is implied
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(10)
                        .withRepeatCount(10)) // note that 10 repeats will give a total of 11 firings
                .forJob(htmlParser) // identify job with handle to its JobDetail itself
                .build();
    }

    public static void main(String[] args) {
        new HTMLParser().startParsing();
    }


}
