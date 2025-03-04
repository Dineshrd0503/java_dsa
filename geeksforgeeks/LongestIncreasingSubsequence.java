package geeksforgeeks;

import java.util.Arrays;


//Given an array arr[] of non-negative integers, the task is to find the length of the Longest Strictly Increasing Subsequence (LIS).
//
//A subsequence is strictly increasing if each element in the subsequence is strictly less than the next element.
//
//Examples:
//
//Input: arr[] = [5, 8, 3, 7, 9, 1]
//Output: 3
//Explanation: The longest strictly increasing subsequence could be [5, 7, 9], which has a length of 3.
//Input: arr[] = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
//Output: 6
//Explanation: One of the possible longest strictly increasing subsequences is [0, 2, 6, 9, 13, 15], which has a length of 6.
//Input: arr[] = [3, 10, 2, 1, 20]
//Output: 3
//Explanation: The longest strictly increasing subsequence could be [3, 10, 20], which has a length of 3.
//Constraints:
//        1 ≤ arr.size() ≤ 103
//        0 ≤ arr[i] ≤ 106

public class LongestIncreasingSubsequence {
    static int lis(int arr[]) {
        // code here
        int[][] dp=new int[arr.length][arr.length+1];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return findlength(0,-1,dp,arr.length,arr);

    }
    private static int findlength(int index,int prev_index,int[][] dp,int length,int[]arr){
        if(index==length)
            return 0;
        if(dp[index][prev_index+1]!=-1)
            return dp[index][prev_index+1];
        int len=0+findlength(index+1,prev_index,dp,length,arr);
        if(prev_index==-1||arr[index]>arr[prev_index])
            len=Math.max(len,1+findlength(index+1,index,dp,length,arr));
        return dp[index][prev_index+1]=len;
    }
    public static void main(String[] args) {
        System.out.println("Longest Increasing Subsequence");
        int[] arr={10,22,9,33,21,50,41,60,80};
        System.out.println(lis(arr));
    }
}
