package educative.coderust.SrutiTest.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayShift {
    public static void main(String[] args) throws IOException {
        String[] arr=new String[5];
        for(int i=0;i< arr.length;i++) {
            System.out.println("Enter element");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String in = br.readLine();
            if (arr[0] == null) {
                arr[0] = in;
            } else {
                for (int j = i; j > 0; j--) {
                    arr[j] = arr[j - 1];

                }
                arr[0]=in;
                System.out.println("Array : " + Arrays.toString(arr));
            }


            /*if(arr[0]!=null){
                if(i+1==arr.length){
                    break;
                }else {
                    arr[i + 1] = arr[0];
                }
            }*/
           // arr[0]=in;
        }
        System.out.println("Final array: "+ Arrays.toString(arr));
    }
}
