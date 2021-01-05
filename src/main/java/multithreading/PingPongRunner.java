package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PingPongRunner implements Runnable {
    String word;
    Object lock;

    public PingPongRunner(String word, Object lock) {
        this.word = word;
        this.lock = lock;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("Received : " + word);
            lock.notifyAll();
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(2);
        Object lock = new Object();
        while(true){
            ex.submit(new PingPongRunner("ping", lock));
            ex.submit(new PingPongRunner("pong", lock));
        }
    }
}