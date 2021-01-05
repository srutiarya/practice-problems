package educative.coderust.SrutiTest.Practice;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProducerConsumerPractice {
    public static void main(String[] args) {
        Queue<String> queue=new LinkedList<>();
        MessageStorePractice messageStorePractice=new MessageStorePractice(10,queue);
        Thread t1=new Thread(new ProducerPractice(messageStorePractice));
        Thread t2=new Thread(new ConsumerPractice(messageStorePractice));
        t1.start();
        t2.start();
    }
}


class MessageStorePractice{
    private int maxlimt;
    private Queue<String> queue;

    public MessageStorePractice(int maxlimt, Queue<String> queue) {
        this.maxlimt = maxlimt;
        this.queue = queue;
    }

    public int getMaxlimt() {
        return maxlimt;
    }

    public void setMaxlimt(int maxlimt) {
        this.maxlimt = maxlimt;
    }

    public Queue<String> getQueue() {
        return queue;
    }

    public void setQueue(Queue<String> queue) {
        this.queue = queue;
    }
}

class ProducerPractice implements Runnable{
    MessageStorePractice msg;
    public ProducerPractice(MessageStorePractice msg){
        this.msg=msg;
    }
    public void run() {
        for (int i = 0; i <= 20; i++) {
            synchronized (msg) {
                if(msg.getQueue().size()==msg.getMaxlimt()){
                    System.out.println("waiting for consumer to consume");
                    try {
                        msg.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    System.out.println("Produceing : "+i);
                   msg.getQueue().add(String.valueOf(i));
                   msg.notify();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}

class ConsumerPractice implements Runnable{
    MessageStorePractice msg;
    public ConsumerPractice(MessageStorePractice msg){
        this.msg=msg;
    }
    public void run(){
        for(int i=0;i<=20;i++) {
            synchronized (msg) {
                if (msg.getQueue().size() == 0) {
                    System.out.println("Waitng for Producer to produce");
                    try {
                        msg.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Consuming : " + i);
                    msg.getQueue().poll();
                    msg.notifyAll();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}