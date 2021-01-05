package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PingPongWaitNotify {
    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock();

        Integer i = 1;

        Runnable r1 = new PingPong(i, "ping", lock);
        Runnable r2 = new PingPong(i, "pong", lock);

        Thread t1 = new Thread(r1, "Thread Ping");
        Thread t2 = new Thread(r2, "Thread Pong");


        t2.start();
        Thread.sleep(1000);
        t1.start();


        /*
        PingPong p1=new PingPong();
        Thread t1=new Thread(p1);
        t1.start();
        Thread t2=new Thread(p1);
        t2.start();

         */
    }
}

/*
class PingPong implements Runnable{
    MessagePingPong m1=new MessagePingPong("Ping","Pong");
    @Override
    public void run()  {
        System.out.println(m1.getS1());
        try {
            m1.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class MessagePingPong{
    String s1;
    String s2;

    public MessagePingPong(String s1,String s2){
        this.s1=s1;
        this.s2=s2;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }
}
*/

class PingPong implements Runnable {
    private Integer n;
    private String s;
    private final Lock lock;

    PingPong(Integer n, String s, Lock lock) {
        this.n = n;
        this.s = s;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                System.out.println(Thread.currentThread());
                if (n % 2 != 0 && s.equals("ping")) {
                    System.out.println(s);
                    n++;
                    lock.notifyAll();
                } else if (n % 2 == 0 && s.equals("pong")) {
                    System.out.println(s);
                    n++;
                    lock.notifyAll();
                }
                else {
                    try {
                        System.out.println("waiting");
                        lock.wait();
                        System.out.println("wait over");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}