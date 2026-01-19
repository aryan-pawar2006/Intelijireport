import java.util.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class streamAPI {
    static void main() {
        Scanner sc= new Scanner(System.in);
       List<Integer> numbers=new ArrayList<>();
        for (int i=1;i<=5;i++)
       {
            System.out.println("enter the "+i+"th ele of list!");
            numbers.add(sc.nextInt());
        }
        System.out.println("filtered odd ele of list is :");
//        numbers.stream()
//                .filter(n-> n%2==1)
//                .forEach(n-> System.out.print(n+"\t"));

        //create the list with the string value and convert itinto the uppercase :
        List<String> names=new ArrayList<>();
        names.add("aryan");
        names.add("athrave");
        names.add("vedant");
        names.add("darshan");

        Stream<String> namesnew=names.stream()
                .map(String::toUpperCase);

        namesnew.forEach(System.out::println);

        //from the list of user remove the guest ant print the result :
        List<String> validation=new ArrayList<>();
        validation.add("admin");
        validation.add("profesor");
        validation.add("clark");
        validation.add("guest");

        validation.stream()
                .filter(n->!n.equals("guest"))
                .forEach(System.out::println);

        //we have numbers list so count how many n is less than 4 and print it :sout
        System.out.println("now no that is lesser than 4 are:");
        numbers.stream()
                .filter(n-> n<4)
                .forEach(System.out::println);
    }
}
