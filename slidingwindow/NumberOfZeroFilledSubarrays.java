package slidingwindow;

/**
 * Problem Statement:
 * Given an integer array nums, return the number of subarrays filled with 0.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * Example 1:
 * Input: nums = [1,3,0,0,2,0,0,4]
 * Output: 6
 * Explanation:
 * There are 4 occurrences of [0] as a subarray.
 * There are 2 occurrences of [0,0] as a subarray.
 * There is no occurrence of a subarray with a size more than 2 filled with 0. Therefore, we return 6.
 *
 * Example 2:
 * Input: nums = [0,0,0,2,0,0]
 * Output: 9
 * Explanation:
 * There are 5 occurrences of [0] as a subarray.
 * There are 3 occurrences of [0,0] as a subarray.
 * There is 1 occurrence of [0,0,0] as a subarray.
 * There is no occurrence of a subarray with a size more than 3 filled with 0. Therefore, we return 9.
 *
 * Example 3:
 * Input: nums = [2,10,2019]
 * Output: 0
 * Explanation: There is no subarray filled with 0. Therefore, we return 0.
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */

public class NumberOfZeroFilledSubarrays {
    /**
     * Given an integer array nums, return the number of subarrays filled with 0.
     *
     * @param nums The input array of integers.
     * @return The number of subarrays filled with 0.
     */
    public static long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long consecutiveZeros = 0;

        for (int num : nums) {
            if (num == 0) {
                consecutiveZeros++;
                count += consecutiveZeros;
            } else {
                consecutiveZeros = 0;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {1, 3, 0, 0, 2, 0, 0, 4};
        System.out.println("Test Case 1: " + zeroFilledSubarray(nums1)); // Expected output: 6

        int[] nums2 = {0, 0, 0, 2, 0, 0};
        System.out.println("Test Case 2: " + zeroFilledSubarray(nums2)); // Expected output: 9

        int[] nums3 = {2, 10, 2019};
        System.out.println("Test Case 3: " + zeroFilledSubarray(nums3)); // Expected output: 0

        int[] nums4 = {0, 0, 0, 0, 0};
        System.out.println("Test Case 4: " + zeroFilledSubarray(nums4)); // Expected output: 15

        int[] nums5 = {1, 0, 1, 0, 1};
        System.out.println("Test Case 5: " + zeroFilledSubarray(nums5)); // Expected output: 2
    }
}