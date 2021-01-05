package educative.coderust.arrays;

import java.util.*;

public class PairWithGivenSumInArray {

    static List<Pair> findPair(int[] arr, int sum) {

        Map<Integer, Integer> map =  new HashMap<Integer, Integer>();
        List<Pair> pairs = new ArrayList<Pair>();

        for (int num : arr) {
            if (map.containsKey(sum - num)) {
                pairs.add(new Pair(sum - num, num));
            } else {
                map.put(num, null);
            }
        }

        return pairs;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 2, 8, 4, 3};
        int sum = 10;
        System.out.println(Arrays.toString(arr) + " | Sum : " + sum + " | Pairs : " + findPair(arr, sum));
    }
}


class Pair {

    private int part1;
    private int part2;

    public Pair(int startTime, int endTime) {
        this.part1 = startTime;
        this.part2 = endTime;
    }

    public int getPart1() {
        return part1;
    }

    public int getPart2() {
        return part2;
    }

    public void setPart1(int part1) {
        this.part1 = part1;
    }

    public void setPart2(int part2) {
        this.part2 = part2;
    }

    @Override
    public String toString() {
        return "(" + part1 + ", " + part2 + ")";
    }
}