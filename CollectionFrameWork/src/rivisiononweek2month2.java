import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class rivisiononweek2month2 {
    //create user class
    public static class user implements Serializable{
        int id;
        String name;

        user(int id,String name)
        {
            this.id=id;
            this.name=name;
        }
    }
    private static final Logger logger=Logger.getLogger(rivisiononweek2month2.class.getName());
   public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //create the file then read that file  display the logs :
        //below code is for writing the data :
        File data=new File("data.txt");
        try(BufferedWriter file1=new BufferedWriter(new FileWriter("data.txt")))
        {
            boolean  yes=true;
            while(yes) {
                System.out.println("enter any sentence that you wanted to write !");
                file1.write(sc.nextLine());
                file1.newLine();
                System.out.println("if you wanted to continue to write then enter true otherwise enter false");
                yes= Boolean.parseBoolean(sc.next());
                sc.nextLine();
            }
        }
        catch (IOException e)
        {
            System.out.println("error is : "+e.getMessage());
        }
        int linecount=0;
        //now write the code for reading the data
        try(BufferedReader reader=new BufferedReader(new FileReader("data.txt")))
        {
            String line;
            while((line=reader.readLine())!=null)
            {
                System.out.println(line);
                linecount++;
            }
        logger.info("fie get readed succsfully !");
        }
        catch (IOException e)
        {
            logger.severe("file won't able to read !");
            System.out.println("error is : "+e.getMessage());
        }
        //create the list of users and then sereialize it :
       List<user> users=new ArrayList<>();
        for (int i=1;i<3;i++)
        {
            System.out.println("enter the info for"+i+"th  user!");
            user user1=new user(sc.nextInt(),sc.next());
            users.add(user1);
        }
        //now serialize the list of users:
       try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("users.txt")))
       {
           oos.writeObject(users);
           logger.info("list get succesfully serialized!");
       }
       catch (IOException e)
       {
           logger.severe("list won't able to sereialized"+e.getMessage());
       }
       //now deserialize it:
       try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("users.txt")))
       {
           List<user> list2 = (List<user>)ois.readObject();
           for (user us: list2) {
               System.out.println("Id of User:"+us.id +" Name of user is : "+us.name);
           }
       }
       catch (IOException | ClassNotFoundException e)
       {
           System.out.println(e.getMessage());
       }
    }
}
