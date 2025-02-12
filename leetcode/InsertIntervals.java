package leetcode;

import java.util.ArrayList;
import java.util.List;
//You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
//
//Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
//
//Return intervals after the insertion.
//
//Note that you don't need to modify intervals in-place. You can make a new array and return it.
//
//
//
//Example 1:
//
//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//Output: [[1,5],[6,9]]
//Example 2:
//
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]
//Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newinterval) {
        List<int[]> result=new ArrayList();
        int i=0,j=intervals.length;
        while(i<j&&intervals[i][1]<newinterval[0]){
            result.add(intervals[i]);
            i++;

        }
        while(i<j&&intervals[i][0]<=newinterval[1]){
            newinterval[0]=Math.min(intervals[i][0],newinterval[0]);
            newinterval[1]=Math.max(intervals[i][1],newinterval[1]);

            i++;


        }
        result.add(newinterval);
        while(i<j){
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals={{1,3},{6,9}};
        int[] newinterval={2,5};
        InsertIntervals obj=new InsertIntervals();
        int[][] result=obj.insert(intervals,newinterval);
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[i].length;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}
