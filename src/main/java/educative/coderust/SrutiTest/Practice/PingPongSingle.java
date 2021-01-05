package educative.coderust.SrutiTest.Practice;

public class PingPongSingle {
    public static void main(String[] args) {
        Object obj=new Object();
        Thread t1=new Thread(new PingPongPrint(obj,"Ping"));
        Thread t2=new Thread(new PingPongPrint(obj,"Pong"));
        t1.start();
        t2.start();
    }
}

class PingPongPrint implements Runnable{
    final Object obj;
    String msg;
    public PingPongPrint(Object obj,String msg){
        this.obj=obj;
        this.msg=msg;
    }

    public void run() {
        while (true) {
            synchronized (obj) {
                System.out.println(msg);
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