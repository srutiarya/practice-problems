package educative.coderust.arrays;

import java.util.Arrays;

public class QuickSort {

    private int[] ar;

    public int[] sort(int[] ar) {
        this.ar = ar;
        sort(0, ar.length);
        return ar;

    }

    private void sort(int l, int h) {
        int p = partition(l, h);
        if (p == -1) {
            return;
        }
        sort(l, p);
        sort(p+1, h);
    }

    private int partition(int l, int h) {

        if (l == h) {
            return -1;
        }

        int pivot = ar[l];
        System.out.printf("Pivot : %d, l : %d, h : %d%n",pivot, l, h);
        int i = l;
        int j = h;

        while (i < j) {
            do {
                i ++;
            } while (i < h && ar[i] < pivot);
            System.out.printf("i = %d%n", i);

            do {
                j --;
            } while (j > l && ar[j] > pivot);
            System.out.printf("j = %d%n", j);


            if (i <  j) {
                swap(i, j);
            }

        }
        if (l < j) {
            swap(l, j);
        }
        System.out.println(Arrays.toString(ar));
        return j;
    }

    private void swap(int i, int j) {
        ar[i] = ar[i] + ar[j];
        ar[j] = ar[i] - ar[j];
        ar[i] = ar[i] - ar[j];
    }


    public static void main(String[] args) {
        int[] ar = {8, 4, 6, 1, 22, 5, 9};
        System.out.println("Original ->" + Arrays.toString(ar));

        System.out.println("Sorted -> " + Arrays.toString(new QuickSort().sort(ar)));
    }


}
