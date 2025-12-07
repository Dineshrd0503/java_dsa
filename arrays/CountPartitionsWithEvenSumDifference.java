package arrays;

/*
LeetCode 3432. Count Partitions with Even Sum Difference

You are given an integer array nums of length n.

A partition is defined as an index i where 0 <= i < n - 1,
splitting the array into two non-empty subarrays such that:
  - Left subarray contains indices [0, i]
  - Right subarray contains indices [i + 1, n - 1]

Return the number of partitions where the difference between the sum
of the left and right subarrays is even.

Example 1:
Input:  nums = [10,10,3,7,6]
Output: 4

Example 2:
Input:  nums = [1,2,2]
Output: 0

Example 3:
Input:  nums = [2,4,6,8]
Output: 3

Constraints:
  2 <= n == nums.length <= 100
  1 <= nums[i] <= 100
*/

import java.util.Arrays;

public class CountPartitionsWithEvenSumDifference {

    // LeetCode-style solution method
    public static int countPartitions(int[] nums) {
        // Compute total sum of the array
        int total = Arrays.stream(nums).sum(); // [web:44]

        // Key observation:
        // For any partition, (leftSum - rightSum) has the same parity as total sum.
        // So if total is odd -> no partition has even difference.
        // If total is even -> all (n - 1) partitions have even difference. [web:47][web:57]
        if ((total & 1) == 1) {
            return 0;
        }
        return nums.length - 1;
    }

    // Demo with static inputs
    public static void main(String[] args) {
        int[] nums1 = {10, 10, 3, 7, 6};
        int[] nums2 = {1, 2, 2};
        int[] nums3 = {2, 4, 6, 8};

        System.out.println(countPartitions(nums1)); // expected 4
        System.out.println(countPartitions(nums2)); // expected 0
        System.out.println(countPartitions(nums3)); // expected 3
    }
}
