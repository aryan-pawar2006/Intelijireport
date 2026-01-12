import com.sun.jdi.ArrayReference;

import javax.sql.rowset.spi.SyncResolver;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Collection {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> marks = new ArrayList<>();
        List<Integer> number = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            number.add(i);
        }
        for (int j = 0; j < 5; j++) {
            System.out.println("enter the " + j + "th student marks");
            marks.add(j, sc.nextInt());
        }
        //print the each ele of marks list with its index :
        System.out.println("printing the marks of students");
        for (int j = 0; j < 5; j++) {
            System.out.println(j+":"+marks.get(j));
        }
        //create the copy of markslist:
        List<Integer> markscopy=new ArrayList<>();
        markscopy.addAll(marks);
        //create the second copy of marks using the for loop:
        List<Integer> copy2=new ArrayList<>();
        for (int i=0;i<5;i++)
        {
            copy2.add(i,marks.get(i));
        }
        //convert list into array:
        Integer[] array1=marks.toArray(new Integer[0]);
        System.out.println("the arry is:"+ Arrays.toString(array1));
        System.out.println("ele of second copy of of marks list are:"+copy2);
        System.out.println("the list of markscopy is:"+markscopy);
        System.out.println("the size of the marks list is " + marks.size());
        System.out.println("the ele of list is:" + number);
        //now thirdd ele of list is:
        System.out.println("thrd ele of list is :" + number.indexOf(2));
        number.remove(2);//delet any ele in list at index 2:
        System.out.println("check 10 is present in list:" + number.contains(10));
        System.out.println("after deleting element list of arraylist:" + number);
        if (marks.size() == 0) {
            System.out.println("the given list of marks is empty it does not contain any value ");
        }
        //check the given list of marks is sorted or not :
        for (int k=0;k<5;k++)
        {
            if (marks.get(k)>marks.get(k+1))
            {
                System.out.println("given list of marks is not soarted !");
            }
        }
    }
}