package educative.coderust.SrutiTest.String;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringPallendrom {
    public static void main(String[] args) throws IOException {
        System.out.println("Please enter one string");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s= br.readLine();
        Boolean flag=true;
        for (int i=0,j=s.length()-1;i<s.length();i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                flag=false;
            }
            if(i==j||j==i+1){
                break;
            }

        }
        if(flag){
            System.out.println("pallendrom");
        }else {
            System.out.println("not pallendrom");
        }
    }
}
