import java.io.*;

public class erializationanddeserialization {
    static  class Employ implements Serializable{
        private static final long serialVersionUID = 1L;
        String name;
        long employId;
        String emplocity;
        String companyname;

        Employ(String name,long Id,String companyname)
        {
            this.companyname=companyname;
            this.name=name;
            this.employId=Id;
        }
    }
    //create the class of user:
    static  class User implements Serializable{
        public static final long serialVersionUID=123L;
        int Id;
        String name;
        String city;

        User(int id,String name)
        {
            this.Id=id;
            this.name=name;
        }
    }
    static void main(String[] args) {
      //now here call only methods to check serialization and deserialization:
       // serialization();
        //deserialization();
        //serializationuser();
        deserializationuser();
    }
    //create function for serializing the file data:
    static void serialization()
    {
        Employ employ1=new Employ("aryan",43,"Microsoft");
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("EmployData.txt")))
        {
            oos.writeObject(employ1);
            System.out.println("object of file get succesfully serialized");
        }
        catch (IOException e)
        {
            System.out.println("error is: "+e.getMessage());
        }
    }
    //now create method for deserialization:
    static void deserialization(){
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("EmployData.txt")))
        {
            Employ employ2=(Employ) ois.readObject();
            System.out.println("Name of Employ: "+employ2.name+", "+"ID of employ: "+employ2.employId+", "+"Company name: "+employ2.companyname);
        }
        catch (InvalidClassException e)
        {
            System.out.println("error get occured: "+e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("error is: "+e.getMessage());
        }
        catch (FileNotFoundException e)
        {
            System.out.println("error is: "+e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println("error is: "+e.getMessage());
        }
    }
    //now create two different functionfor serialization and deserialization:
   static void serializationuser(){
        //create object of user class :
       User user1=new User(43,"aryan");
       try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("user.txt")))
       {
           oos.writeObject(user1);
           System.out.println("serialization completed succesfully!");
       }
       catch (IOException e)
       {
           System.out.println("error is : "+e.getMessage());
       }
    }
    static void deserializationuser(){
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("user.txt")))
        {
            User user2=(User) ois.readObject();
            System.out.println("ID of User: "+user2.Id+", "+"Name of user: "+user2.name);
        }
        catch (InvalidClassException e)
        {
            System.out.println("error is: "+e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("error is : "+e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println("error is : "+e.getMessage());
        }
    }
}
