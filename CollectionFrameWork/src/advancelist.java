import java.util.*;
import java.util.Scanner;
public class advancelist {
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //craete the list of numbers and find even no fromit :
        List<Integer> numbers=new ArrayList<>();
        for (int i=1;i<=4;i++)
        {
            System.out.println("enetr the "+i+"th element of list!");
            numbers.add(sc.nextInt());
        }
        Iterator<Integer> it=numbers.iterator();
        while(it.hasNext())
        {
            int current= it.next();
            if (current %2==0)
                System.out.println(current);
        }

        //create the list of strings and remove te string which has less than 4 characters:
        List<String> names=new ArrayList<>();
        for (int i=1;i<=4;i++)
        {
            System.out.println("enetr the "+i+"th name of list!");
            names.add(sc.nextLine());
        }
        Iterator<String> name=names.iterator();
        int count=0;
        while(name.hasNext()) {
            String name2=name.next();
            if (name2.length()<=4)
            {
                name.remove();
            }
        }
        System.out.println("the list of names after removing the smaller name :"+names);

        //create the list nd find the frequrncy of ele in list :
        List<String> fruits=new ArrayList<>();
        Map<String,Integer> resultfruit=new HashMap<>();
        for (int i=1;i<=3;i++)
        {
            System.out.println("enter the "+i+"th  fruit name :");
            fruits.add(sc.nextLine());
        }
        Iterator<String> fru=fruits.iterator();
        while(fru.hasNext())
        {
            String fruitname=fru.next();
            if (resultfruit.containsKey(fruitname))
            {
                resultfruit.put(fruitname,resultfruit.get(fruitname)+1);
            }
            else
            {
                resultfruit.put(fruitname,1);
            }
        }
               System.out.println("list of ele with their fruits is :"+resultfruit);

        //create the list and then trim extra space and remove duplicates and then print each valu in uppercase :
        List<String> name2=new ArrayList<>();
        name2.add("aryan");
        name2.add("aryan");
        name2.add("athrve");
        name2.add("pranav");
        Iterator<String> name2it=name2.iterator();
        List<String> name2new=new ArrayList<>();
        while (name2it.hasNext())
        {
            String value=name2it.next().trim().toUpperCase();
            if (!name2new.contains(value))
            {
                name2new.add(value);
            }
        }
        System.out.println("the list after allresult :"+name2new);
    }
}
