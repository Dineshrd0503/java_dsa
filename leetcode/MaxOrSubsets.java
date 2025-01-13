package leetcode;

//Given an integer array nums, find the maximum possible bitwise OR of a subset of nums and return the number of different non-empty subsets with the maximum bitwise OR.
//
//An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b. Two subsets are considered different if the indices of the elements chosen are different.
//
//The bitwise OR of an array a is equal to a[0] OR a[1] OR ... OR a[a.length - 1] (0-indexed).
//
//
//
//Example 1:
//
//Input: nums = [3,1]
//Output: 2
//Explanation: The maximum possible bitwise OR of a subset is 3. There are 2 subsets with a bitwise OR of 3:
//        - [3]
//        - [3,1]
//Example 2:
//
//Input: nums = [2,2,2]
//Output: 7
//Explanation: All non-empty subsets of [2,2,2] have a bitwise OR of 2. There are 23 - 1 = 7 total subsets.
//Example 3:
//
//Input: nums = [3,2,1,5]
//Output: 6
//Explanation: The maximum possible bitwise OR of a subset is 7. There are 6 subsets with a bitwise OR of 7:
//        - [3,5]
//        - [3,1,5]
//        - [3,2,5]
//        - [3,2,1,5]
//        - [2,5]
//        - [2,1,5]

public class MaxOrSubsets {

    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        // Step 1: Find the maximum OR possible
        for (int num : nums) {
            maxOr |= num;
        }

        // Step 2: Use backtracking to count how many subsets achieve the maxOr
        return countSubsets(nums, 0, 0, maxOr);
    }

    // Helper method to recursively generate all subsets and count those with maxOr
    private int countSubsets(int[] nums, int idx, int currentOr, int maxOr) {
        // Base case: If we've considered all elements
        if (idx == nums.length) {
            // Check if the current subset's OR equals the max OR
            return currentOr == maxOr ? 1 : 0;
        }

        // Recursive case: Try including or excluding the current element

        // 1. Include nums[idx] in the current subset
        int include = countSubsets(nums, idx + 1, currentOr | nums[idx], maxOr);

        // 2. Exclude nums[idx] from the current subset
        int exclude = countSubsets(nums, idx + 1, currentOr, maxOr);

        // Return total count of subsets that match the max OR
        return include + exclude;
    }

    public static void main(String[] args) {
        MaxOrSubsets mos = new MaxOrSubsets();

        int[] nums1 = {3, 1};
        System.out.println("Result: " + mos.countMaxOrSubsets(nums1)); // Output: 2

        int[] nums2 = {2, 2, 2};
        System.out.println("Result: " + mos.countMaxOrSubsets(nums2)); // Output: 7
    }
}

