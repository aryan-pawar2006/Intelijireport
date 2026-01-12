import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.Scanner;
public class setcollection {
    static void main() {
        Scanner sc=new Scanner(System.in);
//        //create the two sets and find the ele that is present in set1 but not in set2:
//        Set<Integer> set1=new HashSet<>();
//        Set<Integer> set2=new HashSet<>();
//        for (int i=1;i<=5;i++)
//        {
//            System.out.println("enter the"+i+"th ele of set1");
//            set1.add(sc.nextInt());
//        }
//        for (int i=1;i<=5;i++)
//        {
//            System.out.println("enter the"+i+"th ele of set2");
//            set2.add(sc.nextInt());
//        }
//        //create the new set
//        int original=0;
//        Set<Integer> result=new HashSet<>();
//        for (int n:set1)
//        {
//            //for checking the first reapeting ele :
//            if (n==original)
//            {
//                System.out.println("the first reapeted ele is:"+original);
//            }
//            else
//            {
//                original=n;
//            }
//            if (!set2.contains(n))
//            {
//                result.add(n);
//            }
//        }
//        System.out.println("the ele that present in set1 but nt in set2 :"+result);

        //find the first repeating ele using the set
//        List<Integer> list1=new ArrayList<>();
//        for (int i=0;i<=4;i++)
//        {
//            System.out.println("enetr the "+i+"th ele of list");
//            list1.add(sc.nextInt());
//        }
//        Set<Integer> set3=new HashSet<>();
//        boolean isdouble=true;
//        for (int n:list1)
//        {
//          if (!set3.add(n))
//          {
//              System.out.println("the first repeat element of list is:"+n);
//              isdouble=true;
//              break;
//          }
//          if (!isdouble)
//          {
//              System.out.println("their is no any double ele in list !");
//          }
//        }

        //make the student list and store the information of students :
        List<String> student=new ArrayList<>();
        for (int i=1;i<=2;i++)
        {
            System.out.println("the Information of "+i+"th student!");
            student.add("StudentName:"+sc.nextLine() +  " RollNo:"+sc.nextLine() + " Class:"+sc.nextLine());
        }
        for (String n:student)
        {
            System.out.println("the information f first student :"+n);
        }
    }
}
