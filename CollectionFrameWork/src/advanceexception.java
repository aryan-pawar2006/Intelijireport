import java.io.IOException;
import java.util.Scanner;
import java.util.*;
public class advanceexception {
    static Scanner sc1=new Scanner(System.in);
    //create the custom exception for checking the balance :
    static class insufficientException extends RuntimeException{
        insufficientException(String message)
        {
            super(message);
        }
    }
    //create the acount class and check the balance :
    static class account{
        String name;
        long balance;

        account(String name,long balance)
        {
            this.name=name;
            this.balance=balance;
        }

        void widraw()
        {
            System.out.println("enter the amount that you wanted to widrw :");
            long widraw1=sc1.nextInt();
            if (widraw1>=balance)
            {
                throw new insufficientException("balance is insufficient !");
            }
            else
            {
                balance-=widraw1;
                System.out.println("after widraw balance is : "+balance);
            }
        }


    }
    static class arthematic{
        int devide(int a,int b){
           return a/b;
        }
    }
    static class validateemail{
        String email;
        validateemail(String email)
        {
            this.email=email;
        }
        void email(String email)
        {
            System.out.println("the user is valid he/she has email !");
        }
    }

    //create the method to read the file:
    static void readfile(String filename) throws IOException
    {
        if (filename==""||filename.isEmpty())
        {
            throw new IOException("the file is empty!");
        }
        else
        {
            System.out.println("the file is valid!");
        }

    }
    static void main() {
        Scanner sc=new Scanner(System.in);
        arthematic problem1=new arthematic();
        try
        {
            int value=problem1.devide(3,0);
            System.out.println("the operation works properly :"+value);
        }
        catch (ArithmeticException e)
        {
            System.out.println("the operation is not possible : "+e);
        }
        finally {
            System.out.println("operation is completed!");
        }
        //create the object of email class:
        validateemail user1=new validateemail(null);
        try
        {
            user1.email(null);
        }
        catch (NullPointerException e)
        {
            System.out.println("email is null:"+e);
        }

        //create the object of account class and check the balance is valid or not:
        account account1=new account("aryan",122222);
        account1.widraw();
        try
        {
            readfile("");
        } catch (IOException e) {
            System.out.println("error is accured : "+e.getMessage());
        }
        System.out.println("enter the two different numbers :");
        int no1= sc.nextInt();
        int no2= sc.nextInt();
        try
        {
            System.out.println("the result of division is : "+no1/no2);

            int number=Integer.parseInt("aryan");
            System.out.println("after coverting string into int :"+number);
        }
        catch (ArithmeticException e)
        {
            System.out.println("the exception is:"+e);
        }
        catch (NumberFormatException e)
        {
            System.out.println("its the number format exceptio!");
        }
        catch (RuntimeException e) {
            System.out.println("ita runtime exception" + e);
        }
        System.out.println("here we are try to catching multiple exception!");
    //write the try and catch block and handle it by multiple try and catch :
    try {
        int result=2/0;//after first exception hits remaining code inside the try block wil not get executed :
        int name=Integer.parseInt("aryan");
    }
    catch (ArithmeticException e)
    {
        System.out.println("catching the  arithmatic exception is occured!"+e.getMessage());
    }
    catch (NumberFormatException e)
    {
        System.out.println("catching the numberformat exception! "+e.getMessage());
    }

    //now write the nested try and catch block in which we are doing the following things:
        try
        {
            System.out.println("we are entering into inner try and catch block:");
            try
            {
                int result2=2/0;
            }
            catch (ArithmeticException e)
            {
                System.out.println("inner exception get occur: "+e.getMessage());
            }
        }
        catch (Exception e)
        {
            System.out.println("this is generic exception!");
        }
    }
}
