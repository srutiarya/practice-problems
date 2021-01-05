package educative.coderust.SrutiTest.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayZeroSeparate {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter 10 elements");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[] arr=new int[10];
        for(int i=0;i<arr.length;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("array : "+ Arrays.toString(arr));

        for(int i=arr.length-1,j=arr.length-1;i>=0||j>=0;i--){
            if(i>=0 && arr[i]!=0){
                arr[j]=arr[i];
                j--;
            }
            if(i<0){
                arr[j]=0;
                j--;
            }
            System.out.println("arrays : "+Arrays.toString(arr));
        }
        System.out.println("final array : "+Arrays.toString(arr));
    }
}
