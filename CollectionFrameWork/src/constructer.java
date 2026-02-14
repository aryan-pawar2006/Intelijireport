import jdk.dynalink.beans.StaticClass;

import java.lang.classfile.constantpool.AnnotationConstantValueEntry;
import java .util.*;
import java.util.Scanner;
public class constructer {
    static class product{
        int productId ;
        double prise;

        product(int Id,double prise)
        {
            this.prise=prise;
            this.productId=Id;
        }
        //for checking the price is valid or not :
        void check()
        {
            if (prise<=0)
            {
                this.prise=0;
            }
        }

        void display()
        {
            System.out.println("ID : "+productId+"prise: "+prise);
        }

    }

    static class employ{
        int employId;
        String name;
        Double salary;

        //make the default constructor to assign the values :
        employ()
        {
            this.employId=123;
            this.name="aryan";
            this.salary= 50000.0;
        }
        void display()
        {
            System.out.println("employ Id is : "+employId+" name of employ is : "+name+" salary of the employ is : "+salary);
        }
    }
    static class Student {
        int rollno;
        String name;
        String classroom;

        //make the cnstructor and assign the value to datamembers :
         Student(int roll,String name,String class1)
        {
            this.rollno=roll;
            this.name=name;
            this.classroom=class1;
        }
        void displaydata()
        {
            System.out.println("rollno is : "+rollno+" name of student is : "+name+" class of student is : "+classroom);
        }

    }
    static void main() {
        Scanner sc= new Scanner(System.in);
        Student s1=new Student(43,"aryan","secondyear");
        System.out.println("the roll no os student is : ");
        s1.displaydata();

    //create the object of employ class then print the data :
    employ E1=new employ();
        E1.display();

    //create the object of product and check it :
    product P1=new product(3241,-43);
    P1.check();
    P1.display();



    }
}
