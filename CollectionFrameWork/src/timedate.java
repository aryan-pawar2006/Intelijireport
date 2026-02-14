import com.sun.security.jgss.GSSUtil;

import javax.swing.text.DateFormatter;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.*;

public class timedate {
    static void main(String[] args) throws InterruptedException {
        Scanner sc=new Scanner(System.in);
        //now check the curent instant :
        Instant currentinstant=Instant.now();
        System.out.println("current timestamp is : "+currentinstant);
        //create the code which prints Asia/Kolkata time :
        ZoneId indiazone=ZoneId.of("Asia/Kolkata");//hearwe stores the idea zone :
        System.out.println("india zone information :"+indiazone);
        ZonedDateTime indiatimeinstant = currentinstant.atZone(indiazone);
        System.out.println("timestamp for india: "+indiatimeinstant);
        //create the two instant object and check which one is earliar and which one is latter
        Instant t1=Instant.now();
        int no=0;
        for (int i=1;i<1000000;i++)
        {
            no+=i;
        }
        Instant t2=Instant.now();
        Duration inbetweent1andt2=Duration.between(t1,t2);
        long millisecond=inbetweent1andt2.toMillis();
        long seconds=inbetweent1andt2.getSeconds();
        System.out.println("time difference in millisecond: "+millisecond+", time diference in second: "+seconds);
        if (t1.isAfter(t2))
        {
            System.out.println("t1 is greter than t2 ");
        }
        else
        {
            System.out.println("t2 is greter than t1 ");
        }
        System.out.println("so tme instant in between t1 and t2 is:"+inbetweent1andt2);//duration in millisecond
    //check the token is expired or not :
        Instant tokencreationat=Instant.now();
        Thread.sleep(3*1000);
        Instant now=Instant.now();
        Duration  diference=Duration.between(tokencreationat,now);
        if (diference.toSeconds()>=2)
        {
            System.out.println("given token is expired !");
        }
        else {
            System.out.println("given token is valid !");
        }
        //formate the date and time also here with the help of formate we can create diferent formates of dates and time also:
        DateTimeFormatter Formatter =DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1=LocalDate.now();
        System.out.println("after formating th date :"+date1.format(Formatter));
        //formate the current time
        LocalTime time1=LocalTime.now();
        DateTimeFormatter formatefortime=DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("loacl time after formating: "+time1.format(formatefortime));
        //create the formate which change date and time together :
        LocalDateTime dateandtime=LocalDateTime.now();
        DateTimeFormatter datetimefor=DateTimeFormatter.ofPattern("dd:MM:yyyyy HH:mm:ss");
        System.out.println("after formating the date and time both :"+dateandtime.format(datetimefor));
        //we have the custome date and we wanted to change it like "1 jan 2026":
        LocalDate customedate1=LocalDate.of(2026,1,21);
        DateTimeFormatter customeformate=DateTimeFormatter.ofPattern("dd/MMM/yyyy");
        System.out.println("result ater the custome formate is :"+customedate1.format(customeformate));

     //create the string of date and then perse it after that create the formate like this :"1/jan/2026"
     String strdate="2026-09-15";
     LocalDate strlocaldate=LocalDate.parse(strdate);
        System.out.println("after persing the date date result is : "+strlocaldate.format(customeformate));
    //parse the local date time and convert it into formate :
    LocalDateTime custom=LocalDateTime.parse("2006-03-02T12:15:56");
    DateTimeFormatter formate3=DateTimeFormatter.ofPattern("yyyy/MMM/dd  HH:mm:ss a");
        System.out.println("after making the datetime formater is :"+custom.format(formate3));

        //get the current dateand time of asia /kolkata and fornate it :
        ZonedDateTime datetime=ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        DateTimeFormatter zoneformate=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss z\n");
        System.out.println("now zoned formate is : "+datetime.format(zoneformate));

        //create the curent date and time and formate it:
        LocalDateTime local=LocalDateTime.now();
        DateTimeFormatter formate4=DateTimeFormatter.ofPattern("EEEE, dd MMM yyyy 'at' 06:30 a\n");
        System.out.println("now our current time and date in given formate is : "+local.format(formate4));
    }
}
