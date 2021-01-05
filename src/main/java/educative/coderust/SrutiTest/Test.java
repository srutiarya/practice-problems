package educative.coderust.SrutiTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        MessageStore<String> messageStore=new MessageStore<>(10);
        Thread t1=new Thread(new Producer(messageStore));
        Thread t2=new Thread(new Consumer(messageStore));

        t1.start();
        t2.start();



    }
}

class MessageStore<T>{
    private int maxele;
    private Queue<T> store= new LinkedList<>();

    public MessageStore(int maxele){
        this.maxele=maxele;
    }

    public int getMaxele() {
        return maxele;
    }

    public void setMaxele(int maxele) {
        this.maxele = maxele;
    }

    public Queue<T> getStore() {
        return store;
    }

    public void setStore(Queue<T> store) {
        this.store = store;
    }
}
class Producer implements Runnable{
    MessageStore<String> messageStore;

    public Producer(MessageStore messageStore){
        this.messageStore=messageStore;

    }

    @Override
    public void run() {
        for (int i=1;i<=20;i++) {
            synchronized (messageStore) {
            if(messageStore.getStore().size()==messageStore.getMaxele()){
                try {
                    System.out.println("Producer waiting as queue is full. Size = " + messageStore.getStore().size());
                    messageStore.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

                System.out.println("producing :"+i);
                messageStore.getStore().add(String.valueOf(i));
                messageStore.notifyAll();
                try {
                    messageStore.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

    }
}
class Consumer implements Runnable {
    MessageStore<String> messageStore;

    public Consumer(MessageStore messageStore){
        this.messageStore=messageStore;
    }
    @Override
    public void run() {
        for(int i=1;i<=30;i++){
            synchronized (messageStore){

                if(messageStore.getStore().size()== 0){
                    try {
                        System.out.println("Consumer waiting as queue is empty. Size = " + messageStore.getStore().size());
                        messageStore.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                    System.out.println("Consuming :"+messageStore.getStore().poll());
                    messageStore.notifyAll();
                try {
                    messageStore.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}