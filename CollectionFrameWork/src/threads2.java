public class threads2 {
    //create the class which implement runable and print any message from it :
    public static class PrintName implements Runnable{
        String name;
        PrintName(String name)
        {
            this.name=name;
        }
        public void run()
        {
            System.out.println("hey "+name+" how are you !");
        }
    }
    //create the two diferent class which implement threads:
    public static class numbers implements Runnable{
        public void run()
        {
            System.out.println("numbers from 1 to 5 are :");
            for (int i=1;i<=5;i++)
            {
                System.out.println("this ia :"+i);
            }
            System.out.println("execution get completed !");
        }
    }
    //create array which stores the laters :
    public static class laters implements Runnable{
        char laterss[]={'A','B','C','D','E'};
        public void run()
        {
            System.out.println("latters  from A to E are :");
            for (int i=0;i<laterss.length;i++)
            {
                System.out.println("this ia :"+laterss[i]);
            }
        }
    }
    public static class name implements Runnable{
        public void run()
        {
            System.out.println("this Task is Running By: "+Thread.currentThread().getName());
        }
    }
    //create the class for showing the message:
    public static class MessageTalk implements Runnable{
        String message;
        MessageTalk(String message)
        {
            this.message=message;
        }
        public void run()
        {
            System.out.println(message+" handled by "+Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        //create the object of that class printname :
        Thread name1=new Thread(new PrintName("aryan"),"Thread1");
        name1.start();
        //create the threads of two different classes and print the value of it :
        Thread numbers1=new Thread(new numbers(),"numbers");
        Thread laters1=new Thread(new laters(),"laters");
        numbers1.start();
        try{
            numbers1.join();
        }
        catch (InterruptedException e)
        {
            System.out.println("error is: "+e.getMessage());
        }
        laters1.start();
        Thread lambda=new Thread(()->{
            new numbers();
        },"labda");
        lambda.start();
        System.out.println("name of last thread is: "+lambda.getName());
        //create the different threads of same object:
        name name=new name();
        Thread t1=new Thread(name,"thread2");
        Thread t2=new Thread(name,"thread3");
        Thread t3=new Thread(name,"thread4");
        t1.start();
        t2.start();
        t3.start();

        //create the two threads for handling message:
        Thread Login=new Thread(new MessageTalk("Login"),"Login Thread");
        Thread Payment=new Thread(new MessageTalk("Payment"),"Payment Thread");
        Login.start();
        Payment.start();
        Thread Loginlambda=new Thread(()->{
            System.out.println("Login done by "+Thread.currentThread().getName());;
        },"LambdaExpression");
        Loginlambda.start();


    }
}
