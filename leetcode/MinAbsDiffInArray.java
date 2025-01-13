package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
//
//Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
//
//a, b are from arr
//a < b
//b - a equals to the minimum absolute difference of any two elements in arr
//
//
//Example 1:
//
//Input: arr = [4,2,1,3]
//Output: [[1,2],[2,3],[3,4]]
//Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
//        Example 2:
//
//Input: arr = [1,3,6,10,15]
//Output: [[1,3]]
//Example 3:
//
//Input: arr = [3,8,-10,23,19,-4,-14,27]
//Output: [[-14,-10],[19,23],[23,27]]
//
//
//Constraints:
//
//        2 <= arr.length <= 105
//        -106 <= arr[i] <= 106
public class MinAbsDiffInArray {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        List<List<Integer>> result=new ArrayList<>();
        int mindiff=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            int diff=Math.abs(arr[i]-arr[i-1]);
            if(diff<mindiff)
                mindiff=diff;

        }
        for(int i=1;i<n;i++){
            int diff=Math.abs(arr[i]-arr[i-1]);
            if(diff==mindiff){
                List<Integer> pair=Arrays.asList(arr[i-1],arr[i]);
                result.add(pair);

            }
        }
        return result;

    }
    public static void main(String[] args) {
        MinAbsDiffInArray minAbsDiffInArray=new MinAbsDiffInArray();
        int[] arr={4,2,1,3};
        List<List<Integer>> result=minAbsDiffInArray.minimumAbsDifference(arr);
        for(List<Integer> pair:result){
            for(int num:pair){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}
