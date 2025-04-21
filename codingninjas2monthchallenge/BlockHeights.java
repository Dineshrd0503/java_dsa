package codingninjas2monthchallenge;

import java.util.Arrays;

public class BlockHeights {

    /**
     * Problem statement:
     *
     * There are ‘N’ empty places and you are given ‘N’ blocks. The task is to fill each place
     * with a block of some height. After filling all the empty places all blocks should be
     * arranged in increasing order of their height.
     *
     * Given an array 'heights' which denotes the blocks arranged in some order. You have to
     * find and return the number of blocks that are present in the wrong locations.
     *
     * Input Format:
     * The first line of input contains an integer 'T' representing the number of test cases.
     * The first line of each test case contains one integer ‘N’ denoting the number of elements in the array.
     * The second line of each test case contains N space-separated integers denoting the elements of the array “heights”.
     *
     * Output Format:
     * For each test case, print the number of blocks that are present in the wrong locations.
     * Print the output of each test case on a new line.
     *
     * Constraints:
     * 1 <= T <= 5
     * 1 <= N <= 10^5
     * 1 <= heights[i] <= 10^9
     *
     * Sample Input 1:
     * 2
     * 4
     * 1 5 2 4
     * 4
     * 2 3 5 4
     *
     * Sample Output 1:
     * 3
     * 2
     *
     * Explanation of Sample output 1:
     * For the first test case, Blocks with heights 2, 5, 4 are present in the wrong locations.
     * For the second test case, Blocks with heights 4, 5 are present in the wrong locations.
     *
     * Sample Input 2:
     * 2
     * 2
     * 1 2
     * 5
     * 5 1 3 2 4
     *
     * Sample Output 2:
     * 0
     * 4
     */

    public static int getNumberOfBlocks(int[] heights) {
        // Create a copy of the heights to compare with after sorting
        int[] originalHeights = heights.clone();

        // Sort heights
        Arrays.sort(heights);

        // Count mismatched blocks
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != originalHeights[i]) {
                count++;  // Count elements that are not in their correct position
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Static input values for testing
        int[][] testCases = {
                {4, 1, 5, 2, 4},
                {4, 2, 3, 5, 4},
                {2, 1, 2},
                {5, 5, 1, 3, 2, 4}
        };

        // Process each test case
        for (int[] testCase : testCases) {
            int N = testCase[0];  // Number of blocks
            int[] heights = new int[N];
            // Fill the heights from the test case
            for (int i = 0; i < N; i++) {
                heights[i] = testCase[i + 1];
            }

            // Get the number of blocks in the wrong locations
            int result = getNumberOfBlocks(heights);
            System.out.println(result);  // Output the result for each test case
        }
    }
}
