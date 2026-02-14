import java.io.IOException;
import java.util.Scanner;
import java.util.*;
public class checkedandunchecked {
    static void checkemail(String email) throws Exception
    {
        if (email.isEmpty()||email.equals(""))
        {
            throw new Exception("given email is not valid!");
        }
        else
        {
            System.out.println("given email is valid !");
        }
    }
    static void main() {
        Scanner sc=new Scanner(System.in);
        try
        {
            checkemail("");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        int a;
        int b;
        System.out.println("enter any two numbers !");
        a=sc.nextInt();
        b=sc.nextInt();
        //int result4=a/b;if we write this only it will do not produce any error :it will rrun properly :
        //System.out.println("the result is : "+result4);
        try
        {
            int result4=a/b;
        }
        catch (RuntimeException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
