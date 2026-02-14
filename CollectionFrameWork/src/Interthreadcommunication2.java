import java.util.Scanner;

public class Interthreadcommunication2 {

    static Scanner sc = new Scanner(System.in);

    public static class ReadData {
        String name;
        int RollNo;
        String classname;
        boolean hasreaddata = false;

        synchronized void Dataread(String name, int roolno, String classname) {
            while (hasreaddata) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            this.name = name;
            this.RollNo = roolno;
            this.classname = classname;

            System.out.println("Produced -> Name: " + name +
                    ", RollNo: " + roolno +
                    ", Class: " + classname);

            hasreaddata = true;
            notify();
        }

        synchronized void Printdata() {
            while (!hasreaddata) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            System.out.println("Consumed -> Name: " + name +
                    ", RollNo: " + RollNo +
                    ", Class: " + classname);

            hasreaddata = false;
            notify();
        }

        // Producer thread
        static class Producer implements Runnable {
            ReadData data;

            Producer(ReadData data) {
                this.data = data;
            }

            public void run() {
                for (int i = 0; i < 2; i++) {
                    System.out.println("Enter: name roll class");
                    String name = sc.next();
                    int roll = sc.nextInt();
                    String cls = sc.next();
                    data.Dataread(name, roll, cls);
                }
            }
        }

        // Consumer thread
        static class Consumer implements Runnable {
            ReadData data;

            Consumer(ReadData data) {
                this.data = data;
            }

            public void run() {
                for (int i = 0; i < 2; i++) {
                    data.Printdata();
                }
            }
        }
    }

    public static void main(String[] args) {
        ReadData data = new ReadData();

        Thread t1 = new Thread(new ReadData.Producer(data));
        Thread t2 = new Thread(new ReadData.Consumer(data));

        t1.start();
        t2.start();
    }
}
