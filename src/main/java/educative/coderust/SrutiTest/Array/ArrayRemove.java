package educative.coderust.SrutiTest.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayRemove {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the array length");
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        int arrlen = Integer.parseInt(reader1.readLine());
        int[] arr = new int[arrlen];
        System.out.println("Enter Array Elemnt");
        for (int i = 0; i < arrlen; i++) {
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
            int arrele = Integer.parseInt(reader2.readLine());
            arr[i] = arrele;
        }
        System.out.println("Array"+ Arrays.toString(arr));
        System.out.println("Enter the specific value");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int val = Integer.parseInt(reader.readLine());
        for(int i=0;i<arrlen;i++){
            if(val==arr[i]){
                arr[i]=arr[i+1];
            }
        }
        System.out.println("Final Array"+ Arrays.toString(arr));
    }

}
