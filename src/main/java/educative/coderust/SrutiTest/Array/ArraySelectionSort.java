package educative.coderust.SrutiTest.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class ArraySelectionSort {
        public static void main(String[] args) throws IOException {
            // Write your code here
            int[] arr = new int[10];
            System.out.println("please enter 10 numbers");
            for (int i = 0; i < arr.length; i++) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                int str = Integer.parseInt(reader.readLine());
                arr[i] = str;
            }
            System.out.println("array:" + Arrays.toString(arr));

            for (int i = 0; i < arr.length; i++) {

                    for (int j = i + 1; j < arr.length; j++) {
                        if (arr[j] < arr[i]) {
                            int temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;


                    }

                }

            }
            System.out.println("sorted array:" + Arrays.toString(arr));
        }
    }


