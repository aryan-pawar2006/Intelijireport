import java.util.Scanner;

public class demoabstract {
    //create the class for payment service and make a method called as pay:
    interface paymentmethod{
        void pay(double amount);
    }
    static class UPIpayment implements paymentmethod {
        public void pay(double amount)
            {
                System.out.println("the amount pau by the UPI is : "+amount);
            }
    }

    static class cardpayment implements paymentmethod {
        public void pay(double amount)
        {
            System.out.println("the amount pau by the UPI is : "+amount);
        }
    }

    //create the intrface and implement it :
    interface notification{
        void send(String message);
    }
    //create the two classes that implement this interface :
    static class emailnotification implements notification{


        public void send(String message) {
            System.out.println("the email message is : "+message);
        }
    }

    static class SMSnotification implements notification{


        public void send(String message) {
            System.out.println("the email message is : "+message);
        }
    }

    //create the shape class and then abstract the area method from it :
    static abstract class shape
    {
        double lenght;
        double width;
        double radius;

        shape(double l,double w,double radius)
        {
            this.lenght=l;
            this.width=w;
            this.radius=radius;
        }
        abstract  double area();
    }
    //now w'll create the abstract class and their 'll extends te shape class :
    static class circle extends shape
    {
        circle(double lenght,double width,double radius) {
            super(lenght,width,radius);
        }
        double area()
        {
            return 3.14*radius*radius;
        }

    }

    static class rectangle extends shape
    {
        rectangle(double lenght,double width,double radius) {
            super(lenght,width,radius);
        }
        double area()
        {
            return lenght*width;
        }

    }

    //abstract is bassically keyword that we used along class and  method :
    static abstract class Teacher {
        String name;
        int teacherId;
        String classteacher;

        //suppose I wanted to create the method but I dont want to do any task inside that method so in that case we can declear it only but with the help of abstract keyword.
        //and abstract method should have to be in abstract class but abstract class can allow to make abstract as well as non abstract cmethods also .
        abstract void subject();//declearing only abstract method not defining it :

        Teacher(String name1, int ID, String classname) {
            this.name = name1;
            this.teacherId = ID;
            this.classteacher = classname;
        }

        void display() {
            System.out.println("name of teacher is :" + name + "\nteacherId is :" + teacherId + "\n classteacher :" + classteacher);
        }
    }

    //create the another class that abstract the original class teacher:
    static abstract class mathteacher extends Teacher {
        //when in abstract class have constructor then we have to use it super explesatly :
        mathteacher(String name1, int Id1, String class1) {
            super(name1, Id1, class1);
        }

//        @Override
//        void subject() {
//            System.out.println("this is my subject math: ");
//        }
    }

    static class newteacher extends mathteacher{//this nwteacher class is called it as concreate class
        newteacher(String name1, int Id1, String class1) {
            super(name1, Id1, class1);
        }

        void subject(){
            System.out.println("the subject is : ");
        }
    }


    static void main() {
        Scanner sc = new Scanner(System.in);
        //we cannot create the object of abstract class :but we can  extends one
        mathteacher T1 = new newteacher("aryan", 54364, "mathclass");
        T1.display();

        //now we can create the object of newshape :
       circle circle1=new circle(32.23,44,54);
        System.out.println("area of circle: "+circle1.area());

        rectangle rectangle1=new rectangle(43,56,88);
        System.out.println("area of rectangle is : "+rectangle1.area());

        //creaethe object of email and sms notification class objects
        emailnotification E1=new emailnotification();
        E1.send("hey this message through email!");

        SMSnotification S1=new SMSnotification();
        E1.send("hey this message through SMS!");

        //create the object of UPI and card class;
        UPIpayment payment1=new UPIpayment();
        payment1.pay(5342);

        cardpayment payment2=new cardpayment();
        payment1.pay(5463);


    }
}
