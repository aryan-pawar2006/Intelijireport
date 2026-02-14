import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
    static class FileemptyException extends RuntimeException{
        FileemptyException(String message)
        {
            super(message);
        }
    }
    //create the method for concept fail fast:
    static void  readfilesafety(File file) throws FileemptyException, FileNotFoundException {
        if ( file==null)
        {
            throw new FileemptyException("given file is null or empty!");
        }
        if (!file.exists()) {
            throw new FileemptyException("file does not exist");
        }
        if (file.length()==0)
        {
            throw new FileemptyException("file is empty!");
        }
        //now read this given file:
        try
        {
            Scanner sc=new Scanner(file);
            while(sc.hasNextLine())
            {
                String line= sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        }
        catch (FileNotFoundException  e)
        {
            System.out.println("the given file is not readable"+e.getMessage());
        }

    }
    static void main(String[] args) {
        //creating the file object and do some operation on it:
        File file1=new File("file1.txt");//hear we are declearing the file not actually creating:
        //for creating the file :
        try {
            file1.createNewFile();
        }
        catch (IOException e)
        {
            System.out.println("creation of file get failed!");
        }
        if (file1.exists())
        {
            System.out.println("path of file: "+file1.getPath()+" name of file: "+file1.getName()+" and size of file is: "+file1.length());
        }
        else
        {
            System.out.println("such type of file does not exist!");
        }

    //now read the file:
        try {
            Scanner sc = new Scanner(file1);
            while (sc.hasNextLine())
            {
                String name=sc.nextLine();
                System.out.println(name);
            }
            sc.close();
        }
        catch (IOException e)
        {
            System.out.println("file reading is not possible!");
        }

        //create the file and check its the file or not and display data related to it:
        File file2=new File("file2.txt");
        //now create the file actually
        try
        {
            if(file2.createNewFile()) {
                System.out.println("new file get created !");
            }else {
                System.out.println("file already exist!");
            }
        }
        catch ( IOException e)
        {
            System.out.println("file creation get failed!"+e.getMessage());
        }

        //now check the file is really exist or not and print the data releted tofile !
        if (file2.exists())
        {
            System.out.println("name of the file: "+file2.getName()+"\n path of file: "+file2.getAbsolutePath()+"\n size of the file is: "+file2.length()+"\n the given data is file : "+file2.isFile()+"\n the given data is directory: "+file2.isDirectory());
        }

        //now we have to read this file2:
        try
        {
            Scanner sc = new Scanner(file2);
            while(sc.hasNextLine())
            {
                String line= sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("file reaing is not possible!");
        }

//        try
//        {
//            Scanner sc = new Scanner(file2);
//            while(sc.hasNextLine())
//            {
//                String line= sc.nextLine();
//                if (line.contains("error")) {
//                    System.out.println(line);
//                }
//            }
//            sc.close();
//        }
//        catch (FileNotFoundException e)
//        {
//            System.out.println("file reaing is not possible!");
//        }

        //now create the code to find the no of lines ,words and characters of file data:
//        int linecount=0;
//        int wordcount=0;
//        int charactercount=0;
//        try
//        {
//            Scanner sc=new Scanner(file2);
//            while(sc.hasNextLine())
//            {
//                String line=sc.nextLine();
//                linecount++;//it is for counting the lines :
//
//               // charactercount+=line.length();//its for calculating no of charcters:
//
//                String[] words=line.trim().split(" ");
//                if (!line.trim().isEmpty())
//                {
//                    for (int i=0;i<words.length;i++)
//                    {
//                        String word=words[i];
//                        charactercount+=word.length();
//                    }
//                    wordcount+= words.length;//here we are counting the words
//                }
//
//            }
//        }
//        catch (FileNotFoundException e)
//        {
//            System.out.println("file aare not found!");
//        }
//        System.out.println("no of lines in file2 are: "+linecount);
//        System.out.println("no of words in file2 are: "+wordcount);
//        System.out.println("no of characters in file2 are: "+charactercount);

        //for fail fast create the file and then check the operation on it for validity:
        File file3=new File("file3.txt");
        try
        {
            Scanner sc = new Scanner(file3);
            while(sc.hasNextLine())
            {
                String line= sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("file reaing is not possible!");
        }
        //call the method:
        try
        {
            readfilesafety(new File("file3.txt"));
        }
        catch (FileemptyException | FileNotFoundException e)
        {
            System.out.println("error is: "+e.getMessage());
        }

    }
}
