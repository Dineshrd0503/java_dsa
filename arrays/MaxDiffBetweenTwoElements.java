package arrays;

/*
 * Problem Statement:
 * Given a 0-indexed integer array nums of size n, find the maximum difference nums[j] - nums[i]
 * where 0 <= i < j < n and nums[i] < nums[j]. Return the maximum difference, or -1 if no such pair exists.
 *
 * Constraints (assumed):
 * - 1 ≤ n ≤ 10^5
 * - -10^9 ≤ nums[i] ≤ 10^9
 * Time Limit: 1 sec
 *
 * Examples:
 * Input: nums = [7,1,5,4]
 * Output: 4
 * Explanation: Max difference is nums[2] - nums[1] = 5 - 1 = 4 (i=1, j=2).
 *
 * Input: nums = [9,4,3,2]
 * Output: -1
 * Explanation: No i < j exists where nums[i] < nums[j].
 *
 * Input: nums = [1,5,2,10]
 * Output: 9
 * Explanation: Max difference is nums[3] - nums[0] = 10 - 1 = 9 (i=0, j=3).
 */
public class MaxDiffBetweenTwoElements {
    /*
     * Finds the maximum difference nums[j] - nums[i] where i < j and nums[i] < nums[j].
     * Uses a single pass, tracking the minimum element seen so far.
     * @param nums Input array
     * @return Maximum difference, or -1 if no valid pair exists
     */
    public int maximumDifference(int[] nums) {
        if (nums.length < 2) {
            return -1; // No valid i < j possible
        }

        int minSoFar = nums[0]; // Track minimum element seen
        int maxDiff = -1; // Track maximum difference

        // Iterate from index 1 to compare with previous elements
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] > minSoFar) {
                // Valid pair found, update max difference
                maxDiff = Math.max(maxDiff, nums[j] - minSoFar);
            }
            // Update minimum seen so far
            minSoFar = Math.min(minSoFar, nums[j]);
        }

        return maxDiff; // Returns -1 if no valid pair was found
    }

    /*
     * Main method to test maximumDifference with static inputs.
     */
    public static void main(String[] args) {
        MaxDiffBetweenTwoElements solution =new MaxDiffBetweenTwoElements();
        // Test Case 1: Example 1
        int[] nums1 = {7, 1, 5, 4};
        System.out.println("Test Case 1: nums = [7,1,5,4]");
        System.out.println("Output: " + solution.maximumDifference(nums1)); // Expected: 4

        // Test Case 2: Example 2
        int[] nums2 = {9, 4, 3, 2};
        System.out.println("\nTest Case 2: nums = [9,4,3,2]");
        System.out.println("Output: " + solution.maximumDifference(nums2)); // Expected: -1

        // Test Case 3: Example 3
        int[] nums3 = {1, 5, 2, 10};
        System.out.println("\nTest Case 3: nums = [1,5,2,10]");
        System.out.println("Output: " + solution.maximumDifference(nums3)); // Expected: 9

        // Test Case 4: Edge case with single element
        int[] nums4 = {1};
        System.out.println("\nTest Case 4: nums = [1]");
        System.out.println("Output: " + solution.maximumDifference(nums4)); // Expected: -1
    }
}