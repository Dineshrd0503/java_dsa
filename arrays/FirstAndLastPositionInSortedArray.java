package arrays;

import java.util.Arrays;

public class FirstAndLastPositionInSortedArray {
    /**
     * Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given `target` value.
     * <p>
     * If `target` is not found in the array, return `[-1, -1]`.
     * <p>
     * You must write an algorithm with `O(log n)` runtime complexity.
     * <p>
     * Example 1:
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * <p>
     * Example 2:
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     * <p>
     * Example 3:
     * Input: nums = [], target = 0
     * Output: [-1,-1]
     * <p>
     * Constraints:
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * nums is a non-decreasing array.
     * -109 <= target <= 109
     *
     * @param nums   The sorted array of integers.
     * @param target The target value to find.
     * @return An array of two integers representing the starting and ending positions of the target value in the array.
     * Returns `[-1, -1]` if the target value is not found.
     */
    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (first == -1)
                    first = i;
                last = i;
            }

        }
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        FirstAndLastPositionInSortedArray solution = new FirstAndLastPositionInSortedArray();
        // Example 1: Target found multiple times
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int[] result1 = solution.searchRange(nums1, target1);
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + Arrays.toString(result1)); // Expected: [3, 4]
        System.out.println();

        // Example 2: Target not found
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] result2 = solution.searchRange(nums2, target2);
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + Arrays.toString(result2)); // Expected: [-1, -1]
        System.out.println();

        // Example 3: Empty array
        int[] nums3 = {};
        int target3 = 0;
        int[] result3 = solution.searchRange(nums3, target3);
        System.out.println("Input: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Output: " + Arrays.toString(result3)); // Expected: [-1, -1]
        System.out.println();
    }
}