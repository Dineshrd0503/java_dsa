package arrays;

/*
LeetCode Problem: Find Minimum Operations to Make All Elements Divisible by Three

Problem Statement:
You are given an integer array nums.
In one operation, you can add or subtract 1 from any element of nums.

Return the minimum number of operations to make all elements of nums divisible by 3.

Examples:
Input: nums = [1,2,3,4]
Output: 3
Explanation:
All array elements can be made divisible by 3 using 3 operations:
- Subtract 1 from 1. (1 -> 0)
- Add 1 to 2.       (2 -> 3)
- Subtract 1 from 4. (4 -> 3)

Input: nums = [3,6,9]
Output: 0

Constraints:
- 1 <= nums.length <= 50
- 1 <= nums[i] <= 50
*/

import java.util.*;

public class FindMinOperationsDivisibleByThree {
    public static int minOperations(int[] nums) {
        int totalOps = 0;
        for (int num : nums) {
            int rem = num % 3;
            if (rem != 0) {
                // Only 1 operation needed for rem == 1 or rem == 2
                totalOps += 1;
            }
        }
        return totalOps;
    }

    // Example usage
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {3, 6, 9};
        int[] nums3 = {1, 2, 2, 1, 3};

        System.out.println("Minimum operations for [1,2,3,4] => " + minOperations(nums1)); // 3
        System.out.println("Minimum operations for [3,6,9] => " + minOperations(nums2)); // 0
        System.out.println("Minimum operations for [1,2,2,1,3] => " + minOperations(nums3)); // 4
    }
}
