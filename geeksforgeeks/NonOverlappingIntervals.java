package geeksforgeeks;

import java.util.Arrays;
//Given a 2D array intervals[][] of representing intervals where intervals [i] = [starti, endi ]. Return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
//
//        Examples:
//
//Input: intervals[][] = [[1, 2], [2, 3], [3, 4], [1, 3]]
//Output: 1
//Explanation: [1, 3] can be removed and the rest of the intervals are non-overlapping.
//        Input: intervals[][] = [[1, 3], [1, 3], [1, 3]]
//Output: 2
//Explanation: You need to remove two [1, 3] to make the rest of the intervals non-overlapping.
//        Input: intervals[][] = [[1, 2], [5, 10], [18, 35], [40, 45]]
//Output: 0
//Explanation: All ranges are already non overlapping.
public class NonOverlappingIntervals {
    static int minRemoval(int intervals[][]) {
        Arrays.sort(intervals,(a, b) -> Integer.compare(a[1],b[1]));
        int end=intervals[0][1];
        int count=1;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=end){
                count++;
                end=intervals[i][1];
            }

        }
        return intervals.length-count;
        // code here
    }
    public static void main(String[] args) {
        int intervals[][]={{1,2},{2,3},{3,4},{1,3}};
        System.out.println(minRemoval(intervals));
    }


}