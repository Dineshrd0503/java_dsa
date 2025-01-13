package codingninjas;

import java.util.ArrayList;
import java.util.Arrays;

//Given 'N' number of intervals, where each interval contains two integers denoting the boundaries of the interval. The task is to merge all the overlapping intervals and return the list of merged intervals sorted in ascending order.
//
//Two intervals will be considered to be overlapping if the starting integer of one interval is less than or equal to the finishing integer of another interval, and greater than or equal to the starting integer of that interval.
//
//        Example:
//        for the given 5 intervals - [1,4], [3,5], [6,8], [10,12], [8,9].
//Since intervals [1,4] and [3,5] overlap with each other, we will merge them into a single interval as [1,5].
//
//Similarly [6,8] and [8,9] overlaps, we merge them into [6,9].
//
//Interval [10,12] does not overlap with any interval.
//
//Final List after merging overlapping intervals: [1,5], [6,9], [10,12]
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 100
//        1 <= N <= 1000
//        0 <= start, finish <= 10^9
//
//Where 'T' denotes the number of test cases, 'N' denotes the number of intervals respectively, 'start' and 'finish' are the starting and finishing times for intervals.
//
//Time Limit: 1 sec
//Sample Input 1:
//        1
//        2
//        1 3
//        3 5
//Sample Output 1:
//        1 5
//Explanation for Sample Input 1
//Since these two intervals overlap at point 3 so we merge them and the new interval becomes (1,5).
//Sample Input 2:
//        3
//        5
//        1 3 6 8 10
//        4 5 8 9 12
//        10
//        1 2 3 1 9 5 11 7 12 14
//        3 7 5 8 10 11 12 10 12 17
//        7
//        1 4 2 5 6 2 8
//        2 6 7 6 9 11 12
//Sample Output 2:
//        1 5
//        6 9
//        10 12
//        1 12
//        14 17
//        1 12

public class MergeOverLappingIntervals {
    public static ArrayList<ArrayList<Integer>> mergeIntervals(ArrayList<ArrayList<Integer>> intervals) {
        // WRITE YOUR CODE HEREanotherInteger
        intervals.sort((a,b)->a.get(0).compareTo(b.get(0)));

        ArrayList<ArrayList<Integer>> merged=new ArrayList<>();
        for(ArrayList<Integer> interval:intervals)
        {
            if(merged.isEmpty()||merged.get(merged.size()-1).get(1)<interval.get(0))
                merged.add(new ArrayList<>(interval));
            else
                merged.get(merged.size() - 1).set(1, Math.max(merged.get(merged.size() - 1).get(1), interval.get(1)));

        }
        return merged;	}
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();
        intervals.add(new ArrayList<>(Arrays.asList(1, 3)));
        intervals.add(new ArrayList<>(Arrays.asList(2, 6)));
        intervals.add(new ArrayList<>(Arrays.asList(8, 10)));
        intervals.add(new ArrayList<>(Arrays.asList(15, 18)));

        ArrayList<ArrayList<Integer>> mergedIntervals = mergeIntervals(intervals);

        for (ArrayList<Integer> interval : mergedIntervals) {
            for (int num : interval) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
