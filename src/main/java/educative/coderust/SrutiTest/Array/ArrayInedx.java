package educative.coderust.SrutiTest.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayInedx {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int val = Integer.parseInt(reader.readLine());
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        int arrlen = Integer.parseInt(reader1.readLine());
        int[] arr = new int[arrlen];
        for (int i = 0; i < arrlen; i++) {
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
            int arrele = Integer.parseInt(reader2.readLine());
            arr[i] = arrele;
        }

        for(int i=0;i<arrlen;i++){
            if(val==arr[i]){
                System.out.println("Index:"+i);
            }
        }
    }
}
