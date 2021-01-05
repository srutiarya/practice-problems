package educative.coderust.SrutiTest.Practice;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    public static void main(String[] args) {
        Queue<String> store=new LinkedList<>();
        MessageStore messageStore=new MessageStore(10,store);
        Thread t1=new Thread(new Producer(messageStore));
        Thread t2=new Thread(new Consumer(messageStore));
        t1.start();
        t2.start();

    }
}

class MessageStore{
    private int maxsize;
    private Queue<String> queue;

    public MessageStore(int maxsize, Queue<String> queue) {
        this.maxsize = maxsize;
        this.queue = queue;
    }

    public int getMaxsize() {
        return maxsize;
    }

    public void setMaxsize(int maxsize) {
        this.maxsize = maxsize;
    }

    public Queue<String> getQueue() {
        return queue;
    }

    public void setQueue(Queue<String> queue) {
        this.queue = queue;
    }
}

class Producer implements Runnable{
    final MessageStore messageStore;

    public Producer(MessageStore messageStore) {
        this.messageStore = messageStore;
    }
    public void run(){
        for(int i=0;i<=20;i++){
            synchronized (messageStore){
                if(messageStore.getQueue().size()==messageStore.getMaxsize()){
                    try {
                        System.out.println("waiting for consumer to consume");
                        messageStore.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                    System.out.println("Producing : "+i);
                    messageStore.getQueue().add(String.valueOf(i));
                    messageStore.notifyAll();
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }


            }
        }
    }
}

class Consumer implements Runnable{
    MessageStore messageStore;
    public Consumer(MessageStore messageStore){
        this.messageStore=messageStore;
    }
    public void run(){
        for(int i=0;i<=20;i++){
            synchronized (messageStore){
                if(messageStore.getQueue().size()==0){
                    System.out.println("Waitng for Producer to produce");
                    try {
                        messageStore.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                    System.out.println("Consuming : "+i);
                    messageStore.getQueue().poll();
                    messageStore.notifyAll();
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

            }
        }
    }
}