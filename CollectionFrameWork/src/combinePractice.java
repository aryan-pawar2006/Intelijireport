import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

public class combinePractice {
    //create the user and try to handle the null email of user :
    static  class user{
        String email;

        user(String email)
        {
            this.email=email;
        }
    }
    //create the class of employ :
    static class employ {
        String name;
        String department;

        employ(String name, String department) {
            this.name = name;
            this.department = department;
        }
    }

    //create the custom exception
    static class ageivalidException extends RuntimeException {
        ageivalidException(String message) {
            super(message);
        }
    }

    //create the class of banckaccount:
    static class bankaccount {
        Scanner sc = new Scanner(System.in);
        long accountno;
        private double balance;

        bankaccount(long no, double balance) {
            this.accountno = no;
            this.balance = balance;
        }

        //provide te deposit and widraw methods:
        void deposit() {
            System.out.println("enter the amont that you wanted to deposit :");
            balance += sc.nextInt();
        }

        void widraw() {
            System.out.println("enter the amont that you wanted to widraw :");
            balance -= sc.nextInt();
        }

        void display() {
            System.out.println("the information of acout is :" + accountno + ", an balance is: " + balance);
        }
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        bankaccount user1 = new bankaccount(132425, 65555.0);
        user1.deposit();
        user1.widraw();
        user1.display();

        //now we have problem about java 8 features :
        List<Integer> integer = List.of(2, 1, 4, 3, 5, 4, 7, 8);
        List<Integer> resultlist = integer.stream()
                .distinct()//its used to remove diplicate
                .filter(n -> n % 2 == 0)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("the result after applying all the features on list is : " + resultlist);

        //now problem on excepton :
        int age;
        System.out.println("enter the age of user : ");
        age = sc.nextInt();
        try {
            if (age > 18) {
                System.out.println("the given age of user is valid !");
            } else {
                throw new ageivalidException("the age is not valid ");
            }
        } catch (ageivalidException e) {
            System.out.println("the age is not valid!" + e.getMessage());
        }

        List<employ> employlist = List.of(
                new employ("aryan", "CSE"),
                new employ("darshan", "CSE"),
                new employ("atharv", "AIDS"),
                new employ("pravin", "ENTC")
        );
        Map<String,Long> resultmap = employlist.stream()
                .collect(Collectors.groupingBy(
                        n -> n.department,
                        Collectors.counting()
                ));

        System.out.println("after the grouping the result is : "+resultmap);

        //create the object of email
        user user3=new user("aryanpawar03022006@gmail.com");
        user user4=new user(null);

        String Email=
                Optional.ofNullable(user3.email)
                        .orElse("Null");

        String Email1=
                Optional.ofNullable(user4.email)
                        .orElse("Null");
        System.out.println("first user email: "+Email);
        System.out.println("second user email: "+Email1);

    }
}
