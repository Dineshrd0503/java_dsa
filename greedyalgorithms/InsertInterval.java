package greedyalgorithms;

/*
Problem Statement (LeetCode 57: Insert Interval):
Given a set of non-overlapping intervals represented as an array of intervals (where each interval is an array of two integers [start, end]), and a new interval [start, end], insert the new interval into the intervals list, merging any overlapping intervals. The intervals are initially sorted by start time.

Constraints:
- 0 <= intervals.length <= 10^4
- intervals[i].length == 2
- 0 <= intervals[i][0] <= intervals[i][1] <= 10^5
- newInterval.length == 2
- 0 <= newInterval[0] <= newInterval[1] <= 10^5

Sample Test Cases:
1. Input: intervals = [[1, 3], [4, 5], [6, 7], [8, 10]], newInterval = [5, 6]
   Output: [[1, 3], [4, 7], [8, 10]]
   Explanation: The new interval [5, 6] overlaps with [4, 5], merging to [4, 7].
2. Input: intervals = [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]], newInterval = [4, 9]
   Output: [[1, 2], [3, 10], [12, 16]]
   Explanation: The new interval [4, 9] overlaps with [3, 5], [6, 7], and [8, 10], merging to [3, 10].
3. Input: intervals = [], newInterval = [4, 9]
   Output: [[4, 9]]
   Explanation: No existing intervals, so return the new interval.
4. Input: intervals = [[1, 5]], newInterval = [2, 3]
   Output: [[1, 5]]
   Explanation: The new interval [2, 3] is contained within [1, 5], so no change after merging.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class InsertInterval {
    public ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        // Add all intervals that come before the new interval (no overlap)
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals with the new interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Add the remaining intervals that come after the new interval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        InsertInterval solution = new InsertInterval();

        // Test Case 1
        int[][] intervals1 = {{1, 3}, {4, 5}, {6, 7}, {8, 10}};
        int[] newInterval1 = {5, 6};
        ArrayList<int[]> result1 = solution.insertInterval(intervals1, newInterval1);
        System.out.println("Test Case 1: " + Arrays.deepToString(result1.toArray()));

        // Test Case 2
        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 9};
        ArrayList<int[]> result2 = solution.insertInterval(intervals2, newInterval2);
        System.out.println("Test Case 2: " + Arrays.deepToString(result2.toArray()));

        // Test Case 3
        int[][] intervals3 = {};
        int[] newInterval3 = {4, 9};
        ArrayList<int[]> result3 = solution.insertInterval(intervals3, newInterval3);
        System.out.println("Test Case 3: " + Arrays.deepToString(result3.toArray()));

        // Test Case 4
        int[][] intervals4 = {{1, 5}};
        int[] newInterval4 = {2, 3};
        ArrayList<int[]> result4 = solution.insertInterval(intervals4, newInterval4);
        System.out.println("Test Case 4: " + Arrays.deepToString(result4.toArray()));
    }
}
