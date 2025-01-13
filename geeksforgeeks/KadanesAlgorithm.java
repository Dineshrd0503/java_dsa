package geeksforgeeks;
//Given an integer array arr[]. You need to find the maximum sum of a subarray.
//
//Examples:
//
//Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
//Output: 11
//Explanation: The subarray {7, -1, 2, 3} has the largest sum 11.
//Input: arr[] = [-2, -4]
//Output: -2
//Explanation: The subarray {-2} has the largest sum -2.
//Input: arr[] = [5, 4, 1, 7, 8]
//Output: 25
//Explanation: The subarray {5, 4, 1, 7, 8} has the largest sum 25.


public class KadanesAlgorithm {
    public static int maxSubarraySum(int[] arr) {
        int max=Integer.MIN_VALUE,sum=0;
        for(int n:arr){
            sum+=n;
            if(sum>max)
                max=sum;
            if(sum<0)
                sum=0;

        }
        return max;

        // Your code here
    }
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int maxSum = maxSubarraySum(arr);
        System.out.println("Maximum subarray sum is: " + maxSum);
    }
}
