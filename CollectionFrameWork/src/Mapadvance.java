import javax.swing.plaf.synth.SynthSeparatorUI;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;
import java.util.Scanner;
import java.util.stream.Gatherer;

public class Mapadvance {
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        //create the map ant store the student name with its marks :
//        Map<String,Integer> studentinfo=new HashMap<>();
//        for (int i=1;i<=3;i++)
//        {
//            System.out.println("enter the name of"+i+"th student and with their marks:");
//            studentinfo.put(sc.next(),sc.nextInt());
//        }
//        System.out.println("the student information with the their marks:"+studentinfo);

//        //make the user login systeme using the map:
//        Map<String,String> Loginsysystem=new HashMap<>();
//        for (int i=1;i<=1;i++)
//        {
//            System.out.println("enter the"+i+"th username along with their password:");
//            Loginsysystem.put(sc.next(),sc.next());
//        }
//        for (Map.Entry<String,String> e:Loginsysystem.entrySet())
//        {
//            if (e.getKey().equals("admin") && e.getValue().equals("admin@2006"))
//            {
//                System.out.println("user login succesfully!");
//            }
//            else
//            {
//                System.out.println("username or password are invalid !");
//            }
//        }
//
//        //with thw help of map find out the frequency of ele in list:
//        List<String> cities=new ArrayList<>();
//        Map<String,Integer> frequency=new HashMap<>();
//        for (int i=1;i<=3;i++)
//        {
//            System.out.println("enetr the "+i+"th city name!");
//            cities.add(sc.next());
//        }
//        Iterator<String> it=cities.iterator();
//        while(it.hasNext())
//        {
//            String cityname=it.next();
//            if (frequency.containsKey(cityname))
//            {
//                frequency.put(cityname,frequency.get(cityname)+1);
//            }
//            else
//            {
//                frequency.put(cityname,1);
//            }
//        }
//        System.out.println("the city names with their frequencies is :"+frequency);

//        //create the map to soart the user ids:
//        List<Integer> userids=new ArrayList<>();
//        for (int i=1;i<=4;i++)
//        {
//            System.out.println("enter the "+i+"th id");
//            userids.add(sc.nextInt());
//        }
//        Map<Integer,Integer> soarted=new TreeMap<>();
//        Iterator<Integer> it1=userids.iterator();
//        while(it1.hasNext())
//        {
//            Integer no=it1.next();
//        soarted.put(no,userids.indexOf(no));
//        }
//        System.out.println("soarted ids with the help of treemap!"+soarted);
//
//        //store the name with phone numbers and ask the user name and prin phone number:
//       Map<String,Double> Info=new HashMap<>();
//       for (int i=1;i<=3;i++)
//       {
//           //System.out.println("enter the "+i+"th person information!");
//           System.out.println("enter the name of man:");
//           String name=sc.nextLine();
//           System.out.println("enter the phone no of corresponding man!");
//           Double phone=sc.nextDouble();
//           sc.nextLine();
//           Info.put(name,phone);
//       }
//       Iterator<String> it=Info.keySet().iterator();
//        System.out.println("enter the name of man whos phone no you want!");
//        String name1=sc.nextLine();
//        boolean found=false;
//       while(it.hasNext())
//       {
//           String value=it.next();
//           if (value.equals(name1))
//           {
//               System.out.println("phone no is:"+Info.get(name1).intValue());
//               found=true;
//               break;
//
//           }
//       }
//       if (!found)
//       {
//           System.out.println("the name is not found !");
//       }
//
//       //hear we have the string and count the frequency of each character :
//        System.out.println("enter any Sring that you want!");
//       String string=sc.next();
//       Map<Character,Integer> frequencyofchar=new HashMap<>();
//       for (char ch:string.toCharArray())
//       {
//           if (frequencyofchar.keySet().contains(ch))
//           {
//               frequencyofchar.put(ch,frequencyofchar.get(ch)+1);
//           }
//           else
//           {
//               frequencyofchar.put(ch,1);
//           }
//       }
//        System.out.println("map of frequency of character in string !"+frequencyofchar);

       //suppose we have list of int no and we want to print only duplicates int and its frequency:
        List<Integer> numbers=new ArrayList<>();
        Map<Integer,Integer> freu=new HashMap<>();
        for (int i=1;i<=6;i++)
        {
            System.out.println("enter the "+i+"th number!");
            numbers.add(sc.nextInt());
        }
        for (int no:numbers)
        {
            if (freu.containsKey(no))
            {
                freu.put(no,freu.get(no)+1);
            }
            else
            {
                freu.put(no,1);
            }
        }
        Iterator<Integer> itfre=freu.keySet().iterator();
        while(itfre.hasNext())
        {
            int value= itfre.next();
            if (freu.get(value)<=1)
            {
                itfre.remove();
            }
        }
        System.out.println("the map with the duplicate values only is:"+freu);
    }
}
