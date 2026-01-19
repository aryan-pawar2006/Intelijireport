//optional class is help to avoid null pointor exception
import  java.util.*;
import java.util.Scanner;
import java.util.stream.Gatherer;
import java.util.stream.Stream;

public class Optiona {
    static void main() {
        Scanner sc=new Scanner(System.in);
        List<String> names=new ArrayList<>();
        for (int i=1;i<=3;i++)
        {
            System.out.println("enter the "+i+"th name of list!");
            names.add(sc.next());
        }
        Optional<String> name1=names.stream()
                .filter(n-> n.startsWith("a"))
                .findFirst();

        System.out.println("the first aryan is "+name1.orElse("name started with a does not found !"));

        //create the list of integer value and find out any even no is present init or not if its not present throw exception!
        List<Integer> numbers=new ArrayList<>();
        for (int i=1;i<=3;i++)
        {
            System.out.println("enter the "+i+"th number of list!");
            numbers.add(sc.nextInt());
        }
        Optional<Integer> result=numbers.stream()
                .filter(n-> n%2==0)
                .findFirst();

        System.out.println("even value present in list or not :"+result.orElseThrow(()->new RuntimeException()));
    }
}
