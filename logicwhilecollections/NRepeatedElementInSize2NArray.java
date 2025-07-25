package logicwhilecollections;

import java.util.HashMap;
import java.util.Map;

public class NRepeatedElementInSize2NArray {

    /**
     * Problem: N-Repeated Element in Size 2N Array
     *
     * In a array of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
     * Return the element repeated N times.
     *
     * Example:
     * Input: nums = [1,2,3,3]
     * Output: 3
     *
     * Input: nums = [2,1,2,5,3,2]
     * Output: 2
     *
     * Constraints:
     * - 4 <= nums.length <= 10000
     * - nums.length is even.
     * - nums contains N+1 unique elements, where one element is repeated N times.
     */

    public int repeatedNTimes(int[] nums) {
        int n = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == n) {
                return entry.getKey();
            }
        }

        return -1;  // Should never happen per problem constraints
    }

    public static void main(String[] args) {
        NRepeatedElementInSize2NArray solution = new NRepeatedElementInSize2NArray();

        // Test case 1
        int[] nums1 = {1, 2, 3, 3};
        System.out.println("Repeated N times element (Test case 1): " + solution.repeatedNTimes(nums1));  // Expected: 3

        // Test case 2
        int[] nums2 = {2, 1, 2, 5, 3, 2};
        System.out.println("Repeated N times element (Test case 2): " + solution.repeatedNTimes(nums2));  // Expected: 2

        // Test case 3
        int[] nums3 = {5,1,5,2,5,3,5,4};
        System.out.println("Repeated N times element (Test case 3): " + solution.repeatedNTimes(nums3));  // Expected: 5
    }
}
