package educative.coderust.arrays;

/*
https://www.educative.io/courses/coderust-hacking-the-coding-interview/k5llE
 */

public class MaximumSumSlidingWindow {

    private static int maxValue(int[] array, int windowSize) {
        return maxValue(array, 0, windowSize-1, Integer.MIN_VALUE);
    }

    private static int maxValue(int[] array, int start, int end, int maxValue) {

        if (end >= array.length) {
            return maxValue;
        }

        int sum = 0;
        for(int i = start; i <= end; i++) {
            sum += array[i];
        }

        if ( sum > maxValue ) {
            maxValue = sum;
        }

        return  maxValue(array, start+1, end+1, maxValue);

    }

    public static void main(String[] args) {
        int[] sample1 = new int[]{-4,2,-5,3,6};

        System.out.println("Max values : " + maxValue(sample1, 3));
    }

}
