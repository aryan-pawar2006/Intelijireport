import java.awt.image.PixelInterleavedSampleModel;
import java.util.Scanner;

public class ThreadIntercommuni {
    Scanner sc=new Scanner(System.in);
    //create class of data and try to produce data init and consume that data after producing :
    public static class ProcessData {
        int data;
        boolean hasdata=false;

        //now crate method for producing the data:
         synchronized void  producedata(int value) {
           while(hasdata)
           {
               try{
                   wait();
               }
               catch (InterruptedException e)
               {
                   Thread.currentThread().interrupt();
               }
           }
           data=value;
           System.out.println("Produced: "+data);
           hasdata=true;
           notify();
        }
        //for consuming the data:
       synchronized int consumedata(){
            while(!hasdata)
            {
                try {
                    wait();
                }
                catch (InterruptedException e)
                {
                    Thread.currentThread().interrupt();
                }
            }
           System.out.println("Consumed data: "+data);
            hasdata=false;
            notify();
            return data;

        }
    }
    //make two classes producer and consumer:
    static class producer implements Runnable{
        private ProcessData data1;

        producer(ProcessData data1)
        {
            this.data1=data1;
        }
        public void run()
        {
            for (int i=0;i<5;i++)
            {
                data1.producedata(i);
            }
        }
    }
    //same like producer make for consumer:
    static  class consumer implements Runnable{
        private ProcessData data1;
        consumer(ProcessData data1)
        {
            this.data1=data1;
        }
        public void run()
        {
            for (int i=0;i<5;i++)
            {
                int value=data1.consumedata();
            }
        }
        public class SimpleWaitNotify {

            static class SharedResource {

                synchronized void waitMethod() {
                    System.out.println("Waiting thread: Waiting...");
                    try {
                        wait();   // thread goes into waiting state
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Waiting thread: Got notification and resumed.");
                }

                synchronized void notifyMethod() {
                    System.out.println("Notifier thread: Preparing to notify...");
                    try {
                        Thread.sleep(2000); // wait for 2 seconds
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    notify(); // wake up waiting thread
                    System.out.println("Notifier thread: Notification sent.");
                }
            }
        }

    }
    static void main(String[] args) {
     ProcessData data2=new ProcessData();
     Thread producedata=new Thread(new producer(data2));
     Thread consumedata=new Thread(new consumer(data2));
     producedata.start();
     consumedata.start();
     consumer.SimpleWaitNotify.SharedResource resource = new consumer.SimpleWaitNotify.SharedResource();

        // Waiting thread
        Thread waitingThread = new Thread(() -> {
            resource.waitMethod();
        });

        // Notifier thread
        Thread notifierThread = new Thread(() -> {
            resource.notifyMethod();
        });

        waitingThread.start();
        notifierThread.start();


    }
}
