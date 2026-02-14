import java.io.IOException;

public class Threads {
    public static class firstthread implements Runnable{
        String message;
        firstthread(String message)
        {
            this.message=message;
        }
        public void run() {
            System.out.println(message);
        }
    }
    public static class numbers implements Runnable{
        public void run(){
            for (int i=1;i<=5;i++)
            {
                System.out.println(Thread.currentThread().getName()+" :"+i);
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    System.out.println("error s:"+e.getMessage());
                }
            }
        }
    }
    //now suppose we wanted to create thread by extending the thread class:
    public  static class A extends Thread{
        String name;
        int no;
        A(String name,int no)
        {
            this.name=name;
            this.no=no;
        }
        public void run()
        {
            System.out.println("here we make thread by extension!");
        }
    }
    public static class employ implements Runnable{
        public void run()
        {

            System.out.println("name of employ is which is set by the user this is main thred name :"+Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        //now create the diferent threads and :
        Thread t1=new Thread(new firstthread("Hellow from thread!"));
        t1.start();
        //create the three different threads:
        Thread t2=new Thread(new numbers(),"aryan");
        Thread t3=new Thread(new numbers(),"darshan");
        Thread t4=new Thread(new numbers(),"mahesh");
        t2.start();
        t3.start();
        t4.start();
        Thread t5=new Thread(new numbers(),"ram");
        System.out.println("from here I started to fith thread!");
        t5.start();
        //now create thread by extension:
        A t6=new A("aryan",80);
        t6.start();

        System.out.println("Main thread: "+Thread.currentThread().getName());
        //create the ew thread of employ:
        Thread employ1 = new Thread(() -> {
            System.out.println("Child Thread: " +
                    Thread.currentThread().getName());
        }, "Worker-employ");
        employ1.start();

        //make the threads for the  class and use the join methode :
        A aryan=new A("aryan",43);
        A darshan=new A("darshan",31);
        aryan.start();
        try{
            aryan.join();
            System.out.println("firs execution of thread get finished :");
        }
        catch (InterruptedException e)
        {
            System.out.println("error is : "+e.getMessage());
        }
        darshan.start();
    }
}
