package binarysearch;

import java.util.Arrays;

//Given an array arr[] of N elements and a number K., split the given array into K subarrays such that the maximum subarray sum achievable out of K subarrays formed is minimum possible. Find that possible subarray sum.
//
//        Example 1:
//
//Input:
//N = 4, K = 3
//arr[] = {1, 2, 3, 4}
//Output: 4
//Explanation:
//Optimal Split is {1, 2}, {3}, {4}.
//Maximum sum of all subarrays is 4,
//which is minimum possible for 3 splits.
//        Example 2:
//
//Input:
//N = 3, K = 2
//A[] = {1, 1, 2}
//Output:
//        2
//Explanation:
//Splitting the array as {1,1} and {2} is optimal.
//This results in a maximum sum subarray of 2.
//Your Task:
//You do not have to take any input or print anything. The task is to complete the function splitArray() which returns the maximum sum subarray after splitting the array into K subarrays such that maximum sum subarray is minimum possible.
//
//Expected Time Complexity: O(N*log(sum(arr))).
//Expected Auxiliary Space: O(1).
//
//Constraints:
//        1 ≤ N ≤ 105
//        1 ≤ K ≤ N
//1 ≤ arr[i] ≤ 104





public class SplitArrayLargestSum {
    static int splitArray(int[] arr , int N, int k) {
        // code here

        int low= Arrays.stream(arr).max().getAsInt();
        int high=Arrays.stream(arr).sum();
        while(low<=high){
            int mid=(low+high)/2;
            int painters=findpainters(arr,mid);
            if(painters>k)
                low=mid+1;
            else
                high=mid-1;
        }
        return low;
    }
    private static int findpainters(int[] arr,int maxwork){
        int painters=1;
        int sum=0;
        for(int board:arr){
            if(board+sum<=maxwork)
                sum+=board;
            else{
                painters++;
                sum=board;
            }
        }
        return painters;
    }
    public static void main(String[] args) {
        int[] arr={10,20,30,40};
        int N=4;
        int k=2;
        System.out.println(splitArray(arr,N,k));
    }
}
