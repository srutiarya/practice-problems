package educative.coderust.SrutiTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class AddCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        List<Future<Long>> list=new ArrayList<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        long maxvalue =0;
            try {
                maxvalue= Long.parseLong(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        long threadcount= maxvalue/10;
        long lolimit=1;
        if(maxvalue%10!=0){
            threadcount=threadcount+1;
        }
        for(int i=1;i<=threadcount;i++) {
            long highlimit=lolimit+9;
            Future<Long> future = executorService.submit(new Add(lolimit,highlimit));
            list.add(future);
            lolimit=highlimit+1;
        }
         long finalresult = 0;
    for(Future<Long> fut:list){
        long res=fut.get();
        finalresult=res+finalresult;
    }
    System.out.println("Final result:"+finalresult);

    executorService.shutdown();
    }



}

class Add implements Callable<Long> {
    long lowervalue;
    long uppervalue;
    public Add(long lowervalue,long uppervalue){
        this.lowervalue=lowervalue;
        this.uppervalue=uppervalue;
    }


    @Override
    public Long call() throws Exception {

        long result=0;
        for(long i=lowervalue;i<=uppervalue;i++){
             result=i+result;

        }
        System.out.println("lower limit:"+lowervalue+"uper limit:"+uppervalue+"result"+result);
        return result;
    }
}