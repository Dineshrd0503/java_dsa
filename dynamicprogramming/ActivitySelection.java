package dynamicprogramming;
import java.util.Arrays;

public class ActivitySelection {
    /**
     * You are given a set of activities, each with a start time and a finish time,
     * represented by the arrays start[] and finish[], respectively. A single person 
     * can perform only one activity at a time, meaning no two activities can overlap. 
     * Your task is to determine the maximum number of activities that a person can 
     * complete in a day.
     *
     * Examples:
     *
     * Input: start[] = [1, 3, 0, 5, 8, 5], finish[] = [2, 4, 6, 7, 9, 9]
     * Output: 4
     * Explanation: A person can perform at most four activities. The maximum set of 
     * activities that can be executed is {0, 1, 3, 4}
     *
     * Input: start[] = [10, 12, 20], finish[] = [20, 25, 30]
     * Output: 1
     * Explanation: A person can perform at most one activity.
     *
     * Input: start[] = [1, 3, 2, 5], finish[] = [2, 4, 3, 6]
     * Output: 3
     * Explanation: A person can perform activities 0, 1 and 3.
     *
     * Constraints:
     * 1 ≤ start.size() = finish.size() ≤ 2*10^5
     * 1 ≤ start[i] ≤ finish[i] ≤ 10^9
     */

    public int activitySelection(int[] start, int[] finish) {
        int n = start.length;
        
        // Pair start and finish times and sort by finish times
        int[][] activities = new int[n][2];
        for (int i = 0; i < n; i++) {
            activities[i][0] = start[i];
            activities[i][1] = finish[i];
        }
        
        // Sort activities based on their finish times
        Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));
        
        // Greedily select activities
        int count = 0;
        int lastFinishTime = -1;
        
        for (int[] activity : activities) {
            if (activity[0] >= lastFinishTime) {
                count++;
                lastFinishTime = activity[1];
            }
        }
        
        return count; // Return the maximum number of non-overlapping activities
    }

    public static void main(String[] args) {
        ActivitySelection as = new ActivitySelection();
        
        // Test case 1
        int[] start1 = {1, 3, 0, 5, 8, 5};
        int[] finish1 = {2, 4, 6, 7, 9, 9};
        System.out.println(as.activitySelection(start1, finish1)); // Output: 4
        
        // Test case 2
        int[] start2 = {10, 12, 20};
        int[] finish2 = {20, 25, 30};
        System.out.println(as.activitySelection(start2, finish2)); // Output: 1
        
        // Test case 3
        int[] start3 = {1, 3, 2, 5};
        int[] finish3 = {2, 4, 3, 6};
        System.out.println(as.activitySelection(start3, finish3)); // Output: 3
    }
}
