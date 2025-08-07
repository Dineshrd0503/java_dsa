package arrays;
import java.util.Arrays;

public class HeightChecker{
    /**
     * Problem Statement:
     * A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height.
     * You are given an integer array heights representing the current order that the students are standing in.
     * Return the number of indices where heights[i] != expected[i].
     *
     * Example 1:
     * Input: heights = [1,1,4,2,1,3]
     * Output: 3
     * Explanation:
     * heights:  [1,1,4,2,1,3]
     * expected: [1,1,1,2,3,4]
     * Indices 2, 4, and 5 do not match.
     */
    public int heightChecker(int[] heights) {
        // Create a copy of the input array to sort
        int[] expected = heights.clone();

        // Sort the copied array - using the sort function
        Arrays.sort(expected);

        // Initialize a counter to keep track of the number of mismatches
        int count = 0;

        // Iterate through the original and sorted arrays.
        for (int i = 0; i < heights.length; i++) {
            // If the elements are not equal, increment number of times indices do not match.
            if (heights[i] != expected[i]) {
                count++;
            }
        }

        // Return the total number of mismatches
        return count;
    }

    public static void main(String[] args) {
       HeightChecker solution = new HeightChecker();

        // Test case 1 which will return 3
        int[] heights1 = {1, 1, 4, 2, 1, 3};
        int result1 = solution.heightChecker(heights1);
        System.out.println("Test Case 1: " + result1);

        // Test case 2 which will return 5
        int[] heights2 = {5, 1, 2, 3, 4};
        int result2 = solution.heightChecker(heights2);
        System.out.println("Test Case 2: " + result2);

        // Test case 3 which will return 0
        int[] heights3 = {1, 2, 3, 4, 5};
        int result3 = solution.heightChecker(heights3);
        System.out.println("Test Case 3: " + result3);
    }
}
