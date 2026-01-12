import java.util.*;
import java.util.Scanner;
public class collectionMap {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // create the map of student with his roll no
//        Map<Integer,String> studentinfo=new HashMap<>();
//        for (int i=0;i<=2;i++)
//        {
//            System.out.println("enetr the RollNo and Name of "+i+"th student ");
//            studentinfo.put(sc.nextInt(),sc.nextLine());
//        }
//        System.out.println("the stufdent infomatio with their roll no is:"+studentinfo);

        //create the map for employes with Id and salary:
//        Map<Integer,Integer> employes=new HashMap<>();
//        employes.put(1324,10000);
//        employes.put(1544,20000);
//        employes.put(1354,40000);
//        employes.put(13754,70000);
//        System.out.println("the ID's of employes"+employes.keySet());
//        System.out.println("the employes information are:"+employes);
//        //check if any pertecular key is present in map or not :
//        if (employes.containsKey(43526))
//        {
//            System.out.println("the key is present in map :");
//        }
//        else
//        {
//            System.out.println("the key is not present in map :");
//        }
//        //remove the key value pair from the map :
//        employes.remove(1324,10000);
//        System.out.println("after removeing the one key value pair in map :"+employes);
//        //print the all the values saperatly:
//        for (int n:employes.keySet())
//        {
//            System.out.println("the values in map are:"+employes.get(n));
//        }
//        //find the frequency of ele of list using the map :
//        List<String> fruits=new ArrayList<>();
//        for (int i=1;i<6;i++)
//        {
//            System.out.println("enter the fruit name ");
//            fruits.add(sc.nextLine());
//        }
//        Map<String,Integer> frequency=new HashMap<>();
//        List<String> keyset=new ArrayList<>();
//        int n=1;
//        for (String fruit:fruits)
//        {
//
//            if (keyset.contains(fruit))
//            {
//               keyset.add(fruit);
//               frequency.put(fruit,n+1);
//            }
//            else
//            {
//                keyset.add(fruit);
//                frequency.put(fruit,n);
//            }
//        }
//        System.out.println("frequency of the ele in lis:"+frequency);

        //find the student who got heighest marks in exam :
//        Map<String,Integer> studentmark=new HashMap<>();
//        for (int i=0;i<=3;i++)
//        {
//            System.out.println("enter the student name and his marks :");
//            System.out.println("enter the student name :");
//            String name=sc.next();
//            System.out.println("enter te marks of studen:");
//            int marks=sc.nextInt();
//            studentmark.put(name,marks);
//        }
//        int heighest=0;
//        List<String> student=new ArrayList<>();
//        student.addAll(studentmark.keySet());
//        String heighmarkstudent=null;
//        for (String name:studentmark.keySet())
//        {
//            if (studentmark.get(name)>heighest)
//            {
//                heighest=studentmark.get(name);
//                heighmarkstudent=name;
//            }
//        }
//        System.out.println("the heighest marks of student "+heighmarkstudent+" is "+heighest);

        //conver the two diferent lists into map:
        List<Integer> numbers=new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        List<String> values=new ArrayList<>();
        values.add("aryan");
        values.add("pranav");
        values.add("rohan");
        Map<Integer,String> result=new HashMap<>();
        for (int i=0;i<numbers.size();i++)
        {
            result.put(numbers.get(i), values.get(i));
        }
        System.out.println("the combine map of lists is:"+result);
        //check the key is prsent in map or not and update it :
        for (int n:result.keySet())
        {
            if (n==2)
            {
                result.put(n,"swaraj");
            }
        }
        System.out.println("after updating the map key value:"+result);

        //iterate the map using the etryset:
        for (Map.Entry<Integer,String> ele:result.entrySet())
        {
            System.out.println("ele :"+ele);
        }

        List<Integer> no = new ArrayList<>();
        no.add(3);
        no.add(4);
        no.add(5);
        no.add(3);
        no.add(4);

        Map<Integer, Integer> map1 = new HashMap<>();

// Step 1: frequency count
        for (int n : no) {
            map1.put(n, map1.getOrDefault(n, 0) + 1);
        }

// Step 2: find first non-repeating
        for (int n : no) {
            if (map1.get(n) == 1) {
                System.out.println("First non-repeating element is: " + n);
                break;
            }
        }

    }
}
