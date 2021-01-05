package educative.coderust.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://www.educative.io/courses/coderust-hacking-the-coding-interview/lY7or
 */
public class MergeArrayWithOverlappingIntervals {

    static Pair[] merge(Pair[] timeRanges) {

        Pair temp = null;
        List<Pair> timeRangeList = new ArrayList<Pair>();
        for(Pair timeRange : timeRanges) {
            if (temp == null) {
                temp = timeRange;
                continue;
            }

            if(temp.getPart2() >= timeRange.getPart1()) {
                temp.setPart2(timeRange.getPart2());
            } else {
                timeRangeList.add(temp);
                temp = timeRange;
            }

        }

        timeRangeList.add(temp);

        return timeRangeList.toArray(new Pair[timeRangeList.size()]);

    }

    public static void main(String[] args) {
        Pair[] timeRanges = {new Pair(1,5), new Pair(3,7), new Pair(4,6), new Pair(6,8),
                new Pair(10, 12), new Pair(12, 15)};

        System.out.println("Original Array -> " + Arrays.toString(timeRanges));
        System.out.println("Merged Array -> " + Arrays.toString(merge(timeRanges)));

    }

}

class TimeRange {

    private int startTime;
    private int endTime;

    public TimeRange(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "(" + startTime + ", " + endTime + ")";
    }
}