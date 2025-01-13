package geeksforgeeks;
//Given an array of Intervals arr[][], where arr[i] = [starti, endi]. The task is to merge all of the overlapping Intervals.
//
//        Examples:
//
//        Input: arr[][] = [[1,3],[2,4],[6,8],[9,10]]
//        Output: [[1,4], [6,8], [9,10]]
//        Explanation: In the given intervals we have only two overlapping intervals here, [1,3] and [2,4] which on merging will become [1,4]. Therefore we will return [[1,4], [6,8], [9,10]].
//        Input: arr[][] = [[6,8],[1,9],[2,4],[4,7]]
//        Output: [[1,9]]
//        Explanation: In the given intervals all the intervals overlap with the interval [1,9]. Therefore we will return [1,9].
//        Constraints:
//        1 ≤ arr.size() ≤ 105
//        0 ≤ starti ≤ endi ≤ 105


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverLappingIntervals {
    public List<int[]> mergeOverlap(int[][] arr) {
        // Code here // Code here
        int n=arr.length;
        Arrays.sort(arr,(a, b) -> Integer.compare(a[0],b[0]));
        List<int[]> merged=new ArrayList<>();
        merged.add(arr[0]);
        for(int i=1;i<n;i++){
            int[] lastmerged=merged.get(merged.size()-1);
            if(arr[i][0]<=lastmerged[1])
                lastmerged[1]=Math.max(lastmerged[1],arr[i][1]);
            else{
                merged.add(arr[i]);
            }
        }
        return merged;
    }
    public static void main(String[] args) {
        MergeOverLappingIntervals mergeOverLappingIntervals=new MergeOverLappingIntervals();
        int[][] arr={{1,3},{2,6},{8,10},{15,18}};
        List<int[]> result=mergeOverLappingIntervals.mergeOverlap(arr);
        for(int[] res:result){
            System.out.println(res[0]+" "+res[1]);
        }
    }
}
