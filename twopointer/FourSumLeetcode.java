package twopointer;

/**
 * Problem Statement: 4Sum
 * Given an array nums of n integers, return an array of all unique quadruplets
 * [nums[i], nums[j], nums[k], nums[l]] such that i, j, k, l are distinct and
 * nums[i] + nums[j] + nums[k] + nums[l] == target.
 * The solution set must not contain duplicate quadruplets.
 *
 * Constraints:
 * - 1 <= nums.length <= 200
 * - -10^9 <= nums[i] <= 10^9
 * - -10^9 <= target <= 10^9
 *
 * Examples:
 * Example 1:
 * Input: nums = [1, 0, -1, 0, -2, 2], target = 0
 * Output: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
 * Example 2:
 * Input: nums = [2, 2, 2, 2, 2], target = 8
 * Output: [[2, 2, 2, 2]]
 * Example 3:
 * Input: nums = [], target = 0
 * Output: []
 */
import java.util.ArrayList;
import java.util.Arrays;

public class FourSumLeetcode {
    public ArrayList<ArrayList<Integer>> fourSum(int[] nums, long target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }

        // Sort the array to enable two-pointer technique and handle duplicates
        Arrays.sort(nums);
        int n = nums.length;

        // Iterate over first element
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // Early termination: if smallest sum exceeds target
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            // Early termination: if largest sum is less than target
            if ((long) nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                continue;
            }

            // Iterate over second element
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for second element
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // Early termination: if smallest sum with i, j exceeds target
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                // Early termination: if largest sum with i, j is less than target
                if ((long) nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }

                // Two pointers for third and fourth elements
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        left++;
                        right--;
                        // Skip duplicates before moving pointers
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        FourSumLeetcode solution = new FourSumLeetcode();

        // Test Case 1
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        long target1 = 0;
        System.out.println("Test Case 1:");
        System.out.print("Input: nums = [");
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + (i < nums1.length - 1 ? ", " : ""));
        }
        System.out.println("], target = " + target1);
        System.out.println("Output: " + solution.fourSum(nums1, target1));
        System.out.println("Expected: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]");
        System.out.println();

        // Test Case 2
        int[] nums2 = {2, 2, 2, 2, 2};
        long target2 = 8;
        System.out.println("Test Case 2:");
        System.out.print("Input: nums = [");
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i] + (i < nums2.length - 1 ? ", " : ""));
        }
        System.out.println("], target = " + target2);
        System.out.println("Output: " + solution.fourSum(nums2, target2));
        System.out.println("Expected: [[2, 2, 2, 2]]");
        System.out.println();

        // Test Case 3
        int[] nums3 = {};
        long target3 = 0;
        System.out.println("Test Case 3:");
        System.out.println("Input: nums = [], target = " + target3);
        System.out.println("Output: " + solution.fourSum(nums3, target3));
        System.out.println("Expected: []");
        System.out.println();

        // Test Case 4
        int[] nums4 = {1000000000, 1000000000, 1000000000, 1000000000};
        long target4 = 4000000000L;
        System.out.println("Test Case 4:");
        System.out.print("Input: nums = [");
        for (int i = 0; i < nums4.length; i++) {
            System.out.print(nums4[i] + (i < nums4.length - 1 ? ", " : ""));
        }
        System.out.println("], target = " + target4);
        System.out.println("Output: " + solution.fourSum(nums4, target4));
        System.out.println("Expected: [[1000000000, 1000000000, 1000000000, 1000000000]]");
    }
}