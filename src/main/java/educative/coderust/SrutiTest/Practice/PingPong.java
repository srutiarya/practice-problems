package educative.coderust.SrutiTest.Practice;

public class PingPong {
    public static void main(String[] args) {
        Object obj=new Object();
            Thread t1 = new Thread(new Ping(obj));
            Thread t2 = new Thread(new Pong(obj));
            t1.start();
            t2.start();

    }

}

class Ping implements Runnable{
    final Object obj;
    public Ping(Object obj){
        this.obj=obj;
    }
    public void run() {
        while (true) {
            synchronized (obj) {
                System.out.println("Ping");
                try {
                    obj.notify();
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Pong implements Runnable{
   final Object obj;
    public Pong(Object obj){
        this.obj=obj;
    }
    public void run() {
        while (true) {
            synchronized (obj) {
                System.out.println("Pong");
                try {
                    obj.notify();
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}