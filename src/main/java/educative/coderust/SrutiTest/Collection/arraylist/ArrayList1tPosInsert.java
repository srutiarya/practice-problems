package educative.coderust.SrutiTest.Collection.arraylist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ArrayList1tPosInsert {
    public static void main(String[] args) throws IOException {
        List<String> list=new ArrayList<>();
        for(int i=0;i<=10;i++){
            System.out.println("Enter element to add");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String s=br.readLine();
               list.add(0,s);
            }
        System.out.println("Final List : "+list);
            }
        }


