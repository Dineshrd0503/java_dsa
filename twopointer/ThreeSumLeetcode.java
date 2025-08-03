package twopointer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ThreeSumLeetcode {
    /**
     * Problem Statement: 3Sum (LeetCode)
     * Given an integer array nums, return all unique triplets [nums[i], nums[j], nums[k]]
     * such that i != j, i != k, j != k, and nums[i] + nums[j] + nums[k] == 0.
     * The solution set must not contain duplicate triplets.
     *
     * Constraints:
     * - 3 <= nums.length <= 3000
     * - -10^5 <= nums[i] <= 10^5
     *
     * Examples:
     * Example 1:
     * Input: nums = [-1, 0, 1, 2, -1, -4]
     * Output: [[-1, -1, 2], [-1, 0, 1]]
     * Explanation: Triplets [-1, -1, 2] and [-1, 0, 1] sum to 0 and are unique.
     *
     * Example 2:
     * Input: nums = []
     * Output: []
     * Explanation: Empty array has no triplets.
     *
     * Example 3:
     * Input: nums = [0]
     * Output: []
     * Explanation: Single element cannot form a triplet.
     *
     * Example 4:
     * Input: nums = [0, 0, 0]
     * Output: [[0, 0, 0]]
     * Explanation: Triplet [0, 0, 0] sums to 0.
     */

        public List<List<Integer>> threeSum(int[] nums) {
            // Initialize result list to store triplets
            List<List<Integer>> result = new ArrayList<>();

            // Handle edge case: if array has less than 3 elements, no triplets possible
            if (nums.length < 3) {
                return result;
            }

            // Sort the array to enable two-pointer technique and handle duplicates
            Arrays.sort(nums);
            int n = nums.length;

            // Iterate over first element up to n-3 to ensure space for left and right pointers
            for (int i = 0; i < n - 2; i++) {
                // Skip duplicates for first element to avoid duplicate triplets
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                // Initialize two pointers
                int left = i + 1;
                int right = n - 1;

                // Use two pointers to find nums[left] + nums[right] = -nums[i]
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];

                    if (sum == 0) {
                        // Found a valid triplet, add to result
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                        right--;
                        // Skip duplicates for left pointer
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // Skip duplicates for right pointer
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        // Move pointers to check for more triplets

                    } else if (sum < 0) {
                        // Sum too small, move left pointer to increase sum
                        left++;
                    } else {
                        // Sum too large, move right pointer to decrease sum
                        right--;
                    }
                }
            }

            return result;
        }

        // Main method to test the solution with example test cases
        public static void main(String[] args) {
            ThreeSumLeetcode solution = new ThreeSumLeetcode();

            // Test Case 1: Mixed positive and negative numbers
            int[] nums1 = {-1, 0, 1, 2, -1, -4};
            System.out.println("Test Case 1:");
            System.out.print("Input: nums = [");
            for (int i = 0; i < nums1.length; i++) {
                System.out.print(nums1[i] + (i < nums1.length - 1 ? ", " : ""));
            }
            System.out.println("]");
            System.out.println("Output: " + solution.threeSum(nums1));
            System.out.println("Expected: [[-1, -1, 2], [-1, 0, 1]]");
            System.out.println();

            // Test Case 2: Empty array
            int[] nums2 = {};
            System.out.println("Test Case 2:");
            System.out.println("Input: nums = []");
            System.out.println("Output: " + solution.threeSum(nums2));
            System.out.println("Expected: []");
            System.out.println();

            // Test Case 3: Single element
            int[] nums3 = {0};
            System.out.println("Test Case 3:");
            System.out.println("Input: nums = [0]");
            System.out.println("Output: " + solution.threeSum(nums3));
            System.out.println("Expected: []");
            System.out.println();

            // Test Case 4: All zeros
            int[] nums4 = {0, 0, 0};
            System.out.println("Test Case 4:");
            System.out.println("Input: nums = [0, 0, 0]");
            System.out.println("Output: " + solution.threeSum(nums4));
            System.out.println("Expected: [[0, 0, 0]]");
        }
    }
