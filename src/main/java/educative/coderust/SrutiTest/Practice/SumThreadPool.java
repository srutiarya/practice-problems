package educative.coderust.SrutiTest.Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SumThreadPool {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException  {
        List<Future<Integer>> list=new ArrayList<>();
        System.out.println("Enter Max size");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int max=Integer.parseInt(br.readLine());
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        for(int i=0;i<=max;i=i+100){
            if(i+100<max){
                Future<Integer> fut=executorService.submit(new SumElement(i+1,i+100));
                list.add(fut);
            }else {
                Future<Integer> fut = executorService.submit(new SumElement(i + 1, max));
                list.add(fut);
            }
        }
        int finalres=0;
        for (Future<Integer> fut:list) {
                finalres=finalres+fut.get();

        }
        System.out.println("Final result : "+finalres);
        executorService.shutdown();
    }
}

class SumElement implements Callable<Integer>{
    int upperlimt;
    int lowerlimt;
    public SumElement(int lowerlimt,int upperlimt){
        this.lowerlimt=lowerlimt;
        this.upperlimt=upperlimt;
    }
    public Integer call(){
        int res=0;
       for(int i=lowerlimt;i<upperlimt;i++){
           res=res+i;
       }
        System.out.println("Result :"+res);
       return res;
    }
}