import java.io.*;
public class deserialization {
    static class Employ implements Serializable{
        String name;
        long salary;
        String branch;
        static String companyname;

        Employ(String name)
        {
            this.name=name;
        }
    }

    //make methos for serialization:
    static void deserialization()
    {
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("employ.ser")))
        {
            Employ employ2 =(Employ)ois.readObject();
            System.out.println("object get serialized!");
        }
        catch (InvalidClassException e)
        {
            System.out.println("error is: "+e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println("error is: "+e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("error is: "+e.getMessage());
        }
    }
    static void serialization(Employ employ1)
    {
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("employ1.ser")))
        {
            oos.writeObject(employ1);
            System.out.println("file get succesfully serialized!");
        }
        catch (IOException e)
        {
            System.out.println("error is: "+e.getMessage());
        }
    }
    static void main(String[] args) {
        //call the method f serializatio:
        Employ.companyname="Microsoft";
        Employ employ1=new Employ("aryan");
        //serialization(employ1);
        deserialization();


    }
}
