
//collector is features or method that help you to convert the result of stream into the collection formate again :
import  java.util.*;
import  java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Gatherer;

public class collector {
    class isprime{

    }
    static void main() {
        Scanner sc=new Scanner(System.in);
        List<Integer> marks=new ArrayList<>();
        for (int i=1;i<=3;i++)
        {
            System.out.println("enter the "+i+"th marks of student!");
            marks.add(sc.nextInt());
        }
        List<Integer> marksresult=marks.stream()
                .filter(n-> n%2==0)
                .filter(m-> m>4)
                .collect(Collectors.toList());

        System.out.println("after the collect the result of list in list again of stream !"+marksresult);

        //create the list of roll no and find out the roll no which is odd and return only unique ones fom it :
        List<Integer> marks2=new ArrayList<>();
        for (int i=1;i<=6;i++)
        {
            System.out.println("enter the "+i+"th marks of student!");
            marks2.add(sc.nextInt());
        }
        System.out.println("now unique odd marks of studets are :"+marks2.stream().filter(n-> n%2==1).collect(Collectors.toSet()));
    //create the list of student names and stream it and return the result with its leangh of name :
        List<String> students=new ArrayList<>();
        for (int i=1;i<=3;i++)
        {
            System.out.println("enter the "+i+"th name of student!");
            students.add(sc.next());
        }
        Map<Character,List<String>> mapresult=students.stream()
                .collect(Collectors.groupingBy(
                        name-> name.charAt(0)
                ));

        System.out.println("marks of students with thier marks is :"+mapresult);

        //create the list and count how many no are above the 10:
        List<Integer> numbers3=new ArrayList<>();
        numbers3.add(3);
        numbers3.add(4);
        numbers3.add(5);
        numbers3.add(7);
        long count=numbers3.stream()
                .filter(n-> n>2)
                .collect(Collectors.counting());

        System.out.println("cunt of the ele of stream!"+count);


    }
}
