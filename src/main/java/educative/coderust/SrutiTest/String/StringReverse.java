package educative.coderust.SrutiTest.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StringReverse {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String sr=br.readLine();
        int c = 0;
        char[] str = sr.toCharArray() ;
        String temp;
        for(int i=sr.length()-1;i>=0;i--){
            str[c]= sr.charAt(i);

            c++;
        }
        System.out.println("Reverse string :"+ new String(str));
    }
}

