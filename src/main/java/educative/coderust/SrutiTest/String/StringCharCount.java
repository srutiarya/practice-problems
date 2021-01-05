package educative.coderust.SrutiTest.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class StringCharCount  {
    public static void main(String[] args) throws IOException {
        System.out.println("Please enter a string");
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String s= br.readLine();
        Map<Character,Integer> hashMap=new HashMap<>();
    for(int i=0;i<s.length();i++){
        if(hashMap.containsKey(s.charAt(i))){
            int x=hashMap.get(s.charAt(i))+1;
            hashMap.put(s.charAt(i),x);
        }else {
            hashMap.put(s.charAt(i),1);
        }

    }
        System.out.println(hashMap);

    }
}
