package educative.coderust.arrays;

/*
https://www.educative.io/courses/coderust-hacking-the-coding-interview/kR7nE
 */
public class RotatedArraySearch {

    public static int findIndex(int[] array, int element) {
        return findIndex(array, 0, array.length - 1, element);
    }

    public static int findIndex(int[] array, int startIndex, int lastIndex, int element) {

        if (startIndex > lastIndex) {
            return -1;
        }

        int midIndex = startIndex + ((lastIndex - startIndex) / 2 );

        if (array[midIndex] == element) {
            return midIndex;
        }

        if (array[startIndex] <= array[midIndex] && element <= array[midIndex] && element >= array[startIndex]) {
            return findIndex(array, startIndex, midIndex - 1, element);
        }

        else if (array[midIndex] <= array[lastIndex] && element >= array[midIndex] && element <= array[lastIndex]) {
            return findIndex(array, midIndex + 1, lastIndex, element);
        }

        else if (array[lastIndex] <= array[midIndex]) {
            return findIndex(array, midIndex + 1, lastIndex, element);
        }

        else if (array[startIndex] >= array[midIndex]) {
            return findIndex(array, startIndex, midIndex - 1, element);
        }

        return -1;

    }

    public static void main(String[] args) {

        int[] v1 = {6, 7, 1, 2, 3, 4, 5};
        System.out.println("Key(3) found at: " + findIndex(v1, 3));

    }



}
