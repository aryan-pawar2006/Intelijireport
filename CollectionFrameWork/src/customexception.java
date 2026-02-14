import java.util.Scanner;
import java.util.*;
public class customexception {
    //create the custom exception to handle the state:
    static class OrderalreadypaidException extends RuntimeException{
        OrderalreadypaidException(String message)
        {
            super(message);
        }
    }
    static class OrderalreadycancledException extends RuntimeException{
        OrderalreadycancledException(String message)
        {
            super(message);
        }
    }
    //create the class to check the status:
    static class ordercheck{
        int orderId;
        String orderstatus;

        ordercheck(int id,String status)
        {
            this.orderId=id;
            this.orderstatus=status;
        }

        void checkstatus()
        {
            if (orderstatus.equals("Paid"))
            {
                throw new OrderalreadypaidException("order s already paid!");
            } else if (orderstatus.equals("Cancled")) {
                throw new OrderalreadycancledException("order is already cancled!");
            }
            else
            {
                System.out.println("order will success fully place!");
            }
        }
    }
    //create the method to login and handle the exception:
    static class InvalidUserException extends RuntimeException{
        InvalidUserException(String message)
        {
            super(message);
        }
    }
    //for the password incorrect:
    static class IncorrectPasswordException extends RuntimeException{
        IncorrectPasswordException(String message)
        {
            super(message);
        }
    }
    static void login(String username,String password)
    {
        if (username.equals(" ") || username==null || username.isEmpty())
        {
            throw new InvalidUserException("the given username is invalid!");
        }
        else if (password==null || password.isEmpty() ||password.equals(" "))
        {
            throw new IncorrectPasswordException("the given password is incorrect!");
        }
        else
        {
            System.out.println("user loged In succesfully!");
        }
    }
    //create the product class and and check the purchess is possible or not:
    static class ProductPurchessException extends RuntimeException{
        ProductPurchessException(String message)
        {
            super(message);
        }
    }
    static class Product{
        String productname;
        long balance;

        Product(String name,long balance)
        {
            this.productname=name;
            this.balance=balance;
        }

        void purches(long purchessamount)
        {
            if (balance<purchessamount)
            {
                throw new ProductPurchessException("product is out of stock!");
            }
            else if (purchessamount<0)
            {
                throw  new ProductPurchessException("purchess amount is less than 0!");
            }
            else
            {
                System.out.println("after the purchess balance is: "+(balance-=purchessamount));
            }
        }
    }

    //create the invalidamount exception and correct the code:
    static class InvalidamountException extends RuntimeException{
        InvalidamountException(String message)
        {
            super(message);
        }
    }
    static void Processpayment(double amount)
    {
        if (amount<=0)
        {
            throw new InvalidamountException("amount iss invalid!");
        }
        else
        {
            System.out.println("given payment get processed!");
        }
    }
    static void main(String[] args) {
//        try{
//            ordercheck customer1=new ordercheck(123,"prosesing");
//            ordercheck customer2=new ordercheck(123,"Cancled");
//            customer2.checkstatus();
//        }
//        catch (OrderalreadypaidException e)
//        {
//            System.out.println("error is : "+e.getMessage());
//        }
//
//    //handle the use name and password
//        try {
//            login("aryanpawar ", " ");
//        }
//        catch (InvalidUserException e)
//        {
//            System.out.println("error is: "+e.getMessage());
//        }
//        catch (IncorrectPasswordException e)
//        {
//            System.out.println("error is: "+e.getMessage());
//        }

    //check the purches is possible or not:
    Product p1=new Product("applewatch",50000);
        try
        {
            p1.purches(-20000);
        }
        catch (ProductPurchessException e)
        {
            System.out.println("error is: "+e.getMessage());
        }

        //for the proccess payment:
        try
        {
            Processpayment(-20000);
        }
        catch (InvalidamountException e)
        {
            System.out.println("error is: "+e.getMessage());
        }
    }
}
