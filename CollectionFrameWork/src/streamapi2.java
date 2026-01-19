import java.util.*;
import  java.util.Scanner;

public class streamapi2 {
    static void main() {
        Scanner sc=new Scanner(System.in);
//        //create the list and access only even numbers:
//        List<Integer> numbers=new ArrayList<>();
//        for (int i=1;i<=4;i++)
//        {
//            System.out.println("enter the "+i+"th number");
//            numbers.add(sc.nextInt());
//        }
//        numbers.stream()
//                .filter(n-> n%2==0)
//                .map(n-> n*10)
//                .forEach(System.out::println);
//
//        //create the list of string and convert each ele of string into uppercase:
//        List<String> names=new ArrayList<>();
//        for (int i=1;i<=4;i++)
//        {
//            System.out.println("enter the "+i+"th name of list !");
//            names.add(sc.next());
//        }
//        names.stream()
//                .map(n-> n.toUpperCase())
//                .map(n-> n.trim())
//                .forEach(System.out::println);
//
//        //create the list and find out count of the numbers greter than 10:
//        List<Integer> numbers2=new ArrayList<>();
//        for (int i=1;i<=4;i++)
//        {
//            System.out.println("enter the "+i+"th number");
//            numbers2.add(sc.nextInt());
//        }
//        long countt=numbers2.stream()
//                .filter(n-> n>10)
//                .count();
//
//        System.out.println("the count of ele of list which is greater than 10 is"+countt);
        //create the list and check all or any numabers are possitive or not :
        List<Integer> numbers3=new ArrayList<>();
        for (int i=1;i<=4;i++)
        {
            System.out.println("enter the "+i+"th number");
            numbers3.add(sc.nextInt());
        }
        System.out.println(numbers3.stream().allMatch(n-> n>0));

        //create the list of string and findout the ele which start with a char:
        List<String> colleges=new ArrayList<>();
        for (int i=1;i<=4;i++) {
            System.out.println("enter the " + i + "th college name !");
            colleges.add(sc.next());
        }
        Optional<String> firstname=colleges.stream()
                .filter(w->w.toLowerCase().startsWith("a"))
                .findFirst();

        if (firstname.isPresent()) {
            System.out.println("first colege name start with a:" + firstname.get());
        }
        else
        {
            System.out.println("that type of sollege is not present in list :");
        }

    }
}
