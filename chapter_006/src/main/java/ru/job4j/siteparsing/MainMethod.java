package ru.job4j.siteparsing;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * MainMethod class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class MainMethod implements Job {
    /**
     * psvm.
     *
     * @param args - args.
     */
    public static void main(String[] args) {
        try {
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = null;
            scheduler = schedulerFactory.getScheduler();
            JobDetail jobDetail = JobBuilder.newJob(MainMethod.class)
                    .withIdentity("myJob", "myGroup").build();
            SimpleTrigger trigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity("myTrigger", "myGroup")
                    .startNow()
                    .withSchedule(
                            SimpleScheduleBuilder
                                    .simpleSchedule()
                                    .withIntervalInHours(24)
                                    .repeatForever()
                                    .withMisfireHandlingInstructionIgnoreMisfires())
                    .build();

            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }


    }

    /**
     * execute() method.
     * Quartz interface ovverriding.
     *
     * @param context - JobExecutionContext.
     * @throws JobExecutionException - joe.
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String path = "C:\\Projects\\KDanila\\chapter_006\\src\\main\\java\\ru\\job4j\\siteparsing\\config.properties";
        StoreSQL storeSQL = new StoreSQL(path);
        HTMLParser htmlParser = new HTMLParser(path, storeSQL);
        htmlParser.startParsing();
        System.out.println(htmlParser);
    }
}
