package educative.coderust.arrays;

import java.util.Arrays;

/*
https://www.educative.io/courses/coderust-hacking-the-coding-interview/j2pGW
 */
public class StocksBuySellMaxProfit {

    static int maxProfit(int[] stockPrices) {

        int maxProfit = Integer.MIN_VALUE;

        int sumTotal = 0;

        for(int i = 1; i < stockPrices.length; i++) {
            sumTotal = sumTotal + (stockPrices[i] - stockPrices[i-1]);

            if (sumTotal > maxProfit) {
                maxProfit = sumTotal;
            }

            if (sumTotal < 0) {
                sumTotal = 0;
            }

        }

        return maxProfit;

    }

    public static void main(String[] args) {

        int[] arr1 = {8, 5, 12, 9, 19, 1};

        int[] arr2 = {21, 12, 11, 9, 6, 3};

        System.out.println(Arrays.toString(arr1) + " -> " + maxProfit(arr1));
        System.out.println(Arrays.toString(arr2) + " -> " + maxProfit(arr2));


    }

}
