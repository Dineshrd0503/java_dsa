package logicwhilelists;

import java.util.HashSet;
import java.util.Arrays;

public class IntersectionOftwoArrays {

    /**
     * Problem: Intersection of Two Arrays
     *
     * Given two integer arrays nums1 and nums2, return an array of their intersection.
     * Each element in the result must be unique and you may return the result in any order.
     *
     * Example:
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2]
     *
     * Constraints:
     * - 1 <= nums1.length, nums2.length <= 1000
     * - 0 <= nums1[i], nums2[i] <= 1000
     */

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        // Add all elements of nums1 to set1
        for (int n : nums1) {
            set1.add(n);
        }

        // For each element in nums2, add to set2 if it exists in set1
        for (int n : nums2) {
            if (set1.contains(n)) {
                set2.add(n);
            }
        }

        // Convert set2 to int[] using streams
        return set2.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        IntersectionOftwoArrays solution=new IntersectionOftwoArrays();

        // Static test inputs
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] result = solution.intersection(nums1, nums2);

        // Print the intersection array
        System.out.println("Intersection: " + Arrays.toString(result));

        // Additional test case
        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        System.out.println("Intersection: " + Arrays.toString(solution.intersection(nums3, nums4)));
    }
}

