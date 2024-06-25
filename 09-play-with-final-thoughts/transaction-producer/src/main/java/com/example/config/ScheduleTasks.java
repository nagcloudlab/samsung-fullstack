package com.example.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTasks {

//
//    @Autowired
//    private JobLauncher jobLauncher;
//
//    @Autowired
//    private Job job;

   // every day at 10-AM
    @Scheduled(cron = "0 0 10 * * ?")
    public void perform() throws Exception {
//        jobLauncher.run(job, new JobParametersBuilder().toJobParameters());
    }

    // This method will be executed every hour
    @Scheduled(cron = "0 0 * * * ?")
    public void runEveryHour() {
        System.out.println("Task executed at the start of every hour");
    }

    // This method will be executed every 5 minutes on weekdays
    @Scheduled(cron = "0 */5 * ? * MON-FRI")
    public void runEveryFiveMinutesOnWeekdays() {
        System.out.println("Task executed every 5 minutes on weekdays");
    }

    // This method will be executed every 30 seconds
    @Scheduled(cron = "*/30 * * * * ?")
    public void runEvery30Seconds() {
        System.out.println("Task executed every 30 seconds");
    }

    // This method will be executed at 9:15 AM and 3:15 PM on the 1st and 15th of every month
    @Scheduled(cron = "0 15 9,15 1,15 * ?")
    public void runAtSpecificTimes() {
        System.out.println("Task executed at 9:15 AM and 3:15 PM on the 1st and 15th of each month");
    }

    // This method will be executed at 11 PM on the last day of every month
    @Scheduled(cron = "0 0 23 L * ?")
    public void runAtEndOfMonth() {
        System.out.println("Task executed at 11 PM on the last day of every month");
    }

    // This method will be executed at 10:30 AM every Monday and Wednesday
    @Scheduled(cron = "0 30 10 ? * MON,WED")
    public void runOnSpecificDays() {
        System.out.println("Task executed at 10:30 AM on Mondays and Wednesdays");
    }

}
