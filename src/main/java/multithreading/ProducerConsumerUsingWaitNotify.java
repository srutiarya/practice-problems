package multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerUsingWaitNotify {

    public static void main(String[] args) {

        MessageStore<String> messageStore = new MessageStore<String>(10);
        Thread producer = new Thread(new Producer(messageStore));
        Thread consumer = new Thread(new Consumer(messageStore));

        consumer.start();
        producer.start();
    }

}

class MessageStore< T> {

    private int maxElements;
    private Queue<T> store = new LinkedList<T>();

    public MessageStore(int maxElements) {
        this.maxElements = maxElements;
    }

    public int getMaxElements() {
        return maxElements;
    }

    public void setMaxElements(int maxElements) {
        this.maxElements = maxElements;
    }

    public Queue<T> getStore() {
        return store;
    }

    public void setStore(Queue<T> store) {
        this.store = store;
    }
}

class Producer implements Runnable {

    MessageStore<String> messageStore;

    public Producer(MessageStore<String> messageStore) {
        this.messageStore = messageStore;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 20; i++) {
            synchronized (messageStore) {
                if (messageStore.getStore().size() == messageStore.getMaxElements()) {
                    try {
                        System.out.println("Producer waiting as queue is full. Size = " + messageStore.getStore().size());
                        messageStore.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Producing :  " + i);
                messageStore.getStore().add(String.valueOf(i));
                messageStore.notifyAll();
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


class Consumer implements Runnable {

    MessageStore<String> messageStore;

    public Consumer(MessageStore<String> messageStore) {
        this.messageStore = messageStore;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 20; i++) {
            synchronized (messageStore) {
                if (messageStore.getStore().size() == 0) {
                    try {
                        System.out.println("Consumer waiting as queue is empty. Size = " + messageStore.getStore().size());
                        messageStore.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Consuming :  " + messageStore.getStore().poll());
                messageStore.notifyAll();
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}