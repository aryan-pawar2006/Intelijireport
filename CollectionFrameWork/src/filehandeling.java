import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import  java .util.*;
import java.util.Scanner;
public class filehandeling {
    //crate the exception for fail fast:
    static class FilereadException extends RuntimeException{
        FilereadException(String message)
        {
            super(message);
        }
    }
    //create the method that can read the file safely
    static void readfilesafely(File  file) {
        //check the file is null or empty:
        if (file.length()==0 || file==null)
        {
            throw new FilereadException("file is empty or null!");
        }
        //check the existence of file:
        if (file.exists())
        {
            try {
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    System.out.println(line);
                }
                sc.close();
            }
            catch (FileNotFoundException e)
            {
                System.out.println("file does not exist !"+e.getMessage());
            }
        }
    }
    static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        //create the file and then pass it from the fun to check fail fast:
        File file4=new File("file4.txt");//this is decleration of path or directory not creation of file:
        try{
            file4.createNewFile();
            Scanner sc1=new Scanner(file4);
            while(sc1.hasNextLine())
            {
                String line=sc1.nextLine();
            }
            sc1.close();
            readfilesafely(file4);
        }
        catch (IOException e)
        {
            System.out.println("file creation get failed !");
        }

        //now create the two different files and copy the data from the first file and copy it into another file :
        File file5=new File("file5.txt");
        File file6=new File("file6.txt");



        //now check the fie5 is exist or not for copying the data :
        if (!file4.exists())
        {
            System.out.println("file does not exist !");
            return;
        }

        //write the code for copying the data :
        try{
            Scanner sc2=new Scanner(file4);
            FileWriter fw=new FileWriter(file6);
            while (sc2.hasNextLine())
            {
                String line=sc.nextLine();
                fw.write(line);
            }
            System.out.println("file copied succesfully!");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("error is : "+e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println("error is : "+e.getMessage());
        }
    }
}
