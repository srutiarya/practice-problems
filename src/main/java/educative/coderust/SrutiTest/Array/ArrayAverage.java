package educative.coderust.SrutiTest.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayAverage {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter array length");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int arraylen= Integer.parseInt(reader.readLine());
        int[] arr=new int[arraylen];
        System.out.println("Enter 5 element");
        for(int i=0;i<arr.length;i++) {
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            int ele = Integer.parseInt(reader1.readLine());
            arr[i]=ele;
        }
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
        }
        System.out.println("Average:"+sum/arraylen);
    }
}
