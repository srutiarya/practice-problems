package educative.coderust.SrutiTest.Thread;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolSum {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        List<Future<Integer>> list = new ArrayList<>();
        List<Future<Integer>> list1 = new ArrayList<>();
        System.out.println("enter max value to add");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int maxvalue = Integer.parseInt(bufferedReader.readLine());
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<Integer> future;
        for (int i = 0; i < maxvalue; i = i + 10) {
            if (i + 10 < maxvalue) {
                future = executorService.submit(new Add(i + 1, i + 10));
            } else {
                future = executorService.submit(new Add(i + 1, maxvalue));
            }
            list.add(future);
        }



        for (int i = 0; i < list.size(); i = i + 10) {
            if(i+10<list.size()) {
                Future<Integer> future1 = executorService.submit(new Total(list.subList(i, i + 10)));
                list1.add(future1);
            }else {
                Future<Integer> future1=executorService.submit(new Total(list.subList(i,list.size())));
                list1.add(future1);
            }


        }
        int sum=0;
        for (Future<Integer> fut:list1) {
            int res=fut.get();
            sum=sum+res;
        }
        System.out.println("Final result : "+sum);
        executorService.shutdown();
    }
}

class Total implements Callable<Integer> {
    List<Future<Integer>> list;

    public Total(List<Future<Integer>> list) {
        this.list = list;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (Future<Integer> fut : list) {
            int res = fut.get();
            sum = sum + res;
        }
        System.out.println("Sum of 10 numbers : "+sum);
        return sum;
    }
}

class Add implements Callable<Integer> {
    int upperlimit;
    int lowerlimt;

    public Add(int lowerlimt, int upperlimit) {
        this.upperlimit = upperlimit;
        this.lowerlimt = lowerlimt;
    }

    int res;

    public Integer call() {
        for (int i = lowerlimt; i <= upperlimit; i++) {
            res = res + i;
        }
        System.out.println("Add Result: " + res);
        return res;
    }

}