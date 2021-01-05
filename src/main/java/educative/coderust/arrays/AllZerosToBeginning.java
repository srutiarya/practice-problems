package educative.coderust.arrays;

import java.util.Arrays;

/*
https://www.educative.io/courses/coderust-hacking-the-coding-interview/k58JJ
 */
public class AllZerosToBeginning {

    static int[] zerosToBeginning(int[] arr) {
        for (int readIndex = arr.length - 1, writeIndex = arr.length - 1; readIndex >= 0 || writeIndex >= 0; ) {
            if (arr[readIndex] != 0) {
                arr[writeIndex] = arr[readIndex];
                writeIndex--;
            }
            readIndex --;

            if (readIndex == -1) {
                while (writeIndex != -1) {
                    arr[writeIndex] = 0;
                    writeIndex--;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] ar = {1, 10, 120, 0, 99, 63, 0, 88, 0, 0, 0, 0};
        System.out.println("Input -> " + Arrays.toString(ar));
        System.out.println("Output -> " + Arrays.toString(zerosToBeginning(ar)));
    }
}
