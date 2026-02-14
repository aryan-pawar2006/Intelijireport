import java.io.*;

public class serializationAnddeserialization {
    //create class of student :
    static class Student implements Serializable{//after implementing this interface we declear this class can be serialized:
        String Name;
         transient int RollNoll;//basically here we are defining rollno field is not serializable :
        String Branch;

        Student(String name,int rollno,String branch)
        {
            this.Name=name;
            this.RollNoll=rollno;
            this.Branch=branch;
        }
    }
    //create the class of bankAccount and use Serialization:
    static class BankAccount implements Serializable{
        String name;
        transient long accountno;
        String password;

        BankAccount(String name,long accountno,String password)
        {
            this.accountno=accountno;
            this.password=password;
            this.name=name;
        }
    }

    //create the nested object of class and serialize it:
    static class User implements Serializable{
        int ID;
        String name;
        Adress add;


        User(int id,String name,Adress add)
        {
            this.ID=id;
            this.name=name;
            this.add=add;
        }
    }
    static class Adress implements Serializable{
        String city;
        int pincode;

        Adress(String city,int pincode)
        {
            this.city=city;
            this.pincode=pincode;
        }
    }
    static void main(String[] args) {
        //create the object of student class:
        Student s1=new Student("aryan",43,"CSE");
        //now do the serialization :
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("serialized.txt")))
        {
            oos.writeObject(s1);
            System.out.println("object get succesfully serialized!");
        }
        catch(IOException e)
        {
            System.out.println("error is : "+e.getMessage());
        }

        //now we can do deserialization also to convert that serialized data again into object format:
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("serialized.txt")))
        {
         //now create new object and read that data into that newly created file :
         Student s2=(Student) ois.readObject();//without accessing s1 object we are able to copy data of it into s2:
            System.out.println("Name: "+s2.Name+" "+"RollNo: "+s2.RollNoll+" "+"Branch: "+s2.Branch);
        }
        catch (IOException e)
        {
            System.out.println("error is : "+e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        BankAccount account1=new BankAccount("aryan",43521752,"acount@123");
        //now serialize and deserialize the object of bankaccount with trasient data:
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("account.txt")))
        {
           oos.writeObject(account1);
            System.out.println("object of bankaccount get succesfully serialized");
        }
        catch (IOException e)
        {
            System.out.println("error is: "+e.getMessage());
        }

        //now we can create another object by reading that data of first object into second
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("account.txt")))
        {
            BankAccount account2=(BankAccount) ois.readObject();
            System.out.println("name of account holder: "+account2.name+", "+"account number: "+account2.accountno+", "+"password: "+account2.password);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("error is: "+e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println("error is: "+e.getMessage());
        }

        //now create object of nested class:
        Adress add=new Adress("Tambave",415114);
        User user=new User(123,"aryan",add);
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("userdata.txt")))
        {
            oos.writeObject(user);
            System.out.println("object get writed!");
        }
        catch (IOException e)
        {
            System.out.println("error is: "+e.getMessage());
        }

        //now read the data after deserialized it:
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("userdata.txt")))
        {
            User user2=(User) ois.readObject();
            System.out.println("ID: "+user2.ID+", "+"name: "+user2.name+", "+"Adress of city:"+user2.add.city+", "+"adress of pincode: "+user2.add.pincode);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("class not found: "+e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println("error is : "+e.getMessage());
        }
    }
}
