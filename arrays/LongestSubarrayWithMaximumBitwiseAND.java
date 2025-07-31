/**
 * Problem Statement:
 * Find the length of the longest subarray with the maximum possible bitwise AND value
 * from the given integer array nums.
 * 
 * Examples:
 * - Input: nums = [1, 2, 3, 3, 2, 2] -> Output: 2
 * - Input: nums = [1, 2, 3, 4] -> Output: 1
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - 1 <= nums[i] <= 10^6
 * 
 * Date: 11:42 AM IST, Wednesday, July 30, 2025
 */
package arrays;
public class LongestSubarrayWithMaximumBitwiseAND{
    /**
     * Finds the length of the longest subarray with the maximum bitwise AND.
     * 
     * @param nums The input integer array
     * @return The length of the longest subarray with maximum bitwise AND
     */
    public int longestSubarray(int[] nums) {
        int max_val = 0;    // Tracks the maximum value (which is also the max AND for a single element)
        int ans = 0;        // Stores the length of the longest subarray with max AND
        int current_streak = 0; // Tracks the current streak of elements equal to max_val

        for (int num : nums) {
            if (max_val < num) {
                max_val = num;  // Update max_val if a larger number is found
                ans = 0;        // Reset answer since a new max_val resets valid subarrays
                current_streak = 0; // Reset streak for the new max_val
            }

            if (max_val == num) {
                current_streak++;   // Increment streak if current number equals max_val
                ans = Math.max(ans, current_streak); // Update ans with the longest streak
            } else {
                current_streak = 0; // Reset streak if number is less than max_val
            }
        }

        return ans;
    }

    /**
     * Main method to test the longestSubarray method with static inputs.
     * 
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        LongestSubarrayWithMaximumBitwiseAND solution = new LongestSubarrayWithMaximumBitwiseAND();

        // Test Case 1: nums = [1, 2, 3, 3, 2, 2]
        int[] nums1 = {1, 2, 3, 3, 2, 2};
        System.out.println("Test Case 1 - Length: " + solution.longestSubarray(nums1)); // Expected: 2

        // Test Case 2: nums = [1, 2, 3, 4]
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Test Case 2 - Length: " + solution.longestSubarray(nums2)); // Expected: 1
    }
}
