package educative.coderust.SrutiTest.Practice;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerConsumerBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue=new LinkedBlockingDeque<String>(10);
        Thread t1=new Thread(new Producer1(blockingQueue));
        Thread t2=new Thread(new Consumer1(blockingQueue));
        t1.start();
        t2.start();
    }
}
 class Producer1 implements Runnable{
    BlockingQueue<String> blq;
    public Producer1(BlockingQueue<String> blq){
        this.blq=blq;
    }
    public void run(){
        for(int i=0;i<=20;i++){
            System.out.println("Producing : "+i);
            blq.add(String.valueOf(i));
            /*try {
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }*/
        }
    }
 }

 class Consumer1 implements Runnable{
    BlockingQueue<String> blq;
    public Consumer1(BlockingQueue blq){
        this.blq=blq;
    }
    public void run(){
        for(int i=0;i<=20;i++){
            System.out.println("Consuming : "+i);
            blq.poll();
           /* try {
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }*/
        }
    }
 }