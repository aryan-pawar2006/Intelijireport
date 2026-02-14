//optional class is help to avoid null pointor exception
import  java.util.*;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Gatherer;
import java.util.stream.Stream;

public class Optiona {
     static class user{
        String name;
        int ID;

        user(String name1,int id)
        {
            name=name1;
            ID=id;
        }
    };
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

    //create the persons name list and find out the perticular person return it without the null pointer exception:
    List<String> persons=new ArrayList<>();
        for (int i=1;i<=3;i++)
        {
            System.out.println("enter the "+i+"th name of person!");
            persons.add(sc.next());
        }
        System.out.println("enter the any name that you wanted to find !");
        String name2=sc.next();
        Optional<String> resultname=persons.stream()
                .filter(name->name.equals(name2)).findFirst();

       // if (resultname.isPresent())
        //{
            //System.out.println("entered name is found in list!"+resultname.orElse("entered name is not found in list!"));
       // }
        //basically when we use orelse it execute the default value bydefault even if optional contains the value :
        //but in case of orelseget it execute the default value when the ioptional is emty only .
        System.out.println("user is found!"+resultname.orElseGet(()->"value does'nt exist"));

        //create the list of user class and then find out the perticular user by their id and if it's notpresent in list then handle it:
        List<user> userinfo=List.of(
                new user("aryan",43),
                new user("darshan",56),
                new user("komal",67),
                new user("karan",88)
        );
        System.out.println("enter the user id!");
        int id1=sc.nextInt();
        Optional<user> resultuser=userinfo.stream()
                .filter(n->n.ID==id1?true:false)
                .findFirst();
        if (resultuser.isPresent())
        {
            System.out.println("user is present in list!");
        }



    }
}
