package geeksforgeeks;

import java.util.ArrayList;
//Geek has an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith event and intervals is sorted in ascending order by starti. He wants to add a new interval newInterval= [newStart, newEnd] where newStart and newEnd represent the start and end of this interval.
//
//Help Geek to insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
//
//Examples:
//
//Input: intervals = [[1,3], [4,5], [6,7], [8,10]], newInterval = [5,6]
//Output: [[1,3], [4,7], [8,10]]
//Explanation: The newInterval [5,6] overlaps with [4,5] and [6,7].
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,9]
//Output: [[1,2], [3,10], [12,16]]
//Explanation: The new interval [4,9] overlaps with [3,5],[6,7],[8,10].


public class InsertInterval {
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newinterval) {
        // code here
        ArrayList<int[]> ans=new ArrayList();
        int i=0,j=intervals.length;
        while(i<j&&intervals[i][1]<newinterval[0]){
            ans.add(intervals[i]);
            i++;
        }
        while(i<j&&intervals[i][0]<=newinterval[1]){
            newinterval[0]=Math.min(intervals[i][0],newinterval[0]);
            newinterval[1]=Math.max(intervals[i][1],newinterval[1]);
            i++;
        }
        ans.add(newinterval);
        while(i<j){
            ans.add(intervals[i]);
            i++;
        }
        return ans;


    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newinterval = {2, 5};
        ArrayList<int[]> result = insertInterval(intervals, newinterval);
        for (int[] arr : result) {
            System.out.println(arr[0] + " " + arr[1]);
        }
    }

}
