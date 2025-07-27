package arrays;

/**
 * Problem Statement:
 * You are given a 0-indexed integer array nums. An index i is part of a hill in nums if the closest non-equal neighbors of i are smaller than nums[i].
 * Similarly, an index i is part of a valley in nums if the closest non-equal neighbors of i are larger than nums[i].
 * Adjacent indices i and j are part of the same hill or valley if nums[i] == nums[j].
 * Note that for an index to be part of a hill or valley, it must have a non-equal neighbor on both the left and right of the index.
 * Return the number of hills and valleys in nums.
 *
 * Example 1:
 * Input: nums = [2,4,1,1,6,5]
 * Output: 3
 * Explanation:
 * At index 0: There is no non-equal neighbor of 2 on the left, so index 0 is neither a hill nor a valley.
 * At index 1: The closest non-equal neighbors of 4 are 2 and 1. Since 4 > 2 and 4 > 1, index 1 is a hill.
 * At index 2: The closest non-equal neighbors of 1 are 4 and 6. Since 1 < 4 and 1 < 6, index 2 is a valley.
 * At index 3: The closest non-equal neighbors of 1 are 4 and 6. Since 1 < 4 and 1 < 6, index 3 is a valley, but note that it is part of the same valley as index 2.
 * At index 4: The closest non-equal neighbors of 6 are 1 and 5. Since 6 > 1 and 6 > 5, index 4 is a hill.
 * At index 5: There is no non-equal neighbor of 5 on the right, so index 5 is neither a hill nor a valley.
 * There are 3 hills and valleys so we return 3.
 *
 * Example 2:
 * Input: nums = [6,6,5,5,4,1]
 * Output: 0
 * Explanation:
 * At index 0: There is no non-equal neighbor of 6 on the left, so index 0 is neither a hill nor a valley.
 * At index 1: There is no non-equal neighbor of 6 on the left, so index 1 is neither a hill nor a valley.
 * At index 2: The closest non-equal neighbors of 5 are 6 and 4. Since 5 < 6 and 5 > 4, index 2 is neither a hill nor a valley.
 * At index 3: The closest non-equal neighbors of 5 are 6 and 4. Since 5 < 6 and 5 > 4, index 3 is neither a hill nor a valley.
 * At index 4: The closest non-equal neighbors of 4 are 5 and 1. Since 4 < 5 and 4 > 1, index 4 is neither a hill nor a valley.
 * At index 5: There is no non-equal neighbor of 1 on the right, so index 5 is neither a hill nor a valley.
 * There are 0 hills and valleys so we return 0.
 *
 * Constraints:
 * 3 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */

import java.util.ArrayList;

public class CountHillsAndValleysInArray {
    /**
     * Counts the number of hills and valleys in an array.
     *
     * @param nums The input array of integers.
     * @return The number of hills and valleys in the array.
     */
    public int countHillValley(int[] nums) {
        // Create a list to store the unique numbers in the array
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        // Iterate over the array, adding only the numbers that are different from the previous number
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                list.add(nums[i]);
            }
        }

        // Initialize a counter for the number of hills and valleys
        int count = 0;

        // Iterate over the list, checking if each number is a hill or a valley
        for (int i = 1; i < list.size() - 1; i++) {
            int curr = list.get(i);
            int left = list.get(i - 1);
            int right = list.get(i + 1);

            // If the number is a hill or a valley, increment the counter
            if ((curr > left && curr > right) || (curr < left && curr < right)) {
                count++;
            }
        }

        // Return the number of hills and valleys
        return count;
    }

    public static void main(String[] args) {
        CountHillsAndValleysInArray solution = new CountHillsAndValleysInArray();

        // Test cases
        int[] nums1 = {2, 4, 1, 1, 6, 5};
        System.out.println("Test Case 1: " + solution.countHillValley(nums1)); // Expected output: 3

        int[] nums2 = {6, 6, 5, 5, 4, 1};
        System.out.println("Test Case 2: " + solution.countHillValley(nums2)); // Expected output: 0

        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println("Test Case 3: " + solution.countHillValley(nums3)); // Expected output: 0

        int[] nums4 = {5, 4, 3, 2, 1};
        System.out.println("Test Case 4: " + solution.countHillValley(nums4)); // Expected output: 0

        int[] nums5 = {1, 5, 2, 8, 3};
        System.out.println("Test Case 5: " + solution.countHillValley(nums5)); // Expected output: 2

        int[] nums6 = {1, 2, 1, 2, 1};
        System.out.println("Test Case 6: " + solution.countHillValley(nums6)); // Expected output: 4
    }
}
