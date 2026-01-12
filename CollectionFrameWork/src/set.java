import java.util.*;
import java.util.Collection;
import java.util.Scanner;

public class set {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //syntax to create the set :and set doen allw to store duplicate values also it does'nt have indexing .
//        Set<Integer> set1 = new HashSet<>();
//        set1.add(2);
//        set1.add(3);
//        set1.add(5);
//        set1.add(7);
//        set1.add(7);//it will work it wont able to return sae vale again.
//        //in hashset we cant use the methodes whih required indexing like:get/set/conver.
//        System.out.println("the elements of set is :" + set1);
//        System.out.println("the size of set is :" + set1.size());
//        System.out.println("remove any ele in set :" + set1.remove(3));
//        System.out.println("the elements of set is :" + set1);
//
//        //crate the list of cities and find delhi from it :
//        Set<String> cities = new HashSet<>();
//        for (int i = 1; i <= 5; i++) {
//            System.out.println("enter the " + i + "th city name !");
//            cities.add(sc.nextLine());
//        }
//        if (cities.contains("Dehli")) {
//            System.out.println("the delhi is available to deliver!");
//        } else {
//            System.out.println("the dehli is ot avaiable to deliver ");
//        }
//        //create the empty set and add any valu init and again check it :
//        Set<Integer> positiveno = new TreeSet<>();
//        if (positiveno.size() == 0) {
//            System.out.println("the given set is empty!");
//        }
//        positiveno.add(4);
//
//        if (positiveno.size() == 0) {
//            System.out.println("the given set is empty!");
//        }
//        else
//        {
//            System.out.println("the ele is succesfully added ");
//        }

        //create the set of fruits and rmove the banana from it:
//        Set<String> Fruits=new HashSet<>();
//        for (int i=1;i<=3;i++)
//        {
//            System.out.println("enetr any fruit name!");
//            Fruits.add(sc.next());
//        }
//        Fruits.remove("banana");
//        //print the ele of Fruits using for-each loop:
//        for (String fruit:Fruits)
//        {
//            System.out.println("the ele of Fruits is:"+fruit);
//        }
//        System.out.println("after removing banana from set of fruits we got :"+Fruits);

        //create the list and convert itinto set toremove the duplicate :
        List<Integer> evenno=new ArrayList<>();
        for (int i=0;i<=2;i++)
        {
            System.out.println("enter any even number!");
            evenno.add(sc.nextInt());
        }
        //convert it into set:
        Set<Integer> evennumber=new HashSet<>();
        evennumber.addAll(evenno);
        System.out.println("the list of set is:"+evennumber);
        System.out.println("the size of set is:"+evennumber.size());

        //create one more set and chek it isit equal or not:
        Set<Integer> oddno=new HashSet<>();
        oddno.add(3);
        oddno.add(5);
        oddno.add(7);
        if (evennumber.equals(oddno))
        {
            System.out.println("the given two sets are equal!");
        }
        else
        {
            System.out.println("the given two sets are not equal!");
        }

        //make the union of two set :
        //evennumber.addAll(oddno);
        System.out.println("after union f two sets !"+evennumber);

        //find the intersection of two set :
        Set<Integer> result=new HashSet<>();
        evennumber.forEach(ele->{
            if (oddno.contains(ele))
            {
                result.add(ele);
            }
        });
        System.out.println("the intersection of two sets is:"+result);
    }
}
