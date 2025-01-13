package codingninjas;
//Given an integer array nums, find the
//subarray
//with the largest sum, and return its sum.
//
//
//
//Example 1:
//
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: The subarray [4,-1,2,1] has the largest sum 6.
//Example 2:
//
//Input: nums = [1]
//Output: 1
//Explanation: The subarray [1] has the largest sum 1.
//Example 3:
//
//Input: nums = [5,4,-1,7,8]
//Output: 23
//Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

public class MaxSubArraySum {
    public static int maxSubArray(int[] nums) {
        int sum=0,max=Integer.MIN_VALUE;
        for(int n:nums){
            sum+=n;
            if(sum>max)
                max=sum;
            if(sum<0)
                sum=0;

        }
        return max;

    }

    public static void main(String[] args) {
        System.out.println("finding max sum formed by subarrays");
        int a[]={5,3,8,1,25,7,9,0};
        System.out.println("max sum is "+maxSubArray(a));
    }

}
