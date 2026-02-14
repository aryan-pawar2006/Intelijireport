import com.sun.security.jgss.GSSUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;
import java.util.*;

public class javatime {
    static void main() {
        Scanner sc = new Scanner(System.in);
        //print the current date of day :
        LocalDate date = LocalDate.now();
        System.out.println("local date of is:" + date);
        //we can sreate the custom date also :
        LocalDate customdate = LocalDate.of(1998, 4, 24);
        System.out.println("so the custom date is :" + customdate);
        //with the help of get funwe can access the current month,day, and year also:
        int day = LocalDate.now().getDayOfMonth();
        int month = LocalDate.now().getMonthValue();
        int year = LocalDate.now().getYear();
        System.out.println("day of year is: " + day + ", month of year is :" + month + ", current year is :" + year);
        //now we can add and subtract the day and months or even year also :
        LocalDate yestrday = date.minusDays(1);
        LocalDate lastyear = date.minusYears(1);
        System.out.println("after minusing the day result is:" + yestrday);
        System.out.println("after minusing the year the result is:" + lastyear);
        //check wether the current year is leap year or not :
        int currentyear = LocalDate.now().getYear();
        if (currentyear % 4 == 0) {
            System.out.println("the current yaer is leap year !");
        } else {
            System.out.println("the current year is not the leap year!");
        }

        //Local time:in this local time also we can usethe same methods like date,
        LocalTime currenttime = LocalTime.now();
        LocalTime custometime = LocalTime.of(21, 54, 22);
        System.out.println("current and custome time is: " + currenttime + " and " + custometime);
        System.out.println("after converting the string time to original time is: " + LocalTime.parse("19:02:22"));
        //create the local time object of 10:30 AM and orint it :
        LocalTime prticulortime = LocalTime.parse("10:30");
        System.out.println("local time that you wanted is:" + prticulortime + "AM");
        System.out.println("curent hour of time is:" + LocalTime.now().getHour());
        System.out.println("curent minuts of time is:" + LocalTime.now().getMinute());
        System.out.println("curent seconds of time is:" + LocalTime.now().getSecond());
        System.out.println("after adding and subtracting the  hours and time :" + currenttime.plusHours(2).minusMinutes(20));
        LocalTime t1 = LocalTime.of(10, 43, 23);
        LocalTime t2 = LocalTime.of(13, 53, 43);
        if (t1.isAfter(t2)) {
            System.out.println("the time of t1 is greater !");
        } else {
            System.out.println("the time of t2 is greter than t1!");
        }
        //check the office is open or not at current time :
        LocalTime starttime = LocalTime.of(9, 0, 0);
        LocalTime endtime = LocalTime.of(18, 0, 0);
        if (currenttime.isAfter(starttime) && currenttime.isBefore(endtime)) {
            System.out.println("the office is open !");
        } else {
            System.out.println("the office is closed !");
        }
        //Zoned date time://this zoned date time is in UTC(which is universal time constant ) formate it and UTC we can use every where it is basiccaly common time for every zone :
        ZonedDateTime currentzonetime = ZonedDateTime.now();
        System.out.println("current zoned date and time is :" + currentzonetime);
        //create the custome zoned time :
        ZonedDateTime customedatetime = ZonedDateTime.of(2026, 12, 11, 23, 43, 56, 43, ZoneId.of("America/New_York"));
        System.out.println("custome zoneddatetime is :" + customedatetime);
        Set<String> allzoned = ZoneId.getAvailableZoneIds();
        System.out.println("all the zoned id are :");
        for (String zone : allzoned) {
            System.out.println(zone + "\n");
        }
        System.out.println("total number of zoned id's are :" + allzoned.size());

        //create the custom zoned first of all for comparing that zone with London and newyork:
        ZonedDateTime meetingtime = ZonedDateTime.of(LocalDate.now(), LocalTime.of(10, 30, 00, 00), ZoneId.of("Asia/Kolkata"));
        System.out.println("meeting time is :" + meetingtime);
        //if we have only one line to take inut or display output we can use-> IO
        System.out.println("meeting time for london:" + meetingtime.withZoneSameInstant(ZoneId.of("Europe/London")));
        System.out.println("meeting time for New_York:" + meetingtime.withZoneSameInstant(ZoneId.of("America/New_York")));


    }
}
