package educative.coderust.SrutiTest.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArraySum {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[5];
        System.out.println("Enter 5 element");
        for (int i = 0; i < arr.length; i++) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int ele = Integer.parseInt(reader.readLine());
            arr[i]=ele;

        }
        int sum=0;
                for(int i=0;i<arr.length;i++){
                    sum=arr[i]+sum;
                }
        System.out.println("Sum of array element:"+sum);
    }

}
