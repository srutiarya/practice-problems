package educative.coderust.SrutiTest.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StringDuplicate {
    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("Enter a string");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();

            LinkedHashSet<Character> ls =new LinkedHashSet<>();
            for(int i=0;i<s.length();i++){
                ls.add(s.charAt(i));
            }
            StringBuilder sb=new StringBuilder();
            for (Character ch:ls) {
                sb.append(ch);
            }
            System.out.println("result string:"+" "+sb);
        }
    }
}
