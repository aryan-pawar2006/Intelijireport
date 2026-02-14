import java.io.*;

public class serialization {
    //create the class of employ and serialize it:
    static class employ implements Serializable{
        String name;
        static String companyname;

        employ(String name)
        {
            this.name=name;
            //employ.companyname=companyname;//when any field is static define it like this:
        }
    }
    static void main(String[] args) {
        employ.companyname="Microsoft";
        employ employ1=new employ("aryan");
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("employ.ser")))
        {
            oos.writeObject(employ1);
            System.out.println("file get succesfully serialized!");
        }
        catch (IOException e)
        {
            System.out.println("error is: "+e.getMessage());
        }

    }
}
