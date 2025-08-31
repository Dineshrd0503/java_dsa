package twopointer;

import java.util.Arrays;

/**
 * ====================================================================
 * Problem Statement: Container With Most Water
 * ====================================================================
 *
 * You are given an integer array `arr` of length n. There are n vertical lines
 * drawn such that the two endpoints of the i-th line are (i, 0) and (i, arr[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the
 * container contains the most water. Return the maximum amount of water a
 * container can store.
 *
 * The area is calculated as `width * height`, where `width` is the distance
 * between the two lines and `height` is the shorter of the two lines.
 *
 * ====================================================================
 * Sample Test Cases
 * ====================================================================
 *
 * Example 1:
 * Input: arr[] = {1, 8, 6, 2, 5, 4, 8, 3, 7}
 * Output: 49
 * Explanation: The container with the most water is formed by the lines at
 * index 1 (height 8) and index 8 (height 7).
 * Width = 8 - 1 = 7. Height = min(8, 7) = 7. Area = 7 * 7 = 49.
 *
 * Example 2:
 * Input: arr[] = {1, 1}
 * Output: 1
 */
public class ContainerWithMostWater {

    /**
     * Finds the maximum amount of water a container can store.
     * This method uses the optimal two-pointer approach.
     *
     * @param height An array representing the heights of the vertical lines.
     * @return The maximum area.
     */
    public int maxWater(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            // Calculate the width of the current container
            int width = right - left;

            // The height is limited by the shorter of the two lines
            int currentHeight = Math.min(height[left], height[right]);

            // Calculate the area for the current container
            int currentArea = width * currentHeight;

            // Update the maximum area found so far
            maxArea = Math.max(maxArea, currentArea);

            // The key insight: move the pointer of the shorter line inward
            // for a chance to find a taller line that might create a larger area.
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    /*
     * ====================================================================
     * Dry Run
     * ====================================================================
     *
     * Let's trace with the input: arr[] = {1, 8, 6}
     *
     * 1. Initialization:
     * - maxArea = 0
     * - left = 0 (value 1)
     * - right = 2 (value 6)
     *
     * 2. Iteration 1:
     * - while (0 < 2) is true.
     * - width = 2 - 0 = 2.
     * - currentHeight = min(arr[0], arr[2]) = min(1, 6) = 1.
     * - currentArea = 2 * 1 = 2.
     * - maxArea = max(0, 2) = 2.
     * - Check: arr[left] < arr[right]? (1 < 6) is true.
     * - Action: Move the shorter pointer inward -> left++.
     * - State: left = 1, right = 2.
     *
     * 3. Iteration 2:
     * - while (1 < 2) is true.
     * - width = 2 - 1 = 1.
     * - currentHeight = min(arr[1], arr[2]) = min(8, 6) = 6.
     * - currentArea = 1 * 6 = 6.
     * - maxArea = max(2, 6) = 6.
     * - Check: arr[left] < arr[right]? (8 < 6) is false.
     * - Action: Move the shorter pointer inward -> right--.
     * - State: left = 1, right = 1.
     *
     * 4. Termination:
     * - The while loop condition (1 < 1) is now false.
     * - The loop terminates.
     *
     * 5. Final Result:
     * - The function returns maxArea, which is 6.
     */
    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();

        // Test Case 1
        int[] arr1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Max Water: " + solution.maxWater(arr1)); // Expected: 49
        System.out.println("--------------------");

        // Test Case 2
        int[] arr2 = {1, 1};
        System.out.println("Array: " + Arrays.toString(arr2));
        System.out.println("Max Water: " + solution.maxWater(arr2)); // Expected: 1
        System.out.println("--------------------");
    }
}

