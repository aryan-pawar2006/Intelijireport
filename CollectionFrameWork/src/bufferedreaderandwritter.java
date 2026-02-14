import java.io.*;
import java .util.Scanner;
public class bufferedreaderandwritter {
    //crate the new exception:
    static class InvalidDataException extends RuntimeException{
        InvalidDataException(String message)
        {
            super(message);
        }
    }
    //create the method that can read data and assgning the value that we are passing as argument:
    public static void writesafely(String path,String content)
    {
        if (path==null || path.isEmpty())
        {
            throw new InvalidDataException("path is empty!");
        } else if (content==null || content.isEmpty()) {
            throw new InvalidDataException("content is empty!");
        }
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("path",true)))
        {
            bw.write(content);
        }
        catch (IOException e)
        {
            System.out.println("error is : "+e.getMessage());
        }
    }
    static void main()  {
        //crate the file and read that file using bufferedreader:
        File file1=new File("file1.txt");

        try(BufferedWriter bw=new BufferedWriter(new FileWriter("file1.txt",false)))
        {
            bw.newLine();
         bw.write("this is first line of file1!");
         bw.newLine();
         bw.write("this is next line!");
        }
        catch (IOException e)
        {
            System.out.println("file reading is not possible !");
        }

    //now read the file data :
        try(BufferedReader br=new BufferedReader(new FileReader("file1.txt")))
        {
            String line;
            while((line=br.readLine()) !=null)
            {
                System.out.println(line);
            }
            System.out.println("end of file ");
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }

        //now create the new file and read it :
        File file7=new File("file7.txt");
        try{
            file7.createNewFile();
            String line;
            BufferedReader bw=new BufferedReader(new FileReader("file7.txt"));
            while((line=bw.readLine())!=null) {
                System.out.println(line);
            }
            bw.close();
        }
        catch (IOException e)
        {
            System.out.println("reading of file is not possible :"+e.getMessage());
        }

        //create the file and append the data into that file and print it :
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("file1.txt",true)))
        {
            //in the above the line file of App.log get created automatically
            bw.newLine();
            bw.write("this is first line of the append!");
            bw.newLine();
            bw.write("this is second line of append  line:");
        }
        catch (IOException e)
        {
            System.out.println("this is error: "+e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader("file1.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("end of file ");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        //now create the two diferent files and write the data into first file and copy that data into second file:
        File file8=new File("file8.txt");
        File file9=new File("file9.txt");

        //write the data into the first file:
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("file8.txt")))
        {
            bw.write("this is first line of first file!");
            bw.newLine();
            bw.write("this is second line of first file!");
            bw.newLine();
            bw.write("this is the third line of first file!");
        }
        catch (IOException e)
        {
            System.out.println("error occured during writing!"+e.getMessage());
        }

        //now copy the all the data of first file into second file :
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("file9.txt"));
         BufferedReader br=new BufferedReader(new FileReader("file8.txt")))
        {

            String line;
            while((line=br.readLine())!= null)
            {
                bw.write(line);
                bw.newLine();
            }
            br.close();
        }
        catch (IOException e)
        {
            System.out.println("error is : "+e.getMessage());
        }


        //now read the data of copied file:
        try(BufferedReader br=new BufferedReader(new FileReader("file9.txt")))
        {
           String line;
           while((line=br.readLine())!=null)
           {
               System.out.println(line);
           }
        }
        catch (IOException e)
        {
            System.out.println("error occured during writing!"+e.getMessage());
        }
    //create the file that store the register information:
        File register=new File("register.txt");
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("register.txt")))
        {
            bw.write("ID:1,");
            bw.write("Name:name,");
            bw.write("Email:aryanpawar@gmail.com");
        }
        catch (IOException e)
        {
            System.out.println("error is:"+e.getMessage());
        }

        //creat the object of file and write it:
        writesafely("data.txt","hey this is new file of data!");
    }
}
