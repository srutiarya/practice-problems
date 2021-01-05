package educative.coderust.arrays;

/*
https://www.educative.io/courses/coderust-hacking-the-coding-interview/lYg2l
 */
public class LowHighIndexOfKeyInSortedArray {
    static int findLowIndex(int[] arr, int key) {
        return findLowIndex(arr, key, 0, arr.length - 1);
    }

    static int findLowIndex(int[] arr, int key, int startIndex, int endIndex) {

        if (startIndex > endIndex) {
            return -2;
        }

        int midIndex = startIndex + ((endIndex - startIndex) / 2);

        if (arr[midIndex] == key && arr[midIndex - 1] < key) {
            return  midIndex;
        } else if (key <= arr[midIndex]) {
            return  findLowIndex(arr, key, startIndex, midIndex - 1);
        } else if (key > arr[midIndex]) {
            return  findLowIndex(arr, key, midIndex + 1, endIndex);
        }

        return -2;

    }

    static int findHighIndex(int[] arr, int key) {
        return findHighIndex(arr, key, 0, arr.length - 1);
    }

    static int findHighIndex(int[] arr, int key, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -2;
        }

        int midIndex = startIndex + ((endIndex - startIndex) / 2);

        if (arr[midIndex] == key && arr[midIndex + 1] > key) {
            return  midIndex;
        } else if (key < arr[midIndex]) {
            return  findHighIndex(arr, key, startIndex, midIndex - 1);
        } else if (key >= arr[midIndex]) {
            return  findHighIndex(arr, key, midIndex + 1, endIndex);
        }

        return -2;
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6};

        System.out.println("Low Index  : " + findLowIndex(arr, 3));
        System.out.println("High Index  : " + findHighIndex(arr, 3));

    }
}
