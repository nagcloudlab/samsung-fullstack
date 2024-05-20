package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class Ex3 {
    public static void main(String[] args) {

        Date date=new Date();
        System.out.println("Current date and time: "+date.toString());

        // Limitations of Date class
        // 1. Date class is not thread safe, so it can cause issues in multithreaded environment.
        // 2. Date class is not providing any mechanism to format the date.
        // 3. Date class is not providing any mechanism to parse the date.
        // 4. Date class is not providing any mechanism to manipulate the date.
        // 5. Date class is not providing any mechanism to get only date or only time.
        // 6. Date class is not providing any mechanism to get the day, month or year separately.

        Calendar calendar=Calendar.getInstance();

        // LImitations of Calendar class
        // 1. Calendar class is not providing any mechanism to format the date.
        // 2. Calendar class is not providing any mechanism to parse the date.
        // 3. Calendar class is not providing any mechanism to manipulate the date.

        // third party libraries like Joda-Time.

        // Java 8 introduced a new Date-Time API in java.time package to overcome the limitations of old date-time classes.

        LocalDate localDate=LocalDate.now();
        System.out.println("Current date: "+localDate);

        LocalTime localTime=LocalTime.now();
        System.out.println("Current time: "+localTime);

        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println("Current date and time: "+localDateTime);

    }
}
