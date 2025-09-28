package arrays;

import java.util.Arrays;

/**
 * Problem: 976. Largest Perimeter Triangle
 * Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths.
 * If it is impossible to form any triangle of a non-zero area, return 0.
 *
 * Example 1:
 * Input: nums = [2,1,2]
 * Output: 5
 * Explanation: You can form a triangle with three side lengths: 1, 2, and 2.
 *
 * Example 2:
 * Input: nums = [1,2,1,10]
 * Output: 0
 * Explanation:
 * You cannot use the side lengths 1, 1, and 2 to form a triangle.
 * You cannot use the side lengths 1, 1, and 10 to form a triangle.
 * You cannot use the side lengths 1, 2, and 10 to form a triangle.
 * As we cannot use any three side lengths to form a triangle of non-zero area, we return 0.
 *
 * Constraints:
 * 3 <= nums.length <= 104
 * 1 <= nums[i] <= 106
 */
public class LargestPerimeterTriangle {
    /**
     * Solution: Sort the array and iterate from the end.
     * For any three consecutive numbers a, b, c (a >= b >= c), check if b + c > a.
     * If so, a triangle can be formed and return the perimeter a + b + c.
     * Otherwise, continue to check the next three numbers.
     * If no triangle can be formed, return 0.
     * @param nums The input array.
     * @return The largest perimeter of a triangle with a non-zero area.
     */
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            int a = nums[i];
            int b = nums[i - 1];
            int c = nums[i - 2];
            if (b + c > a) {
                return a + b + c;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LargestPerimeterTriangle solution = new LargestPerimeterTriangle();

        // Example 1
        int[] nums1 = {2, 1, 2};
        System.out.println("Example 1: " + solution.largestPerimeter(nums1)); // Output: 5

        // Example 2
        int[] nums2 = {1, 2, 1, 10};
        System.out.println("Example 2: " + solution.largestPerimeter(nums2)); // Output: 0

        // Example 3
        int[] nums3 = {3, 6, 2, 3};
        System.out.println("Example 3: " + solution.largestPerimeter(nums3)); // Output: 8

        // Example 4
        int[] nums4 = {3,2,3,4};
        System.out.println("Example 4: " + solution.largestPerimeter(nums4)); // Output: 9

        // Example 5
        int[] nums5 = {1, 1, 1, 2, 3, 5, 12, 100};
        System.out.println("Example 5: " + solution.largestPerimeter(nums5)); // Output: 5

    }
}