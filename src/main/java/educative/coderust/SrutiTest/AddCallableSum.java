package educative.coderust.SrutiTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class AddCallableSum {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        long maxvalue;
        long uplimt;
        long lolimit=1;
        long threadcount;
        ExecutorService executorService=Executors.newFixedThreadPool(10);
        List<Future<Long>> list= new ArrayList<>();
        System.out.println("Enter max number to add");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        maxvalue= Long.parseLong(br.readLine());
        threadcount=maxvalue/10;
        if(maxvalue%10!=0){
            threadcount++;
        }

        for(int i=1;i<=threadcount;i++){
            List<Long> longList=new ArrayList<>();
            for(long j=lolimit;j<=lolimit+9;j++){
                longList.add(j);
            }
            Future<Long> future=executorService.submit(new AddSum(longList));
            list.add(future);

        }

        List<List<Long>> lists= sum(list);

        while (lists.size() > 1) {
            list.clear();
            for( List<Long> longList : lists) {
                Future<Long> future=executorService.submit(new AddSum(longList));
                list.add(future);
            }
            lists = sum(list);
        }

        Future<Long> future=executorService.submit(new AddSum(lists.get(0)));
        System.out.println("Final Result : " + future.get() );


    }
   private static List<List<Long>> sum(List<Future<Long>> list){
        List<List<Long>> lists=new ArrayList<>();
        for(int i=0;i<list.size();i+=10){
            List<Long> longList = new ArrayList<>();
            int k = i + 10 <= list.size() ? i + 10 : list.size();
            for (Future<Long> future : list.subList(i,k)) {
                try {
                    longList.add(future.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
            lists.add(longList);
        }

        return lists;
    }

}

class AddSum implements Callable<Long> {
    List<Long> list;

    public AddSum(List<Long> list){
        this.list=list;

    }

    @Override
    public Long call() throws Exception {
        long result=0;
        for(long i=0;i<list.size();i++){
            result=list.indexOf(i)+result;
        }
        //System.out.println("lolimt:"+""+lolimit+"uplimt:"+""+uplimit+"result"+result);
        return result;
    }
}