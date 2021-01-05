package educative.coderust.SrutiTest.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class WordReverse {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter a sentence");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String sentence=br.readLine();
        Stack<String> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<sentence.length();i++){
            if(sentence.charAt(i)==' '){
                st.push(sb.toString());
                sb=new StringBuilder();
            }
            else {
                sb.append(sentence.charAt(i));
            }
        }
        if(sb.length()>0){
            st.push(sb.toString());
        }
        while(!st.empty()) {
            System.out.print(st.pop() + " ");
        }

    }
}
