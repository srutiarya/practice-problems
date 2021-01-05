package educative.coderust.arrays;

/*
https://www.educative.io/courses/coderust-hacking-the-coding-interview/k5qJx
 */

public class BinarySearch {

    public static int findIndex(int element, int[] array) {
        return findIndex(element, 0, array.length - 1, array);
    }

    private static int findIndex(int element, int startIndex, int endIndex, int[] array) {

        if (startIndex > endIndex) {
            return -1;
        }
        System.out.println("Start Index : " + startIndex + " | End Index : " + endIndex);

        int index = startIndex + ((endIndex - startIndex) / 2);

        if (array[index] == element) {
            return index;
        } else if (element < array[index]) {
            return findIndex(element, startIndex, index - 1, array);
        } else {
            return findIndex(element, index + 1, endIndex, array);
        }

    }

    public static void main(String[] args) {
        int[] sample1 = new int[]{1,10,20,47,59,63,75,88,99,107,120,133,155,162,176,188,199,200,210,222};

        System.out.println("Index for '47' is " + findIndex(47, sample1));

    }

}
