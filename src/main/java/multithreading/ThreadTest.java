package multithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException, IOException {

            Thread t1 = new ThreadUser();
            t1.start();

            Runnable r = new ThreadRunnable();
            Thread t2 = new Thread(r);
            t2.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(br.readLine());
            while (true) {
                System.out.println("Main");
            }

        }

}

class ThreadRunnable implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("Runnable");
        }
    }
}

class ThreadUser extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("Thread");
        }
    }

}
