package arrays;

import java.util.HashMap;

public class LongestHarmonicSubsequence {
    /**
     * We define a harmonious array as an array where the difference between its
     * maximum value and its minimum value is **exactly** `1`.
     *
     * Given an integer array `nums`, return the length of its longest harmonious
     * subsequence among all its possible subsequences.
     *
     * **Example 1:**
     *
     * **Input:** nums = \[1,3,2,2,5,2,3,7]
     *
     * **Output:** 5
     *
     * **Explanation:**
     * The longest harmonious subsequence is `[3,2,2,2,3]`.
     *
     * **Example 2:**
     *
     * **Input:** nums = \[1,2,3,4]
     *
     * **Output:** 2
     *
     * **Explanation:**
     * The longest harmonious subsequences are `[1,2]`, `[2,3]`, and `[3,4]`,
     * all of which have a length of 2.
     *
     * **Example 3:**
     *
     * **Input:** nums = \[1,1,1,1]
     *
     * **Output:** 0
     *
     * **Explanation:**
     * No harmonic subsequence exists.
     *
     * **Constraints:**
     *
     *   `1 <= nums.length <= 2 * 104`
     *   `-109 <= nums[i] <= 109`
     *
     * @param nums The input array of integers.
     * @return The length of the longest harmonious subsequence.
     */
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        int max = 0;
        for (int n : map.keySet()) {
            if (map.containsKey(n + 1))
                max = Math.max(max, map.get(n) + map.get(n + 1));
        }
        return max;

    }

    public static void main(String[] args) {
        LongestHarmonicSubsequence solution = new LongestHarmonicSubsequence();
        // Test case 1
        int[] nums1 = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println("Test Case 1: " + solution.findLHS(nums1) + " (Expected: 5)");

        // Test case 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Test Case 2: " + solution.findLHS(nums2) + " (Expected: 2)");

        // Test case 3
        int[] nums3 = {1, 1, 1, 1};
        System.out.println("Test Case 3: " + solution.findLHS(nums3) + " (Expected: 0)");

        // Test Case 4
        int[] nums4 = {1, 1, 1, 1, 2, 2, 2, 2};
        System.out.println("Test Case 4: " + solution.findLHS(nums4) + " (Expected: 8)");

        // Test Case 5
        int[] nums5 = {4,1,2,3,4,5,6,7,8,9,10};
        System.out.println("Test Case 5: " + solution.findLHS(nums5) + " (Expected: 2)");
    }
}
