import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogginBasic {
    private static final Logger logger=Logger.getLogger(LogginBasic.class.getName());
    //make the method for user validation:
    static void uservalidation(String username,int password)
    {
        logger.info("login attempt get started !");
        if (password!=1234)
        {
            logger.warning("given password is incorrect!");
        }
        if (username.equals("aryanpawar") && password==1234)
        {
            logger.info("login done succesfully!");
        }
    }
    static void main(String[] args)  {
        Scanner sc=new Scanner(System.in);
        //create the log that tells about error,info,seveire:
       //for the warning :
        logger.warning("this input can be harmfull!");

        //for the information:
        logger.info("your application get started succesfuly!");

        //now we can use the sevier for exception case :
        try{
            int result=3/0;
        }
        catch (ArithmeticException e)
        {
         logger.severe(e.getMessage());
        }
    //create the diferent logs and add it into file in specific formate :
        try {
            FileHandler fileHandler = new FileHandler("app1.log", true);//these create handeler to handle the log:
            logger.addHandler(fileHandler);//this add the logs into fiedandler :
            SimpleFormatter formatter=new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.info("this app is not working !");
            logger.warning("please handle inpute exception!");
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        //teke the two inputs and perform the operation of devission and print the diferent logs in this case:
        try {
            System.out.println("enter any two numbers !");
            int a = sc.nextInt();
            int b = sc.nextInt();
            logger.info("Calculation get started!");
            int result = a / b;
            logger.info("result Occuared successfully! which is : " + result);
        }
        catch (Exception e)
        {
            logger.severe("division get by 0");
            System.out.println("division 0 get occurs here !");
        }
        //take the input from user and show the different logs:
        System.out.println("enter any input from user:");
        int number=sc.nextInt();
        if (number<0)
        {
            logger.warning("number is lessthan zero!");
        }
        else if(number==0)
        {
            logger.info("given number is zero!");
        }
        else
        {
            logger.info("given number is valid!");
        }

        //take the user name and password and print different logs for the different reasons :
        uservalidation("aryanpawar",1234);

    }
}
