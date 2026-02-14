
public class synchronization {
    //create the class for the Synchronization concept:
    public static class A  implements Runnable{
        int  balance;
        A(int  balance)
        {
            this.balance=balance;
        }
        //create the method which is sharable and can access by the diferent thread:
        //so block of code which is shared in between one than one thread and create the snychronization problem :
        //that block of code called as critical section and that condition is called rise condition:
        public  synchronized void balanceIncrementor()
        {
            balance++;//we can make the synchronization field and methods also :
        }
        int getbalance()
        {
            return balance;
        }
        public void run() {
                for (int i = 1; i <= 1000; i++) {
                    balanceIncrementor();
                }
        }
    }
    //create the bankaccount class and make sure after widraw amount will be correct:
    public static class Bankacount implements Runnable{
        int balance;
        Bankacount(int amount)
        {
            this.balance=amount;
        }
        //create method which wil widraw the amount from balance:
        public synchronized int  Withdraw(int withdrawamount)
        {
            if (withdrawamount>balance)
            {
                System.out.println("insufficeint balance!");
            }
            else if (withdrawamount<0)
            {
                System.out.println("withdraw amount is invalid!");
            }
            else
            {
                int temp=balance;
                temp=temp-withdrawamount;
                balance=temp;
            }
            return balance;
        }
       public void run()
        {
            for (int i=0;i<10000;i++) {
                Withdraw(1);
            }
        }
    }
    //create the class which will bok your flight ticket:
    public static class Bookticket implements Runnable{
        int tickets=5;
        public synchronized void Book(){
            if (tickets<0 || tickets>5)
            {
                System.out.println("tickets are not available:");
            }
            else {
                System.out.println("your ticket get booked!"+Thread.currentThread().getName());
                tickets--;
            }
        }
        public void run()
        {
            Book();
        }
    }
    static void main(String[] args) {
        //create two different threads and access it:
        A obj1=new A(3);
        Thread t1=new Thread(obj1);
        Thread t2=new Thread(obj1);
        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }
        catch (InterruptedException e)
        {
            System.out.println("error is :"+e.getMessage());
        }
        System.out.println("balance after incrementing : "+obj1.getbalance());
        //now we can create the two diferent threads for the bankaccount class :
        Bankacount acount=new Bankacount(50000);
        Thread account1=new Thread(acount);
        Thread account2=new Thread(acount);
        account1.start();
        account2.start();
        try {
            account1.join();
            account2.join();
        }
        catch (InterruptedException e)
        {
            System.out.println("error is:"+e.getMessage());
        }
        System.out.println("after widraw check the ammount :"+acount.balance);
        //create the threads for booking your tickets:
        Bookticket ticket=new Bookticket();
        Thread ticket1=new Thread(ticket,"thread1");
        Thread ticket2=new Thread(ticket,"thread2");

        ticket1.start();
        ticket2.start();
        try {
            ticket1.join();
            ticket2.join();
        }
        catch (InterruptedException e)
        {
            System.out.println("error is : "+e.getMessage());
        }
    }
}
