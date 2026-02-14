import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.*;

public class java8problems {
    //now create the class of student and give some info to it and trying to apply all the concept of java8 onit:
    static class student{
        int roll;
        String name;
        String email;
        LocalDateTime loginAt;

        student(int roll,String name,String email,LocalDateTime loginedAt)
        {
            this.roll=roll;
            this.name=name;
            this.email=email;
            this.loginAt=loginedAt;

        }

    }

    //create the user class and do following operations which will help you to practice java8 feature:
    static class User {
        int ID;
        String Name;
        String Email;
        LocalDateTime createdAt;

        User(int id, String name, String email, LocalDateTime createdAt) {
            this.ID = id;
            this.Name = name;
            this.Email = email;
            this.createdAt = createdAt;
        }
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<User> userlist = new ArrayList<>();
        User user1 = new User(1, "aryan", "aryan02@gmail.com", LocalDateTime.now());
        User user2 = new User(2, "darshan", null, LocalDateTime.now().minusDays(3));
        User user3 = new User(3, "atharv", "atharv02@gmail.com", LocalDateTime.now());
        User user4 = new User(4, "mahesh", "mahesh02@gmail.com", LocalDateTime.now());

        userlist.add(user1);
        userlist.add(user2);
        userlist.add(user3);
        userlist.add(user4);

        //create tthe format for dateandtime:
        DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss a");
        //now we have to handle the null email to avoid the null pointer exception :
        userlist.stream()
                .filter(user ->user.createdAt.isAfter(LocalDateTime.now().minusDays(2)))
                .forEach(user->{
                    String Email=Optional.ofNullable(user.Email)
                            .orElse("Null");

                    String date=user.createdAt.format(format);
                    System.out.println("name of user is: "+user.Name+", Email: "+Email+",Date: "+date);

                });
        //now create the list of students :
        List<student> students=List.of(
                new student(43,"aryan","aryan2006@gmail.com",LocalDateTime.now().minusDays(1)),
                new student(34,"sanchita","sanchita2006@gmail.com",LocalDateTime.now()),
                new student(31,"darshan","darshan2006@gmail.com",LocalDateTime.now().minusDays(2)),
                new student(76,"mohit","mohit2006@gmail.com",LocalDateTime.now().minusDays(3))
                );
        students.stream()
                .filter(student->student.roll>0&&student.loginAt.isAfter(LocalDateTime.now().minusDays(2)))
                .forEach(student -> {
                    String Email=Optional.ofNullable(student.email)
                            .orElse("Null");
                    DateTimeFormatter format2=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss a");
                    String date=student.loginAt.format(format2);

                    System.out.println("name of student is: "+student.name+", email: "+Email+", logineddate: "+date+", roll: "+student.roll);
                });

    }
}
